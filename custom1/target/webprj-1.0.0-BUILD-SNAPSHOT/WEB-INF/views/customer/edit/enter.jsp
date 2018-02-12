<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html><head>
<title>Insert title here</title></head><body>
<h2>입력화면</h2>
<form:form modelAttribute="editCustomer">	
	<spring:hasBindErrors name="editCustomer">	
		<spring:message code="${ngemail.code}" />
	</spring:hasBindErrors>
	
	<dl>
	<dt>이름</dt><dd><form:input path="name"/>
		<form:errors path="name"/></dd>
	<dt>주소</dt><dd><form:input path="address"/>
		<form:errors path="address"/></dd>
	<dt>이름</dt><dd><form:input path="emailAddress"/>
		<form:errors path="emailAddress"/></dd></dl>
	<button type="submit" name="_event_proceed" 
		value="proceed" >다음</button>	
	</form:form>
</body>
</html>