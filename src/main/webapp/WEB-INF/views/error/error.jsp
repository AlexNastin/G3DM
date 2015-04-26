<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Global3Dmod</title>

<link href="<c:url value="/resources/css/bootstrap.css"  />"
	rel="stylesheet" />
<script src="<c:url value="/resources/js/jquery-2.1.1.js" />">
	
</script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Custom Theme files -->
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />

<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!--webfont-->


<link
	href="<c:url value="http://fonts.googleapis.com/css?family=Montserrat:400,700" />"
	rel="stylesheet" />
<script src="<c:url value="/resources/js/jquery.easydropdown.js" />">
	
</script>
<script src="<c:url value="/resources/js/login.js" />">
	
</script>

<!--Animation-->
<script src="js/wow.min.js"></script>
<script src="<c:url value="/resources/js/wow.min.js" />">
	
</script>
<link href="<c:url value="/resources/css/animate.css"  />"
	rel="stylesheet" />

<script>
	new WOW().init();
</script>
</head>
<body>
	<div class="header">
		<div class="col-sm-8 header-left">
			<div class="logo">
				<a href="place for logo"></a>
			</div>
			<div class="menu">
				<a class="toggleMenu" href="#"><img src="images/nav.png" alt="" /></a>
				<ul class="nav" id="nav">
					<li class="active"><a href="index.html">Rules</a></li>
					<li><a href="#">Projects</a></li>
					<li><a href="#">link</a></li>
					<li><a href="#">link</a></li>
					<li><a href="#">link</a></li>
					<div class="clearfix"></div>
				</ul>
				<script type="text/javascript" src="js/responsive-nav.js"></script>
			</div>
			<!-- start search-->

			<!----search-scripts---->
			<script src="js/classie.js"></script>
			<script src="js/uisearch.js"></script>
			<script>
				new UISearch(document.getElementById('sb-search'));
			</script>
			<!----//search-scripts---->
			<div class="clearfix"></div>
		</div>
		<div class="col-sm-4 header_right">
			<span class="menu btn btn-primary">Login</span>

		</div>
		<div class="clearfix"></div>
	</div>
	<div class="clearfix"></div>

	<div class="banner">
		<div class="container_wrap">
			<h1>What are you looking for?</h1>
			<form>
				<input type="text" value="Type your query here"
					onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'Type your query here';}">
				<div class="contact_btn">
					<label class="btn1 btn-2 btn-2g"><input name="submit"
						type="submit" id="submit" value="Search"></label>
				</div>
			</form>
			<div class="clearfix"></div>
		</div>
	</div>
	<c:if test="${not empty errCode}">
		<h1>${errCode}:System Errors</h1>
	</c:if>

	<c:if test="${empty errCode}">
		<h1>System Errors</h1>
	</c:if>

	<c:if test="${not empty errMsg}">
		<h2>${errMsg}</h2>
	</c:if>
	<div class="footer">
		<div class="container">

			<div class="footer_grids">
				<div class="footer-grid">
					<h4>Ipsum Quis</h4>
					<ul class="list1">
						<li><a href="contact.html">Contact</a></li>
						<li><a href="#">Mirum est</a></li>
						<li><a href="#">placerat facer</a></li>
						<li><a href="#">claritatem</a></li>
						<li><a href="#">sollemnes </a></li>
					</ul>
				</div>
				<div class="footer-grid">
					<h4>Quis Ipsum</h4>
					<ul class="list1">
						<li><a href="#">placerat facer</a></li>
						<li><a href="#">claritatem</a></li>
						<li><a href="#">sollemnes </a></li>
						<li><a href="#">Claritas</a></li>
						<li><a href="#">Mirum est</a></li>
					</ul>
				</div>
				<div class="footer-grid last_grid">
					<h4>Follow Us</h4>
					<ul class="footer_social wow fadeInLeft" data-wow-delay="0.4s">
						<li><a href=""> <i class="fb"> </i>
						</a></li>
						<li><a href=""><i class="tw"> </i> </a></li>
						<li><a href=""><i class="google"> </i> </a></li>
						<li><a href=""><i class="u_tube"> </i> </a></li>
					</ul>

				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</body>
</html>