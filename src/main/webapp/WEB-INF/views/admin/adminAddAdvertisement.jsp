<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Edit data  | Global3dmod</title>
<!-- Init search variable -->
<spring:message code="headerWithSearch.header.search" var="search"/>
<spring:message code="designer.menu.works" var="works"/>
<spring:message code="designer.menu.data" var="data"/>
<spring:message code="designer.menu.add" var="add"/>
<spring:message code="user.menu.mybookmarks" var="mybookmarks"/>
<spring:message code="javascript.validation" var="validation" />
<spring:message code="admin.menu.moderators" var="moderators" />
<spring:message code="admin.menu.designers" var="designers" />
<spring:message code="admin.menu.users" var="users" />
<spring:message code="admin.menu.advertisement" var="advertisement" />
<spring:message code="admin.advertisement.addadvertisement" var="addadvertisement" />
<spring:message code="form.title" var="title" />
<spring:message code="form.description" var="description" />
<spring:message code="form.client" var="client" />
<spring:message code="form.addadvertisement.date" var="date" />
<spring:message code="admin.advertisement.addadvertisement.advertisementphoto" var="advertisementphoto" />

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="global3dmod team">
    <meta name="keywords" content="3d printer, 3d model, 3d model free, 3d model download, 3d model download free, model to print 3d printer free, stl, stl download,stl download free, 3d designer, 3d model robot, 3д модель, 3д принтер, 3д модель скачать, 3д модель скачать напечатать, 3д дизайнер, stl бесплатные, stl скачать, global3dmod, global 3d mod admin, admin"> 
<meta name="description" content=""> 
    <link href="<c:url value="/resources/css/bootstrap.min.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/cabinets/designer.css"  />" rel="stylesheet" />
     <link href="<c:url value="/resources/css//fontawesome430/css/font-awesome.css"  />" rel="stylesheet" />
      <link href="<c:url value="/resources/css/calendar.css"  />" rel="stylesheet" />
     
    
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    <link rel="icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon">
   </head>
<body>
	<%@include file="/WEB-INF/views/header/headerWithSearch.jsp" %>  
		     
	<!-- Menu -->     
 <div class="row footerpadding">
    <div class="col-md-2 nopadding1">
     <div class="list-group">
				<img src="<c:url value="${user.avatar.avatarPath}" />"
					class="img-responsive img-thumbnail" alt="Global3Dmod avatar">
				<a href="<c:url value="/admin/profile" />"
					class="list-group-item "> <i class="fa fa-exclamation-triangle"></i> ${moderators}
				</a> <a href="<c:url value="/admin/designers" />"
					class="list-group-item"> <i class="fa fa-ban"></i> ${designers}
				</a> <a href="<c:url value="/admin/users" />" class="list-group-item">
					<i class="fa fa-user-plus"></i> ${users}
				</a> <a href="<c:url value="/admin/advertisements" />" class="list-group-item active">
					<i class="fa fa-user-plus"></i> ${advertisement}
				</a>
			</div>
    </div>
      <!--main content start-->
     <div class="nopadding2 col-md-10 ">
          <div class="mt">
                  <div class="col-md-12 nopadding2">
                  <div class="row">  
                  <div class="col-md-8">
                  <h2>${addadvertisement}</h2>
                   <form:form id="advertisement-form" name="advertisement-form" class="form-horizontal" modelAttribute="addAdvertisementForm" method="POST" enctype="multipart/form-data">
	   <div class="form-group sign-feld-margin-top">
		</div>
		<div class="form-group">
		<div class="col-md-12 height-input-string-personal">
		<form:input id="title" name="title" class="form-control input-md" path="title" placeholder="${title}"></form:input>
		<label class="error" generated="true" for="title" style="font-size:9pt; line-height: 1.2;"></label>
		<span class="error"><form:errors path="title" /></span>
		</div>
		</div>
		<div class="form-group">
		<div class="col-md-12 height-input-string-addAdvertisement">
		<form:textarea id="description" name="description" class="form-control input-md" path="description" placeholder="${description}"></form:textarea>
		<label class="error" generated="true" for="description" style="font-size:9pt; line-height: 1.2;"></label>
		<span class="error"><form:errors path="description" /></span>
		</div>
		</div>
		<br>
		<div class="form-group">
		<div class="col-md-12 height-input-string-addAdvertisement-client" style=" padding-top: 10px;">
		<form:input id="client" name="client" class="form-control input-md" path="client" placeholder="${client}"></form:input>
		<label class="error valid" generated="true" for="client" style="font-size:9pt; line-height: 1.2;"></label>
		<span class="error"><form:errors path="client" /></span>
		</div>
		</div>
		<div class="height-input-string-addAdvertisement-client">
		<form:input type="text" class="form-control" id="expirationDate" name="calendar" path="expirationDate" placeholder="${date}"/> 
			<label class="error" generated="true" for="expirationDate" style="font-size:9pt; line-height: 1.2;"></label>
			<span class="error"><form:errors path="expirationDate" /></span>
		</div>
		<br>
		<div class="height-input-string-addAdvertisement-image">
		${advertisementphoto} <input type="file" name="advertisementPhoto">
		<label class="error" generated="true" for="advertisementPhoto" style="font-size:9pt; line-height: 1.2;"></label>
		<span class="error"><form:errors path="advertisementPhoto" /></span>
		</div>
		<br>
		
		<div class="form-group">
		<div class="col-md-12">
		<input type="submit" class="btn btn-primary left-designer" value="Save" />
		</div>
	    </div>
	</form:form>
                  
                  
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
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

   <script>

 
  $(function() {

    $( "#expirationDate" ).datepicker({dateFormat:'yy-mm-dd', maxDate: "+3650",changeMonth: true,
		changeYear: true, minDate:"+0",
		yearRange: "-0:+10"});
    

  });

  </script>
  
<script src="<c:url value="/resources/js/jquery.validate.min.js" />"> </script>
<script src="<c:url value="/resources/js/${validation}.js" />"> </script>
</body>
</html> 
