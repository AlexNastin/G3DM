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
<meta name="keywords" content="3d printer, 3d model, 3d model free, 3d model download, 3d model download free, model to print 3d printer free, stl, stl download,stl download free, 3d designer, 3d model robot, 3д модель, 3д принтер, 3д модель скачать, 3д модель скачать напечатать, 3д дизайнер, stl бесплатные, stl скачать, global3dmod, global 3d mod "> 

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


<div class="col-md-6 jobs-background " style="text-align:center;" >
<div class="row">
<div class="text-jobs-title" style="text-align:center; margin-bottom: 4%">THERE ARE CURRENTLY NO JOB VACANCIES</div>
</div>
 Please check the website at a later date for any future vacancies.
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