package battleshipsweb.components;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import battleshipsweb.UserDetails;

@Component
public class BattleshipsDAO {
	
	@Autowired
	private JdbcTemplate template;
	
	private RowMapper<UserDetails> udRowMapper = new RowMapper<UserDetails>() {
		
		public UserDetails mapRow(ResultSet rs, int el) throws SQLException {
			
			UserDetails user = new UserDetails();
			
			user.setWins(rs.getInt("wins"));
			user.setLosses(rs.getInt("losses"));
			user.setTotalHits(rs.getInt("total_hits"));
			user.setTotalMisses(rs.getInt("total_misses"));
			user.setUsername(rs.getString("username"));
			
			return user;
		}
	};
	
	public List<UserDetails> getAllUsers() {
		
		return template.query("SELECT username, wins, losses, total_hits, total_misses FROM battleships.user", udRowMapper);
	}
}
