<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title></head><body>
<h2>상세 정보</h2>
아이디 : ${customer.id }<p>
이름 : ${customer.name }<p>
주소 : ${customer.address }<p>
이메일 : ${customer.emailAddress }<p>
<c:url var="url" value="/customer"></c:url>
<a href="${url }">목록</a>
</body>
</html>