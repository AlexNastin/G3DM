<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Global3Dmod</title>
<!-- Init search variable -->
<spring:message code="main.search.search" var="search"/>
<spring:message code="main.search.searchInto" var="searchmain"/>
<spring:message code="main.top.topModels" var="topmodel" />
<spring:message code="main.top.topDesigners" var="topdesigner" />

 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="global3dmod team">
   
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
     <link href="<c:url value="/resources/css/fontawesome430/css/font-awesome.min.css"  />" rel="stylesheet" />
     
    
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    <link rel="icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon">
    
   </head>
<body>
<!-- Here some place for ads -->

	<%@include file="/WEB-INF/views/header/header.jsp" %>   

<div class="banner">
    <div class="container_wrap">
        <h1><spring:message code="main.search.searchUp" /></h1>
        <div class="col-md-4"></div>
            <form class="col-md-4">
            <div class="input-group" style="width:100%; text-align:center;margin:0 auto;">
            <input class="form-control input-lg" placeholder="${searchmain}" type="text">
              <span class="input-group-btn"><button class="btn btn-lg btn-primary" type="button">${search}</button></span>
            </div>
          </form>
          
          <div class="col-md-4"></div>
        <div class="clearfix"></div>
    </div>
</div>
    
       
        <div class="group container categories">
    <div class="item line"></div>
    <div class="item text"><spring:message code="main.categories.categories" /></div>
    <div class="item line"></div>
</div>
<div class="container col-lg-12 nomargin"  >

 
			<section id="portfolio">
            <div class="row portfolio-items"> 
            <!--1st element-->
             <c:forEach items="${listCategory}" var="category" >
                <div class="portfolio-item apps  col-md-3">
                        <div class="item-inner">
                            <div class="portfolio-image">
                                <img src=<c:url value="${category.imagePath}" /> alt="">
                                <div class="overlay container">
                                    <div class="menuis">
                                    <a href="<c:url value="/result?idCategory=${category.idCategory}" />" class="preview btn btn-primary mainbutton" title="${category.title}">${category.title}</a>
                                    	<c:forEach items="${category.subcategories}" var="subcategory">
                                    		<p><a class="categorytxt" href="<c:url value="/result?idCategory=${category.idCategory}&idSubcategory=${subcategory.idSubcategory}" />">${subcategory.title }</a></p>
                                    		
										</c:forEach>
                                    </div>
                                </div>
                            </div>
                            <h5>${category.title}</h5>
                        </div>
                    </div>
            </c:forEach>
</section>

 </div>
 <div class="group container">
    <div class="item line"></div>
    <div class="item text">Our tops</div>
    <div class="item line"></div>
</div>
<div class="clearfix"></div>

<div class="backgroundslider">
<div class="container">
<div class="row nomargin">
 <div class="carousel-container contanier col-md-12 sliderup">
  
			<!-- Codrops top bar -->
			
			
				<div id="mi-slider" class="mi-slider respimg">
					<ul>
					<c:forEach items="${listTop4Posts}" var="post">
						<li><a href="<c:url value="/model?id=${post.idPost}"/>"><img class="respimg" src=<c:url value="${post.postPhotos[0].photoPath}" /> alt=""><h4>${post.title}</h4></a></li>
					</c:forEach>
					</ul>
					<ul>
						<li><a href="#"><img class="respimg" src=<c:url value="/resources/images/categories/toys.jpg" /> alt=""><h4>Boots</h4></a></li>
						<li><a href="#"><img src=<c:url value="/resources/images/categories/architecture.jpg" /> alt=""><h4>Boots</h4></a></li>
						<li><a href="#"><img src=<c:url value="/resources/images/categories/garden.jpg" /> alt=""><h4>Boots</h4></a></li>
						<li><a href="#"><img src=<c:url value="/resources/images/categories/home.jpg" /> alt=""><h4>Boots</h4></a></li>
					</ul>
					
					
					<nav>
						<a href="#">${topmodel}</a>
						<a href="#">${topdesigner}</a>
						
					</nav>
				</div>
			</div>
		</div><!-- /container -->
		</div>
		</div>
		
		 </div>
    <div class="clearfix"></div>
    <br>
<div class="row nomargin"><%@include file="/WEB-INF/views/adslider.jsp" %> 

</div>   
<div class="clearfix"></div>        
<%@include file="/WEB-INF/views/footer.jsp" %>  
    <script src="<c:url value="/resources/js/jquery-1.7.min.js" />"> </script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script> 
    <script src="<c:url value="/resources/js/slider/modernizr.custom.63321.js" />"> </script> 
    <script src="<c:url value="/resources/js/slider/jquery.catslider.js" />"> </script> 
      
	  

</body>
</html>
