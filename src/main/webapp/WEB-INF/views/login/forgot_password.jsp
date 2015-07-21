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
			<h1></h1>
			<div>
				<br> <label>resetPasswor</label> <input id="email" name="email"
					type="email" value="" />
				<button type="submit" onclick="resetPass()">resetPassword</button>
			</div>
 <a href="<c:url value="/user/resetPassword?email=alexnastin1992@gmail.com" />">link</a>
		</div>
	</div>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script type="text/javascript">
		function resetPass() {
			var email = $("#email").val();
			$.post("<c:url value="/resetPassword"></c:url>",{email : email},
							function(data) {
								window.location.href = "<c:url value="/login2.html"></c:url>"
										+ "?message=aasasda"})
					.fail(function(data) {
								if (data.responseJSON.error
										.indexOf("MailError") > -1) {
									window.location.href = "<c:url value="/emailError.html"></c:url>";
								} else {
									window.location.href = "<c:url value="/login.html"></c:url>"
											+ "?message="
											+ data.responseJSON.message;
								}
							});
		}
	</script>
</body>

</html>