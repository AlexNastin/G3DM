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
	<%@include file="/WEB-INF/views/header.jsp" %>   




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
            <div class="row portfolio-items"> 
            <!--1st element-->
            <c:forEach items="${listCategory}" var="category" >
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
</section>

<div class="row nomargin">
<div class="col-md-2"><h3 class="nothingelsematters">die</h3></div>
 <div class="carousel-container contanier col-md-9">
 <center><h1><spring:message code="main.topModels" /></h1></center>
 
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
    <div class="col-md-2"> <h3 class="nothingelsematters">die</h3></div>
    </div>
          
<%@include file="/WEB-INF/views/footer.jsp" %>  
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
