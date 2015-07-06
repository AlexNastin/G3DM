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
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">

<link href="<c:url value="/resources/css/prettyPhoto.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/feature-carousel.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/sign.css"  />" rel="stylesheet" />
<link rel="stylesheet" href="<c:url value="/resources/css/formValidation.css"/>">
<link href="<c:url value="/resources/css/fontawesome430/css/font-awesome.min.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/radio.css"  />" rel="stylesheet" />
<link rel="icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon">
<title><spring:message code="signup.signup" /></title>
<spring:message code="signup.login" var="login"/>
<spring:message code="signup.password" var="password"/>
<spring:message code="signup.confirmpassword" var="confirmpassword"/>
<spring:message code="signup.nickname" var="nickname"/>
<spring:message code="signup.designer" var="designer"/>
<spring:message code="signup.user" var="user" />
<spring:message code="signup.signup" var="signup" />


</head>
<body>
<%@include file="/WEB-INF/views/header/header.jsp" %> 
<div class="signup-background height-sign">
<div class="col-md-4"></div>
<div class="col-md-4"></div>
<div class="container col-md-3 sign-up-background">
	<form:form id="contact-form" name="contact-form" class="form-horizontal" modelAttribute="signupForm" method="POST">
	   <div class="form-group sign-feld-margin-top">
	   <div class="col-md-12">
	   <div class="row">
	   <div class="col-md-5">
	   <form:radiobutton class="css-checkbox" path="role_idRole" name="radiog_lite" id="radio1" value="3"  /><label for="radio1" class="css-label" data-toggle="tooltip" data-placement="top" title="Lorem ipsum dolor sit amet, consectetur adipiscing elit.">${designer}</label>
	   </div>
	   <div class="col-md-5">
	   <form:radiobutton class="css-checkbox" path="role_idRole" name="radiog_lite" id="radio2" value="2"  /><label for="radio2" class="css-label" data-toggle="tooltip" data-placement="top" title="Lorem ipsum dolor sit amet, consectetur adipiscing elit.">${user}</label>
	   </div>
	   </div>
	   <span class="error color-style-validation"><form:errors path="role_idRole" /></span>
		</div>
		</div>
		<div class="form-group">
		<div class="col-md-12 height-input-string-signup">
		<form:input id="login" name="login" class="form-control input-md" path="login" placeholder="${login}"></form:input>
		<span class="error color-style-validation"><form:errors path="login" /></span>
		</div>
		</div>
		<div class="form-group">
		<div class="col-md-12 height-input-string-signup">
		<form:password id="password" name="password" class="form-control input-md" path="password" placeholder="${password}"></form:password>
		<span class="error color-style-validation"><form:errors path="password" /></span>
		</div>
		</div>
		<div class="form-group">
		<div class="col-md-12 height-input-string-signup">
		<form:password id="confirmPassword" name="confirmPassword" class="form-control input-md" path="confirmPassword" placeholder="${confirmpassword}"></form:password>
		<span class="error color-style-validation"><form:errors path="confirmPassword" /></span>
		</div>
		</div>
		<div class="form-group">
		<div class="col-md-12 height-input-string-signup">
		<form:input id="nickName" name="nickName" class="form-control input-md" path="nickName" placeholder="${nickname}"></form:input>
		<span class="error color-style-validation"><form:errors path="nickName" /></span>
		</div>
		</div>
		<div class="form-group">
		<div class="col-md-5">
		<input type="submit" class="btn btn-default btn-outline btn-circle" value="${signup}" />
		</div>
	    </div>
	</form:form>
	</div>
	<div class="clearfix"></div>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp" %>
	<script src="<c:url value="/resources/js/jquery.min.js" />"> </script>
<script src="<c:url value="/resources/js/jquery-2.1.1.js" />"> </script>
<script src="<c:url value="/resources/js/jquery.validate.min.js" />"> </script>
<script src="<c:url value="/resources/js/validation.js" />"> </script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script>
<script src="<c:url value="/resources/js/tooltip.js" />"></script>
</body>
</html>