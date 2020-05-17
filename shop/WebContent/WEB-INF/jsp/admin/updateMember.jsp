<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 정보 수정</title>
</head>
<body><center>
	<h1>관리자 회원 수정</h1>
		<form method="post" action="${pageContext.request.contextPath }/admin/UpdateMember">
			<div>
				member_id :
				<input type="text" name="memberId" value="${member.memberId}" readonly="readonly">
			</div>
			<div>
				member_pw :
				<input type="password" name="memberPw" value="">
			</div>
			<div>
			<button type="submit">비밀번호 번경</button>
			</div>
		</form>
</body></center>
</html>