<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	// 1. Board정보 출력
	BoardDAO dao = new BoardDAO();
	BoardVO vo = new BoardVO();
	List<BoardVO> list = dao.getBoardList(vo);
	System.out.println(list.size());
%>
<html>
<head>
<title>boardList</title>
</head>
<body>
	<h1>BoardList</h1>
	<h3>
		<a href="logout_proc.jsp">로그아웃</a>
	</h3>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<%
			for (int i = 0; i < list.size(); i++) {
				BoardVO b = list.get(i);
		%>
		<tr>
			<td><%=b.getSeq()%></td>
			<td><%=b.getTitle()%></td>
			<td><%=b.getWriter()%></td>
			<td><%=b.getRegDate()%></td>
			<td><%=b.getCnt()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>