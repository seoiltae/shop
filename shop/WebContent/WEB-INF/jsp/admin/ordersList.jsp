<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>주문 목록</title>
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
		<h1>주문 목록</h1>
		${SloginId}님 반갑습니다 
		</div>
			<c:if test="${list == null}">
				<a>상품이 없습니다</a>
			</c:if>
				<c:if test="${list !=null}">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ORDERS-ID</th>
							<th>ITEM-ID</th>
							<th>ITEM-COUNT</th>
							<th>ORDERS-DATE</th>
							<th>ORDERS-PRICE</th>
							<th>ORDERS-STATE</th>
							<th>USER-NAME</th>
							<th>USER-PHONE</th>
							<th>USER-ADDRESS</th>
							<th>수정</th>
						</tr>
					</thead>
							<tbody>
							<c:forEach var="o" items="${list}">
								<tr>
									<td>${o.ordersId}</td>
									<td>${o.itemId}</td>
									<td>${o.itemCount}</td>
									<td>${o.ordersDate}</td>
									<td>${o.ordersPrice}</td>
									<td>${o.ordersState}</td>
									<td>${o.userName}</td>
									<td>${o.userPhone}</td>
									<td>${o.userAddress}</td>
									<td><a href="${pageContext.request.contextPath}/admin/UpdateOrders?ordersId=${o.ordersId}">수정</a></td>
								</tr>
							</c:forEach>	
							</tbody>
				</table>
				</c:if>
		 <div class="footer">		
		<a href="${pageContext.request.contextPath }/admin/AdminLogout">로그아웃</a>
		<a href="${pageContext.request.contextPath }/admin/Index">메인화면</a>
		</div>
</body></center>
</html>