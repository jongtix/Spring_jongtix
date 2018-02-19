<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>회원 가입 정보</title>
</head>
<body>
	<table>
		<caption>
			<h3>${name}님 회원가입을축하드립니다.</h3>
		</caption>
		<tr>
			<th>나이</th>
			<td>${age}세</td>
		</tr>
		<tr>
			<th>성별</th>
			<td>${gen}</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${addr}</td>
		</tr>
		<tr>
			<th>가입일자</th>
			<td>${reg}</td>
		</tr>
	</table>
</body>
</html>