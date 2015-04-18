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
<script src="<c:url value="/resources/js/validation.js" />"> </script>	
<title><spring:message code="signup.signup" /></title>
</head>
<body>
<div class="col-md-4"></div>
<div class="container col-md-4 signup-lenght-string">
<form:form class="form-horizontal">
<fieldset>
<div class="form-group signin-height-background">
  <label class="col-md-3 control-label signin-text-color" for="role"><spring:message code="signup.role" /></label>
  <div class="col-md-8"> 
    <label class="radio-inline signin-text-color" for="role-0">
      <input name="role" id="role-0" value="" checked="checked" type="radio">
     <spring:message code="signup.user" />
    </label> 
    <label class="radio-inline signin-text-color" for="role-1">
      <input name="role" id="role-1" value="" type="radio">
      <spring:message code="signup.designer" />
    </label>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-3 control-label signin-text-color" for="login">  <spring:message code="signup.login" /></label>  
  <div class="col-md-8">
  <input id="login" name="login" placeholder="Email" class="form-control input-md" required pattern="^[-\w.]+@([A-z0-9][-A-z0-9]+\.)+[A-z]{2,4}$" title="example@examle.com" type="text">
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-3 control-label signin-text-color" for="password"><spring:message code="signup.password" /></label>
  <div class="col-md-8">
    <input  id="password" title="Minimum length is 6 characters. Use Latin characters, digits, and underscores" name="password" placeholder="<spring:message code="signup.password" />" class="form-control input-md" required pattern="&#40;?=^.&#123;6,&#125;$&#41;&#40;&#40;?=.*\d&#41;|&#40;?=.*\W+&#41;&#41;&#40;?!&#91;.\n&#93;&#41;&#40;?=.*&#91;A-Z&#93;&#41;&#40;?=.*&#91;a-z&#93;&#41;.*$" type="password">
    
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-3 control-label signin-text-color" for="repeatpassword"><spring:message code="signup.confirmpassword" /></label>
  <div class="col-md-8">
    <input id="repeatpassword"  name="repeatpassword" placeholder="<spring:message code="signup.confirmpassword" />" class="form-control input-md" required="" type="password">
   
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-3 control-label signin-text-color" for="nickname"><spring:message code="signup.nickname" /></label>  
  <div class="col-md-8">
  <input id="nickname" name="nickname" placeholder="<spring:message code="signup.nickname" />" title="Minimum lenght is 3 characters. Use latin characters, digits, and underscores" class="form-control input-md" required pattern="&#40;&#40;^|&#58;&#41;&#40;&#91;0-9a-fA-F&#93;&#123;0,4&#125;&#41;&#41;&#123;1,8&#125;$" type="text">
    
  </div>
</div>
<!-- Multiple Checkboxes -->
<div class="form-group">
  <label class="col-md-3 control-label" for="checkboxes"></label>
  <div class="col-md-8">
  <div class="checkbox">
    <label class="signin-text-color" for="checkboxes-0">
      <input name="checkboxes" id="checkboxes" value="1" type="checkbox" required="">
     <spring:message code="signup.agree" />
    </label>
	</div>
  </div>
</div>
<!-- Button (Double) -->
<div class="form-group">
  <label class="col-md-3 control-label" for="button1id"></label>
  <div class="col-md-8">
    <button type="submit" id="button1id" name="button1id" class="btn btn-primary signin-button-color"><spring:message code="signup.signup" /></button>
    <button type="button" id="button2id" name="button2id" class="btn btn-default signup-button" onClick='location.href="<c:url value="/signin" />"'><spring:message code="signup.signin" /></button>
  </div>
</div>

</fieldset>
</form:form>
</div>
<div class="col-md-4"></div>
</body>
</html>