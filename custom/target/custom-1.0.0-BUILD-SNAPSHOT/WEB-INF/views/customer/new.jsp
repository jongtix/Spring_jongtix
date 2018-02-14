<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>신규 가입</title>
</head>
<body>
	<form action="newCustomerPro.do" method="post">
		<table border="1" bgcolor="violet">
			<caption>
				<h3>신규가입</h3>
			</caption>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email"></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="확인"> <input
					type="reset" value="취소"></td>
			</tr>
		</table>
		<c:url var="url" value="/customer.do"></c:url>
		<a href="${url}">목록</a>
	</form>
</body>
</html>