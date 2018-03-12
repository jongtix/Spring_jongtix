<%@page import="java.util.Date"%>
<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%-- <%
//1. 파라미터 받기
	request.setCharacterEncoding("utf-8");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String writer = request.getParameter("writer");
	Date date = new Date();
	java.sql.Date date1 = new java.sql.Date(date.getTime());
	
	//2.DB연동 처리
	BoardVO vo = new BoardVO();
	vo.setTitle(title);
	vo.setContent(content);
	vo.setWriter(writer);
	vo.setRegDate(date1);
	
	BoardDAO dao = new BoardDAO();
	dao.insertBoard(vo);
	
	//3. 화면이동
	response.sendRedirect("getBoardList.jsp");
	
%> --%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
</body>
</html>