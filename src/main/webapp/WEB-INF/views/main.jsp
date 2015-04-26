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
    <link href="<c:url value="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"  />" rel="stylesheet" />
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
                                    	<c:forEach items="${category.subcategories}" var="subcategory">
                                    		<p><a href="/subcategory/${subcategory.idSubcategory}">${subcategory.title }</a></p>
										</c:forEach>
                                    </div>
                                </div>
                            </div>
                            <h5>${category.title}</h5>
                        </div>
                    </div>
            </c:forEach>
</section>

<div class="row nomargin">
<div class="col-md-2"><h3 class="nothingelsematters">die</h3></div>
 <div class="carousel-container contanier col-md-9">
  
			<!-- Codrops top bar -->
			
			
				<div id="mi-slider" class="mi-slider">
					<ul>
						<li><a href="#"><img src=<c:url value="resources/images/slider/3.jpg" /> alt=""><h4>Boots</h4></a></li>
						<li><a href="#"><img src=<c:url value="resources/images/slider/3.jpg" /> alt=""><h4>Boots</h4></a></li>
						<li><a href="#"><img src=<c:url value="resources/images/slider/3.jpg" /> alt=""><h4>Boots</h4></a></li>
						<li><a href="#"><img src=<c:url value="resources/images/slider/3.jpg" /> alt=""><h4>Boots</h4></a></li>
					</ul>
					<ul>
						<li><a href="#"><img src=<c:url value="resources/images/slider/3.jpg" /> alt=""><h4>Boots</h4></a></li>
						<li><a href="#"><img src=<c:url value="resources/images/slider/3.jpg" /> alt=""><h4>Boots</h4></a></li>
						<li><a href="#"><img src=<c:url value="resources/images/slider/3.jpg" /> alt=""><h4>Boots</h4></a></li>
						<li><a href="#"><img src=<c:url value="resources/images/slider/3.jpg" /> alt=""><h4>Boots</h4></a></li>
					</ul>
					
					
					<nav>
						<a href="#">Top works</a>
						<a href="#">Top authors</a>
						
					</nav>
				</div>
			</div>
		</div><!-- /container -->
		
		 </div>
		 <div class="col-md-2"></div>
		 </div>
    <div class="clearfix"></div>
    <br>
          
<%@include file="/WEB-INF/views/footer.jsp" %>  
    <script src="<c:url value="/resources/js/jquery-1.7.min.js" />"> </script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script>
 
    <!---<script src="js/jquery.isotope.min.js"></script>--->
    <!--<script src="js/jquery.prettyPhoto.js"></script>-->
    <script src="<c:url value="/resources/js/carousel.min.js" />"> </script> 
     <script src="<c:url value="/resources/js/slide.js" />"> </script> 
    <script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/jquery-resize/1.1/jquery.ba-resize.min.js" />"> </script>
    <script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" />"> </script>
    <script src="<c:url value="/resources/js/slider/modernizr.custom.63321.js" />"> </script> 
    <script src="<c:url value="/resources/js/slider/jquery.catslider.js" />"> </script> 
      
	  

</body>
</html>
