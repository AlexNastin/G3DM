<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/font-awesome.min.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/prettyPhoto.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/feature-carousel.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/sign.css"  />" rel="stylesheet" />
<link rel="stylesheet" href="<c:url value="/resources/css/formValidation.css"/>">
<link href="<c:url value="/resources/css/fontawesome430/css/font-awesome.min.css"  />" rel="stylesheet" />
<link rel="icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon">

<spring:url var="authUrl" value="/static/j_spring_security_check" /> 
<title><spring:message code="signin.signin" /></title>
<spring:message code="signin.password" var="password" />
<spring:message code="signin.rememberme" var="rememberme" />
<spring:message code="signin.signin" var="signin" />
<spring:message code="signin.signup" var="signup" />

</head>
<body>
<%@include file="/WEB-INF/views/header/header.jsp" %>  
<div class="signup-background height-sign">
<div class="col-md-4"></div>
<div class="col-md-4"></div>
<div class="container col-md-3 sign-in-background">
 <form id="contact-form" class="form-horizontal" method="post" action="${authUrl}">
 <c:if test="${not empty param.error}">
		<font color="red"> LOGIN ERORR
			: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</font>
	</c:if>
   <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
  <div class="form-group sign-feld-margin-top">
    <div class="col-md-12 height-input-string-signin">
       <input type="text" class="form-control" id="inputEmail3" name="j_username"  placeholder="&#xf003; E-mail" style="font-family:Arial, FontAwesome">
      </div>
     </div>
    <div class="form-group">
    <div class="col-md-12 ">   
    <div class="signin-margin-input height-input-string-signin">
      <input type="password" class="form-control" id="inputPassword3" name="j_password" placeholder="&#xf084; ${password}" style="font-family:Arial, FontAwesome">
    </div>
    </div>
  
  </div>
     <div class="form-group">
      <div class="col-md-8">
      <div class="checkbox">
        <label class="signin-text-color">
          <input type="checkbox" name="_spring_security_remember_me" >${rememberme}
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
     <div class="col-md-8">
      <button type="submit" class="btn btn-default btn-outline btn-circle">${signin}</button>
      <button type="button" class="btn btn-default btn-outline btn-circle"  onClick='location.href="<c:url value="/signup"  />"'>
      ${signup}
      </button>
      </div>    
    </div>
</form>
</div>
<div class="clearfix"></div>
</div>
<%@include file="/WEB-INF/views/footer.jsp" %>

<script src="<c:url value="/resources/js/jquery.min.js" />"> </script>
<script src="<c:url value="/resources/js/jquery-2.1.1.js" />"> </script>
<script src="<c:url value="/resources/js/jquery.validate.min.js" />"> </script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script>
<script src="<c:url value="/resources/js/validation.js" />"> </script>
</body>
</html>