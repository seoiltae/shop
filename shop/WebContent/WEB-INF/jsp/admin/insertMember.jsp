<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
  <title>관리자 회원가입</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<style>
      body{ background-color: #F7FFF5;}
    </style>
</head>
<body><center>
	<div class="jumbotron jumbotron-fluid">
	<h1>회원가입</h1>
	</div>
	<form method="post" action="${pageContext.request.contextPath}/admin/InsertMember">
		<div>
			아이디 :
			<input type="text" name="memberId">
			비밀번호 :
			<input type="password" name="memberPw">
		</div>
		<button type="submit">가입하기</button>
	</form>
</body></center>
</html>