<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Reset password | Global3DMod</title>
<!-- Init search variable -->

 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="global3dmod team">
   
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/404.css"  />" rel="stylesheet" />
     <link href="<c:url value="/resources/css/fontawesome430/css/font-awesome.min.css"  />" rel="stylesheet" />
     <link rel="icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon">
     
<spring:message code="403page.error.oops" var="oops" />
<spring:message code="404.error.look" var="look" />
<spring:message code="404.error.sorry" var="sorry2" />
<spring:message code="403page.error.home" var="home" />
<spring:message code="403page.error.contactss" var="contactss" />
<spring:message code="javascript.validation" var="validation" />
<body>
<%@include file="/WEB-INF/views/header/header.jsp" %>   
<div class="container">
    <div class="row">
    <div class="col-md-12" style="padding-top: 3em;" >
    <h1 style="text-align:center"><i class="fa fa-lock"></i> Please, enter your new password <i class="fa fa-lock"></i></h1>
    <div class="col-md-4"></div>
        <div class="col-md-4">
            <div class="error-template" style="min-height:45em; padding-top:1em;">
            	<security:authorize access="hasRole('ROLE_GUEST')">
                <form:form id="contact-form" name="contact-form"
								class="form-horizontal" modelAttribute="updateForgotPasswordForm"
								method="POST">
								<div class="form-group sign-feld-margin-top"></div>
								<div class="form-group">
									<div class="col-md-12 height-input-string-update-password">
										<form:password id="password" name="password"
											class="form-control input-md" path="password"
											placeholder="Password"></form:password>
										<span class="error"><form:errors path="password" /></span>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-12 height-input-string-update-password">
										<form:password id="confirmPassword" name="confirmPassword"
											class="form-control input-md" path="confirmPassword"
											placeholder="Confirm password"></form:password>
										<span class="error"><form:errors path="confirmPassword" /></span>
									</div>
								</div>
								
								<br>

								<div class="form-group" style="text-align: center;">

									<input type="submit" class="btn btn-primary" value="Save" />

								</div>
							</form:form>
							</security:authorize>
	
	<script type="text/javascript">
		function savePass() {
			var pass = $("#pass").val();
			var valid = pass == $("#passConfirm").val();
			if (!valid) {
				$("#error").show();
				return;
			}
			$
					.post(
							"<c:url value="/savePassword"></c:url>",
							{
								password : pass
							},
							function(data) {
								window.location.href = "<c:url value="/login.html"></c:url>"
										+ "?message=" + data.message;
							})
					.fail(
							function(data) {
								window.location.href = "<c:url value="/login.html"></c:url>"
										+ "?message="
										+ data.responseJSON.message;
							});
		}
	</script>
            </div>
            
        </div>
    </div>
</div>
</div>

<%@include file="/WEB-INF/views/footer.jsp" %>  
    <script src="<c:url value="/resources/js/jquery-1.7.min.js" />"> </script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script> 
    
</body>
</html>