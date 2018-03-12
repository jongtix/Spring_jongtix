<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html><head><title><spring:message code="message.board.list.mainTitle"/></title></head>
<body>
  <h1><spring:message code="message.board.list.mainTitle"/></h1>
  <h3>${userName}<spring:message code="message.board.list.welcomeMsg"/><a href="logout.do">Log_out</a></h3>
<form action="getBoardList.do" method="post"> 
	<table border="1">
	<tr>
		<td align="center">
		<select name="searchCondition">
			<c:forEach items="${conditionMap}" var="option">
				<option value="${option.value}">${option.key}
			</c:forEach>
		</select>
		<input type="text" name="searchKeyword">
		<input type="submit" value="<spring:message code="message.board.list.search.condition.btn"/>"/>
		</td>
	</tr>
	</table>
</form> 
<!--검색 종료  -->
  <table border="1" >  
  <tr>
  <th><spring:message code="message.board.list.table.head.seq"/></th>
  <th><spring:message code="message.board.list.table.head.title"/></th>
  <th><spring:message code="message.board.list.table.head.writer"/></th>
  <th><spring:message code="message.board.list.table.head.regDate"/></th>
  <th><spring:message code="message.board.list.table.head.cnt"/></th>
  </tr>

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
  <a href ="insertBoard.do"><spring:message code="message.board.list.link.insertBoard"/></a>
</body>
</html>