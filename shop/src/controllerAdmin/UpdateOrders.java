package controllerAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OrdersDao;
import vo.Item;
import vo.Orders;

@WebServlet("/admin/UpdateOrders")
public class UpdateOrders extends HttpServlet { // HttpServlet ���
	private OrdersDao ordersDao; // �ʵ尪(�̾ȿ����� ����� �� �ְ� private�Ӽ��� �ش�)

	@Override // ��Ʈ�ѷ�-��-�� C-M-V && @Override = �θ𿡰� ��� ����(����ڵ�)
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { // request, response�� ����. ���ܸ� ���ѱ�ڴ� throws
		int ordersId = Integer.parseInt(request.getParameter("ordersId")); // ������ �� ordersId���� ������ ������!
		System.out.println(ordersId + "  <--ordersId doGet()  ordersId"); // �����

		this.ordersDao = new OrdersDao(); // private�� �ذ� �̾ȿ��� ���� ����
		Orders orders = ordersDao.selectOrdersOne(ordersId); // orders�� Dao.selectOrdersOne�� �� �ֱ�
		orders.setOrdersId(ordersId); // itemId�� ���ڴ�
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/updateOrders.jsp").forward(request, response);
	}

	@Override // ��Ʈ�ѷ� - ��- new��Ʈ�ѷ� C-V-C(new) redricet
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int ordersId = Integer.parseInt(request.getParameter("ordersId"));
		String ordersState = request.getParameter("ordersState");
		System.out.println(ordersId + " <--ordersId doPost() ordersId");
		System.out.println(ordersState + " <--ordersState doPost() ordersState");

		Orders orders = new Orders();
		orders.setOrdersId(ordersId);
		orders.setOrdersState(ordersState);

		this.ordersDao = new OrdersDao();
		ordersDao.updateOrdersState(orders);

		response.sendRedirect(request.getContextPath() + "/admin/OrdersList");
	}
}
