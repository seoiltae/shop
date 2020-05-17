package controllerAdmin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ItemDao;
import vo.Item;

@WebServlet("/admin/ItemList") // 웹 서블릿 이름()
public class ItemList extends HttpServlet { // 웹페이지에 ItemList의 이름을 띄우겠다 // 클래스 ItemList에 부모가 HttpServlet이다 (상속)
	private ItemDao itemDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 로그인 세션값
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("SloginId") + "  <--SloginId");

		if (session.getAttribute("SloginId") == null) {
			response.sendRedirect(request.getContextPath() + "/admin/AdminLogin");
			return;
		}

		// 모델 호출 후 뷰
		this.itemDao = new ItemDao();
		ArrayList<Item> list = itemDao.selectItemListAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/itemList.jsp").forward(request, response);

	}
}
