<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form action="customerEditPro.do" method="post">
		<table border="1" bgcolor="violet">
			<caption>
				<h3>수정</h3>
			</caption>
			<c:if test="${!empty customer}">
				<tr>
					<th>아이디</th>
					<td><input type="text" value="${customer.id}" name="id"
						readonly="readonly"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" value="${customer.name}" name="name"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" value="${customer.address}"
						name="address"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" value="${customer.email}" name="email"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="수정">
						<input type="reset" value="다시작성">
				</tr>
			</c:if>
			<c:if test="${empty customer}">
				<tr>
					<td colspan="2">해당 정보가 없습니다.</td>
				</tr>
			</c:if>
		</table>
		<c:url var="url" value="/customer.do"></c:url>
		<a href="${url}">목록</a>
	</form>
</body>
</html>