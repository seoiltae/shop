package controllerAdmin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.OrdersDao;
import vo.Orders;

@WebServlet("/admin/OrdersList")
public class OrdersList extends HttpServlet { // Httpservlet에 상속시킨다
	private OrdersDao ordersDao;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { // request, response
		// 로그인 세션값
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("SloginId") + "  <--SloginId");

		if (session.getAttribute("SloginId") == null) {
			response.sendRedirect(request.getContextPath() + "/admin/AdminLogin");
			return;
		}

		this.ordersDao = new OrdersDao(); // 위에 private한 값을 새로 선언
		List<Orders> list = ordersDao.selectOrdersListAll();

		request.setAttribute("list", list); // 위에 list를 list로 부르겟다
		request.getRequestDispatcher("/WEB-INF/jsp/admin/ordersList.jsp").forward(request, response); // forward()안에 값을
																										// 넘겨주겠다

	}
}
