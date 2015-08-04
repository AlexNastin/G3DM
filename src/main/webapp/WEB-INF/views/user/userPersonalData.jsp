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
<spring:message code="user.menu.mybookmarks" var="mybookmarks"/>



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
	     
	    
 <!-- Menu -->     
 <div class="row footerpadding3">
    <div class="col-md-2 nopadding1">
     <div class="list-group">
      <img src="<c:url value="${user.avatar.avatarPath}" />" class="img-responsive img-thumbnail" alt="Global3Dmod avatar">      
  
  <a href="<c:url value="/user/profile" />" class="list-group-item  "><i class="fa fa-briefcase"></i> ${mybookmarks}</a>
 <a href="<c:url value="/user/personalData" />" class="list-group-item active"><i class="fa fa-cogs"></i> Personal Data  </a>
  <a href="<c:url value="/user/personalSecurity" />" class="list-group-item"><i class="fa fa-lock"></i> Personal Security  </a>
  
	 </div>
    </div>
      <!--main content start-->
      <div class="nopadding2 col-md-10 ">
          <div class="mt">
                  <div class="col-md-12 nopadding2">
                      <div class="col-md-4" style="padding-left:0px;">
                      <div class="content-pael">                      
                      <h2>Personal data</h2>
                      
                          <table class="table table-striped table-advance table-hover">
                                                                                      
                              <tbody>
                              <tr>
                                  <td>NickName</td>
                                  <td class="hidden-phone">${user.nickName}</td>
                                  
                              </tr>
                              <tr>
                                   <td>City</td>
                                  	<td class="hidden-phone">${user.city.title}</td>
                                  
                              </tr>
                              <tr>
                                  <td>Country</td>
                                  <td class="hidden-phone">${user.country.title}</td>
                                  
                              </tr>
                              <tr>
                                   <td>Login</td>
                                  <td class="hidden-phone">${user.login}</td>
                              </tr>
                              <tr>
                                   <td>Name</td>
                                  <td class="hidden-phone">${user.name}</td>
                                  
                              </tr>
                              <tr>
                                   <td>Surname</td>
                                  <td class="hidden-phone">${user.surname}</td>
                                  
                              </tr>
                              <tr>
                                   <td>Date birth</td>
                                  <td class="hidden-phone">${user.dateBirth}</td>
                                  
                              </tr>
                              <tr>
                                   <td>Gender</td>
                                  <td class="hidden-phone"><c:if test="${user.gender == 2}">
			Male
		</c:if>
		<c:if test="${user.gender == 1}">
			Female
		</c:if>
		<c:if test="${user.gender == 0}">
			None
		</c:if></td>
                                  
                              </tr>
                                  </tbody>
                          </table>
                      </div>
                      <div class="col-md-12">
                      <button type="button" style="text-align: center;" class="btn btn-primary left-designer"  onClick='location.href="<c:url value="/user/personalData/updateForm"  />"'>
      Update
      </button>
      </div>                
                     
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
