<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html lang="en">
<head>
  <title>내 주문목록</title>
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
	<body>
	<div class="container-fluid">
		<div>
			<a href="${pageContext.request.contextPath}/mall/MallIndex">처음화면</a>
		</div>
		 <!-- 나의 주문확인 -->
		 <table class="table table-bordered table-sm">
		 	<tr>
		 		<th>주문번호</th>
		 		<th>상품수량</th>
		 		<th>총가격</th>
		 		<th>진행상태</th>
		 		<th>고객이름</th>
		 		<th>고객폰번호</th>
		 		<th>고객주소</th>
		 	</tr>
		 	<c:forEach var="o" items="${list}">
		 	<tr>
		 		
		 		<td>${o.ordersId}</td>
		 		<td>${o.itemCount}</td>
		 		<td>${o.ordersPrice}</td>
		 		<td>${o.ordersState}</td>
		 		<td>${o.userName}</td>
		 		<td>${o.userPhone}</td>
		 		<td>${o.userAddress}</td>
		 		
		 	</tr>
		 	</c:forEach>
		 </table>
	</div>
	</body>
</html>