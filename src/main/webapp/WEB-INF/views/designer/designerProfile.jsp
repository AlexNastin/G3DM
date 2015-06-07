<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Designer's page | Global3dmod</title>
<!-- Init search variable -->
<spring:message code="headerWithSearch.header.search" var="search"/>
<spring:message code="moderator.menu.postsunpublished" var="unpblsd"/>
<spring:message code="moderator.menu.postspublished" var="publics"/>
<spring:message code="moderator.menu.users" var="users"/>
<spring:message code="moderator.menu.designer" var="designers"/>


 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="global3dmod team">
    <link href="<c:url value="/resources/css/bootstrap.css"  />" rel="stylesheet" />
    <link href="<c:url value="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/cabinets/designer.css"  />" rel="stylesheet" />
     <link href="<c:url value="/resources/css/fontawesome430/css/font-awesome.css"  />" rel="stylesheet" />
    
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    <link rel="icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon">
   </head>
<body>
<!-- Here some place for ads. After placing ads you may delete "placeforads" css class in header -->

	<%@include file="/WEB-INF/views/header/headerWithSearch.jsp" %>  
	<!-- Designer's page will start here -->
	     
	      <!--sidebar start-->
     
      <div class="row footerpadding">      
      <div class="col-md-2 nopadding1">      
      <div class="list-group">
            <img src="<c:url value="/resources/images/auto.jpg" />" class="img-responsive img-thumbnail" alt="Responsive image">      
  <a class="list-group-item">
    <i class="fa fa-archive"></i> Have posts:   </a>
  <a  class="list-group-item"> <i class="fa fa-thumbs-o-up"></i> Rating:</a>
  <a class="list-group-item"> <i class="fa fa-globe"></i> Country:</a>
  
  
</div>
      </div>
      <!--main content start-->
      
      <div class="nopadding2 col-md-10 ">
      <h2>Valery Tompkins's works</h2>
          <div class="mt">
                  <div class="col-md-12 nopadding2">                 
              <section id="portfolio">
                <div class="row portfolio-items"> <!--1st element-->
                <div class="portfolio-item apps  col-md-3">
                        <div class="item-inner">
                            <div class="portfolio-image">
                                <img src="<c:url value="/resources/images/auto.jpg" />" alt="">
                                <div class="overlay container">
                                    <div class="menuis">
                                    <a href="">Awesome name</a>
                                    
                                    <p style="padding-top:0.5em"><i class="fa fa-thumbs-o-up leftstr"> 8 </i><i class="fa fa-download rightstr">15</i><div style="clear: left"></div></p>
                                    </div>
                                </div>
                            </div>
                            <h5>1</h5>
                        </div>
                    </div>
                    <!--/.portfolio-item 2 -->
                <div class="portfolio-item apps  col-md-3">
                    <div class="item-inner">
                        <div class="portfolio-image">
                            <img src="<c:url value="/resources/images/auto.jpg" />" alt="">
                            <div class="overlay container">
                                 <div class="menuis">
                                    <a href="">Awesome name</a>
                                    
                                    <p style="padding-top:0.5em"><i class="fa fa-thumbs-o-up leftstr"> 8 </i><i class="fa fa-download rightstr">15</i><div style="clear: left"></div></p>
                                    </div>
                            </div>
                        </div>
                        <h5>2</h5>
                    </div>
                </div>
                     <!--/.portfolio-item 3 -->
                <div class="portfolio-item apps  col-md-3">
                    <div class="item-inner">
                        <div class="portfolio-image">
                            <img src="<c:url value="/resources/images/auto.jpg" />" alt="">
                            <div class="overlay container">
                                 <div class="menuis">
                                    <a href="">Awesome name</a>
                                    
                                    <p style="padding-top:0.5em"><i class="fa fa-thumbs-o-up leftstr"> 8 </i><i class="fa fa-download rightstr">15</i><div style="clear: left"></div></p>
                                    </div>
                            </div>
                        </div>
                        <h5>3</h5>
                    </div>
                </div>
                 <!--/.portfolio-item 4 -->
                   <div class="portfolio-item apps col-md-3">
                     <div class="item-inner">
                         <div class="portfolio-image">
                             <img src="<c:url value="/resources/images/auto.jpg" />" alt="">
                             <div class="overlay container">
                                  <div class="menuis">
                                    <a href="">Awesome name</a>
                                    
                                    <p style="padding-top:0.5em"><i class="fa fa-thumbs-o-up leftstr"> 8 </i><i class="fa fa-download rightstr">15</i><div style="clear: left"></div></p>
                                    </div>
                             </div>
                         </div>
                         <h5>4</h5>
                     </div>
                   </div> 
                   </div>                                       
   			 </section>
                  </div>
              </div>              
      </div>
</div>

    
  <div class="clearfix"> </div>
	<%@include file="/WEB-INF/views/footer.jsp" %>  
    <script src="<c:url value="/resources/js/jquery-1.7.min.js" />"> </script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script> 
   
	  

</body>
</html> 