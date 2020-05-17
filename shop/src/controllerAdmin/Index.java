package controllerAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Member;
@WebServlet("/admin/Index")
public class Index extends HttpServlet {
	
	//수정폼!
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 세션값
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("SloginId")+"  <--SloginId");
		
		
		if(session.getAttribute("SloginId") == null) {
			response.sendRedirect(request.getContextPath()+"/admin/AdminLogin");
			return;
		} 
		
		request.getRequestDispatcher("/WEB-INF/jsp/admin/index.jsp").forward(request, response);
		
	}

}
