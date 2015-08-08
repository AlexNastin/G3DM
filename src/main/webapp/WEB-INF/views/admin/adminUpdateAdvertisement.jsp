<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Edit data | Global3dmod</title>
<!-- Init search variable -->
<spring:message code="headerWithSearch.header.search" var="search" />
<spring:message code="designer.menu.works" var="works" />
<spring:message code="designer.menu.data" var="data" />
<spring:message code="designer.menu.add" var="add" />
<spring:message code="user.menu.mybookmarks" var="mybookmarks" />
<spring:message code="javascript.validation" var="validation" />
<spring:message code="admin.menu.moderators" var="moderators" />
<spring:message code="admin.menu.designers" var="designers" />
<spring:message code="admin.menu.users" var="users" />
<spring:message code="admin.menu.advertisement" var="advertisementUpdate" />
<spring:message code="form.title" var="title" />
<spring:message code="form.image" var="image" />
<spring:message code="form.description" var="description" />
<spring:message code="form.client" var="client" />
<spring:message code="admin.menu.moderators.dateregister" var="dateregister" />
<spring:message code="form.expirationdate" var="expirationdate" />
<spring:message code="admin.advertisement.addadvertisement" var="addadvertisement" />
<spring:message code="form.addadvertisement.date" var="date" />
<spring:message code="admin.advertisement.addadvertisement.advertisementphoto" var="advertisementphoto" />
<spring:message code="form.save" var="save" />

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="global3dmod team">
<link href="<c:url value="/resources/css/bootstrap.min.css"  />"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/cabinets/designer.css"  />"
	rel="stylesheet" />
<link
	href="<c:url value="/resources/css//fontawesome430/css/font-awesome.css"  />"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/calendar.css"  />"
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

	<!-- Menu -->
	<div class="row footerpadding">
		<div class="col-md-2 nopadding1">
			<div class="list-group">
				<img src="<c:url value="${user.avatar.avatarPath}" />"
					class="img-responsive img-thumbnail" alt="Global3Dmod avatar">
				<a href="<c:url value="/admin/profile" />" class="list-group-item ">
					<i class="fa fa-exclamation-triangle"></i> ${moderators}
				</a> <a href="<c:url value="/admin/designers" />"
					class="list-group-item"> <i class="fa fa-ban"></i> ${designers}
				</a> <a href="<c:url value="/admin/users" />" class="list-group-item">
					<i class="fa fa-user-plus"></i> ${users}
				</a> <a href="<c:url value="/admin/advertisements" />"
					class="list-group-item active"> <i class="fa fa-user-plus"></i>
					${advertisementUpdate}
				</a>
			</div>
		</div>
		<!--main content start-->
		<div class="nopadding2 col-md-10 ">
			<div class="mt">
				<div class="col-md-12 nopadding2">
					<div class="row">
						<div class="col-md-4" style="padding-left: 0px;">
							<div class="content-pael">
								<h2>${advertisementUpdate}</h2>

								<table class="table table-striped table-advance table-hover">

									<tbody>
										<tr>
											<td>${title}</td>
											<td class="hidden-phone">${advertisement.title}</td>
										</tr>
										<tr>
											<td>${image}</td>
											<td><img alt=""
												src="<c:url value="${advertisement.filePath}" />"></td>

										</tr>
										<tr>
											<td>${description}</td>
											<td class="hidden-phone">${advertisement.description}</td>

										</tr>
										<tr>
											<td>${client}</td>
											<td class="hidden-phone">${advertisement.client}</td>

										</tr>
										<tr>
											<td>${dateregister}</td>
											<td class="hidden-phone">${advertisement.registrationDate}</td>

										</tr>
										<tr>
											<td>${expirationdate}</td>
											<td class="hidden-phone">${advertisement.expirationDate}</td>

										</tr>
									</tbody>
								</table>
							</div>

						</div>
						<div class="col-md-8">
							<h2>${addadvertisement}</h2>
							<form:form id="advertisement-form" name="advertisement-form"
								class="form-horizontal" modelAttribute="updateAdvertisementForm"
								method="POST" enctype="multipart/form-data">
								<div class="form-group sign-feld-margin-top"></div>
								<div class="form-group">
									<div class="col-md-12 height-input-string-updateAdvertisement">
										<form:input id="title" name="title"
											class="form-control input-md" path="title"
											placeholder="${title}"></form:input>
										<label class="error" generated="true" for="title" style="font-size:9pt; line-height: 1.2;"></label>
										<span class="error"><form:errors path="title" /></span>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-12 height-input-string-updateAdvertisement-description"
										style="padding-top: 10px;">
										<form:textarea id="description" name="description"
											class="form-control input-md" path="description"
											placeholder="${description}"></form:textarea>
										<label class="error" generated="true" for="description" style="font-size:9pt; line-height: 1.2;"></label>
										<span class="error"><form:errors path="description" /></span>
									</div>
								</div>
								<div class="height-input-string-updateAdvertisement">
								<form:input type="text" class="form-control" id="expirationDate"
									name="calendar" path="expirationDate"
									placeholder="${date}" />
								<label class="error" generated="true" for="expirationDate" style="font-size:9pt; line-height: 1.2;"></label>
								<span class="error"><form:errors path="expirationDate" /></span>
								</div>
								<br>
								<div class="height-input-string-updateAdvertisement">
		${advertisementphoto}<input type="file" name="advertisementPhoto">
								<label class="error" generated="true" for="advertisementPhoto" style="font-size:9pt; line-height: 1.2;"></label>
								<span class="error"><form:errors
										path="advertisementPhoto" /></span>
								</div>
								<br>
								<form:input id="idAdvertisement" name="idAdvertisement"
									path="idAdvertisement" value="${advertisement.idAdvertisement}"
									type="hidden"></form:input>
								<div class="form-group">
									<div class="col-md-12">
										<input type="submit" class="btn btn-primary left-designer"
											value="${save}" />
									</div>
								</div>
							</form:form>


						</div>
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


	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

	<script>
		$(function() {

			$("#expirationDate").datepicker({
				dateFormat : 'yy-mm-dd',
				maxDate : "+3650",
				minDate : "+0",
				changeMonth : true,
				changeYear : true,
				yearRange : "-0:+10"
			});

		});
	</script>

	<script src="<c:url value="/resources/js/jquery.validate.min.js" />">
		
	</script>
	<script src="<c:url value="/resources/js/${validation}.js" />">
		
	</script>
</body>
</html>
