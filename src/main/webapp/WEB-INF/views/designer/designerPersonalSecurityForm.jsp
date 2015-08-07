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
<spring:message code="javascript.validation" var="validation" />
<spring:message code="designer.menu.personalsecurity" var="personalsecurity" />
<spring:message code="form.updatepassword" var="updatepassword" />
<spring:message code="form.password" var="password" />
<spring:message code="form.confirmpassword" var="confirmpassword" />

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="global3dmod team">
<link href="<c:url value="/resources/css/bootstrap.css"  />"
	rel="stylesheet" />
<link
	href="<c:url value="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"  />"
	rel="stylesheet" />

<link href="<c:url value="/resources/css/cabinets/designer.css"  />"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
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
<c:url value="/get/cities" var="getCities" />
<c:url value="/get/countries" var="getCountries" />
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
				<a href="<c:url value="/designer/profile?sort=date&page=1" />"
					class="list-group-item"> <i class="fa fa-briefcase"></i>
					${works}
				</a> <a href="<c:url value="/designer/personalData" />"
					class="list-group-item"><i class="fa fa-cogs"></i> ${data} </a> <a
					href="<c:url value="/designer/secure/personalSecurity" />"
					class="list-group-item active"><i class="fa fa-lock"></i>
					${personalsecurity} </a> <a href="<c:url value="/designer/addPost" />"
					class="list-group-item"><i class="fa fa-plus-square"></i>
					${add} </a>
			</div>
		</div>
		<!--main content start-->
		<div class="nopadding2 col-md-10 ">
			<div class="mt">
				<div class="col-md-12 nopadding2">
					<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-4">

							<h2 style="text-align: center; padding-top: 1em;">
								<i class="fa fa-lock"></i> ${updatepassword} <i class="fa fa-lock"></i>
							</h2>
							<form:form id="contact-form" name="contact-form"
								class="form-horizontal" modelAttribute="personalSecurityForm"
								method="POST">
								<div class="form-group sign-feld-margin-top"></div>
								<div class="form-group">
									<div class="col-md-12 height-input-string-security">
										<form:password id="password" name="password"
											class="form-control input-md" path="password"
											placeholder="${password}"></form:password>
										<span class="error"><form:errors path="password" /></span>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-12 height-input-string-security">
										<form:password id="confirmPassword" name="confirmPassword"
											class="form-control input-md" path="confirmPassword"
											placeholder="${confirmpassword}"></form:password>
										<span class="error"><form:errors path="confirmPassword" /></span>
									</div>
								</div>

								<c:if test="${message != null}">
									<div class="alert alert-info" role="alert"
										style="margin-top: 3%; padding: 1%">${message}</div>
								</c:if>
								<br>

								<div class="form-group" style="text-align: center;">

									<input type="submit" class="btn btn-primary" value="Save" />

								</div>
							</form:form>


						</div>
						<div class="col-md-4"></div>
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




	<script src="//code.jquery.com/jquery-1.10.2.js"></script>

	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>


	<script>
		$(function() {

			$("#dateBirth").datepicker({
				dateFormat : 'yy-mm-dd',
				maxDate : "+0",
				changeMonth : true,
				changeYear : true,
				yearRange : "-100:+0"
			});

		});
	</script>

	<script src="<c:url value="/resources/js/jquery.validate.min.js" />">
		
	</script>
	<script src="<c:url value="/resources/js/${validation}.js" />">
		
	</script>
</body>
</html>
