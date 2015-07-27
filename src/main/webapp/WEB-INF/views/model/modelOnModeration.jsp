<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Global3Dmod | Model</title>

<spring:message code="main.search.search" var="search" />
<spring:message code="model.info.tab1" var="info" />
<spring:message code="model.info.tab2" var="instruct" />
<spring:message code="model.info.author" var="author" />
<spring:message code="model.info.category" var="category" />
<spring:message code="model.info.idpost" var="id" />
<spring:message code="model.info.soft" var="soft" />
<spring:message code="model.info.desrciption" var="desc" />
<spring:message code="model.body.photo" var="photo" />
<spring:message code="model.body.comments" var="comms" />
<spring:message code="model.body.comcol" var="colcom" />
<spring:message code="model.body.download" var="down" />
<spring:message code="model.body.rating" var="like" />
<spring:message code="model.body.issue" var="issue" />
<spring:message code="javascript.validation" var="validation" />

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="global3dmod team">

<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/model.css"  />"
	rel="stylesheet" />
<link
	href="<c:url value="/resources/css/fontawesome430/css/font-awesome.min.css"  />"
	rel="stylesheet" />


<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
<link rel="icon" href="<c:url value="/resources/images/favicon.png" />"
	type="image/x-icon">



</head>
<body>
	<%@include file="/WEB-INF/views/header/headerWithSearch.jsp"%>
	Модель на модерации
	<!-- Modal -->

	<%@include file="/WEB-INF/views/footer.jsp"%>
	<script src="<c:url value="/resources/js/jquery.min.js" />">
	</script>
	
	<script src="<c:url value="/resources/js/jquery.validate.min.js" />">
		
	</script>
	<script src="<c:url value="/resources/js/${validation}.js" />">
		
	</script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />">
		
	</script>
	<script src="<c:url value="/resources/js/model.js" />">
		
	</script>

</body>
</html>