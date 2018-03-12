<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<!-- 반응형 쿼리 지정 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no"/>
<head><title>새글 등록</title>
<!-- jquey mobile css 링크 -->
<!-- <link rel="stylesheet" 
           href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css"/> -->
<!-- jquery -->
<!-- <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script> -->
<!-- jquery mobile  -->
<!-- <script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script> -->
</head>
<body>
<h1>글 등록</h1>
<a href="logout.do">Log-out</a>
<hr>
<form action="insertBoardProc.do" method="post">
<table border="1" >
<tr data-role="fieldcontain">
<td>제목</td>
<td ><input type="text" name="title"></td>
</tr>
<tr data-role="fieldcontain">
<td>작성자</td>
<td><input type="text" name="writer"></td>
</tr>
<tr data-role="fieldcontain">
<td>내용</td>
<td><textarea rows="10" cols="40" name="content"></textarea></td>
</tr>
<tr data-role="fieldcontain">
<td colspan="2" align="center">
	<input  data-icon="forward" type="submit" value="새글 등록"/>
</td>
</tr>
</table>
</form>
<hr>
<a href="getBoardList.jsp">글 목록 가기</a>
</body>
</html>