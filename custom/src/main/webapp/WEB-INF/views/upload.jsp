<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="upload" method="post" enctype="multipart/form-data">
	파일 : <input type="file" name="uploadFile"><p>
	<input type="submit" value="확인">
</form><p>
<c:if test="${!empty msg }">
	${msg }
</c:if>
</body>
</html>

