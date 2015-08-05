<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Admin's page | Global3dmod</title>
<!-- Init search variable -->
<spring:message code="headerWithSearch.header.search" var="search" />
<spring:message code="moderator.menu.postsunpublished" var="unpblsd" />
<spring:message code="moderator.menu.postspublished" var="publics" />
<spring:message code="moderator.menu.users" var="users" />
<spring:message code="moderator.menu.designer" var="designers" />
<spring:message code="javascript.validation" var="validation" />
<spring:message code="moderator.menu.users" var="users" />
<spring:message code="moderator.menu.designer" var="designers" />
<spring:message code="admin.menu.moderators" var="moderators" />
<spring:message code="admin.menu.designers" var="designers" />
<spring:message code="admin.menu.users" var="users" />
<spring:message code="admin.menu.advertisement" var="advertisement" />
<spring:message code="admin.addmoderator.login" var="login" />
<spring:message code="admin.addmoderator.password" var="password" />
<spring:message code="admin.addmoderator.confirmpassword" var="confirmpassword" />
<spring:message code="admin.addmoderator.nickname" var="nickname" />
<spring:message code="admin.addmoderator.name" var="name" />
<spring:message code="admin.addmoderator.surname" var="surname" />
<spring:message code="admin.addmoderator.signupmoderator" var="signupmoderator" />

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
<link rel="icon" href="<c:url value="/resources/images/favicon.png" />"
	type="image/x-icon">
</head>
<body>
	<!-- Here some place for ads. After placing ads you may delete "placeforads" css class in header -->

	<%@include file="/WEB-INF/views/header/headerWithSearch.jsp"%>
	<!-- Designer's page will start here -->

	<!--sidebar start-->

	<!-- Menu -->
	<div class="row footerpadding">
		<div class="col-md-2 nopadding1">
			<div class="list-group">
				<img src="<c:url value="${user.avatar.avatarPath}" />"
					class="img-responsive img-thumbnail" alt="Global3Dmod avatar">
				<a href="<c:url value="/admin/profile" />"
					class="list-group-item active"> <i
					class="fa fa-exclamation-triangle"></i> ${moderators}
				</a> <a href="<c:url value="/admin/designers" />"
					class="list-group-item"> <i class="fa fa-ban"></i> ${designers}
				</a> <a href="<c:url value="/admin/users" />" class="list-group-item">
					<i class="fa fa-user-plus"></i> ${users}
				</a> <a href="<c:url value="/admin/advertisements" />" class="list-group-item">
					<i class="fa fa-user-plus"></i> ${advertisement}
				</a>
			</div>
		</div>
		
		<!--main content start-->
		<div class="nopadding2 col-md-10 ">
			<div class="mt">
			<div class="col-md-1"> </div>
				<div class="col-md-4">
					
					
			<form:form modelAttribute="addModeratorForm" method="POST">
		<div class="form-group height-input-string-addModerator">
		
		<form:input placeholder="${login}" class="form-control" id="login" name="login" path="login"></form:input>
		
		<span class="error color-style-validation"><form:errors
				path="login" /></span>
				</div>	
		<div class="form-group height-input-string-addModerator">
		
		<form:password placeholder="${password}" class="form-control" id="password" name="password" path="password"></form:password>
		<form:errors path="password" />
		
		</div>
		<div class="form-group height-input-string-addModerator">
		<form:password placeholder="${confirmpassword}" class="form-control" id="confirmPassword" name="confirmPassword"
			path="confirmPassword"></form:password>
		<form:errors path="confirmPassword" />
		</div>
		<div class="form-group height-input-string-addModerator">
		<form:input placeholder="${nickname}" class="form-control" id="nickName" name="nickName" path="nickName"></form:input>
		<form:errors path="nickName" />
		</div>
		<div class="form-group height-input-string-addModerator">
		<form:input placeholder="${name}" class="form-control" id="name" name="name" path="name"></form:input>
		<form:errors path="name" />
		</div>
		<div class="form-group height-input-string-addModerator">
		<form:input placeholder="${surname}" class="form-control" id="surname" name="surname" path="surname"></form:input>
		<form:errors path="surname" />
		</div>
		<div style="text-align: center">
		<input class="btn btn-primary" type="submit" value="${signupmoderator}" />
		</div>
	</form:form>
			</div>
			</div>
			</div>
			</div>
		


	<div class="clearfix"></div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
	 <script src="<c:url value="/resources/js/jquery-1.7.min.js" />"> </script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script> 
    <script src="<c:url value="/resources/js/jquery.validate.min.js" />"> </script>
    <script src="<c:url value="/resources/js/${validation}.js" />"> </script>
	  
	



</body>
</html>
