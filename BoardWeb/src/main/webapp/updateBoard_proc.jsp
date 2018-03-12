<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%-- <%
	//1. 파라미터 받기
	request.setCharacterEncoding("utf-8");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String seq = request.getParameter("seq");
	
	//2. DB연동처리
	BoardVO vo = new BoardVO();
	vo.setTitle(title);
	vo.setContent(content);
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAO dao = new BoardDAO();
	dao.updateBoard(vo);
	//3. 화면 이동
	response.sendRedirect("getBoardList.jsp");

%> --%>
<html><head>
<title>Insert title here</title>
</head>
<body>

</body>
</html>