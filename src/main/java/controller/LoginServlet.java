package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.SupervisorDao;
import domain.Supervisor;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request
				.getRequestDispatcher("/WEB-INF/view/login.jsp")
				.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String supervisorId = request.getParameter("supervisorId");
		String supervisorPass = request.getParameter("supervisorPass");





		SupervisorDao dao = DaoFactory.createSupervisorDao();
		//正しければユーザー情報、不正ならnull
		Supervisor supervisor = dao.findByLoginAndPass(supervisorId, supervisorPass);


		if (supervisor == null) {
			//ログイン失敗
			request.setAttribute("error", "IDまたはパスワードが合いません");
			request
					.getRequestDispatcher("/WEB-INF/view/login.jsp")
					.forward(request, response);
			return;
		}

		response.sendRedirect(request.getContextPath() + "/supervisor");

	}

}
