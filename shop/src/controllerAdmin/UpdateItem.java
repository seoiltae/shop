package controllerAdmin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CategoryDao;
import model.ItemDao;
import vo.Category;
import vo.Item;

@WebServlet("/admin/UpdateItem")
public class UpdateItem extends HttpServlet {
	private ItemDao itemDao;

	// 수정 폼을 보여줄거다 C-M-V
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		System.out.println(itemId + "  <--UpdateItem.doGet() itemId");

		this.itemDao = new ItemDao();
		Item item = itemDao.selectItemOne(itemId);
		item.setItemId(itemId);

		CategoryDao categoryDao = new CategoryDao();
		ArrayList<Category> list = categoryDao.selectCategoryListAll();

		request.setAttribute("list", list);
		request.setAttribute("item", item);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/updateItem.jsp").forward(request, response);
	}

	// 수정 액션(C-M) -> (C)reDirect 음 같은post방식에 있는 곳에 post방식으로 넘기고 다시 새로운 컨트롤러로 복귀한다
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 같은 언어로 대화한다
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		String itemName = request.getParameter("itemName");
		int itemPrice = Integer.parseInt(request.getParameter("itemPrice"));
		System.out.println(categoryId + "  <--doPost() categoryId");
		String itemContents = request.getParameter("itemContents");
		System.out.println(itemId + "  <--dopost() itemId");
		System.out.println(itemName + "  <--dopost() itemName");
		System.out.println(itemPrice + "  <--dopost() itemPrice");
		System.out.println(itemContents + "  <--dopost() itemContents");

		Item item = new Item();
		item.setItemId(itemId);
		item.setItemName(itemName);
		item.setItemPrice(itemPrice);
		item.setItemContents(itemContents);
		item.setCategoryId(categoryId);

		this.itemDao = new ItemDao();
		this.itemDao.updateItem(item);

		response.sendRedirect(request.getContextPath() + "/admin/ItemList");
	}
}
