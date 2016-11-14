package scoreapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import scoreapp.scores.Teams;

public class Teamsdao {
	public boolean saveTeam(Teams teams) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackathon", "root", "murali");
			PreparedStatement pstmt = con.prepareStatement("insert into teamusecases VALUES(?,?,?,?)");
			pstmt.setString(1, teams.getTeamname());
			pstmt.setInt(2, teams.getTeammembers());
			pstmt.setString(3, teams.getTeamleadername());
			pstmt.setString(4, teams.getUsecasegiven());
			int result = pstmt.executeUpdate();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return false;
		}
	}
}
