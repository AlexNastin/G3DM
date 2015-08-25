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
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/sign.css"  />" rel="stylesheet" />
<link rel="stylesheet" href="<c:url value="/resources/css/formValidation.css"/>">
<link href="<c:url value="/resources/css/fontawesome430/css/font-awesome.min.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/radio.css"  />" rel="stylesheet" />
<link rel="icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon">
<title>Sign Up | Global3dMod.com</title>
<spring:message code="signup.login" var="login"/>
<spring:message code="signup.password" var="password"/>
<spring:message code="signup.confirmpassword" var="confirmpassword"/>
<spring:message code="signup.nickname" var="nickname"/>
<spring:message code="signup.designer" var="designer"/>
<spring:message code="signup.user" var="user" />
<spring:message code="signup.signup" var="signupnew" />
<spring:message code="javascript.validation" var="validation" />
<spring:message code="signup.confirmpassword" var="confirmpassword" />
<spring:message code="signup.role.designer" var="descdesigner" />
<spring:message code="signup.role.user" var="descuser" />
<meta name="keywords" content="3d printer, 3d model, 3d model free, 3d model download, 3d model download free, model to print 3d printer free, stl, stl download,stl download free, 3d designer, 3d model robot, 3д модель, 3д принтер, 3д модель скачать, 3д модель скачать напечатать, 3д дизайнер, stl бесплатные, stl скачать, global3dmod, global 3d mod "> 


</head>
<body>
<%@include file="/WEB-INF/views/header/header.jsp" %> 
<div class="signup-background height-sign">
<div class="col-md-4"></div>
<div class="col-md-4"></div>
<div class="container col-md-3 sign-up-background">
	<form:form id="contact-form" name="contact-form" class="form-horizontal" modelAttribute="signupForm" method="POST">
	   <div class="form-group sign-feld-margin-top">
	   <div class="col-md-12">
	   <div class="row">
	   <div class="col-md-12 radio-height">
	   <form:radiobutton class="css-checkbox" path="role_idRole" name="radiog_lite" id="radio1" value="3"  /><label for="radio1" class="css-label" data-toggle="tooltip" data-placement="top" title="${descdesigner}">${designer}</label>
	  
	   <form:radiobutton style="margin-left:7%" class="css-checkbox" path="role_idRole" name="radiog_lite" id="radio2" value="2"  /><label style="margin-left:7%" for="radio2" class="css-label" data-toggle="tooltip" data-placement="top" title="${descuser}">${user}</label><br>
	   <label class="error" generated="true" for="role_idRole" style="font-size:9pt; line-height: 1.2;"></label>
	   </div>
	   </div>
	   <span class="error color-style-validation"><form:errors path="role_idRole" /></span>
		</div>
		</div>
		<div class="form-group">
		<div class="col-md-12 height-input-string-signup">
		<form:input id="login" name="login" class="form-control input-md" path="login" placeholder="${login}"></form:input>
		<label class="error" generated="true" for="login" style="font-size:9pt; line-height: 1.2;"></label>
		<span class="error color-style-validation"><form:errors path="login" /></span>
		</div>
		</div>
		<div class="form-group">
		<div class="col-md-12 height-input-string-signup">
		<form:password id="password" name="password" class="form-control input-md" path="password" placeholder="${password}"></form:password>
		<label class="error" generated="true" for="password" style="font-size:9pt; line-height: 1.2;"></label>
		<span class="error color-style-validation"><form:errors path="password" /></span>
		</div>
		</div>
		<div class="form-group">
		<div class="col-md-12 height-input-string-signup">
		<form:password id="confirmPassword" name="confirmPassword" class="form-control input-md" path="confirmPassword" placeholder="${confirmpassword}"></form:password>
		<label class="error" generated="true" for="confirmPassword" style="font-size:9pt; line-height: 1.2;"></label>
		<span class="error color-style-validation"><form:errors path="confirmPassword" /></span>
		</div>
		</div>
		<div class="form-group">
		<div class="col-md-12 height-input-string-signup">
		<form:input id="nickName" name="nickName" class="form-control input-md" path="nickName" placeholder="${nickname}"></form:input>
		<label class="error" generated="true" for="nickName" style="font-size:9pt; line-height: 1.2;"></label>
		<span class="error color-style-validation"><form:errors path="nickName" /></span>
		</div>
		</div>
		<div class="form-group">
		<div class="col-md-5">
		<input type="submit" class="btn btn-default btn-outline btn-circle" value="${signupnew}" />
		</div>
	    </div>
	</form:form>
	</div>
	<div class="clearfix"></div>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp" %>
	<script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"> </script>
<script src="<c:url value="/resources/js/jquery.validate.min.js" />"> </script>
<script src="<c:url value="/resources/js/${validation}.js" />"> </script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script>
<script src="<c:url value="/resources/js/tooltip.js" />"></script>
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