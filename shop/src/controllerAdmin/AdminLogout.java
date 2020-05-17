package controllerAdmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/admin/AdminLogout")
public class AdminLogout extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate(); // 현재 요청주인의 세션을 지우고 새로 (리셋)
		System.out.println("현재 요청주인의 요청을 리셋");
		response.sendRedirect(request.getContextPath()+"/admin/AdminLogin");
		
	}

}
