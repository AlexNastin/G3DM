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
<spring:message code="designer.updatepost.post" var="postforupdate" />
<spring:message code="form.image" var="image" />
<spring:message code="form.description" var="description" />
<spring:message code="form.category" var="category" />
<spring:message code="form.subcategory" var="subcategory" />
<spring:message code="form.title" var="title" />
<spring:message code="form.instruction" var="instruction" />
<spring:message code="designer.updatepost.designerprogram"
	var="designerprogram" />
<spring:message code="designer.updatepost.technologies"
	var="technologies" />
<spring:message code="form.file" var="file" />
<spring:message code="form.updatedata" var="updatedata" />
<spring:message code="designer.updatepost.selecttechnologies"
	var="selecttechnologies" />
<spring:message code="designer.updatepost.modeltoupload"
	var="modeltoupload" />
<spring:message code="designer.updatepost.photomodeltoupload"
	var="photomodeltoupload" />
<spring:message code="form.save" var="save" />


<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="global3dmod team">
<meta name="keywords"
	content="3d printer, 3d model, 3d model free, 3d model download, 3d model download free, model to print 3d printer free, stl, stl download,stl download free, 3d designer, 3d model robot, 3д модель, 3д принтер, 3д модель скачать, 3д модель скачать напечатать, 3д дизайнер, stl бесплатные, stl скачать, global3dmod, global 3d mod, designer ">
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
<c:url value="/get/subcategories" var="getSubcategories" />
<c:url value="/get/categories" var="getCategories" />
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
					class="img-responsive avatar-img img-thumbnail"
					alt="Global3Dmod avatar"> <a
					href="<c:url value="/designer/profile?sort=date&page=1" />"
					class="list-group-item active"> <i class="fa fa-briefcase"></i>
					${works}
				</a> <a href="<c:url value="/designer/personalData" />"
					class="list-group-item"><i class="fa fa-cogs"></i> ${data} </a> <a
					href="<c:url value="/designer/secure/personalSecurity" />"
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
						<div class="col-md-4" style="padding-left: 0px;">
							<div class="content-pael">
								<h2>${postforupdate}</h2>

								${image} <img alt="" class="img-responsive"
									src="<c:url value="${post.postPhotos[0].photoPath}" />">
								<div class="table-responsive">
								<table class="table table-striped table-advance table-hover">

									<tbody>
										<tr>
											<td>${title}</td>
											<td class="hidden-phone">${post.title}</td>

										</tr>
										<tr>
											<td>${description}</td>
											<td class="hidden-phone">${post.description}</td>

										</tr>
										<tr>
											<td>${instruction}</td>
											<td class="hidden-phone">${post.instruction}</td>

										</tr>
										<tr>
											<td>${category}</td>
											<td class="hidden-phone">${post.category.title}</td>

										</tr>
										<tr>
											<td>${subcategory}</td>
											<td class="hidden-phone">${post.subcategory.title}</td>

										</tr>
										<tr>
											<td>${designerprogram}</td>
											<td class="hidden-phone">${post.disProgram.title}</td>

										</tr>
										<tr>
											<td>${technologies}</td>

											<td class="hidden-phone"><c:forEach
													items="${post.technologies}" var="technology"> ${technology.title} </c:forEach>
											</td>

										</tr>
										<tr>
											<td>${file}</td>
											<td><a
												href="<c:url value="/download?id=${post.file.idFile}" />">
													<i class="btn btn-primary fa fa-download"> ${down}</i>
											</a></td>
										</tr>
									</tbody>
								</table>
								</div>
							</div>

						</div>
						<div class="col-md-8">
							<h2>${updatedata}</h2>
							<form:form id="contact-form" name="contact-form"
								class="form-horizontal" modelAttribute="updatePostForm"
								method="POST" enctype="multipart/form-data">
								<form:input id="idPost" name="idPost" path="idPost"
									value="${post.idPost}" type="hidden"></form:input>
								<div class="form-group sign-feld-margin-top"></div>

								<div class="form-group">
									<div class="col-md-12 height-input-string-updatepost-title">
										<form:input id="title" name="title"
											class="form-control input-md" path="title"
											placeholder="${title}" value="${post.title}"></form:input>
										<label class="error valid" generated="true" for="title"
											style="font-size: 9pt; line-height: 1.2;"></label> <span
											class="error"><form:errors path="title" /></span>
									</div>
								</div>
								<div class="form-group">
									<div style="margin-bottom: 6em;" class="col-md-12 height-input-string-updatepost-description">
										<textarea rows="5" id="description" name="description"
											class="form-control input-md" path="description">${post.description}</textarea>

										<label class="error valid" generated="true" for="description"
											style="font-size: 9pt; line-height: 1.2;"></label> <span
											class="error"><form:errors path="description" /></span>
									</div>
								</div>
								<div class="form-group">
									<div style="margin-bottom: 6em;" class="col-md-12 height-input-string-updatepost-instruction">
										<textarea rows="5" id="instruction" name="instruction"
											class="form-control input-md" path="instruction">${post.instruction}</textarea>
										<label class="error valid" generated="true" for="instruction"
											style="font-size: 9pt; line-height: 1.2;"></label> <span
											class="error"><form:errors path="instruction" /></span>
									</div>
								</div>

								<fieldset>
									<div>
										<div
											class="form-group height-input-string-updatepost-category">
											<form:select class="form-control" id="idCategory"
												path="category_idCategory">
											</form:select>
											<label class="error" generated="true" for="idCategory"
												style="font-size: 9pt; line-height: 1.2;"></label> <span
												class="error"><form:errors path="category_idCategory" /></span>
										</div>
										<div
											class="form-group height-input-string-updatepost-category">
											<form:select class="form-control" id="idSubcategory"
												path="subcategory_idSubcategory">
												<form:option value="0">Subcategory</form:option>
											</form:select>
											<label class="error" generated="true" for="idSubcategory"
												style="font-size: 9pt; line-height: 1.2;"></label> <span
												class="error"><form:errors
													path="subcategory_idSubcategory" /></span>
										</div>
									</div>
								</fieldset>

								<div class="form-group">
									<form:select class="form-control" id="disProgram_idDisProgram"
										name="disProgram_idDisProgram" path="disProgram_idDisProgram">
										<c:forEach items="${listDisProgram}" var="disProgram">
											<form:option value="${disProgram.idDisProgram}">${disProgram.title}</form:option>
										</c:forEach>
									</form:select>
									<span class="error"><form:errors
											path="disProgram_idDisProgram" /></span>
								</div>

								<div class="col-md-6">
									<h3 style="margin-top: 0px">${selecttechnologies}</h3>
									<div class="height-input-string-updatepost-technologies"
										style="margin-bottom: 5%;">
										<c:forEach items="${listTechnologies}" var="technology">
											<form:checkbox path="technologiesId"
												value="${technology.idTechnology}" />${technology.title}<br>
										</c:forEach>
										<span class="error"><form:errors path="technologiesId" /></span>
										<label for="technologiesId" class="error" generated="true"
											style="font-size: 9pt; line-height: 1.2;"></label>
									</div>
								</div>

								<br>

								<div class="height-input-string-updatepost-stl">
									${modeltoupload} <input type="file" name="modelUpdate"> <label
										class="error" generated="true" for="modelUpdate"
										style="font-size: 9pt; line-height: 1.2;"></label> <span
										class="error"><form:errors path="modelUpdate" /></span>
								</div>
								<br>
								<div class="height-input-string-updatepost-stl">
									${photomodeltoupload} <input type="file" name="firstPhotoUpdate">
									<label class="error" generated="true" for="firstPhotoUpdate"
										style="font-size: 9pt; line-height: 1.2;"></label> <span
										class="error"><form:errors path="firstPhotoUpdate" /></span>
								</div>
								<br>

								<div class="form-group">
									<div class="col-md-5">
										<input type="submit" class="btn btn-primary" value="${save}" />
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


	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$('#idCategory')
									.change(
											function() {
												$
														.getJSON(
																'${getSubcategories}',
																{
																	idCategory : $(
																			this)
																			.val(),
																	ajax : 'true'
																},
																function(data) {
																	var html = '<option value="0">Subcategory</option>';
																	var len = data.length;
																	for (var i = 0; i < len; i++) {
																		html += '<option value="' + data[i].idSubcategory + '">'
																				+ data[i].title
																				+ '</option>';
																	}
																	html += '</option>';
																	$(
																			'#idSubcategory')
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
											'${getCategories}',
											{
												ajax : 'true'
											},
											function(data) {
												var html = '<option value="">Category</option>';
												var len = data.length;
												for (var i = 0; i < len; i++) {
													html += '<option value="' + data[i].idCategory + '">'
															+ data[i].title
															+ '</option>';
												}
												html += '</option>';
												$('#idCategory').html(html);
											});
						});
	</script>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#idSubcategory").change(onSelectChange);
		});
		function onSelectChange() {
			var selected = $("#idSubcategory option:selected");
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
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		})(window, document, 'script',
				'//www.google-analytics.com/analytics.js', 'ga');
		ga('create', 'UA-66505156-1', 'auto');
		ga('send', 'pageview');
	</script>
	<!-- Yandex.Metrika counter -->
	<script type="text/javascript">
		(function(d, w, c) {
			(w[c] = w[c] || []).push(function() {
				try {
					w.yaCounter32035491 = new Ya.Metrika({
						id : 32035491,
						clickmap : true,
						trackLinks : true,
						accurateTrackBounce : true
					});
				} catch (e) {
				}
			});

			var n = d.getElementsByTagName("script")[0], s = d
					.createElement("script"), f = function() {
				n.parentNode.insertBefore(s, n);
			};
			s.type = "text/javascript";
			s.async = true;
			s.src = "https://mc.yandex.ru/metrika/watch.js";

			if (w.opera == "[object Opera]") {
				d.addEventListener("DOMContentLoaded", f, false);
			} else {
				f();
			}
		})(document, window, "yandex_metrika_callbacks");
	</script>
	<noscript>
		<div>
			<img src="https://mc.yandex.ru/watch/32035491"
				style="position: absolute; left: -9999px;" alt="" />
		</div>
	</noscript>
	<!-- /Yandex.Metrika counter -->
</body>
</html>
