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
public class UpdateOrders extends HttpServlet { // HttpServlet 상속
	private OrdersDao ordersDao; // 필드값(이안에서만 사용할 수 있게 private속성을 준다)

	@Override // 컨트롤러-모델-뷰 C-M-V && @Override = 부모에게 상속 받음(상속자들)
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { // request, response로 선언. 예외를 떠넘기겠다 throws
		int ordersId = Integer.parseInt(request.getParameter("ordersId")); // 수정할 때 ordersId열을 가져와 수정폼!
		System.out.println(ordersId + "  <--ordersId doGet()  ordersId"); // 디버깅

		this.ordersDao = new OrdersDao(); // private값 준걸 이안에서 새로 선언
		Orders orders = ordersDao.selectOrdersOne(ordersId); // orders에 Dao.selectOrdersOne의 값 넣기
		orders.setOrdersId(ordersId); // itemId값 쓰겠다
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/updateOrders.jsp").forward(request, response);
	}

	@Override // 컨트롤러 - 뷰- new컨트롤러 C-V-C(new) redricet
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
