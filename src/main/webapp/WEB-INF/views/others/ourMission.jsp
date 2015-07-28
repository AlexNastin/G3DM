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
<title>our mission</title>
<spring:message code="headerWithSearch.header.search" var="search"/>
</head>
<body>
<%@include file="/WEB-INF/views/header/headerWithSearch.jsp" %>
<div class="container holycontent">
<div class="row">
<div class="font-contact line-contact col-md-12">
Our mission 
</div>
</div>
<div class="col-md-6">
<img src="<c:url value="/resources/images/ourmission.jpeg" />" class="img-responsive img-thumbnail miniature-image" alt="jobs">
</div>
<div class="col-md-6 font-size-ourmission">
<p>  We are ... We are a group of enthusiasts who do not want to be just another consumer of the goods of society, using someone else’s inventions, ideas and work.  We do not agree with the position of dependency and inability to voice complaints that would make changes to better this world.  We want to feel the joy and satisfaction from implementing our own ideas.  We appreciate and love what we do!  We want to reveal the human potential, embody our dreams, surprise!  
<p>  We understand our purpose and it is clear!   
<p>  Be useful to society!   
<p>  Join!
</div>
</div>
<%@include file="/WEB-INF/views/footer.jsp" %>
<script src="<c:url value="/resources/js/jquery.min.js" />"> </script>
<script src="<c:url value="/resources/js/jquery-2.1.1.js" />"> </script>
<script src="<c:url value="/resources/js/jquery.validate.min.js" />"> </script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script> 
</html>