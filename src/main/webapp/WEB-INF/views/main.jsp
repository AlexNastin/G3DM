<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Global3Dmod</title>
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
	

<!-- AAAAAAAAAAAAAFTER!!!! -->

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
<div class="banner">
    <div class="container_wrap">
        <h1><spring:message code="main.searchUp" /></h1>
        <form>
        <span>
            <input type="text" value="<spring:message code="main.searchInto" />" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '<spring:message code="main.searchInto" />';}">
		    <label class="btn1 btn2 btn-2 btn-2g"> <input name="submit" type="submit" id="submit" value="<spring:message code="main.search" />"> </label>
		    <div class="clearfix"> </div>
		</span>    
        </form>
        <div class="clearfix"></div>
    </div>
</div>
    <section id="portfolio">
        <div class="container">
<center><h1><spring:message code="main.categories" /></h1></center>
			<c:forEach items="${listCategory}" var="category" >
			<c:set var="id" value="${category.idCategory}"></c:set>
            <div class="row portfolio-items"> <!--1st element-->
                <div class="portfolio-item apps  col-md-3">
                        <div class="item-inner">
                            <div class="portfolio-image">
                                <img src=<c:url value="${category.imagePath}" /> alt="">
                                <div class="overlay container">
                                    <div class="menuis">
                                    <a class="preview btn btn-primary" title="Lorem ipsum dolor sit amet">${category.title}</a>
                                    	<p><a href="#">Subcategory</a></p>
                                    </div>
                                </div>
                            </div>
                            <h5>Lorem ipsum dolor sit amet</h5>
                        </div>
                    </div>
            </c:forEach>

<center><h1><spring:message code="main.topModels" /></h1></center>
<div class="row">
<div class="col-md-2"></div>
 <div class="carousel-container contanier col-md-8">
 
      <div id="carousel">
        <div class="carousel-feature">
          <a href="#"><img class="carousel-image" alt="Image Caption" src=<c:url value="/resources/images/sample1.jpg" />></a>
          <div class="carousel-caption">
            <p>
              This area is typically used to display captions associated with the images. They are set to hide and fade in on rotation.
            </p>
          </div>
        </div>
        <div class="carousel-feature">
          <a href="#"><img class="carousel-image" alt="Image Caption" src=<c:url value="/resources/images/sample5.jpg" />></a>
          <div class="carousel-caption">
            <p>
              The background will expand up or down to fit the caption.
            </p>
          </div>
        </div>
        <div class="carousel-feature">
          <a href="#"><img class="carousel-image" alt="Image Caption" src=<c:url value="/resources/images/sample2.jpg" />></a>
          <div class="carousel-caption">
            <p>
              Images can be placed here as well.
            </p>
          </div>
        </div>
        <div class="carousel-feature">
          <a href="#"><img class="carousel-image" alt="Image Caption" src=<c:url value="/resources/images/sample3.jpg" />></a>
        </div>
        <div class="carousel-feature">
          <a href="#"><img class="carousel-image" alt="Image Caption" src=<c:url value="/resources/images/sample4.jpg" />></a>
          <div class="carousel-caption">
            <p>
              The background color of the caption area can be changed using CSS. The opacity can be changed in the options, but it will also change the opacity of the text.
            </p>
          </div>
        </div>
      </div>
    
      <div id="carousel-left"><img src=<c:url value="/resources/images/arrow-left.png" /> alt=""></div>
      <div id="carousel-right"><img src=<c:url value="/resources/images/arrow-right.png" /> alt=""></div>
    </div>
    <div class="col-md-2"> </div>
    </div>
          

<div class="footer">
    <div class="container">

        <div class="footer_grids">
            <div class="footer-grid">
                <h4>Ipsum Quis</h4>
                <ul class="list1">
                    <li><a href="contact.html">Contact</a></li>
                    <li><a href="#">Mirum est</a></li>
                    <li><a href="#">placerat facer</a></li>
                    <li><a href="#">claritatem</a></li>
                    <li><a href="#">sollemnes </a></li>
                </ul>
            </div>
            <div class="footer-grid">
                <h4>Quis Ipsum</h4>
                <ul class="list1">
                    <li><a href="#">placerat facer</a></li>
                    <li><a href="#">claritatem</a></li>
                    <li><a href="#">sollemnes </a></li>
                    <li><a href="#">Claritas</a></li>
                    <li><a href="#">Mirum est</a></li>
                </ul>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
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
