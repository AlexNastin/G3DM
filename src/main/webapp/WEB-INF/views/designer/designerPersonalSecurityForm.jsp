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
     <div class="nopadding2 col-md-10 ">
          <div class="mt">
                  <div class="col-md-12 nopadding2">
                  <div class="row">
                  
                  <div class="col-md-8">
                  <h2>Update password</h2>
                   <form:form id="contact-form" name="contact-form" class="form-horizontal" modelAttribute="personalSecurityForm" method="POST">
	   <div class="form-group sign-feld-margin-top">
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
		
		<br>
		
		<div class="form-group">
		<div class="col-md-5">
		<input type="submit" class="btn btn-primary" value="Save" />
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


  <script src="//code.jquery.com/jquery-1.10.2.js"></script>

  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

  
  <script>

 
  $(function() {

    $( "#dateBirth" ).datepicker({dateFormat:'yy-mm-dd', maxDate: "+0",changeMonth: true,
		changeYear: true,
		yearRange: "-100:+0"});
    

  });

  </script>


</body>
</html> 
