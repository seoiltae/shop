<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<head>
  <title>카테고리 목록</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<style>
      body{ background-color: #F7FFF5;}
      /* 본문 내 이미지 요소의 'position' 속성을 'static'으로 지정 */
     .footer {
    position: absolute;
    left: 0;
    bottom: 0;
    width: 100%;
	padding: 15px 0;
	text-align: center;
	color: white;
      a.static { 
        position: static;
      }
    </style>
</head>
<body><center>
	<div class="jumbotron jumbotron-fluid">
	<h1>카테고리 목록</h1>
	${SloginId}님 반갑습니다
	</div>
	<table class="table table-borderless">
			<tr>
				<th>category_id</th>
				<th>category_name</th>
				<th>수정</th>
			</tr>
		<c:forEach var="c" items="${list}"> <!-- request.getAttribute("list") -->
			<tr>
				<td>${c.categoryId}</td>
				<td>${c.categoryName}</td>
				<td><a href="${pageContext.request.contextPath}/admin/UpdateCategory?categoryId=${c.categoryId}">수정</a></td>
			</tr>
		</c:forEach>			
	</table>
	<div class="footer">
		<a href="${pageContext.request.contextPath }/admin/AdminLogout">로그아웃</a>
		<a href="${pageContext.request.contextPath }/admin/Index">메인화면</a>
		<a href="${pageContext.request.contextPath}/admin/InsertCategory">카테고리 입력</a>
	</div>
</body></center>
</html>