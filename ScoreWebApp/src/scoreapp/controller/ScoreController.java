package scoreapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scoreapp.dao.Teamsdao;
import scoreapp.scores.Teams;

/**
 * Servlet implementation class ScoreController
 */
@WebServlet("/ScoreController")
public class ScoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ScoreController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String teamname = request.getParameter("teamname");
		Integer teammembers = Integer.parseInt(request.getParameter("teammembers"));
		String teamleadername = request.getParameter("teamleadername");
		String usecasegiven = request.getParameter("usecasegiven");
		Teams teams = new Teams();
		teams.setTeamname(teamname);
		teams.setTeammembers(teammembers);
		teams.setTeamleadername(teamleadername);
		teams.setUsecasegiven(usecasegiven);
		Teamsdao teamsdao = new Teamsdao();
		boolean x = teamsdao.saveTeam(teams);
		if(x==true){
			RequestDispatcher rd=request.getRequestDispatcher("success.html");
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
