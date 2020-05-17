<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
  <title>Bootstrap Example</title>
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
	<center><body>
		<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1>주문화면</h1>
			<a href="${pageContext.request.contextPath}/mall/MallIndex">처음화면</a>
		</div>
		</div>
		<!-- item 상세화면 -->
			<table class="table table-hover">
				<tr>
					<td>상품번호</td>
					<td>${item.itemId}</td>
					
				</tr>
				<tr>
					<td>카테고리번호</td>
					<td>${item.categoryId}</td>
					
				</tr>
				<tr>
					<td>상품이름</td>
					<td>${item.itemName}</td>
					
				</tr>
				<tr>
					<td>상품가격</td>
					<td>${item.itemPrice}</td>
					
				</tr>
				<tr>
					<td>상품내용</td>
					<td>${item.itemContents}</td>
					
				</tr>
				<tr>
					<td>상품이미지</td>
					<td>
					<img width="300" height="300" src="${pageContext.request.contextPath }/imgs/${item.itemImg}" >
					</td>
				</tr>
				</table>	
			<!-- 주문 폼 -->
			<form method="post" action="${pageContext.request.contextPath }/mall/InsertOrders">
				<input type="hidden" name="itemId" value="${item.itemId}">
				<input type="hidden" name="itemPrice" value="${item.itemPrice}">
				<div>
					아이템갯수
					<input type="text" name="itemCount" value="">
				</div>
				<div>
					고객이름
					<input type="text" name="userName" value="">
				</div>
				<div>
					고객폰번호
					<input type="text" name="userPhone" value="">
				</div>
				<div>
					고객주소
					<input type="text" name="userAddress" value="">
				</div>
				<div>
					<button type="submit">주문하기</button>
				</div>
			</form>
	</body></center>
</html>