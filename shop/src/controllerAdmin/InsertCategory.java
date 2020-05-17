package controllerAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CategoryDao;
import vo.Category;

@WebServlet("/admin/InsertCategory")
public class InsertCategory extends HttpServlet{
	// InsertCategory��û�� get��� -> �Է���
	@Override // C-V
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/admin/insertCategory.jsp").forward(request, response);
	}
	
	// InsertCategory��û�� post��� -> �Է�
	@Override // C- M --> C("/CategoryList")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
		//1. ��û�м� (�ּҺм�, request�м�)
		request.setCharacterEncoding("UTF-8");
		String categoryName = request.getParameter("categoryName");
		System.out.println(categoryName+"<-- InsertCategory.doPost() categoryName");
		Category category = new Category();
		category.setCategoryName(categoryName);
		
		// 2. �� ȣ��
		CategoryDao categoryDao = new CategoryDao();
		categoryDao.insertCategory(category);
		
		// 3. �� ���� or �ٸ� ��Ʈ�ѷ��� �����̷�Ʈ
		response.sendRedirect(request.getContextPath()+"/admin/CategoryList");
	}
	
}
