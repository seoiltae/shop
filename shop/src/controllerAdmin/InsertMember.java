package controllerAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDao;
import vo.Member;

@WebServlet("/admin/InsertMember")
public class InsertMember extends HttpServlet {
	// 입력 폼으로 간다
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/admin/insertMember.jsp").forward(request, response);
	}

	// 입력 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		System.out.println(memberId + "  <--memberId doPost");
		System.out.println(memberPw + "  <--memberPw doPost");

		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);

		MemberDao memberDao = new MemberDao();
		memberDao.insertMember(member);

		response.sendRedirect(request.getContextPath() + "/admin/AdminLogin");
	}
}
