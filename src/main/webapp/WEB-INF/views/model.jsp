<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Global3Dmod | Model</title>

<spring:message code="main.search.search" var="search"/>

 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="global3dmod team">
   
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/model.css"  />" rel="stylesheet" />
     <link href="<c:url value="/resources/css/fontawesome430/css/font-awesome.min.css"  />" rel="stylesheet" />
     
    
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    <link rel="icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon">
    <spring:message code="model.info.tab1" var="info"/>
    <spring:message code="model.info.tab2" var="instruct"/>
    <spring:message code="model.info.author" var="author"/>
    <spring:message code="model.info.category" var="category"/>
    <spring:message code="model.info.idpost" var="id"/>
    <spring:message code="model.info.soft" var="soft"/>
    <spring:message code="model.info.desrciption" var="desc"/>
    <spring:message code="model.body.photo" var="photo"/>
    <spring:message code="model.body.comments" var="comms"/>
    <spring:message code="model.body.comcol" var="colcom"/>
    <spring:message code="model.body.download" var="down"/>
    <spring:message code="model.body.rating" var="like"/>
    <spring:message code="model.body.issue" var="issue"/>
    


   </head>
<body>
<%@include file="/WEB-INF/views/header/headerWithSearch.jsp" %> 
<div class="container modelmain">
<div class="row">
<div class="col-md-4">
<h3>Model name</h3>
<img src="<c:url value="/resources/images/logosign.jpg" />" class="img-responsive margination" alt="Responsive image"> 
<div>
<button class="btn btn-primary fa fa-download"> ${down} </button>
<button class="btn btn-success fa fa-thumbs-o-up"> ${like} </button>
<button type="button" class="btn btn-danger fa fa-exclamation-circle">${issue}</button>
</div>

</div>
<div class="col-md-8">
	<h3>${info}</h3>

			<div class="tabbable-panel">
				<div class="tabbable-line">
					<ul class="nav nav-tabs ">
						<li class="active">
							<a href="#tab_default_1" data-toggle="tab">
							${info} </a>
						</li>
						<li>
							<a href="#tab_default_2" data-toggle="tab">
							${instruct} </a>
						</li>
						</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="tab_default_1">
							<p><i class="fa fa-user"></i> ${author}: <a>Put name here</a></p>
							<p><i class="fa fa-cubes"></i> ${category}: <a>Put category here</a></p>
							<p><i class="fa fa-slack"></i> ${id}:46546</p>
							<p><i class="fa fa-file"></i> ${soft}: <a>Put soft here</a></p>
							<p><i class="fa fa-align-justify"></i> ${desc}: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."</p>
						</div>
						<div class="tab-pane" id="tab_default_2">
							
						</div>
						
					</div>
				</div>
			</div>
</div>
</div>
</div> 
<div class="container">
<h3>More photos</h3>
    <div class="col-xs-6 col-sm-3">
        <a href="#" class="thumbnail" data-toggle="modal" data-target="#lightbox"> 
            <img src="https://s3.amazonaws.com/ooomf-com-files/lqCNpAk3SCm0bdyd5aA0_IMG_4060_1%20copy.jpg" alt="...">
        </a>
    </div>
    <div class="col-xs-6 col-sm-3">
        <a href="#" class="thumbnail" data-toggle="modal" data-target="#lightbox"> 
            <img src="https://s3.amazonaws.com/ooomf-com-files/deYU3EyQP9cN23moYfLw_Dandelion.jpg" alt="...">
        </a>
    </div>
    <div class="col-xs-6 col-sm-3">
        <a href="#" class="thumbnail" data-toggle="modal" data-target="#lightbox"> 
            <img src="https://s3.amazonaws.com/ooomf-com-files/8H0UdTsvRFqe03hZkNJr_New%20York%20-%20On%20the%20rock%20-%20Empire%20State%20Building.jpg" alt="...">
        </a>
    </div>
    <div class="col-xs-6 col-sm-3">
        <a href="#" class="thumbnail" data-toggle="modal" data-target="#lightbox"> 
            <img src="https://s3.amazonaws.com/ooomf-com-files/Z3LXxzFMRe65FC3Dmhnp_woody_unsplash_DSC0129.jpg" alt="...">
        </a>
    </div>
</div>

<div id="lightbox" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <button type="button" class="close hidden" data-dismiss="modal" aria-hidden="true">×</button>
        <div class="modal-content">
            <div class="modal-body">
                <img src="" alt="" />
            </div>
        </div>
    </div>
</div>
<div class="container">
            <div class="row">
                <div class="col-md-12">
                  <div class="page-header">
                    <h3><small class="pull-right">45 comments</small> Comments </h3>
                  </div> 
                   <div class="comments-list">
                       <div class="media">
                           <p class="pull-right"><small>5 days ago</small></p>
                            <a class="media-left" href="#">
                              <img src="http://lorempixel.com/40/40/people/1/">
                            </a>
                            <div class="media-body">
                                
                              <h4 class="media-heading user_name">Baltej Singh</h4>
                              Wow! this is really great.
                              
                              <p><small><a href="">Like</a> - <a href="">Share</a></small></p>
                            </div>
                          </div>
                       <div class="media">
                           <p class="pull-right"><small>5 days ago</small></p>
                            <a class="media-left" href="#">
                              <img src="http://lorempixel.com/40/40/people/2/">
                            </a>
                            <div class="media-body">
                                
                              <h4 class="media-heading user_name">Baltej Singh</h4>
                              Wow! this is really great.
                              
                              <p><small><a href="">Like</a> - <a href="">Share</a></small></p>
                            </div>
                          </div>
                       <div class="media">
                           <p class="pull-right"><small>5 days ago</small></p>
                            <a class="media-left" href="#">
                              <img src="http://lorempixel.com/40/40/people/3/">
                            </a>
                            <div class="media-body">
                                
                              <h4 class="media-heading user_name">Baltej Singh</h4>
                              Wow! this is really great.
                              
                              <p><small><a href="">Like</a> - <a href="">Share</a></small></p>
                            </div>
                          </div>
                       <div class="media">
                           <p class="pull-right"><small>5 days ago</small></p>
                            <a class="media-left" href="#">
                              <img src="http://lorempixel.com/40/40/people/4/">
                            </a>
                            <div class="media-body">
                                
                              <h4 class="media-heading user_name">Baltej Singh</h4>
                              Wow! this is really great.
                              
                              <p><small><a href="">Like</a> - <a href="">Share</a></small></p>
                            </div>
                          </div>
                   </div>
                    
                    
                    
                </div>
                </div>
                </div>
<%@include file="/WEB-INF/views/footer.jsp" %>  
    <script src="<c:url value="/resources/js/jquery-1.7.min.js" />"> </script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script> 
    <script src="<c:url value="/resources/js/model.js" />"> </script> 
    
</body>
</html>