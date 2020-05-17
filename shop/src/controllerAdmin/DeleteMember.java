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
	
	//ȣ��Ż�� ���� â���� �̵�
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/admin/deleteMember.jsp").forward(request, response);
	}
	
	//post��� ȸ��Ż�� �� �α���â����!
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		System.out.println(memberId+"ȸ��Ż�� <--doPost memberId");
		System.out.println(memberPw+"ȸ��Ż�� <--doPost memberId");
		
		this.memberDao = new MemberDao();
		memberDao.deleteMember(memberId);
		
		response.sendRedirect(request.getContextPath()+"/admin/AdminLogin");
	}
}
