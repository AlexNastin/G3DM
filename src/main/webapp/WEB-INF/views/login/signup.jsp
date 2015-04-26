<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<link href="<c:url value="/resources/css/stylesheet.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<link rel="stylesheet" href="<c:url value="/resources/css/formValidation.css"/>">
<script src="<c:url value="/resources/js/jquery.min.js" />"> </script>
<script src="<c:url value="/resources/js/jquery-2.1.1.js" />"> </script>
<script src="<c:url value="/resources/js/jquery.validate.min.js" />"> </script>
<script src="<c:url value="/resources/js/validation.js" />"> </script>
<title><spring:message code="signup.signup" /></title>
<spring:message code="signup.login" var="login"/>
<spring:message code="signup.password" var="password"/>
<spring:message code="signup.confirmpassword" var="confirmpassword"/>
<spring:message code="signup.nickname" var="nickname"/>

</head>
<body>
<%@include file="/WEB-INF/views/header.jsp" %>  
<div class="col-md-4"></div>
<div class="container col-md-5">
	<form:form id="contact-form" name="contact-form" class="form-horizontal" modelAttribute="signupForm" method="POST">
	    <div class="form-group">
	    <div class="col-md-9">  
		<form:radiobutton path="role_idRole" value="2"  /><spring:message code="signup.designer" />
		<form:radiobutton path="role_idRole" value="3"  /><spring:message code="signup.user" />
		<span class="error"><form:errors path="role_idRole" /></span>
		</div>
		</div>
		<div class="form-group">
		<div class="col-md-5">
		<form:input id="login" name="login" class="form-control input-md" path="login" placeholder="${login}"></form:input>
		</div>
		<div class="col-md-5">
		<span class="error"><form:errors path="login" /></span>
		</div>
		</div>
		<div class="form-group">
		<div class="col-md-5">
		<form:password class="form-control input-md" path="password" placeholder="${password}"></form:password>
		</div>
		<div class="col-md-5">
		<span class="error"><form:errors path="password" /></span>
		</div>
		</div>
		<div class="form-group">
		<div class="col-md-9">
		<form:password class="form-control input-md" path="confirmPassword" placeholder="${confirmpassword}"></form:password>
		<span class="error"><form:errors path="confirmPassword" /></span>
		</div>
		</div>
		<div class="form-group">
		<div class="col-md-9">
		<form:input class="form-control input-md" path="nickName" placeholder="${nickname}"></form:input>
		<span class="error"><form:errors path="nickName" /></span>
		</div>
		</div>
		<div class="form-group">
		<div class="col-md-9">
		<input type="submit" class="btn btn-primary signin-button-color" value="<spring:message code="signup.signup"/>" />
		</div>
		</div>
	</form:form>
	</div>
	<div class="col-md-4"></div>
	 <div class="clearfix"></div>
	<%@include file="/WEB-INF/views/footer.jsp" %>  
</body>
</html>