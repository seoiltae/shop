<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>manager main</title>
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
		<h1>관리자 로그인</h1>
		</div>
		<form method="post" action="${pageContext.request.contextPath }/admin/AdminLogin">
			<div>
				ID : <input type="text" name="adminId">
				PW : <input type="password" name="adminPw">
			</div>
			<div>
				
			</div>
			<div>
				<button type="submit">로그인</button>
			</div>
		</form>	
</body></center>
</html>