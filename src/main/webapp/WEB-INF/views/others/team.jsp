
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Our team | Global3Dmod</title>

    <!-- Bootstrap Core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css"  />" rel="stylesheet" />
    <!-- Custom CSS -->
<link href="<c:url value="/resources/css/team.css"  />" rel="stylesheet" /> 
<link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />   
<!-- Custom Fonts -->
   <link href="<c:url value="/resources/css//fontawesome430/css/font-awesome.css"  />" rel="stylesheet" />
    <link rel="icon" href="<c:url value="/resources/images/favicon.png" />"
	type="image/x-icon">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        
    <![endif]-->
    <spring:message code="other.team.ourteam" var="ourteam"/>
<spring:message code="other.team.name1" var="name1"/>
<spring:message code="other.team.name2" var="name2"/>
<spring:message code="other.team.name3" var="name3"/>
<spring:message code="other.team.name4" var="name4"/>
<spring:message code="other.team.name5" var="name5"/>

</head>

<body id="page-top" class="index">
<%@include file="/WEB-INF/views/header/headerWithSearch.jsp" %>  
           <!-- Team Section -->
    <section id="team" class="bg-light-gray">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">${ourteam}</h2>
                    
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <div class="team-member">
                        <img src="<c:url value="/resources/images/team/nickita.jpg" />" class="img-responsive img-circle" alt="">
                        <h4>${name3}</h4>
                        <p class="text-muted">Java Developer</p>
                        <ul class="list-inline social-buttons">
                            <li><a href="https://vk.com/crea_rec" target="_blank"><i class="fa fa-vk"></i></a>
                            </li>
                            <li><a href="https://www.facebook.com/nickita.stepanov#" target="_blank"><i class="fa fa-facebook"></i></a>
                            </li>
                            <li><a target="_blank" href="https://www.linkedin.com/pub/%D0%BD%D0%B8%D0%BA%D0%B8%D1%82%D0%B0-%D1%81%D1%82%D0%B5%D0%BF%D0%B0%D0%BD%D0%BE%D0%B2/bb/109/940"><i class="fa fa-linkedin"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="team-member">
                        <img src="<c:url value="/resources/images/team/alexey.jpg" />" class="img-responsive img-circle" alt="">
                        <h4>${name1}</h4>
                        <p class="text-muted">Project manager, Java Developer, Database Architect</p>
                        <ul class="list-inline social-buttons">
                            <li><a target="_blank" href="https://vk.com/alex_nastin"><i class="fa fa-vk"></i></a>
                            </li>
                            <li><a target="_blank" href="https://www.facebook.com/alex.nastin.1992"><i class="fa fa-facebook"></i></a>
                            </li>
                            <li><a target="_blank" href="https://www.linkedin.com/pub/%D0%B0%D0%BB%D0%B5%D0%BA%D1%81%D0%B5%D0%B9-%D0%BD%D0%B0%D1%81%D1%82%D0%B8%D0%BD/aa/583/113"><i class="fa fa-linkedin"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="team-member">
                        <img src="<c:url value="/resources/images/team/philip.jpg" />" class="img-responsive img-circle" alt="">
                        <h4>${name2}</h4>
                        <p class="text-muted">QA Manager, Front-end Developer</p>
                        <ul class="list-inline social-buttons">
                            <li><a target="_blank" href="https://vk.com/rock_patriot"><i class="fa fa-vk"></i></a>
                            </li>
                            <li><a target="_blank" href="https://www.facebook.com/pilip.fursau"><i class="fa fa-facebook"></i></a>
                            </li>
                            <li><a target="_blank" href="https://www.linkedin.com/in/philipfursov"><i class="fa fa-linkedin"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
			<div class="row">
                <div class="col-sm-4">
                    <div class="team-member">
                        <img src="<c:url value="/resources/images/team/dima.jpg" />" class="img-responsive img-circle" alt="">
                        <h4>${name4}</h4>
                        <p class="text-muted">Front-end Developer</p>
                        <ul class="list-inline social-buttons">
                            <li><a target="_blank" href="https://vk.com/id87216245"><i class="fa fa-vk"></i></a>
                            </li>
                            <li><a  target="_blank" href="https://www.facebook.com/profile.php?id=100002518853490"><i class="fa fa-facebook"></i></a>
                            </li>
                            <li><a target="_blank" href="#"><i class="fa fa-linkedin"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-4">
                    
                </div>
                <div class="col-sm-4">
                    <div class="team-member">
                        <img src="<c:url value="/resources/images/team/yuriy.jpg" />" class="img-responsive img-circle" alt="">
                        <h4>${name5}</h4>
                        <p class="text-muted">Web-Designer, UI/UX Designer</p>
                        <ul class="list-inline social-buttons">
                            <li><a target="_blank" href="https://vk.com/y.bolshynov"><i class="fa fa-vk"></i></a>
                            </li>
                            <li><a target="_blank" href="https://www.facebook.com/yuri.bolshynov"><i class="fa fa-facebook"></i></a>
                            </li>
                            <li><a target="_blank" href="#"><i class="fa fa-linkedin"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
			
                    </div>
    </section>

   
  
    <%@include file="/WEB-INF/views/footer.jsp" %>  

   
   

   <script src="<c:url value="/resources/js/jquery-1.7.min.js" />"> </script>
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
