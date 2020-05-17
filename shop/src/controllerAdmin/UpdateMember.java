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

/**
 * Servlet implementation class UpdateMember
 */
@WebServlet("/admin/UpdateMember")
public class UpdateMember extends HttpServlet {
	private MemberDao memberDao;

	// �����ڳ��� �� ���� ������
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println(memberId+" <--updatememberId doget()");
		String memberId = request.getParameter("memberId");
		this.memberDao = new MemberDao();
		// �� ȣ��
		Member member = memberDao.selectloginOne(memberId);
		// ��� �ѱ�
		request.setAttribute("member", member);
		// System.out.println(memberId+" <--updatememberId doget()");
		request.getRequestDispatcher("/WEB-INF/jsp/admin/updateMember.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// �α��� ���ǰ�
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("SloginId") + "  <--SloginId");

		if (session.getAttribute("SloginId") == null) {
			response.sendRedirect(request.getContextPath() + "/admin/AdminLogin");
			return;
		}

		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		System.out.println(memberId + "  <--doPost() memberId");
		System.out.println(memberPw + "  <--doPost() memberPw");

		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);

		this.memberDao = new MemberDao();
		this.memberDao.updateMember(member);

		response.sendRedirect(request.getContextPath() + "/admin/AdminLogin");
	}

}
