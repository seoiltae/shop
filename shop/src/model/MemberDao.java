package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import commons.DBUtil;
import vo.Member;

public class MemberDao {

	public void deleteMember(String memberId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("DELETE FROM member WHERE member_id=?");
			stmt.setString(1, memberId);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// �Է� ��
	public void insertMember(Member member) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("INSERT INTO member(member_id, member_pw) VALUES(?, ?)");
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// ���� �׼� �����
	public void updateMember(Member member) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("UPDATE member set member_pw=? WHERE member_id=?");
			stmt.setString(1, member.getMemberPw());
			stmt.setString(2, member.getMemberId());
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("MemberDao.updateMember <--�����");
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// ������ �����
	public Member selectloginOne(String memberId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Member member = null;
		try {
			member = new Member();
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM member WHERE member_id = ?");
			stmt.setString(1, memberId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				System.out.println("��� �ٿ��ǰ��� �Ѿ���� Ȯ���ڵ�");
			}
		} catch (Exception e) {
			System.out.println("selectMemberOne(String memberId) <--MemberDao ����Ȯ��");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return member;
	}

	public Member login(Member member) {
		Member returnMember = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection(); // static�� ���� ���� �����ü� �ִ�
			stmt = conn.prepareStatement("SELECT * " + "FROM member " + "WHERE member_id=? and member_pw=?");
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			rs = stmt.executeQuery();
			if (rs.next()) {
				returnMember = new Member();
				returnMember.setMemberId(rs.getString("member_id"));
				returnMember.setMemberPw(rs.getString("member_pw"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, stmt, conn); // select
			// DBUtil.close(null, stmt, conn); // insert.update delete
		}
		return returnMember;
	}
}
