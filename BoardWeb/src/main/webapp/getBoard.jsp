<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html><head><title><spring:message code="message.board.view.mainTitle"/></title>
<script type="text/javascript">
function myFunction(){
	alert(document.forms[0].uploadFile.value);
	document.forms[0].span[0].innerHTML=document.forms[0].uploadFile.value; 
}
</script>
</head><body>
<a href="logout.do"><spring:message code="message.user.link.logout"/></a>
<hr>
<form action="updateBoard.do" method="post" enctype="multipart/form-data">
<input type="hidden" name="seq" value="${board.seq}">
	<table border=1>
	<tr>
		<td><spring:message code="message.board.view.table.head.seq"/></td>
		<td><input type="text" name="title" value="${board.title}">
	</tr>
	<tr>
		<td><spring:message code="message.board.insert.table.head.upload"/></td>
		<td><input type="file" name="uploadFile" value="${board.files}" onchange="myFunction()">
		<span><a href="${board.files}">${board.files}</a></span>
		<!-- link 택은 미디어는 실행, 일반파일은 download -->
		</td>
	</tr>
	<tr>
		<td><spring:message code="message.board.view.table.head.title"/></td>
		<td><input type="text" name="writer" value="${board.writer}"></td>
	</tr>
	<tr>
		<td><spring:message code="message.board.view.table.head.content"/></td>
		<td><textarea name="content" cols="40" rows="10">${board.content}</textarea>
	</tr>
	<tr>
		<td><spring:message code="message.board.view.table.head.regDate"/></td>
		<td>${board.regDate}</td>
	</tr>
	<tr>
		<td><spring:message code="message.board.view.table.head.cnt"/></td>
		<td>${board.cnt}</td>
	</tr>
	
	<tr>
	<td colspan="2" align="center">
	 <input type="submit" value="<spring:message code="message.board.view.viewBtn"/>"/>
	</tr>
	</table>
</form>
<hr>
<a href="insertBoard.do"><spring:message code="message.board.view.link.insertBoard"/></a>&nbsp;&nbsp;&nbsp;
<a href="deleteBoard.do?seq=${board.seq}"><spring:message code="message.board.view.link.deleteBoard"/></a>&nbsp;&nbsp;&nbsp;
<a href="getBoardList.do"><spring:message code="message.board.view.link.getBoardList"/></a>

</body>
</html>