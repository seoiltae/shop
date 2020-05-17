package controllerAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ItemDao;
import model.OrdersDao;
import vo.Item;
import vo.Orders;

@WebServlet("/mall/InsertOrders")
public class InsertOrders extends HttpServlet {
	private ItemDao itemDao;
	private OrdersDao ordersDao;

	// insertOrders Form
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		this.itemDao = new ItemDao();
		Item item = itemDao.selectItemOne(itemId);

		request.setAttribute("item", item);

		request.getRequestDispatcher("/WEB-INF/jsp/mall/insertOrders.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int itemId = Integer.parseInt(request.getParameter("itemId")); // doGet에 있는 아이디값
		int itemPrice = Integer.parseInt(request.getParameter("itemPrice"));
		int itemCount = Integer.parseInt(request.getParameter("itemCount"));
		int ordersPrice = itemPrice * itemCount;
		String userName = request.getParameter("userName");
		String userPhone = request.getParameter("userPhone");
		String userAddress = request.getParameter("userAddress");
		System.out.println(itemId + "  <--itemId doPost() itemId");

		Orders orders = new Orders();
		orders.setItemId(itemId);
		orders.setItemCount(itemCount);
		orders.setOrdersPrice(ordersPrice);
		orders.setUserName(userName);
		orders.setUserPhone(userPhone);
		orders.setUserAddress(userAddress);
		this.ordersDao = new OrdersDao();
		ordersDao.insertOrders(orders);

		response.sendRedirect(request.getContextPath() + "/mall/MyOrdersList");
		System.out.println("에러 확인잉니이이이이이");
	}

}
