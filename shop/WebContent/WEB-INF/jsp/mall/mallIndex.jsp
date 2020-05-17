<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html lang="en">
<head>
  <title>쇼핑몰</title>
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
			<!--
			 상품 리스트 - 상품상세+주문폼 - 주문액션 - 주문정보폼(이름+전화번호) - 나의 주문목록 
			 -->
			 <div class="jumbotron jumbotron-fluid">
			 <center><h1>SHOP</h1>
			 </div>
			<form method="post" action="${pageContext.request.contextPath }/mall/MyOrdersList">
			<center>
			<div>
				고객 이름
				<input type="text" name=userName value="">
			</div>
			<div>
				고객 폰번호
				<input type="text" name=userPhone value="">
			</div>
			<button type="submit">검색</button>
			</div>
			</center>
			</form>
			
			 <h2>상품목록</h2>
				<table class="table table-borderless">
				 <tr>
				 	<c:forEach var="item" items="${list}" varStatus="stats">
				 			
				 			<c:if test="${stats.index != 0 && stats.index % 5 == 0}">
				 				</tr>
				 				<tr>
				 			</c:if>
				 			<td>
				 				<div>
				 					<img width="250" height="250" src="${pageContext.request.contextPath }/imgs/${item.itemImg}">
				 				</div>
				 				<div>
				 					<a href="${pageContext.request.contextPath}/mall/InsertOrders?itemId=${item.itemId}">
				 					${item.itemName}
				 					</a>
				 				</div>
				 			</td>		
				 	</c:forEach>
				 	<c:if test="${list.size() % 5 != 0 }">
								<c:forEach begin="${list.size() % 5}" end="4" step="1">
									<td>&nbsp;</td>
								</c:forEach>
				 				<!-- <td>&nbsp;</td> -->
				 	</c:if>
				</tr>	
				</table>
		</center>		
		</div>		
		</body>
</html>