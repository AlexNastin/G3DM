<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Personal data | Global3dmod</title>
<!-- Init search variable -->
<spring:message code="headerWithSearch.header.search" var="search"/>
<spring:message code="designer.menu.works" var="works"/>
<spring:message code="designer.menu.data" var="data"/>
<spring:message code="designer.menu.add" var="add"/>
<spring:message code="moderator.menu.postsunpublished" var="unpblsd"/>



 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="global3dmod team">
    <link href="<c:url value="/resources/css/bootstrap.css"  />" rel="stylesheet" />
    <link href="<c:url value="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/cabinets/designer.css"  />" rel="stylesheet" />
     <link href="<c:url value="/resources/css//fontawesome430/css/font-awesome.css"  />" rel="stylesheet" />
    
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
	     
	    
     
 <div class="row footerpadding">
    <div class="col-md-2 nopadding1">
     <div class="list-group">
      <img src="<c:url value="/resources/images/auto.jpg" />" class="img-responsive img-thumbnail" alt="Responsive image">      
  
 <a href="<c:url value="/moderator/profile" />" class="list-group-item active">
    <i class="fa fa-exclamation-triangle"></i> ${unpblsd}
  </a>
  <a href="<c:url value="/moderator/rejectingPosts" />" class="list-group-item"> <i class="fa fa-check-circle"></i> Rejecting Posts</a>

  
	 </div>
    </div>
      <!--main content start-->
      <div class="nopadding2 col-md-10 ">
          <div class="mt">
                  <div class="col-md-12 nopadding2">
                      <div class="col-md-4" style="padding-left:0px;">
                      <div class="content-pael">                      
                      <h2>Post</h2>
                      
                          <table class="table table-striped table-advance table-hover">
                                                                                      
                              <tbody>
                              <tr>
                                  <td>Designer</td>
                                  <td class="hidden-phone">${post.user.nickName}</td>
                                  
                              </tr>
                              <tr>
                                   <td>Category</td>
                                  	<td class="hidden-phone">${post.category.title}</td>
                                  
                              </tr>
                              <tr>
                                  <td>Subcategory</td>
                                  <td class="hidden-phone">${post.subcategory.title}</td>
                                  
                              </tr>
                              <tr>
                                   <td>Designer program</td>
                                  <td class="hidden-phone">${post.disProgram.title}</td>
                              </tr>
                              <tr>
                                   <td>Number</td>
                                  <td class="hidden-phone">${post.numberPost}</td>
                                  
                              </tr>
                              <tr>
                                   <td>Title</td>
                                  <td class="hidden-phone">${post.title}</td>
                                  
                              </tr>
                              <tr>
                                   <td>Description</td>
                                  <td class="hidden-phone">${post.description}</td>
                                  
                              </tr>
                              <tr>
                                   <td>Instruction</td>
                                  <td class="hidden-phone">${post.instruction}</td>
                                  
                              </tr>
                              <tr>
                                   <td>Upload date</td>
                                  <td class="hidden-phone">${post.dateReg}</td>
                                  
                              </tr>
                              <tr>
                                   <td>Change date</td>
                                  <td class="hidden-phone">${post.dateUpdate}</td>
                                  
                              </tr>
                              <tr>
                                   <td>File</td>
                                  <td class="hidden-phone">${post.file.filePath}</td>
                                  
                              </tr>
                              <tr>
                                   <td>Photo</td>
                                  <td class="hidden-phone"><img alt="" src="<c:url value="${post.postPhotos[0].photoPath}" />"></td>
                                  
                              </tr>
                                  </tbody>
                          </table>
                      </div>
                      <div class="col-md-12">
                      <button type="button" style="text-align: center;" class="btn btn-primary left-designer"  onClick='location.href="<c:url value="/moderator/publishPost"  />"'>Publish</button>
      				  <button type="button" style="text-align: center;" class="btn btn-primary left-designer"  onClick='location.href="<c:url value="/moderator/rejectPost"  />"'>Reject</button>
      </div>                
                     
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
