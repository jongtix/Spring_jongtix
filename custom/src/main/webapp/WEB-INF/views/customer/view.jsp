<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<table border="1" bgcolor="violet">
		<caption>
			<h3>상세정보</h3>
		</caption>
		<c:if test="${!empty customer}">
			<tr>
				<th>아이디</th>
				<td>${customer.id}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${customer.name}</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>${customer.address}</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${customer.email}</td>
			</tr>
		</c:if>
		<c:if test="${empty customer}">
			<tr>
				<td colspan="2">정보가 없습니다.</td>
			</tr>
		</c:if>
	</table>
	<br>
	<c:url var="url" value="/customer.do"></c:url>
	<a href="${url}">목록</a>
	<c:url var="url" value="deleteCustomer.do?id=${customer.id}"></c:url>
	<a href="${url}">삭제</a>
</body>
</html>