<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/fontawesome430/css/font-awesome.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/about.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/otherpage.css"  />" rel="stylesheet" />
<link rel="icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon">
<spring:message code="jobs.title" var="title" />
<title>${title} | Global3dMod.com</title>
</head>
<body>
<%@include file="/WEB-INF/views/header/header.jsp" %>

<div class="container holycontent">
<div class="row">
<div class="font-jobs line-jobs col-md-12">
Jobs
</div>
</div>
<div class="row">
<div class="col-md-6 img-jobs-margin img-responsive">
<img src="<c:url value="/resources/images/jobs.jpg" />" class="img-responsive img-thumbnail miniature-image" alt="jobs">
</div>


<div class="col-md-6 jobs-background">
<div class="row">
<div class="col-md-5"></div>
<div class="col-md-6 text-jobs-title">Wanted!</div>
</div>
 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at est nisl. 
 Ut dictum magna finibus leo venenatis, sed lacinia arcu bibendum. Nulla facilisi. 
 Donec sed eleifend ipsum. Duis suscipit venenatis purus, hendrerit rhoncus mauris bibendum ac. 
 In dictum metus lorem, vitae iaculis lorem porta ac. Ut eget ullamcorper mi, non accumsan tortor. 
 Morbi mattis arcu sed dui convallis, nec egestas est aliquam. Fusce lacinia pellentesque faucibus. 
 Nam vehicula pharetra sem, ut ultrices justo egestas nec. Quisque ultrices non massa sit amet suscipit. 
 Pellentesque lacus metus, egestas quis augue nec, iaculis gravida mi. Morbi sit amet dolor nunc. 
 Maecenas pulvinar nulla id risus imperdiet elementum nec non lorem. 
 Nullam tincidunt volutpat nisi, a mollis ipsum mattis eget. 
 Aenean pellentesque ex sed ligula condimentum, sed vehicula odio malesuada. 
</div>
</div>
</div>

<%@include file="/WEB-INF/views/footer.jsp" %>
<script src="<c:url value="/resources/js/jquery.min.js" />"> </script>
<script src="<c:url value="/resources/js/jquery-2.1.1.js" />"> </script>
<script src="<c:url value="/resources/js/jquery.validate.min.js" />"> </script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script>
</body>
</html>