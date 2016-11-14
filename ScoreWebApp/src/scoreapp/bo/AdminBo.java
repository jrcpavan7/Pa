package scoreapp.bo;

public class AdminBo {
	public boolean validateAdmin(String adminname, String adminpass) {
		
		if (adminname == "root" && adminpass == "root123") {
//			System.out.println("Im inside");
			return true;
		} else {
			return false;
		}
	}
}
