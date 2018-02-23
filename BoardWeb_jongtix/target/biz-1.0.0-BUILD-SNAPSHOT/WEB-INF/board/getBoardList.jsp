<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <%
	 String id = (String)session.getAttribute("id");
     if(id==null|"".equals(id))
    	 response.sendRedirect("login.jsp");
     
	//1.Board 정보 출력
	BoardDAO dao = new BoardDAO();
	BoardVO vo = new BoardVO();
	List<BoardVO> list = dao.getBoardList(vo);
%> --%>
<%-- <%
List<BoardVO> list = (List)session.getAttribute("boardList");
%> --%>
<html>
<head>
<title>boardList</title>
</head>
<body>
	<h1>게시글 목록</h1>
	<h3>
		${userName}님, 게시판에 오신걸 환영합니다. <a href="logout.do">Log_out</a>
	</h3>
	<form action="getBoardList.do" method="post">
		<table border="1">
			<tr>
				<td align="right"><select name="searchCondition">
						<c:forEach items="${conditionMap}" var="option">
							<option value="${option.value}"
								<c:if test="${condition==null&&option.value=='TITLE'}">selected="selected"</c:if>
								<c:if test="${option.value==condition}">selected="selected"</c:if>>${option.key}</option>
						</c:forEach>
				</select><input type="text" name="searchKeyword"
					<c:if test="${keyword!=null}">value='${keyword}'</c:if>><input
					type="submit" value="검색"></td>
			</tr>
		</table>
	</form>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<%-- <%
  for(int i=0;i<list.size();i++){
  %>
  <tr>
  <td><%=list.get(i).getSeq()%></td>
  <td><a href="getBoard.do?seq=<%=list.get(i).getSeq()%>"><%=list.get(i).getTitle()%></a></td>
  <td><a href="getBoard.jsp?seq=<%=list.get(i).getSeq()%>"><%=list.get(i).getTitle()%></a></td>
  <td><%=list.get(i).getWriter()%></td>
  <td><%=list.get(i).getRegDate()%></td>
  <td><%=list.get(i).getCnt()%></td>
  </tr>	  
 <%}
 %> 
 --%>
		<c:forEach var="l" items="${boardList}">
			<tr>
				<td>${l.seq}</td>
				<td><a href="getBoard.do?seq=${l.seq}">${l.title}</a></td>
				<td>${l.writer}</td>
				<td>${l.regDate}</td>
				<td>${l.cnt}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="insertBoard.do">새글등록</a>
</body>
</html>