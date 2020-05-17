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

@WebServlet("/admin/ItemList") // �� ���� �̸�()
public class ItemList extends HttpServlet { // ���������� ItemList�� �̸��� ���ڴ� // Ŭ���� ItemList�� �θ� HttpServlet�̴� (���)
	private ItemDao itemDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �α��� ���ǰ�
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("SloginId") + "  <--SloginId");

		if (session.getAttribute("SloginId") == null) {
			response.sendRedirect(request.getContextPath() + "/admin/AdminLogin");
			return;
		}

		// �� ȣ�� �� ��
		this.itemDao = new ItemDao();
		ArrayList<Item> list = itemDao.selectItemListAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/itemList.jsp").forward(request, response);

	}
}
