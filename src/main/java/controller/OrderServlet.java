package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao2.DaoFactory2;
import dao2.OrderDao;



@WebServlet("/item/order")
public class OrderServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request
				.getRequestDispatcher("/WEB-INF/view/order.jsp")
				.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		int productId = Integer.parseInt(request.getParameter("product_id"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		System.out.println(productId);
		System.out.println(quantity);
		
		OrderDao dao = DaoFactory2.createOrderDao();
		
		dao.insert(productId,quantity);
		
//		response.sendRedirect(request.getContextPath() + "/login");

//   response.sendRedirect(request.getContextPath() + "/products.jsp");
	}
}
