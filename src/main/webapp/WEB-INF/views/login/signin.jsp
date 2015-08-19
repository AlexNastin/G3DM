<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

<link href="<c:url value="/resources/css/prettyPhoto.css"  />"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />

<link href="<c:url value="/resources/css/sign.css"  />" rel="stylesheet" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/formValidation.css"/>">
<link
	href="<c:url value="/resources/css/fontawesome430/css/font-awesome.min.css"  />"
	rel="stylesheet" />
<link rel="icon" href="<c:url value="/resources/images/favicon.png" />"
	type="image/x-icon">

<spring:url var="authUrl" value="/static/j_spring_security_check" />
<title>Sign In | Global3dMod.com</title>
<spring:message code="signin.password" var="password" />
<spring:message code="signin.rememberme" var="rememberme" />
<spring:message code="signin.signin" var="signinnew" />
<spring:message code="signin.signup" var="signupnew" />
<spring:message code="javascript.validation" var="validation" />
<spring:message code="signin.forgotpassword" var="forgotpassword" />
<meta name="keywords" content="3d printer, 3d model, 3d model free, 3d model download, 3d model download free, model to print 3d printer free, stl, stl download,stl download free, 3d designer, 3d model robot, 3д модель, 3д принтер, 3д модель скачать, 3д модель скачать напечатать, 3д дизайнер, stl бесплатные, stl скачать, global3dmod, global 3d mod "> 


</head>
<body>
	<%@include file="/WEB-INF/views/header/header.jsp"%>
	<div class="signup-background height-sign">
		<div class="col-md-4"></div>
		<div class="col-md-4"></div>
		<div class="container col-md-3 sign-in-background">
		
			<form id="contact-form" class="form-horizontal" method="post"
				action="${authUrl}">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<div class="form-group sign-feld-margin-top">
					<div class="col-md-12 height-input-string-signin">
						<input type="text" class="form-control" id="inputEmail3"
							name="j_username" placeholder="&#xf003; E-mail"
							style="font-family: Arial, FontAwesome">
							<label class="error" generated="true" for="inputEmail3" style="font-size:9pt;"></label>
							
					</div>
					
				</div>
				<div class="form-group">
					<div class="col-md-12 ">
						<div class="signin-margin-input height-input-string-signin">
							<input type="password" class="form-control" id="inputPassword3"
								name="j_password" placeholder="&#xf084; ${password}"
								style="font-family: Arial, FontAwesome">
								
							<label class="error" generated="true" for="inputPassword3" style="font-size:9pt; line-height: 1.2;"></label>
								
						</div>
					</div>

				</div>
				
				<div class="form-group">
					<div class="col-md-12">
					<div class="col-md-6">
						<div class="checkbox" style="padding-left:0px">
							<label class="signin-text-color"> <input type="checkbox"
								name="_spring_security_remember_me">${rememberme}
							</label>
						</div>
						</div>
						<div class="col-md-6">
						<c:if test="${param.login_error == 'true'}">
					<div style="text-align:center;"><span class="alert alert-danger" role="alert" style="padding: 1.1%; text-align:center">Invalid credentials</span></div>
				</c:if>
					</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-8">
						<button type="submit"
							class="btn btn-default btn-outline btn-circle">${signinnew}</button>
						<button type="button"
							class="btn btn-default btn-outline btn-circle"
							onClick='location.href="<c:url value="/signup"  />"'>
							${signupnew}</button>
							
					</div>
				</div>
				
				<div class="margin-forgot-password">
					<a href="<c:url value="/forgotPassword.html" />">${forgotpassword}
					</a>
				</div>
			</form>
			<c:if test="${message != null}">
			  <div class="alert alert-success" role="alert" style="padding: 1%; text-align:center">${message}</div> 
			   </c:if>
			   
		</div>
		<div class="clearfix"></div>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>

	<script src="<c:url value="/resources/js/jquery.min.js" />">
		
	</script>
	<script src="<c:url value="/resources/js/jquery-2.1.1.js" />">
		
	</script>
	<script src="<c:url value="/resources/js/jquery.validate.min.js" />">
		
	</script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />">
		
	</script>
	<script src="<c:url value="/resources/js/${validation}.js" />">
		
	</script>
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