<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>로그인 화면</title>
</head>
<body>
<h1>로그인</h1>
<form action="login.do" method="post">
<table border="1" cellpadding="0" cellspacing="0">
<tr>
<td>아이디</td>
<td><input type="text" name="id"></td>
</tr>
<tr>
<td>비밀번호</td>
<td><input type="password" name="password"></td>
</tr>
<tr><td colspan="2" align="center">
    <input type="submit" value="확인">
   </td>
</tr> 
</table>
</form>
</body>
</html>