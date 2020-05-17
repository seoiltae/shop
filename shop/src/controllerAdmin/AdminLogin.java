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


@WebServlet("/admin/AdminLogin") //({"/admin", "/admin/Index"}) 맵핑값을 두개로 지정하는법
public class AdminLogin extends HttpServlet {
	private MemberDao memberDao;
	//로그인 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/admin/adminLogin.jsp").forward(request, response);
	}
	
	//로그인액션 인증
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
			System.out.println("로그인 성공");
			// 1. 로그인했다는 정보를 톰켓안(변수)에 저장해야한다
			HttpSession session = request.getSession();
			session.setAttribute("SloginId", SMember.getMemberId());
			// 2. 관리자 메인화면으로 이동한다 Index
			response.sendRedirect(request.getContextPath()+"/admin/Index");
			
		} else {
			System.out.println("로그인 실패");
			response.sendRedirect(request.getContextPath()+"/admin/AdminLogin");
		}
		
	}
}
