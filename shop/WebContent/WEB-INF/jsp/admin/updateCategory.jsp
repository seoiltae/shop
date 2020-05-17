<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>카테고리 수정</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<style>
      body{ background-color: #F7FFF5;}
    .footer {
    position: absolute;
    left: 0;
    bottom: 0;
    width: 100%;
	padding: 15px 0;
	text-align: center;
	color: white;
	}
</style>      
</head>
<body><center>
 	<div class="jumbotron jumbotron-fluid">
	<h1>카테고리 수정</h1>
	${SloginId}님 반갑습니다
	</div>
	
	<form method="post" action="${pageContext.request.contextPath}/admin/UpdateCategory">
		<div>
			category_id : 
			<input type="text" name="categoryId" value="${category.categoryId}" readonly="readonly">
			category_name :
			<input type="text" name="categoryName" value="${category.categoryName}">
		</div>
		<div><button type="submit">수정하기</button></div>
	</form>
	 	<div class="footer">		
			<a href="${pageContext.request.contextPath }/admin/AdminLogout">로그아웃</a>
			<a href="${pageContext.request.contextPath }/admin/Index">메인화면</a>
		</div>
</body></center>
</html>