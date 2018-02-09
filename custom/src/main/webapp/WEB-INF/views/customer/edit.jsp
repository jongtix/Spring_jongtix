<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form action="editCustomer/${customer.id}.do">
		<table border="1" bgcolor="violet">
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
		</table>
	</form>
</body>
</html>