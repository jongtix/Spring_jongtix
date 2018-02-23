<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% response.setStatus(200); %>
<html>
<head>
<title>예외발생(디버그용)</title>
</head>
<body>
<h1>예외발생(디버그용)</h1>
<dl>
<dt>메시지</dt>
<dd>${exception.message}</dd>
</dl>
</body>
</html>