<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html lang="en">
<head>
  <title>주문 수정</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<style>
      body{ background-color: #F7FFF5;}
       .footer{
    position: absolute;
    left: 0;
    bottom: 0;
    width: 100%;
	padding: 15px 0;
	text-align: center;
	color: white;
	}
</style>  
<body><center>
		<div class="jumbotron jumbotron-fluid">
		<h1>주문 수정</h1>
		${SloginId}님 반갑습니다
		</div>
			
			<c:if test="${orders ==null}">
				<a>상품이 없습니다</a>
			</c:if>
			<form method="post" action="${pageContext.request.contextPath}/admin/UpdateOrders">
				<c:if test="${orders !=null}">
				<div>
					주문번호 :
					<input type="text" name="ordersId" value="${orders.ordersId}" readonly="readonly">
				</div>
				<div>
					상품번호 : 
					<input type="text" name="itemId" value="${orders.itemId}" readonly="readonly">
				</div>
				
				<div>
					아이템 갯수 :
					<input type="text" name="itemCount" value="${orders.itemCount}" readonly="readonly">
				</div>
				<div>
					아이템 가격 :
					<input type="text" name="ordersPrice" value="${orders.ordersPrice }" readonly="readonly">
				</div>
				<div>
					주문상태 :
					<input type="radio" name="ordersState" value="주문취소">주문취소
					<input type="radio" name="ordersState" value="주문완료" >주문완료
					<input type="radio" name="ordersState" value="배송중" >배송중
					<input type="radio" name="ordersState" value="배송완료">배송완료
				</div>
				<div>
					고객이름 :
					<input type="text" name="userName" value="${orders.userName}" readonly="readonly">
				</div>
				<div>
					고객번호 :
					<input type="text" name="userPhone" value="${orders.userPhone}" readonly="readonly">
				</div>	
				<div>
					배송주소 :
					<input type="text" name="userAddress" value="${orders.userAddress}" readonly="readonly">
				</div>
				<div>
					<button type="submit">수정완료</button>
				</div>	
				</c:if>
			</form>	
			<div class="footer">
			<a href="${pageContext.request.contextPath }/admin/Index">메인화면</a>
			<a href="${pageContext.request.contextPath }/admin/OrdersList">이전화면</a>
			</div>
</body></center>
</html>