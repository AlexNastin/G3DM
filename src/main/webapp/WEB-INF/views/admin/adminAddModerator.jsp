<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Admin's page | Global3dmod</title>

<spring:message code="signup.login" var="login" />
<spring:message code="signup.password" var="password" />
<spring:message code="signup.confirmpassword" var="confirmpassword" />
<spring:message code="signup.nickname" var="nickname" />
<spring:message code="signup.designer" var="designer" />
<spring:message code="signup.user" var="user" />
<spring:message code="signup.signup" var="signup" />
<spring:message code="signup.name" var="name" />
<spring:message code="signup.surname" var="surname" />
<spring:message code="javascript.validation" var="validation" />
</head>
<body>

	<form:form modelAttribute="addModeratorForm" method="POST">

		<form:input id="login" name="login" path="login"
			placeholder="${login}"></form:input>
		<span class="error color-style-validation"><form:errors
				path="login" /></span>
		<form:password id="password" name="password" path="password"
			placeholder="${password}"></form:password>
		<form:errors path="password" />
		<form:password id="confirmPassword" name="confirmPassword"
			path="confirmPassword" placeholder="${confirmpassword}"></form:password>
		<form:errors path="confirmPassword" />
		<form:input id="nickName" name="nickName" path="nickName"
			placeholder="${nickname}"></form:input>
		<form:errors path="nickName" />
		<form:input id="name" name="name" path="name"
			placeholder="${name}"></form:input>
		<form:errors path="name" />
		<form:input id="surname" name="surname" path="surname"
			placeholder="${surname}"></form:input>
		<form:errors path="surname" />
		<input type="submit" value="${signup}" />
	</form:form>


</body>
</html>
