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
 * Servlet implementation class SupervisorRegisterServlet
 */
@WebServlet("/register")
public class SupervisorRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		request
				.getRequestDispatcher("/WEB-INF/view/register.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
	//DBへ登録
			String supervisorId = request.getParameter("id");
			String supervisorPass = request.getParameter("pass");
			
			//１　必要なデータの確認
			
			//２　バリデーション
			
			//３　Daoを使いDBへ登録
			SupervisorDao dao = DaoFactory.createSupervisorDao();
			
			dao.insert(new Supervisor(null,supervisorId,supervisorPass));
			
			response.sendRedirect(request.getContextPath() + "/login");
			

	}

}
