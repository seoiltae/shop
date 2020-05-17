package controllerAdmin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CategoryDao;
import model.ItemDao;
import vo.Category;
import vo.Item;
	@WebServlet("/admin/InsertItem")
	public class InsertItem extends HttpServlet{
		private ItemDao itemDao;
		private CategoryDao categoryDao;
		//입력폼
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("doGet()");
			this.categoryDao = new CategoryDao();
			List<Category> list = categoryDao.selectCategoryListAll();
			
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/insertItem.jsp").forward(request, response);
			System.out.println("doGet()");
		}
		//입력 액션
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			String itemName = request.getParameter("itemName");
			int itemPrice = Integer.parseInt(request.getParameter("itemPrice"));
			int categoryId = Integer.parseInt(request.getParameter("categoryId"));
			String itemContents = request.getParameter("itemContents");
			System.out.println(itemName+"  <--itemId dopost() itemName");
			System.out.println(itemPrice+"  <--itemId dopost() itemPrice");
			System.out.println(itemContents+"  <--itemId dopost() itemContents");
			System.out.println(categoryId+"  <--categoryId dopost() categoryId");
			
			Item item = new Item();
			item.setItemName(itemName);
			item.setItemPrice(itemPrice);
			item.setItemContents(itemContents);
			item.setCategoryId(categoryId);
			ItemDao itemDao = new ItemDao();
			itemDao.insertItem(item);
			
			response.sendRedirect(request.getContextPath()+"/admin/ItemList");
		}
	}
