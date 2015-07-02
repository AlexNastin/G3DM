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
<spring:message code="headerWithSearch.header.search" var="search"/>
<spring:message code="designer.menu.works" var="works"/>
<spring:message code="designer.menu.data" var="data"/>
<spring:message code="designer.menu.add" var="add"/>



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
<c:url value="/get/cities" var="getCities" />
<c:url value="/get/countries" var="getCountries" />
   </head>
<body>
<!-- Here some place for ads. After placing ads you may delete "placeforads" css class in header -->

	<%@include file="/WEB-INF/views/header/headerWithSearch.jsp" %>  
	<!-- Designer's page will start here -->
	     
	    
     
 <div class="row footerpadding">
    <div class="col-md-2 nopadding1">
     <div class="list-group">
      <img src="<c:url value="/resources/images/auto.jpg" />" class="img-responsive img-thumbnail" alt="Responsive image">      
  <a href="<c:url value="/designer/profile?sort=date&page=1" />" class="list-group-item">
    <i class="fa fa-briefcase"></i> ${works} 
  </a>
  
  <a href="<c:url value="/designer/personalData" />" class="list-group-item active"><i class="fa fa-cogs"></i> ${data}  </a>
  <a href="<c:url value="/designer/addPost" />" class="list-group-item"><i class="fa fa-plus-square"></i> ${add}  </a>
  
	 </div>
    </div>
      <!--main content start-->
      
      ${user.nickName}<br>
      ${user.city.title}<br>
      ${user.country.title}<br>
      ${user.login}<br>
      ${user.name}<br>
      ${user.surname}<br>
      ${user.dateBirth}<br>
      ${user.rating}<br>
		<c:if test="${user.gender == 2}">
			Male
		</c:if>
		<c:if test="${user.gender == 1}">
			Female
		</c:if>
		<c:if test="${user.gender == 0}">
			None
		</c:if>
		<br>
       <form:form id="contact-form" name="contact-form" class="form-horizontal" modelAttribute="personalDataForm" method="POST">
	   <div class="form-group sign-feld-margin-top">
		</div>
		<div class="form-group">
		<div class="col-md-12 height-input-string-signup">
		<form:input id="name" name="name" class="form-control input-md" path="name" placeholder="Name" value="${user.name}"></form:input>
		<span class="error"><form:errors path="name" /></span>
		</div>
		</div>
		<div class="form-group">
		<div class="col-md-12 height-input-string-signup">
		<form:input id="surname" name="surname" class="form-control input-md" path="surname" placeholder="Surname" value="${user.surname}"></form:input>
		<span class="error"><form:errors path="surname" /></span>
		</div>
		</div>
		<div class="form-group">
		<div class="col-md-12 height-input-string-signup">
		<form:password id="password" name="password" class="form-control input-md" path="password" placeholder="Password"></form:password>
		<span class="error"><form:errors path="password" /></span>
		</div>
		</div>
		<div class="form-group">
		<div class="col-md-12 height-input-string-signup">
		<form:password id="confirmPassword" name="confirmPassword" class="form-control input-md" path="confirmPassword" placeholder="Confirm password"></form:password>
		<span class="error"><form:errors path="confirmPassword" /></span>
		</div>
		</div>
		
		<fieldset>
			<div>
				<div class="form-group">
				<form:select class="form-control" id="idCountry" path="country_idCountry">
				</form:select>
				</div>
				<div class="form-group">
				<form:select class="form-control" id="idCity" path="city_idCity">
					<form:option value="0">City</form:option>
				</form:select>
				</div>
			</div>
		</fieldset>
		<p>ДР: <form:input type="date" name="calendar" path="dateBirth" id="dateBirth"/>
		<form:select class="form-control" id="gender"
			name="gender" path="gender">
			<form:option value="0">None</form:option>
			<form:option value="1">Female</form:option>
			<form:option value="2">Male</form:option>
		</form:select>
		
		<div class="form-group">
		<div class="col-md-5">
		<input type="submit" class="btn btn-default btn-outline btn-circle" value="Update" />
		</div>
	    </div>
	</form:form>
      
          
  
  
  <div class="clearfix"> </div>
  </div>
	<%@include file="/WEB-INF/views/footer.jsp" %>  
    <script src="<c:url value="/resources/js/jquery-1.7.min.js" />"> </script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script> 
   
	  
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
																var html = '<option value="0">City</option>';
																var len = data.length;
																for (var i = 0; i < len; i++) {
																	html += '<option value="' + data[i].idCity + '">'
																			+ data[i].title
																			+ '</option>';
																}
																html += '</option>';
																$(
																		'#idCity')
																		.html(
																				html);
															});
										});
					});
</script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$.getJSON('${getCountries}', {
					ajax : 'true'
				}, function(data) {
					var html = '<option value="0">Country</option>';
					var len = data.length;
					for (var i = 0; i < len; i++) {
						html += '<option value="' + data[i].idCountry + '">'
								+ data[i].title + '</option>';
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
</body>
</html> 
