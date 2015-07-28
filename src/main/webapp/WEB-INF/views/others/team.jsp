<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/fontawesome430/css/font-awesome.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/otherpage.css"  />" rel="stylesheet" />
<link rel="icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon">
<spring:message code="aboutus.title" var="title" />
<title>Insert title here</title>
<spring:message code="headerWithSearch.header.search" var="search"/>
</head>
<body>
<%@include file="/WEB-INF/views/header/headerWithSearch.jsp" %>
<div class="container holycontent">
<div class="row">
<div class="font-contact line-contact col-md-12 margin-bottom-team">
Team
</div>
</div>
<div class="col-md-3">
<img src="<c:url value="/resources/images/team1.jpg" />" class="img-responsive img-thumbnail img-circle" alt="jobs">
<div class="font-family-team">
Robert De Niro
</div>
<div class="font-family-team-small">
Lead Designer
</div>
<div class="fafa-icon-team">
<i class="fa fa-vk fa-2x"></i> <i class="fa fa-facebook-official fa-2x"></i> <i class="fa fa-twitter fa-2x"></i>
</div>
</div>
<div class="col-md-3">
<img src="<c:url value="/resources/images/team1.jpg" />" class="img-responsive img-thumbnail img-circle" alt="jobs">
<div class="font-family-team">
Robert De Niro
</div>
<div class="font-family-team-small">
Lead Designer
</div>
<div class="fafa-icon-team">
<i class="fa fa-vk fa-2x"></i> <i class="fa fa-facebook-official fa-2x"></i> <i class="fa fa-twitter fa-2x"></i>
</div>
</div>
<div class="col-md-3">
<img src="<c:url value="/resources/images/team1.jpg" />" class="img-responsive img-thumbnail img-circle" alt="jobs">
<div class="font-family-team">
Robert De Niro
</div>
<div class="font-family-team-small">
Lead Designer
</div>
<div class="fafa-icon-team">
<i class="fa fa-vk fa-2x"></i> <i class="fa fa-facebook-official fa-2x"></i> <i class="fa fa-twitter fa-2x"></i>
</div>
</div>
<div class="col-md-3">
<img src="<c:url value="/resources/images/team1.jpg" />" class="img-responsive img-thumbnail img-circle" alt="jobs">
<div class="font-family-team">
Robert De Niro
</div>
<div class="font-family-team-small">
Lead Designer
</div>
<div class="fafa-icon-team">
<i class="fa fa-vk fa-2x"></i> <i class="fa fa-facebook-official fa-2x"></i> <i class="fa fa-twitter fa-2x"></i>
</div>
</div>
<div class="col-md-2"></div>
<div class="col-md-8 background-color-team">
Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aut eaque, laboriosam veritatis, quos non quis ad perspiciatis, totam corporis ea, alias ut unde.
</div>
<div class="col-md-2"></div>
</div>
<%@include file="/WEB-INF/views/footer.jsp" %>
<script src="<c:url value="/resources/js/jquery.min.js" />"> </script>
<script src="<c:url value="/resources/js/jquery-2.1.1.js" />"> </script>
<script src="<c:url value="/resources/js/jquery.validate.min.js" />"> </script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script> 
</body>
</html>