package battleshipsweb;

public class UserDetails implements Comparable<UserDetails> {
	
	private String username;
	private Integer wins;
	private Integer losses;
	private Integer totalHits;
	private Integer totalMisses;
	
	public String getUsername() {
		
		return username;
	}
	
	public void setUsername(String username) {
		
		this.username = username;
	}
	
	public Integer getWins() {
		
		return wins;
	}
	
	public void setWins(Integer wins) {
		
		this.wins = wins;
	}
	
	public Integer getLosses() {
		
		return losses;
	}
	
	public void setLosses(Integer losses) {
		
		this.losses = losses;
	}
	
	public Integer getTotalHits() {
		
		return totalHits;
	}
	
	public void setTotalHits(Integer totalHits) {
		
		this.totalHits = totalHits;
	}
	
	public Integer getTotalMisses() {
		
		return totalMisses;
	}
	
	public void setTotalMisses(Integer totalMisses) {
		
		this.totalMisses = totalMisses;
	}

	public int compareTo(UserDetails o) {
		
		int myScore = wins - losses;
		int oScore = o.wins - o.losses;
		
		if(myScore > oScore) {
			
			return -1;
		}
		else if(myScore < oScore) {
			
			return 1;
		}
		
		return 0;
	}
	
}
