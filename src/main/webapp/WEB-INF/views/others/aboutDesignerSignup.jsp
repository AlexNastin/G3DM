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
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/fontawesome430/css/font-awesome.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/otherpage.css"  />" rel="stylesheet" />
<link rel="icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon">
<title>Sign up for designers | Global3dMod</title>
<spring:message code="headerWithSearch.header.search" var="search"/>
</head>
<body>
<%@include file="/WEB-INF/views/header/headerWithSearch.jsp" %>
<div class="container holycontent">
<div class="row">
<div class="font-contact line-contact col-md-12">
<i class="fa fa-sign-in"></i> Sign up for designers  
</div>
</div>
<div class="col-md-12 background-howitworks">
<div class="font-family-howitworks">
<p><i class="fa fa-circle"></i> Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
Quisque bibendum risus vitae metus pellentesque, a ultrices eros interdum. 
Interdum et malesuada fames ac ante ipsum primis in faucibus.
<p><i class="fa fa-circle"></i> Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
Quisque bibendum risus vitae metus pellentesque, a ultrices eros interdum. 
Interdum et malesuada fames ac ante ipsum primis in faucibus.
<p><i class="fa fa-circle"></i> Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
Quisque bibendum risus vitae metus pellentesque, a ultrices eros interdum. 
Interdum et malesuada fames ac ante ipsum primis in faucibus.
<p><i class="fa fa-circle"></i> Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
Quisque bibendum risus vitae metus pellentesque, a ultrices eros interdum. 
Interdum et malesuada fames ac ante ipsum primis in faucibus.
<p><i class="fa fa-circle"></i> Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
Quisque bibendum risus vitae metus pellentesque, a ultrices eros interdum. 
Interdum et malesuada fames ac ante ipsum primis in faucibus.
<p><i class="fa fa-circle"></i> Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
Quisque bibendum risus vitae metus pellentesque, a ultrices eros interdum. 
Interdum et malesuada fames ac ante ipsum primis in faucibus.
<p><i class="fa fa-circle"></i> Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
Quisque bibendum risus vitae metus pellentesque, a ultrices eros interdum. 
Interdum et malesuada fames ac ante ipsum primis in faucibus.
</div>
</div>
</div>
<%@include file="/WEB-INF/views/footer.jsp" %>
<script src="<c:url value="/resources/js/jquery.min.js" />"> </script>
<script src="<c:url value="/resources/js/jquery-2.1.1.js" />"> </script>
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