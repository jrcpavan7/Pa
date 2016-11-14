package scoreapp.scores;

public class Judges {
	private String judgename;
	private String judgecompany;
	private String judgeemailid;

	public Judges() {

	}

	public Judges(String judgename, String judgecompany, String judgeemailid) {
		super();
		this.judgename = judgename;
		this.judgecompany = judgecompany;
		this.judgeemailid = judgeemailid;
	}

	public String getJudgename() {
		return judgename;
	}

	public void setJudgename(String judgename) {
		this.judgename = judgename;
	}

	public String getJudgecompany() {
		return judgecompany;
	}

	public void setJudgecompany(String judgecompany) {
		this.judgecompany = judgecompany;
	}

	public String getJudgeemailid() {
		return judgeemailid;
	}

	public void setJudgeemailid(String judgeemailid) {
		this.judgeemailid = judgeemailid;
	}

}
