<%@page import="com.springbook.biz.user.impl.UserDAO"%>
<%@page import="com.springbook.biz.user.UserVO"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
	//1.사용자 정보
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	//2.dB처리
	UserVO user = new UserVO();
	user.setId(id);
	user.setPassword(password);
	
	UserDAO dao = new UserDAO();
	UserVO user2 = dao.getUser(user);
	
	//3. 세션처리 및 화면 이동
	if(user2!=null){
		session.setAttribute("id", user2.getId());
		response.sendRedirect("getBoardList.jsp");
	}
	else
		response.sendRedirect("login.jsp");
%>
<html>
<head>
<title>로그인 처리 </title>
</head>
<body>

</body>
</html>