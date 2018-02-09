<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<table border="1" bgcolor="violet">
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
	</table>
</body>
</html>