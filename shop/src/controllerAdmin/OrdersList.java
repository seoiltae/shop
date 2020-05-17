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
public class OrdersList extends HttpServlet { // Httpservlet�� ��ӽ�Ų��
	private OrdersDao ordersDao;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { // request, response
		// �α��� ���ǰ�
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("SloginId") + "  <--SloginId");

		if (session.getAttribute("SloginId") == null) {
			response.sendRedirect(request.getContextPath() + "/admin/AdminLogin");
			return;
		}

		this.ordersDao = new OrdersDao(); // ���� private�� ���� ���� ����
		List<Orders> list = ordersDao.selectOrdersListAll();

		request.setAttribute("list", list); // ���� list�� list�� �θ��ٴ�
		request.getRequestDispatcher("/WEB-INF/jsp/admin/ordersList.jsp").forward(request, response); // forward()�ȿ� ����
																										// �Ѱ��ְڴ�

	}
}
