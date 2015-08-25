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
<spring:message code="designer.menu.personalsecurity"
	var="personalsecurity" />
<spring:message code="form.city" var="city" />
<spring:message code="form.country" var="country" />
<spring:message code="form.login" var="login" />
<spring:message code="form.nickname" var="nickname" />
<spring:message code="form.name" var="name" />
<spring:message code="form.surname" var="surname" />
<spring:message code="form.datebirth" var="datebirth" />
<spring:message code="form.rating" var="rating" />
<spring:message code="form.gender.male" var="male" />
<spring:message code="form.gender.female" var="female" />
<spring:message code="form.gender" var="gender" />
<spring:message code="form.gender.none" var="none" />
<spring:message code="form.updatedata" var="updatedata" />
<spring:message code="designer.updatepersonaldata.birthdate"
	var="birthdate" />
<spring:message code="form.save" var="save" />
<spring:message code="form.avatarupload" var="avatarupload" />

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="global3dmod team">
 <meta name="keywords" content="3d printer, 3d model, 3d model free, 3d model download, 3d model download free, model to print 3d printer free, stl, stl download,stl download free, 3d designer, 3d model robot, 3д модель, 3д принтер, 3д модель скачать, 3д модель скачать напечатать, 3д дизайнер, stl бесплатные, stl скачать, global3dmod, global 3d mod, designer "> 
    <meta name="description" content=""> 
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
					class="img-responsive avatar-img img-thumbnail" alt="Global3Dmod avatar">
				<a href="<c:url value="/designer/profile?sort=date&page=1" />"
					class="list-group-item"> <i class="fa fa-briefcase"></i>
					${works}
				</a> <a href="<c:url value="/designer/personalData" />"
					class="list-group-item active"><i class="fa fa-cogs"></i>
					${data} </a> <a href="<c:url value="/designer/secure/personalSecurity" />"
					class="list-group-item"><i class="fa fa-lock"></i>
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
						<div class="col-md-4 height-div-updatepersonal"
							style="padding-left: 0px;">
							<div class="content-pael">
								<h2>${data}</h2>

								<table class="table table-striped table-advance table-hover">

									<tbody>
										<tr>
											<td>${nickname}</td>
											<td class="hidden-phone">${user.nickName}</td>

										</tr>
										<tr>
											<td>${city}</td>
											<td class="hidden-phone">${user.city.title}</td>

										</tr>
										<tr>
											<td>${country}</td>
											<td class="hidden-phone">${user.country.title}</td>

										</tr>
										<tr>
											<td>${login}</td>
											<td class="hidden-phone">${user.login}</td>
										</tr>
										<tr>
											<td>${name}</td>
											<td class="hidden-phone">${user.name}</td>

										</tr>
										<tr>
											<td>${surname}</td>
											<td class="hidden-phone">${user.surname}</td>

										</tr>
										<tr>
											<td>${datebirth}</td>
											<td class="hidden-phone">${user.dateBirth}</td>

										</tr>
										<tr>
											<td>${rating}</td>
											<td class="hidden-phone">${user.rating}</td>

										</tr>
										<tr>
											<td>${gender}</td>
											<td class="hidden-phone"><c:if
													test="${user.gender == 2}">
			${male}
		</c:if> <c:if test="${user.gender == 1}">
			${female}
		</c:if> <c:if test="${user.gender == 0}">
			${none}
		</c:if></td>

										</tr>
									</tbody>
								</table>
							</div>

						</div>
						<div class="col-md-8">
							<h2>${updatedata}</h2>
							<form:form id="contact-form" name="contact-form"
								class="form-horizontal" modelAttribute="personalDataForm"
								method="POST" enctype="multipart/form-data">
								<div class="form-group sign-feld-margin-top"></div>
								<div class="form-group">
									<div class="col-md-12 height-input-string-personal">
										<form:input id="name" name="name"
											class="form-control input-md" path="name"
											placeholder="${name}" value="${user.name}"></form:input>
										<label class="error" generated="true" for="name"style="font-size:9pt; line-height: 1.2;"></label>
										<span class="error"><form:errors path="name" /></span>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-12 height-input-string-personal">
										<form:input id="surname" name="surname"
											class="form-control input-md" path="surname"
											placeholder="${surname}" value="${user.surname}"></form:input>
										<label class="error" generated="true" for="surname" style="font-size:9pt; line-height: 1.2;"></label>
										<span class="error"><form:errors path="surname" /></span>
									</div>
								</div>


								<div>

									<form:select class="form-control" id="idCountry"
										path="country_idCountry">
									</form:select>

									<br>
									<form:select class="form-control" id="idCity"
										path="city_idCity">
										<form:option value="0">None</form:option>
									</form:select>
									<br>
								</div>
								<div class="height-input-updatepersonal-date">
									<form:input type="text" class="form-control" id="dateBirth"
										name="calendar" path="dateBirth" placeholder="${birthdate}" />
									<label class="error" generated="true" for="dateBirth" style="font-size:9pt; line-height: 1.2;"></label>
									<span class="error"><form:errors path="dateBirth" /></span>
								</div>
								<br>
								<form:select class="form-control" id="gender" name="gender"
									path="gender">
									<form:option value="0">${none}</form:option>
									<form:option value="1">${female}</form:option>
									<form:option value="2">${male}</form:option>
								</form:select>
								<br>
								<div class="height-input-updatepersonal-avatar">
									${avatarupload} <input type="file" name="avatar">
									<label class="error" generated="true" for="avatar" style="font-size:9pt; line-height: 1.2;"></label>
									<span class="error"><form:errors path="avatar" /></span>
								</div>
								<br>

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
	<script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"> </script>
		
	</script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />">
		
	</script>


	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$('#idCountry')
									.change(
											function() {
												$
														.getJSON(
																'${getCities}',
																{
																	idCountry : $(
																			this)
																			.val(),
																	ajax : 'true'
																},
																function(data) {
																	var html;
																	var len = data.length;
																	for (var i = 0; i < len; i++) {
																		html += '<option value="' + data[i].idCity + '">'
																				+ data[i].title
																				+ '</option>';
																	}
																	html += '</option>';
																	$('#idCity')
																			.html(
																					html);
																});
											});
						});
	</script>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$
									.getJSON(
											'${getCountries}',
											{
												ajax : 'true'
											},
											function(data) {
												var html;
												var len = data.length;
												for (var i = 0; i < len; i++) {
													html += '<option value="' + data[i].idCountry + '">'
															+ data[i].title
															+ '</option>';
												}
												html += '</option>';
												$('#idCountry').html(html);
											});
						});
	</script>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#idCity").change(onSelectChange);
		});
		function onSelectChange() {
			var selected = $("#idCity option:selected");
			var output = "";
			if (selected.val() != 0) {
				output = "You selected City " + selected.text();
			}
			$("#output").html(output);
		}
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
	<script>
    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
    (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
    m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
    })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
    ga('create', 'UA-66505156-1', 'auto');
    ga('send', 'pageview');
    </script>
    <!-- Yandex.Metrika counter -->
    <script type="text/javascript">
    (function (d, w, c) {
        (w[c] = w[c] || []).push(function() {
            try {
                w.yaCounter32035491 = new Ya.Metrika({
                    id:32035491,
                    clickmap:true,
                    trackLinks:true,
                    accurateTrackBounce:true
                });
            } catch(e) { }
        });

        var n = d.getElementsByTagName("script")[0],
            s = d.createElement("script"),
            f = function () { n.parentNode.insertBefore(s, n); };
        s.type = "text/javascript";
        s.async = true;
        s.src = "https://mc.yandex.ru/metrika/watch.js";

        if (w.opera == "[object Opera]") {
            d.addEventListener("DOMContentLoaded", f, false);
        } else { f(); }
    })(document, window, "yandex_metrika_callbacks");
    </script>
    <noscript><div><img src="https://mc.yandex.ru/watch/32035491" style="position:absolute; left:-9999px;" alt="" /></div></noscript>
    <!-- /Yandex.Metrika counter -->
</body>
</html>
