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
<link href="<c:url value="/resources/css/otherpage.css"  />" rel="stylesheet" />
<link rel="icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>Contact us | Global3dMod.com</title>
</head>
<body>
<%@include file="/WEB-INF/views/header/header.jsp" %>
<div class="container holycontent">
<div class="row">
<div class="font-contact line-contact col-md-8">
Contact
</div>
</div>
<div class="row">
<div class="col-md-4 contact-background contact-vertical-line">
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-8 text-contact-title"> 
How to contact us?
</div>
<div class="col-md-2"></div>
</div>
We are happy to answer any questions you may have about our website. We will deal with any comments or questions you may have about our organisation and services. For more information or if you have a query about a Global3Dmod please email <a href="mailto:info@global3dmod.com">info@global3dmod.com</a> 
<p>For more information on advertising opportunities with Global3Dmod please contact the relevant department below: <a href="mailto:advertising@global3dmod.com">advertising@global3dmod.com</a></p>
</div>

<div class="col-md-4 contact-background">
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-8 text-contact-title"> 
Follow us in social networks
</div>
<div class="col-md-2 "></div>
</div>
<ul class="list-group">
 				<li class="list-group-item"><a class="fa fa-facebook-official fa-2x"> Facebook</a></li>
                <li class="list-group-item"><a class="fa fa-twitter fa-2x"> Twitter</a></li>
                <li class="list-group-item"><a class="fa fa-vk fa-2x"> VK</a></li>
                <li class="list-group-item"><a class="fa fa-instagram fa-2x"> Instagram</a>   </li>
 </ul>
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