package battleshipsweb.components;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import battleshipsweb.UserDetails;

public class BattleshipsDAO {
	
	private JdbcTemplate template;
	
	private RowMapper<UserDetails> udRowMapper = new RowMapper<UserDetails>() {
		
		public UserDetails mapRow(ResultSet rs, int el) throws SQLException {
			
			UserDetails user = new UserDetails();
			
			user.setWins(rs.getInt("wins"));
			user.setLosses(rs.getInt("losses"));
			user.setTotalHits(rs.getInt("total_hits"));
			user.setTotalMisses(rs.getInt("total_misses"));
			user.setUsername(rs.getString("username"));
			user.setHasImage(rs.getBoolean("image"));
			
			return user;
		}
	};
	
	public void setTemplate(JdbcTemplate template) {
		
		this.template = template;
	}
	
	public List<UserDetails> getAllUsers() {
		
		return template.query("SELECT username, wins, losses, total_hits, total_misses, image FROM battleships.user", udRowMapper);
	}
	
	public void addNewUser(String username, String password, boolean image) {
		
		MessageDigest dig = null;
		
		try {
			
			dig = MessageDigest.getInstance("SHA-256");
			
		}
		catch(NoSuchAlgorithmException e) {
			
			System.out.println("no to sraka");
		}
		dig.update(password.getBytes());
		
		byte[] mdbytes = dig.digest();
		StringBuffer sb = new StringBuffer();
        for (int i = 0; i < mdbytes.length; i++) {
        	
        	sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        String hash = sb.toString();
		
		template.update("INSERT INTO battleships.user (username, hash, image)"
					  + " VALUES (?, ?, ?) ", username, hash, image);
		
		template.update("INSERT INTO battleships.role (usr_id, value)"
					  + " VALUES ((SELECT user_id FROM battleships.user WHERE username = ?), 'ROLE_TROLL') ", username);
	}
	
	public boolean userExists(String username) {
		
		return template.queryForInt("SELECT COUNT(*) FROM battleships.user"
								  + " WHERE username = ?", username) != 0;
	}
	
	public UserDetails getDetailsByUsername(String username) {
		
		return template.queryForObject("SELECT username, wins, losses, total_hits, total_misses, image FROM battleships.user"
									 + " WHERE username = ?", new Object[]{ username }, udRowMapper);
	}
	
	public void setNoImage(String username) {
		
		template.update("UPDATE battleships.user SET image = false "
					  + "WHERE username = ?", username);
	}
}
