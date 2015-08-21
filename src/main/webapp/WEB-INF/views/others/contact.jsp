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
<link href="<c:url value="/resources/css/fontawesome430/css/font-awesome.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/sign.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/otherpage.css"  />" rel="stylesheet" />
<link rel="icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<meta name="keywords" content="3d printer, 3d model, 3d model free, 3d model download, 3d model download free, model to print 3d printer free, stl, stl download,stl download free, 3d designer, 3d model robot, 3д модель, 3д принтер, 3д модель скачать, 3д модель скачать напечатать, 3д дизайнер, stl бесплатные, stl скачать, global3dmod, global 3d mod "> 
<spring:message code="footer.footer.contact" var="contact" />
<spring:message code="other.contact.text" var="text" />
<spring:message code="other.contact.howtocontactus" var="howtocontactus" />
<spring:message code="other.contact.follow" var="followus" />


<title>Contact us | Global3dMod.com</title>
</head>
<body>
<%@include file="/WEB-INF/views/header/header.jsp" %>
<div class="container holycontent">
<div class="row">
<div class="font-contact line-contact col-md-8">
${contact}
</div>
</div>
<div class="row">
<div class="col-md-4 contact-background contact-vertical-line">
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-8 text-contact-title"> 
${howtocontactus}
</div>
<div class="col-md-2"></div>
</div>
${text}
</div>

<div class="col-md-4 contact-background">
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-8 text-contact-title"> 
${followus}
</div>
<div class="col-md-2 "></div>
</div>
<ul class="list-group">
 				<li class="list-group-item"><a  href="${facebook}" class="fa fa-facebook-official fa-2x"> Facebook</a></li>
                <li class="list-group-item"><a href="${twitter}" class="fa fa-twitter fa-2x"> Twitter</a></li>
                <li class="list-group-item"><a href="${vk}" class="fa fa-vk fa-2x"> VK</a></li>
                <li class="list-group-item"><a  href="${instagram}" class="fa fa-instagram fa-2x"> Instagram</a>   </li>
 </ul>
</div>
<div class="col-md-4">
<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d150508.34195687232!2d27.594974049999987!3d53.883888400000004!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x46dbcfd35b1e6ad3%3A0x0b61b853ddb570d9!2z0JzQuNC90YHQug!5e0!3m2!1sru!2sby!4v1439056380604" width="400" height="300" frameborder="0" style="border:0" allowfullscreen></iframe>

</div>
</div>
</div>

<%@include file="/WEB-INF/views/footer.jsp" %>
<script src="<c:url value="/resources/js/jquery.min.js" />"> </script>
<script src="<c:url value="/resources/js/jquery-2.1.1.js" />"> </script>
<script src="<c:url value="/resources/js/jquery.validate.min.js" />"> </script>
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