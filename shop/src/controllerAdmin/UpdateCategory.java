package controllerAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CategoryDao;
import vo.Category;

@WebServlet("/admin/UpdateCategory")
public class UpdateCategory extends HttpServlet {
	private CategoryDao categoryDao;

	// 수정 폼을 보여줄거 C-M-V
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 로그인 세션값
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("SloginId") + "  <--SloginId");

		if (session.getAttribute("SloginId") == null) {
			response.sendRedirect(request.getContextPath() + "/admin/AdminLogin");
			return;
		}

		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		System.out.println(categoryId + "  <--UpdateCateogory.doGet() categoryId");
		this.categoryDao = new CategoryDao();
		Category category = categoryDao.selectCategoryOne(categoryId);

		request.setAttribute("category", category); //
		// view forward
		request.getRequestDispatcher("/WEB-INF/jsp/admin/updateCategory.jsp").forward(request, response);
		;
	}

	// 수정 액션(C-M) ->(C)reDirect
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // doPost안에는 인코딩이 있어야한다 //ex)같은 언어로 대화하겠다
		int categoryId = Integer.parseInt(request.getParameter("categoryId")); // categoryId를 형변환 시켜 request.안에 받겟다
		String categoryName = request.getParameter("categoryName");
		System.out.println(categoryId + "<--categoryId doPost() categoryId");
		System.out.println(categoryName + "<--categoryName doPost() categoryName");

		Category category = new Category();
		category.setCategoryId(categoryId);
		category.setCategoryName(categoryName);

		this.categoryDao = new CategoryDao();
		this.categoryDao.updateCategory(category);

		response.sendRedirect(request.getContextPath() + "/admin/CategoryList");
	}

}
