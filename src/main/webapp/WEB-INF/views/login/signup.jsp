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
<spring:message code="signup.password" var="password"/>
<spring:message code="signup.confirmpassword" var="confirmpassword"/>
<spring:message code="signup.nickname" var="nickname"/>
</head>
<body>
	<form:form modelAttribute="signupForm" method="POST">
		<form:radiobutton path="role_idRole" value="0" />Dis 
		<form:radiobutton path="role_idRole" value="1" />User
		<form:input path="login" placeholder="${login}"></form:input>
		<span class="error"><form:errors path="login" /></span>
		<form:password path="password" placeholder="${password}"></form:password>
		<span class="error"><form:errors path="password" /></span>
		<form:password path="confirmPassword" placeholder="${confirmpassword}"></form:password>
		<span class="error"><form:errors path="confirmPassword" /></span>
		<form:input path="nickName" placeholder="${nickname}"></form:input>
		<span class="error"><form:errors path="nickName" /></span>
		<input type="submit" value="<spring:message code="signup.signup"/>" />



	</form:form>
</body>
</html>