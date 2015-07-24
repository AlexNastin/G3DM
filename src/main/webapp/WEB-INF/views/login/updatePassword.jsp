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
<title><spring:message code="message.updatePassword"></spring:message></title>
</head>
<body>

		<div class="container">
			<div class="span12">
				<h1>
					<spring:message code="message.resetYourPassword"></spring:message>
				</h1>
				<div>
					<br>

					<input id="pass" name="password" type="password" value="" />
				
					
			
						<input id="passConfirm" type="password" value="" /> <span
							id="error" class="alert alert-error" style="display: none">
							
						</span>
			
					<br>
					<br>
					<button type="submit" onclick="savePass()">
						<spring:message code="message.updatePassword"></spring:message>
					</button>
				</div>

			</div>
		</div>

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