<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Service error | Global3DMod</title>
<!-- Init search variable -->

 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="global3dmod team">
   
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/404.css"  />" rel="stylesheet" />
     <link href="<c:url value="/resources/css/fontawesome430/css/font-awesome.min.css"  />" rel="stylesheet" />
     <link rel="icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon">
     

<spring:message code="403page.error.home" var="home" />
<spring:message code="403page.error.contactss" var="contactss" />

<body>
<%@include file="/WEB-INF/views/header/header.jsp" %>   
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template" style="min-height:45em;">
                <h1><i class="fa fa-exclamation-triangle"></i> Service error <i class="fa fa-exclamation-triangle"></i></h1>
                <h2>Sorry, but your actions caused a service error</h2>
                <div class="error-details">
                    ${sorry2}
                </div>
                <div class="error-actions">
                    <a href="<c:url value="/index"/>" class="btn btn-primary btn-lg"><span class="fa fa-home"></span>
                        ${home} </a><a href="<c:url value="/index"/>" class="btn btn-default btn-lg"><span class="fa fa-envelope-o"></span> ${contactss} </a>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/footer.jsp" %>  
    <script src="<c:url value="/resources/js/jquery-1.7.min.js" />"> </script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script> 
    
</body>
</html>