package battleshipsweb;

public class Dummy {
	
	private String username;
	private Integer score;
	
	public Dummy(String username, Integer score) {
		
		this.username = username;
		this.score = score;
	}

	public String getUsername() {
		
		return username;
	}
	
	public void setUsername(String username) {
		
		this.username = username;
	}
	
	public Integer getScore() {
		
		return score;
	}
	
	public void setScore(Integer score) {
		
		this.score = score;
	}
	
}