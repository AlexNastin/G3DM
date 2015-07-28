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
<title>Sign up for designers | Global3dMod</title>
<spring:message code="headerWithSearch.header.search" var="search"/>
</head>
<body>
<%@include file="/WEB-INF/views/header/headerWithSearch.jsp" %>
<div class="container holycontent">
<div class="row">
<div class="font-contact line-contact col-md-12">
<i class="fa fa-sign-in"></i> Sign up for designers  
</div>
</div>
<div class="col-md-12 background-howitworks">
<div class="font-family-howitworks">
<p><i class="fa fa-circle"></i> Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
Quisque bibendum risus vitae metus pellentesque, a ultrices eros interdum. 
Interdum et malesuada fames ac ante ipsum primis in faucibus.
<p><i class="fa fa-circle"></i> Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
Quisque bibendum risus vitae metus pellentesque, a ultrices eros interdum. 
Interdum et malesuada fames ac ante ipsum primis in faucibus.
<p><i class="fa fa-circle"></i> Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
Quisque bibendum risus vitae metus pellentesque, a ultrices eros interdum. 
Interdum et malesuada fames ac ante ipsum primis in faucibus.
<p><i class="fa fa-circle"></i> Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
Quisque bibendum risus vitae metus pellentesque, a ultrices eros interdum. 
Interdum et malesuada fames ac ante ipsum primis in faucibus.
<p><i class="fa fa-circle"></i> Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
Quisque bibendum risus vitae metus pellentesque, a ultrices eros interdum. 
Interdum et malesuada fames ac ante ipsum primis in faucibus.
<p><i class="fa fa-circle"></i> Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
Quisque bibendum risus vitae metus pellentesque, a ultrices eros interdum. 
Interdum et malesuada fames ac ante ipsum primis in faucibus.
<p><i class="fa fa-circle"></i> Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
Quisque bibendum risus vitae metus pellentesque, a ultrices eros interdum. 
Interdum et malesuada fames ac ante ipsum primis in faucibus.
</div>
</div>
</div>
<%@include file="/WEB-INF/views/footer.jsp" %>
<script src="<c:url value="/resources/js/jquery.min.js" />"> </script>
<script src="<c:url value="/resources/js/jquery-2.1.1.js" />"> </script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script>
</body>
</html>