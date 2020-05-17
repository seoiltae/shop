<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
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
      /* 본문 내 이미지 요소의 'position' 속성을 'static'으로 지정 */
      img.static { 
        position: static;
      }
    </style>
</head>
<body><center>
	<div class="jumbotron jumbotron-fluid">
	<h1>관리자 화면</h1>
	<h3>${SloginId}님 반갑습니다</h3>
	<!-- category CRUD -->
	<button type="submit" class="btn btn-outline-primary">
	<a href="${pageContext.request.contextPath }/admin/CategoryList">카테고리 관리</a>
	</button>
	<button type="submit" class="btn btn-outline-warning">
	<!--  item CRU -->
	<a href="${pageContext.request.contextPath }/admin/ItemList">상품 관리</a>
	</button>
	<!-- orders RUD -->
	<button type="submit" class="btn btn-outline-danger">
	<a href="${pageContext.request.contextPath}/admin/OrdersList">주문 관리</a>
	</button>
	</div>	
	<br>
		
		 <img src="${pageContext.request.contextPath}/imgs/main.jpg" class="static">
		<div>
			<a href="${pageContext.request.contextPath }/admin/InsertMember">회원가입</a>
			<a href="${pageContext.request.contextPath }/admin/UpdateMember?memberId=${SloginId}">회원정보 수정</a>
			<a href="${pageContext.request.contextPath }/admin/AdminLogout">로그아웃</a>
			<a href="${pageContext.request.contextPath }/admin/DeleteMember">회원탈퇴</a>
		</div>
	</div>
</body></center>
</html>