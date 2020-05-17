package controllerAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDao;
import vo.Member;


@WebServlet("/admin/AdminLogin") //({"/admin", "/admin/Index"}) ���ΰ��� �ΰ��� �����ϴ¹�
public class AdminLogin extends HttpServlet {
	private MemberDao memberDao;
	//�α��� ��
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/admin/adminLogin.jsp").forward(request, response);
	}
	
	//�α��ξ׼� ����
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String adminId = request.getParameter("adminId");
		String adminPw = request.getParameter("adminPw");
		Member member = new Member();
		member.setMemberId(adminId);
		member.setMemberPw(adminPw);
		
		MemberDao memberDao = new MemberDao();
		Member SMember = memberDao.login(member);
		
		if(SMember != null) {
			System.out.println("�α��� ����");
			// 1. �α����ߴٴ� ������ ���Ͼ�(����)�� �����ؾ��Ѵ�
			HttpSession session = request.getSession();
			session.setAttribute("SloginId", SMember.getMemberId());
			// 2. ������ ����ȭ������ �̵��Ѵ� Index
			response.sendRedirect(request.getContextPath()+"/admin/Index");
			
		} else {
			System.out.println("�α��� ����");
			response.sendRedirect(request.getContextPath()+"/admin/AdminLogin");
		}
		
	}
}
