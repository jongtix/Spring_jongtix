<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//세션 종료 처리
	session.invalidate();
	// 로그인 화면으로 이동
	response.sendRedirect("login.jsp");
%>
<html><head>
<title>로그아웃 처리</title>
</head>
<body>

</body>
</html>