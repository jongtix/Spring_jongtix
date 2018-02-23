<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title></head>
<body>
	<h2>확인화면</h2>
<form method="post">
<table height="200">
	<tr><td>이름</td><td>${editCustomer.name }</td></tr>
	<tr><td>주소</td><td>${editCustomer.address }</td></tr>
	<tr><td>이메일</td>
		<td>${editCustomer.emailAddress }</td></tr>
</table>
<button type="submit" name="_event_confirmed">갱신</button>
<button type="submit" name="_event_revise">재입력</button>
</form>
</body>
</html>