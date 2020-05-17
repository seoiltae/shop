package controllerAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDao;

@WebServlet("/admin/DeleteMember")
public class DeleteMember extends HttpServlet{
	MemberDao memberDao;
	
	//È£¿øÅ»Åð ÁøÇà Ã¢À¸·Î ÀÌµ¿
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/admin/deleteMember.jsp").forward(request, response);
	}
	
	//post¹æ½Ä È¸¿øÅ»Åð ÈÄ ·Î±×ÀÎÃ¢À¸·Î!
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		System.out.println(memberId+"È¸¿øÅ»Åð <--doPost memberId");
		System.out.println(memberPw+"È¸¿øÅ»Åð <--doPost memberId");
		
		this.memberDao = new MemberDao();
		memberDao.deleteMember(memberId);
		
		response.sendRedirect(request.getContextPath()+"/admin/AdminLogin");
	}
}
