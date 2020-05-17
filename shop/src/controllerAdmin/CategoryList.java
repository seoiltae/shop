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

import model.CategoryDao;
import vo.Category;

@WebServlet("/admin/CategoryList") //이노테이션, 맵핑
public class CategoryList extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 세션값
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("SloginId")+"  <--SloginId");
		
		
		if(session.getAttribute("SloginId") == null) {
			response.sendRedirect(request.getContextPath()+"/admin/AdminLogin");
			return;
		} 
				
		
		//controller 역할
		//  1) request 분석
			System.out.println(request.getRemoteAddr()); // 내가 넣는 공간
			
		//request.getParameter("")
		//  2) model 호출
			CategoryDao categoryDao = new CategoryDao();
			ArrayList<Category> list = categoryDao.selectCategoryListAll();
			System.out.println(list.size()); // null 3
			request.setAttribute("list", list); //Object 
			
		// 	3) view 연결 */
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin/categoryList.jsp");
			rd.forward(request, response);
	}
}
