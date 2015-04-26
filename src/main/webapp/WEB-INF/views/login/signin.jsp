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
<script src="<c:url value="/resources/js/jquery.min.js" />"> </script>
<script src="<c:url value="/resources/js/jquery-2.1.1.js" />"> </script>
<script src="<c:url value="/resources/js/jquery.validate.min.js" />"> </script>
<script src="<c:url value="/resources/js/validation.js" />"> </script>

<title><spring:message code="signin.signin" /></title>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp" %>  
<div class="signup-background">
<div class="col-md-4"></div>
<div class="col-md-4"></div>
<div class="container col-md-3 sign-background">
 <form:form id="contact-form" class="form-horizontal">
  <div class="form-group sign-feld-margin-top">
    <div class="col-md-12">
       <input type="text" class="form-control" required pattern="^[-\w.]+@([A-z0-9][-A-z0-9]+\.)+[A-z]{2,4}$" title="example@examle.com" id="inputEmail3" name="inputEmail3" path="inputEmail3" placeholder="Email">
      </div>
     </div>
    <div class="form-group">
    <div class="col-md-12">   
    <div class="signin-margin-input">
      <input type="password" class="form-control" id="inputPassword3" name="inputPassword3" required="" path="inputEmail3" placeholder="<spring:message code="signin.password" />">
    </div>
    </div>
   
  </div>
     <div class="form-group">
      <div class="col-md-8">
      <div class="checkbox">
        <label class="signin-text-color">
          <input type="checkbox"><spring:message code="signin.rememberme" />
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
     <div class="col-md-8">
      <button type="submit" class="btn btn-default btn-outline btn-circle"><spring:message code="signin.signin" /></button>
      <button type="button" class="btn btn-default btn-outline btn-circle"  onClick='location.href="<c:url value="/signup"  />"'>
      <spring:message code="signin.signup" />
      </button>
      </div>    
    </div>
</form:form>
</div>
<div class="clearfix"></div>
</div>
<%@include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>