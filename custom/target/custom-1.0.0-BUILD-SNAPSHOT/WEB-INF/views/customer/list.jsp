<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	tr:HOVER { background-color: red; color: white; }
</style></head><body><h2>회원정보</h2>
<table bgcolor="yellow" border="1">
<tr><th>아이디</th><th>이름</th><th>주소</th>
	<th>이메일</th><th>비고</th></tr>
<c:forEach var="ct" items="${list }">
	<tr>
		<td>${ct.id }</td><td>${ct.name }</td>
		<td>${ct.address }</td><td>${ct.emailAddress }</td>
		<td><c:url value="/customer/${ct.id }" var="url"></c:url>
			<a href="${url }">상세</a>&nbsp; 
			<c:url value="/customer/${ct.id }/edit" var="url"></c:url>
			<a href="${url }">수정</a></td>
</c:forEach></table></body>
</html>