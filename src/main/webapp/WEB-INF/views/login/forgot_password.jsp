<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Forgot password | Global3DMod</title>
<!-- Init search variable -->

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="global3dmod team">
    <meta name="keywords" content="3d printer, 3d model, 3d model free, 3d model download, 3d model download free, model to print 3d printer free, stl, stl download,stl download free, 3d designer, 3d model robot, 3д модель, 3д принтер, 3д модель скачать, 3д модель скачать напечатать, 3д дизайнер, stl бесплатные, stl скачать, global3dmod, global 3d mod "> 
    
    <spring:message code="email.message.resetPassword.enteremailmessage" var="enteremailmessage"/>
   
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/404.css"  />" rel="stylesheet" />
     <link href="<c:url value="/resources/css/fontawesome430/css/font-awesome.min.css"  />" rel="stylesheet" />
     <link rel="icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon">
   
<body>
<%@include file="/WEB-INF/views/header/header.jsp" %>   
<div class="container">
    <div class="row">
        <div class="col-md-12" style="padding-top: 3em;" >
    <h1 style="text-align:center"><i class="fa fa-envelope-o"></i> ${enteremailmessage} <i class="fa fa-envelope-o"></i></h1>
    <div class="col-md-4"></div>
    <div class="col-md-4">
            <div class="error-template" style="min-height:45em;">
               
               <form action="<c:url value="/resetPassword"></c:url>" method="POST">
				<input class="form-control" required id="email" name="email"	type="email" value="" placeholder="Email" />
				<input style="margin-top: 10px;" type="submit"  class="btn btn-primary" />
			   </form>
			   <c:if  test="${message != null}">
			  <div class="alert alert-info" role="alert" style="margin-top: 3%; padding:1%">${message}</div> 
			   </c:if>
		</div>
	</div>
	</div>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script type="text/javascript">
		function resetPass() {
			var email = $("#email").val();
			$.post("<c:url value="/resetPassword"></c:url>",{email : email},
					function(data){
	            window.location.href = 
	              "<c:url value="/go/signin"></c:url>" + "?message=" + data.message;
	    })
	    .fail(function(data) {
	        if(data.responseJSON.error.indexOf("MailError") > -1) {
	            window.location.href = 
	              "<c:url value="/emailError.html"></c:url>";
	        }
	        else {
	            window.location.href = 
	              "<c:url value="/login.html"></c:url>" + "?message=" + data.responseJSON.message;
	        }
	    });
	}
	</script>
            </div>
        </div>
   

<%@include file="/WEB-INF/views/footer.jsp" %>  
    <script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"> </script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script> 
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