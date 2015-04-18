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
<link href="<c:url value="/resources/css/stylesheet.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />
<link rel="stylesheet" href="<c:url value="/resources/css/formValidation.css"/>">
<script src="<c:url value="/resources/js/jquery.min.js" />"> </script>
<script src="<c:url value="/resources/js/jquery-2.1.1.js" />"> </script>
<script src="<c:url value="/resources/js/jquery.validate.min.js" />"> </script>	


<title>Sign in</title>
</head>
<body>

<div class="col-md-4"></div>
<div class="container col-md-4 signin-lenght-string ">
 <form:form id="contact-form" class="form-horizontal">
  <div class="form-group signin-height-background">
    <label for="inputEmail3" class="col-md-3 control-label signin-text-color">Email</label>
      <div class="col-md-8">
      <div class="signin-margin-input">
      <input type="text" class="form-control" required pattern="^[-\w.]+@([A-z0-9][-A-z0-9]+\.)+[A-z]{2,4}$" title="example@examle.com" id="inputEmail3" name="inputEmail3" path="inputEmail3" placeholder="Email">
      </div>
      </div>
     </div>
    <div class="form-group">
    <label for="inputPassword3" class="col-md-3 control-label signin-text-color">Password</label>
    <div class="col-md-8">   
    <div class="signin-margin-input">
      <input type="password" class="form-control" id="inputPassword3" name="inputPassword3" required="" path="inputEmail3" placeholder="Password">
    </div>
    </div>
   
  </div>
     <div class="form-group">
    <label class="col-md-3 control-label" for="checkboxes"></label>
    <div class="col-md-8">
      <div class="checkbox">
        <label class="signin-text-color">
          <input type="checkbox"> Remember me
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
     <label class="col-md-3 control-label" for="button1id"></label>
     <div class="col-md-8">
      <button type="submit" class="btn btn-primary signin-button-color">Sign in</button>
      <button type="button" class="btn btn-primary signin-margin-button" onClick='location.href="<c:url value="/signup" />"'>
      <spring:message code="signin.signup" />
      </button>
      </div>    
    </div>
</form:form>
</div>
<div class="col-md-4"></div>
</body>
</html>