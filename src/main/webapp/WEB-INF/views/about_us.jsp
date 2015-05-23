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
<link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/sign.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/about.css"  />" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/views/header/header.jsp" %> 
<div class="container holycontent">
<div class="col-md-10 image-about"></div>
<div class="col-md-12 line-about font-about">
Who are we?
</div>
<div class="col-md-12 about-footer-margin ">
Morbi varius mauris id neque ornare, et pretium ex pellentesque. 
Fusce volutpat, quam laoreet ultrices tincidunt, tellus elit sodales risus, vitae blandit orci neque at est. 
Integer ultrices, odio nec placerat laoreet, lectus arcu laoreet purus, eget gravida metus nibh id augue. 
Nulla convallis condimentum eros. Phasellus rhoncus ante nec tellus scelerisque, ac pulvinar lectus tincidunt.
Curabitur sit amet magna gravida, ullamcorper nisi vitae, efficitur dolor. Cras quis tempus mi. 
</div>
</div>
<%@include file="/WEB-INF/views/footer.jsp" %>
<script src="<c:url value="/resources/js/jquery.min.js" />"> </script>
<script src="<c:url value="/resources/js/jquery-2.1.1.js" />"> </script>
<script src="<c:url value="/resources/js/jquery.validate.min.js" />"> </script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script>

</body>
</html>