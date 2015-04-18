<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>Insert title here</title>
<spring:message code="signup.login" var="login"/>
</head>
<body>
	<form:form modelAttribute="user" method="POST" action="/signup">
		<form:radiobutton path="role_idRole" value="0" />Dis 
<form:radiobutton path="role_idRole" value="1" />User
<form:label path="login">
			
		</form:label>
		<form:input path="login" placeholder="${login}"></form:input>



	</form:form>
</body>
</html>