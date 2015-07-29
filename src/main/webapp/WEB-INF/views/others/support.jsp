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
<link href="<c:url value="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/fontawesome430/css/font-awesome.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/otherpage.css"  />" rel="stylesheet" />
<link rel="icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon">
<title>24/7 Support | Global3dMod</title>
<spring:message code="headerWithSearch.header.search" var="search"/>
</head>
<body>
<%@include file="/WEB-INF/views/header/headerWithSearch.jsp" %>
<div class="container holycontent">
<div class="row">
<div class="font-contact line-contact col-md-12">
<i class="fa fa-life-ring"></i> 24/7 Support  
</div>
</div>
<form id="support" name="support">
<div class="row margin-top-support">
<div class=col-md-6>
<img src="<c:url value="/resources/images/support.jpg" />" class="img-responsive img-thumbnail miniature-image" alt="jobs">
</div>
<div class="col-md-6 background-color-support ">
<div class="form-group">
    <div class="col-md-12 margin-bottom-input-support margin-top-support-input">
       <input type="text" class="form-control" id="email_support" name="email_support"  placeholder="E-mail" style="font-family:Arial, FontAwesome">
      </div>
     </div>
<div class="form-group">
<div class="col-md-12">
<textarea name="support_text" class="form-control" placeholder="Please enter your message" cols="40" rows="9"></textarea>
</div>
</div>
<div class="right-support">
<input class="btn btn-primary" type="submit" value="Submit" />
</div>
</div>

</div>
</form>
</div>
<%@include file="/WEB-INF/views/footer.jsp" %>
<script src="<c:url value="/resources/js/jquery.min.js" />"> </script>
<script src="<c:url value="/resources/js/jquery-2.1.1.js" />"> </script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script>
</body>
</html>