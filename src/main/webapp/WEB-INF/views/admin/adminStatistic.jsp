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
<spring:message code="admin.menu.moderators" var="moderators" />
<spring:message code="admin.menu.designers" var="designers" />
<spring:message code="admin.menu.statictic" var="statictic" />
<spring:message code="admin.menu.users" var="users" />
<spring:message code="admin.menu.advertisement" var="advertisement" />
<spring:message code="admin.menu.moderators.addmoderator"
	var="addmoderator" />
<spring:message code="admin.menu.moderators.nickname" var="nickname" />
<spring:message code="admin.menu.moderators.login" var="login" />
<spring:message code="admin.menu.moderators.name" var="name" />
<spring:message code="admin.menu.moderators.surname" var="surname" />
<spring:message code="admin.menu.moderators.dateregister"
	var="dateregister" />
	<spring:message code="admin.menu.moderators.deleteModerator"
	var="deleteModerator" />
<spring:message code="form.close" var="close" />
<spring:message code="admin.moderator.deletemessage" var="deletemessage" />

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="global3dmod team">
<meta name="keywords" content="3d printer, 3d model, 3d model free, 3d model download, 3d model download free, model to print 3d printer free, stl, stl download,stl download free, 3d designer, 3d model robot, 3д модель, 3д принтер, 3д модель скачать, 3д модель скачать напечатать, 3д дизайнер, stl бесплатные, stl скачать, global3dmod, global 3d mod, admin"> 
<meta name="description" content=""> 
<link href="<c:url value="/resources/css/bootstrap.min.css"  />"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/cabinets/designer.css"  />"
	rel="stylesheet" />
<link	href="<c:url value="/resources/css/fontawesome430/css/font-awesome.css"  />"
	rel="stylesheet" />

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
					class="img-responsive avatar-img img-thumbnail" alt="Global3Dmod avatar">
				<a href="<c:url value="/admin/profile" />"
					class="list-group-item"> <i
					class="fa fa-exclamation-triangle"></i> ${moderators}
				</a> <a href="<c:url value="/admin/designers" />"
					class="list-group-item"> <i class="fa fa-ban"></i> ${designers}
				</a> <a href="<c:url value="/admin/users" />" class="list-group-item">
					<i class="fa fa-user-plus"></i> ${users}
				</a> <a href="<c:url value="/admin/advertisements" />"
					class="list-group-item"> <i class="fa fa-user-plus"></i>
					${advertisement}
				</a> <a href="<c:url value="/admin/statistic" />"
					class="list-group-item active"> <i class="fa fa-user-plus"></i>
					${statictic}
				</a>
			</div>
		</div>
		<!--main content start-->

		<div class="nopadding2 col-md-10 ">
			<div class="mt">
				<div class="col-md-12 nopadding2">
					<div class="content-panel">
						<table class="table table-striped table-advance table-hover">
							<div class="row">
								<h2>
									<div class="col-md-12">
										${statictic}
									</div>
								</h2>
							</div>
							<!-- Some sorts for table -->

							${numberOfAllUsers},
							${numberOfDesigners},
							${numberOfModerators},
							${numberOfAdmins},
							${numberOfUsers},
							${numberOfAllPosts},
							${numberOfDeletedPosts},
							${numberOfRejectedPosts},
							${numberOfModeratingPosts},
							${numberOfPublishingPosts}
						</table>
					</div>
				</div>
			</div>

		</div>
	</div>


	<div class="clearfix"></div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
	<script src="<c:url value="/resources/js/jquery-1.7.min.js" />">
		
	</script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />">
		
	</script>
    
</body>
</html>
