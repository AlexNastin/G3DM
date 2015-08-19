<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

<link
	href="<c:url value="/resources/css/fontawesome430/css/font-awesome.css"  />"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/otherpage.css"  />"
	rel="stylesheet" />
<link rel="icon" href="<c:url value="/resources/images/favicon.png" />"
	type="image/x-icon">
<title>24/7 Support | Global3dMod</title>
<spring:message code="headerWithSearch.header.search" var="search" />
<spring:message code="support.email" var="email" />
<spring:message code="support.text" var="text" />
<spring:message code="javascript.validation" var="validation" />
<spring:message code="support.placeholder" var="placeholder" />
<meta name="keywords" content="3d printer, 3d model, 3d model free, 3d model download, 3d model download free, model to print 3d printer free, stl, stl download,stl download free, 3d designer, 3d model robot, 3д модель, 3д принтер, 3д модель скачать, 3д модель скачать напечатать, 3д дизайнер, stl бесплатные, stl скачать, global3dmod, global 3d mod "> 

</head>
<body>
	<%@include file="/WEB-INF/views/header/headerWithSearch.jsp"%>
	<div class="container holycontent">
		<div class="row">
			<div class="font-contact line-contact col-md-12">
				<i class="fa fa-life-ring"></i> 24/7 Support
			</div>
		</div>

		<form:form id="support-form" name="support-form"
			modelAttribute="supportForm" method="POST">
			<div class="row margin-top-support">
				<div class=col-md-6>
					<p>Our friendly Support Team is available to help you 24 hours a day, seven days a week. We look forward to hearing from you! 
				<p>Gathering specific information can help us gain some insight into the issues you need help resolving. To do so here's a basic guide of what information we're looking for:
<ul>
					<li>Your name.
					<li>A description of the problem.
					<li>History of the problem.
					<li>Any error messages you are receiving.
					<li>Steps we can take to replicate the problem.
</ul>				
				</div>
					
				<div class="col-md-6 background-color-support ">
				
					<div class="form-group input-height-support-email">
						<div
							class="col-md-12 margin-bottom-input-support margin-top-support-input input-height-support-email">
							<form:input id="email" name="email" class="form-control input-md"
								path="email" placeholder="${email}"></form:input>
							<label class="error" generated="true" for="email" style="font-size:9pt; line-height: 1.2;"></label>
							<span class="error color-style-validation"><form:errors
									path="email" /></span>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-12 input-height-support-message">
							<form:textarea id="textSupport" name="textSupport"
								style="resize:none" class="form-control input-md"
								path="textSupport" placeholder="${placeholder}" rows="5" cols="30"></form:textarea>
							<label class="error" generated="true" for="textSupport" style="font-size:9pt; line-height: 1.2;"></label>
							<span class="error"><form:errors path="textSupport" /></span> <br>
						</div>
					</div>
					<div class="row">
					<div class="col-md-9">
					<c:if test="${message != null}">
			        <div class="alert alert-info" role="alert"
				        style="margin-left: 1em; margin-top: 5.5%; padding: 0.5%; text-align: center;">${message}</div>
		           </c:if>
					</div>
					<div class="col-md-3">
					<div class="right-support">
						<input class="btn btn-primary" type="submit" value="Submit" />
					</div>
				   </div>
				   </div>
				</div>

			</div>
		</form:form>
		
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
	<script src="<c:url value="/resources/js/jquery.min.js" />">
		
	</script>
	<script src="<c:url value="/resources/js/jquery-2.1.1.js" />">
		
	</script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />">
		
	</script>
	<script src="<c:url value="/resources/js/jquery.validate.min.js" />">
		
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