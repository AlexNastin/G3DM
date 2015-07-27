<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<html>
<head>
<link href="<c:url value="/resources/bootstrap.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title></title>
</head>
<body>
	<div class="container">
		<div class="span12">
			<h1>reset yor pass</h1>
			<div>
				<br> new pass <input id="pass" name="password" type="password"
					value="" /> pass confirm <input id="passConfirm" type="password"
					value="" /> <span id="error" class="alert alert-error"
					style="display: none"> pass confirm </span> <br> <br>
				<button type="submit" onclick="savePass()">update pass</button>
			</div>

		</div>
	</div>
<form:form id="contact-form" name="contact-form"
								class="form-horizontal" modelAttribute="updateForgotPasswordForm"
								method="POST">
								<div class="form-group sign-feld-margin-top"></div>
								<div class="form-group">
									<div class="col-md-12 height-input-string-security">
										<form:password id="password" name="password"
											class="form-control input-md" path="password"
											placeholder="Password"></form:password>
										<span class="error"><form:errors path="password" /></span>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-12 height-input-string-security">
										<form:password id="confirmPassword" name="confirmPassword"
											class="form-control input-md" path="confirmPassword"
											placeholder="Confirm password"></form:password>
										<span class="error"><form:errors path="confirmPassword" /></span>
									</div>
								</div>
								<spring:message
									code="designerPersonalSecurityForm.updatepassword.successfully"
									var="successfully" />
								<c:if test="${updatePasswordSuccessfully != null}">
									${successfully }
							</c:if>
								<br>

								<div class="form-group" style="text-align: center;">

									<input type="submit" class="btn btn-primary" value="Save" />

								</div>
							</form:form>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
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
</body>

</html>