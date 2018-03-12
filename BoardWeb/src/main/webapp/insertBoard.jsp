<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<!-- 반응형 쿼리 지정 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no"/>
<head><title><spring:message code="message.board.insert.mainTitle"/></title>
</head>
<body>
<h1><spring:message code="message.board.insert.mainTitle"/></h1>
<a href="logout.do"><spring:message code="message.user.link.logout"/></a>
<hr>
<form action="insertBoardProc.do" method="post" enctype="multipart/form-data">
<table border="1" >
<tr data-role="fieldcontain">
<td><spring:message code="message.board.insert.table.head.title"/></td>
<td ><input type="text" name="title"></td>
</tr>
<tr>
<td><spring:message code="message.board.insert.table.head.upload"/></td>
<td>
<input type="file" name="uploadFile">
</td>
</tr>
<tr data-role="fieldcontain">
<td><spring:message code="message.board.insert.table.head.writer"/></td>
<td><input type="text" name="writer" value="${userName}" readonly="readonly"></td>
</tr>
<tr data-role="fieldcontain">
<td><spring:message code="message.board.insert.table.head.content"/></td>
<td><textarea rows="10" cols="40" name="content"></textarea></td>
</tr>
<tr data-role="fieldcontain">
<td colspan="2" align="center">
	<input  data-icon="forward" type="submit" value="<spring:message code="message.board.insert.insertBtn"/>"/>
</td>
</tr>
</table>
</form>
<hr>
<a href="getBoardList.do"><spring:message code="message.board.insert.link.getBoardList"/></a>
</body>
</html>