<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<body>
	<center><h1>주문검색</h1>
	<div class="container-fluid">
		<div>
			<a href="${pageContext.request.contextPath}/mall/MallIndex">처음화면</a>
		</div>
		<form method="post" action="${pageContext.request.contextPath }/mall/MyOrdersList">
			<div>
				고객 이름
				<input type="text" name=userName value="">
			</div>
			<div>
				고객 폰번호
				<input type="text" name=userPhone value="">
			</div>
			<button type="submit">주문확인</button>
		</form>
	</div>
	</center>
	</body>
</html>