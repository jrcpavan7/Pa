package scoreapp.scores;

public class Teams {
	private String teamname;
	private Integer teammembers;
	private String teamleadername;
	private String usecasegiven;

	public String getTeamname() {
		return teamname;
	}

	public Teams() {

	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public Integer getTeammembers() {
		return teammembers;
	}

	public void setTeammembers(Integer teammembers) {
		this.teammembers = teammembers;
	}

	public String getTeamleadername() {
		return teamleadername;
	}

	public void setTeamleadername(String teamleadername) {
		this.teamleadername = teamleadername;
	}

	public String getUsecasegiven() {
		return usecasegiven;
	}

	public void setUsecasegiven(String usecasegiven) {
		this.usecasegiven = usecasegiven;
	}

	public Teams(String teamname, Integer teammembers, String teamleadername, String usecasegiven) {
		super();
		this.teamname = teamname;
		this.teammembers = teammembers;
		this.teamleadername = teamleadername;
		this.usecasegiven = usecasegiven;
	}

}
