<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>header</title>
<!-- After -->

 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="global3dmod team">
    <title>Global 3d Mod | Site</title>
    <link href="<c:url value="/resources/css/bootstrap.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/font-awesome.min.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/prettyPhoto.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/feature-carousel.css"  />" rel="stylesheet" />
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
   </head>
<body>
<!-- AFTER!!!! -->

<nav class="navbar navbar-default">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-2">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Brand</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbar-collapse-2">
            <ul class="nav navbar-nav navbar-left">
                <!-- put some links here -->
                </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><spring:message code="main.about" /></a></li>
                <li><a href="#"><spring:message code="main.servises" /></a></li>
                <li><a href="#"><spring:message code="main.works" /></a></li>
                <li><a href="#"><spring:message code="main.news" /></a></li>
                <li><a href="#"><spring:message code="main.contact" /></a></li>
                <li><a class="supernav" href="?locale=en">EN |</a>
                <li><a href="?locale=ru">RU</a></li>
                    <li><button type="button" class="btn btn-default btn-outline btn-circle" onClick='location.href="<c:url value="/go/signin" />"'>
      <spring:message code="main.signin" />
      </button>
                </li>
            </ul>

        </div><!-- /.navbar-collapse -->
    </div><!-- /.container -->
</nav><!-- /.navbar -->
  <script src="<c:url value="/resources/js/jquery-1.7.min.js" />"> </script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script>
 
    <!---<script src="js/jquery.isotope.min.js"></script>--->
    <!--<script src="js/jquery.prettyPhoto.js"></script>-->
    <script src="<c:url value="/resources/js/carousel.min.js" />"> </script> 
     <script src="<c:url value="/resources/js/slide.js" />"> </script> 
    <script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/jquery-resize/1.1/jquery.ba-resize.min.js" />"> </script>
    <script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" />"> </script>
    <script src="<c:url value="/resources/js/carousel-3d.js" />"> </script> 
    
</body>
</html>