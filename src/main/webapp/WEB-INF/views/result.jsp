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

 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="global3dmod team">
   
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/fontawesome430/css/font-awesome.min.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/search.css"  />" rel="stylesheet" />
     
    
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    <link rel="icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon">
   </head>
<body>
<%@include file="/WEB-INF/views/header/header.jsp" %>  
<div class="container meow">

    <hgroup class="mb20">
        <h1>Search Results</h1>
        <h2 class="lead"><strong class="text-danger">3</strong> results were found for the search for <strong class="text-danger">Lorem</strong></h2>
    </hgroup>

    <section class="col-xs-12 col-sm-6 col-md-12">
        <article class="search-result row">
            <div class="col-xs-12 col-sm-12 col-md-3">
                <a href="#" title="Lorem ipsum" class="thumbnail"><img src="<c:url value="/resources/images/auto.jpg" />" alt="Lorem ipsum" /></a>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-2">
                <ul class="meta-search">
                    <li><i class="fa fa-star"></i><span>Rating 464</span></li>
                    <li><i class="fa fa-download"></i> <span>Downloads 315</span></li>
                    <li><i class="fa fa-comments"></i> <span>Comments 654</span></li>
                    <li><i class="fa fa-user"></i> <span>Author jhg  jg</span></li>
                </ul>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-7 excerpet">
                <h3><a href="#" title="">Voluptatem, exercitationem, suscipit, distinctio</a></h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatem, exercitationem, suscipit, distinctio, qui sapiente aspernatur molestiae non corporis magni sit sequi iusto debitis delectus doloremque.</p>

            </div>
            <span class="clearfix borda"></span>
        </article>

        <article class="search-result row">
            <div class="col-xs-12 col-sm-12 col-md-3">
                <a href="#" title="Lorem ipsum" class="thumbnail"><img src="<c:url value="/resources/images/auto.jpg" />" alt="Lorem ipsum" /></a>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-2">
                <ul class="meta-search">
                    <li><i class="fa fa-star"></i><span>Rating 464</span></li>
                    <li><i class="fa fa-download"></i> <span>Downloads 315</span></li>
                    <li><i class="fa fa-comments"></i> <span>Comments 654</span></li>
                    <li><i class="fa fa-user"></i> <span>Author jhg  jg</span></li>
                </ul>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-7">
                <h3><a href="#" title="">Voluptatem, exercitationem, suscipit, distinctio</a></h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatem, exercitationem, suscipit, distinctio, qui sapiente aspernatur molestiae non corporis magni sit sequi iusto debitis delectus doloremque.</p>

            </div>
            <span class="clearfix borda"></span>
        </article>

        <article class="search-result row">
            <div class="col-xs-12 col-sm-12 col-md-3">
                <a href="#" title="Lorem ipsum" class="thumbnail"><img src="<c:url value="/resources/images/auto.jpg" />" alt="Lorem ipsum" /></a>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-2">
                <ul class="meta-search">
                    <li><i class="fa fa-star"></i><span>Rating 464</span></li>
                    <li><i class="fa fa-download"></i> <span>Downloads 315</span></li>
                    <li><i class="fa fa-comments"></i> <span>Comments 654</span></li>
                    <li><i class="fa fa-user"></i> <span>Author jhg  jg</span></li>
                </ul>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-7">
                <h3><a href="#" title="">Voluptatem, exercitationem, suscipit, distinctio</a></h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatem, exercitationem, suscipit, distinctio, qui sapiente aspernatur molestiae non corporis magni sit sequi iusto debitis delectus doloremque.</p>

            </div>
            <span class="clearfix border"></span>
        </article>
         <article class="search-result row">
            <div class="col-xs-12 col-sm-12 col-md-3">
                <a href="#" title="Lorem ipsum" class="thumbnail"><img src="<c:url value="/resources/images/auto.jpg" />" alt="Lorem ipsum" /></a>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-2">
                <ul class="meta-search">
                    <li><i class="fa fa-star"></i><span>Rating 464</span></li>
                    <li><i class="fa fa-download"></i> <span>Downloads 315</span></li>
                    <li><i class="fa fa-comments"></i> <span>Comments 654</span></li>
                    <li><i class="fa fa-user"></i> <span>Author jhg  jg</span></li>
                </ul>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-7">
                <h3><a href="#" title="">Voluptatem, exercitationem, suscipit, distinctio</a></h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatem, exercitationem, suscipit, distinctio, qui sapiente aspernatur molestiae non corporis magni sit sequi iusto debitis delectus doloremque.</p>

            </div>
            <span class="clearfix border"></span>
        </article>
         <article class="search-result row">
            <div class="col-xs-12 col-sm-12 col-md-3">
                <a href="#" title="Lorem ipsum" class="thumbnail"><img src="<c:url value="/resources/images/auto.jpg" />" alt="Lorem ipsum" /></a>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-2">
                <ul class="meta-search">
                    <li><i class="fa fa-star"></i><span>Rating 464</span></li>
                    <li><i class="fa fa-download"></i> <span>Downloads 315</span></li>
                    <li><i class="fa fa-comments"></i> <span>Comments 654</span></li>
                    <li><i class="fa fa-user"></i> <span>Author jhg  jg</span></li>
                </ul>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-7">
                <h3><a href="#" title="">Voluptatem, exercitationem, suscipit, distinctio</a></h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatem, exercitationem, suscipit, distinctio, qui sapiente aspernatur molestiae non corporis magni sit sequi iusto debitis delectus doloremque.</p>

            </div>
            <span class="clearfix border"></span>
        </article>
         <article class="search-result row">
            <div class="col-xs-12 col-sm-12 col-md-3">
                <a href="#" title="Lorem ipsum" class="thumbnail"><img src="<c:url value="/resources/images/auto.jpg" />" alt="Lorem ipsum" /></a>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-2">
                <ul class="meta-search">
                    <li><i class="fa fa-star"></i><span>Rating 464</span></li>
                    <li><i class="fa fa-download"></i> <span>Downloads 315</span></li>
                    <li><i class="fa fa-comments"></i> <span>Comments 654</span></li>
                    <li><i class="fa fa-user"></i> <span>Author jhg  jg</span></li>
                </ul>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-7">
                <h3><a href="#" title="">Voluptatem, exercitationem, suscipit, distinctio</a></h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatem, exercitationem, suscipit, distinctio, qui sapiente aspernatur molestiae non corporis magni sit sequi iusto debitis delectus doloremque.</p>

            </div>
            <span class="clearfix border"></span>
        </article>

    </section>
</div>
<%@include file="/WEB-INF/views/footer.jsp" %>  
    <script src="<c:url value="/resources/js/jquery-1.7.min.js" />"> </script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script> 
    <script src="<c:url value="/resources/js/uisearch.js" />"> </script> 
</body>
</html>