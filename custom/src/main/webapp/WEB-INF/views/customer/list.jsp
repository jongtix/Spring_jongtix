<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h2>회원정보</h2>
	<table border="1" bgcolor="violet">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>주소</th>
			<th>이메일</th>
		</tr>

		<c:if test="${empty list}">
			<tr>
				<td colspan="4">리스트가 비었습니다.</td>
			</tr>
		</c:if>

		<c:if test="${!empty list}">
			<c:forEach var="list" items="${list}">
				<tr>
					<td>${list.id}</td>
					<td>${list.name}</td>
					<td>${list.address}</td>
					<td>${list.email}</td>
				</tr>
			</c:forEach>
		</c:if>
		
	</table>
</body>
</html>