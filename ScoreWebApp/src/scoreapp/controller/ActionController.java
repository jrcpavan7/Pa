package scoreapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import scoreapp.bo.AdminBo;
import scoreapp.scores.Admin;
import scoreapp.scores.Judges;

/**
 * Servlet implementation class ActionController
 */
@WebServlet("/ActionController")
public class ActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActionController() {
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
		String judgename = request.getParameter("judgename");
		String company = request.getParameter("company");
		String judgeemail = request.getParameter("judgeemail");
		Judges judges = new Judges();
		judges.setJudgename(judgename);
		judges.setJudgecompany(company);
		judges.setJudgeemailid(judgeemail);
		request.setAttribute("judges", judges);
		// RequestDispatcher rd =
		// request.getRequestDispatcher("ScoreComments.jsp");
		// rd.forward(request, response);
		// <%Judges judges=(Judges)request.getAttribute("judges"); %>

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String adminname = request.getParameter("adminname");
		String adminpass = request.getParameter("adminpass");
		Admin admin = new Admin();
		admin.setAdminname(adminname);
		admin.setAdminpassword(adminpass);
		AdminBo adminbo = new AdminBo();
		boolean res = adminbo.validateAdmin(adminname, adminpass);
		if (res == true) {
			System.out.println("Im In");
			RequestDispatcher rd = request.getRequestDispatcher("/SuccessAdmin.html");
			rd.include(request, response);
		} else {
			
			RequestDispatcher rd = request.getRequestDispatcher("AdminForm.html");
			rd.include(request, response);
			}
	}

}
