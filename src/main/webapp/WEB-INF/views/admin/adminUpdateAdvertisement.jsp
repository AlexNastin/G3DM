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
   </head>
<body>
<!-- Here some place for ads. After placing ads you may delete "placeforads" css class in header -->

	<%@include file="/WEB-INF/views/header/headerWithSearch.jsp" %>  
	<!-- Designer's page will start here -->
	     
	<!-- Menu -->     
 <div class="row footerpadding">
    <div class="col-md-2 nopadding1">
     <div class="list-group">
				<img src="<c:url value="${user.avatar.avatarPath}" />"
					class="img-responsive img-thumbnail" alt="Global3Dmod avatar">
				<a href="<c:url value="/admin/profile" />"
					class="list-group-item active"> <i
					class="fa fa-exclamation-triangle"></i> Moderators
				</a> <a href="<c:url value="/admin/designers" />"
					class="list-group-item"> <i class="fa fa-ban"></i> Designers
				</a> <a href="<c:url value="/admin/users" />" class="list-group-item">
					<i class="fa fa-user-plus"></i> Users
				</a> <a href="<c:url value="/admin/advertisements" />" class="list-group-item">
					<i class="fa fa-user-plus"></i> Advertisement
				</a>
			</div>
    </div>
      <!--main content start-->
     <div class="nopadding2 col-md-10 ">
          <div class="mt">
                  <div class="col-md-12 nopadding2">
                  <div class="row">  
                  <div class="col-md-4" style="padding-left:0px;">
                      <div class="content-pael">                      
                      <h2>Advertisement</h2>
                      
                          <table class="table table-striped table-advance table-hover">
                                                                                      
                              <tbody>
                              <tr>
                              		<td>Title</td>
                                    <td class="hidden-phone">${advertisement.title}</td>
                              </tr>
                              <tr>
                                  <td>Image</td>
                              	  <td><img alt="" src="<c:url value="${advertisement.filePath}" />"></td>
                                  
                              </tr>
                              <tr>
                                   <td>Description</td>
                                  	<td class="hidden-phone">${advertisement.description}</td>
                                  
                              </tr>
                              <tr>
                                  <td>Client</td>
                                  <td class="hidden-phone">${advertisement.client}</td>
                                  
                              </tr>
                              <tr>
                                   <td>Registration date</td>
                                  <td class="hidden-phone">${advertisement.registrationDate}</td>
                                  
                              </tr>
                              <tr>
                                   <td>Expiration date</td>
                                  <td class="hidden-phone">${advertisement.expirationDate}</td>
                                  
                              </tr>
                                  </tbody>
                          </table>
                      </div>
                                          
                  </div>
                  <div class="col-md-8">
                  <h2>Add advertisement</h2>
                   <form:form id="advertisement-form" name="advertisement-form" class="form-horizontal" modelAttribute="updateAdvertisementForm" method="POST" enctype="multipart/form-data">
	   <div class="form-group sign-feld-margin-top">
		</div>
		<div class="form-group">
		<div class="col-md-12 height-input-string-personal">
		<form:input id="title" name="title" class="form-control input-md" path="title" placeholder="Title"></form:input>
		<span class="error"><form:errors path="title" /></span>
		</div>
		</div>
		<div class="form-group">
		<div class="col-md-12 height-input-string-personal">
		<form:input id="description" name="description" class="form-control input-md" path="description" placeholder="Description"></form:input>
		<span class="error"><form:errors path="description" /></span>
		</div>
		</div>
		<form:input type="text" class="form-control" id="expirationDate" name="calendar" path="expirationDate" placeholder="Please select a date of expiration"/> 
		<br>
		Advertisement photo: <input type="file" name="advertisementPhoto">
		<span class="error"><form:errors path="advertisementPhoto" /></span>
		<br>
		<form:input id="idAdvertisement" name="idAdvertisement" path="idAdvertisement" value="${advertisement.idAdvertisement}" type="hidden"></form:input>
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

    $( "#expirationDate" ).datepicker({dateFormat:'yy-mm-dd', maxDate: "+3650",changeMonth: true,
		changeYear: true,
		yearRange: "-0:+10"});
    

  });

  </script>
  
<script src="<c:url value="/resources/js/jquery.validate.min.js" />"> </script>
<script src="<c:url value="/resources/js/${validation}.js" />"> </script>
</body>
</html> 