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

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
<spring:message code="email.message.updatepassword.enterpasswordmessage" var="enterpasswordmessage" />
<spring:message code="form.password" var="password" />
<spring:message code="form.confirmpassword" var="confirmpassword" />
<spring:message code="form.save" var="save" />
<spring:message code="email.message.updatepassword.user.auth" var="auth" />
<meta name="keywords" content="3d printer, 3d model, 3d model free, 3d model download, 3d model download free, model to print 3d printer free, stl, stl download,stl download free, 3d designer, 3d model robot, 3д модель, 3д принтер, 3д модель скачать, 3д модель скачать напечатать, 3д дизайнер, stl бесплатные, stl скачать, global3dmod, global 3d mod "> 


<body>
<%@include file="/WEB-INF/views/header/header.jsp" %>   
<div class="container">
    <div class="row">
    <div class="col-md-12" style="padding-top: 3em;" >
    <h1 style="text-align:center"><i class="fa fa-lock"></i> ${enterpasswordmessage} <i class="fa fa-lock"></i></h1>
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
											placeholder="${password}"></form:password>
										<span class="error"><form:errors path="password" /></span>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-12 height-input-string-update-password">
										<form:password id="confirmPassword" name="confirmPassword"
											class="form-control input-md" path="confirmPassword"
											placeholder="${confirmpassword}"></form:password>
										<span class="error"><form:errors path="confirmPassword" /></span>
									</div>
								</div>
								
								<br>

								<div class="form-group" style="text-align: center;">

									<input type="submit" class="btn btn-primary" value="${save}" />

								</div>
							</form:form>
							</security:authorize>
	<security:authorize access="hasAnyRole('ROLE_DESIGNER','ROLE_USER', 'ROLE_MODERATOR', 'ROLE_ADMIN')">
	${auth}
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
   <script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"> </script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script>
    <script src="<c:url value="/resources/js/jquery.validate.min.js" />"> </script>
    <script src="<c:url value="/resources/js/${validation}.js" />"> </script>
    <script>
    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
    (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
    m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
    })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
    ga('create', 'UA-66505156-1', 'auto');
    ga('send', 'pageview');
    </script>
    <!-- Yandex.Metrika counter -->
    <script type="text/javascript">
    (function (d, w, c) {
        (w[c] = w[c] || []).push(function() {
            try {
                w.yaCounter32035491 = new Ya.Metrika({
                    id:32035491,
                    clickmap:true,
                    trackLinks:true,
                    accurateTrackBounce:true
                });
            } catch(e) { }
        });

        var n = d.getElementsByTagName("script")[0],
            s = d.createElement("script"),
            f = function () { n.parentNode.insertBefore(s, n); };
        s.type = "text/javascript";
        s.async = true;
        s.src = "https://mc.yandex.ru/metrika/watch.js";

        if (w.opera == "[object Opera]") {
            d.addEventListener("DOMContentLoaded", f, false);
        } else { f(); }
    })(document, window, "yandex_metrika_callbacks");
    </script>
    <noscript><div><img src="https://mc.yandex.ru/watch/32035491" style="position:absolute; left:-9999px;" alt="" /></div></noscript>
    <!-- /Yandex.Metrika counter -->
</body>
</html>