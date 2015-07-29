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
<spring:message code="user.menu.mybookmarks" var="mybookmarks"/>
<spring:message code="javascript.validation" var="validation" />


 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="global3dmod team">
    <link href="<c:url value="/resources/css/bootstrap.css"  />" rel="stylesheet" />
    <link href="<c:url value="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/cabinets/designer.css"  />" rel="stylesheet" />
     <link href="<c:url value="/resources/css//fontawesome430/css/font-awesome.css"  />" rel="stylesheet" />
      <link href="<c:url value="/resources/css/calendar.css"  />" rel="stylesheet" />
     
    
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
	     
	<!-- Menu -->     
 <div class="row footerpadding">
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
                  <div class="row">
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
                                          
                  </div>
                  <div class="col-md-8">
                  <h2>Update data</h2>
                   <form:form id="contact-form" name="contact-form" class="form-horizontal" modelAttribute="personalDataForm" method="POST" enctype="multipart/form-data">
	   <div class="form-group sign-feld-margin-top">
		</div>
		<div class="form-group">
		<div class="col-md-12 height-input-string-personal">
		<form:input id="name" name="name" class="form-control input-md" path="name" placeholder="Name" value="${user.name}"></form:input>
		<span class="error"><form:errors path="name" /></span>
		</div>
		</div>
		<div class="form-group">
		<div class="col-md-12 height-input-string-personal">
		<form:input id="surname" name="surname" class="form-control input-md" path="surname" placeholder="Surname" value="${user.surname}"></form:input>
		<span class="error"><form:errors path="surname" /></span>
		</div>
		</div>
		
		
			<div>
				
				<form:select class="form-control" id="idCountry" path="country_idCountry">
				</form:select>
				
				<br>
				<form:select class="form-control" id="idCity" path="city_idCity">
					<form:option value="0">None</form:option>
				</form:select>
				<br>
			</div>
		
		<form:input type="text" class="form-control" id="dateBirth" name="calendar" path="dateBirth" placeholder="Please select a date of birth"/> 
		<br>
				<form:select class="form-control" id="gender"
			name="gender" path="gender">
			<form:option value="0">None</form:option>
			<form:option value="1">Female</form:option>
			<form:option value="2">Male</form:option>
		</form:select>
		<br>
		Avatar to upload: <input type="file" name="avatar">
		<span class="error"><form:errors path="avatar" /></span>
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
					var html;
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


  <script src="//code.jquery.com/jquery-1.10.2.js"></script>

  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

  
  <script>

 
  $(function() {

    $( "#dateBirth" ).datepicker({dateFormat:'yy-mm-dd', maxDate: "+0",changeMonth: true,
		changeYear: true,
		yearRange: "-100:+0"});
    

  });

  </script>
<script src="<c:url value="/resources/js/jquery.validate.min.js" />"> </script>
<script src="<c:url value="/resources/js/${validation}.js" />"> </script>
</body>
</html> 
