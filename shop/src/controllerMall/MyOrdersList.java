package controllerMall;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ItemDao;
import model.OrdersDao;
import vo.Orders;

@WebServlet("/mall/MyOrdersList")
public class MyOrdersList extends HttpServlet {
	private OrdersDao ordersDao;
	private ItemDao itemDao;

	// 이름과 전화번호를 입력하는 폼 이름전화번호를 입력하면 내가 주문한 정보를 볼 수 있는 곳
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/jsp/mall/myOrdersList.jsp").forward(request, response);
		System.out.println("MyOrdersList.java doGet 에러 확인!");
	}

	// MyOrdersList View
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("dopost myOrdersList");
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String userPhone = request.getParameter("userPhone");
		System.out.println(userName + "  <--userName doPost() userName");
		System.out.println(userPhone + "  <--userPhone doPost() userPhone");

		Orders orders = new Orders();
		orders.setUserName(userName);
		orders.setUserPhone(userPhone);
		this.ordersDao = new OrdersDao();
		List<Orders> list = new ArrayList<Orders>();
		list = this.ordersDao.seachmeOrders(userName, userPhone);
		System.out.println(list.size());
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/mall/myOrdersList2.jsp").forward(request, response);
	}

}
