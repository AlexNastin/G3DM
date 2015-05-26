<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Post Form</title>
</head>
<script src="<c:url value="/resources/js/jquery-2.1.1.js" />">
	
</script>
<script src="<c:url value="/resources/js/jquery.validate.min.js" />">
	
</script>
<script src="<c:url value="/resources/js/validation.js" />">
	
</script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />">
	
</script>
<body>
	<c:forEach items="${listPostsByDesigner}" var="post" >
	<span>${post.title}</span><br>
	<span>${post.isDisplay}</span><br>
	<span>${post.category.title}</span><br>
	<span>${post.file.filePath}</span><br>
		<c:forEach items="${post.postPhotos}" var="postPhoto" >
		<span>${postPhoto.photoPath}</span><br>
		</c:forEach>
		<c:forEach items="${post.printers}" var="printer" >
		<span>${printer.title}</span><br>
		</c:forEach>
	<span>=========================</span><br>
	</c:forEach>
	
	<a href="<c:url value="/designer/addPost"/>">Add post</a>
		<a href="<c:url value="/model"/>">model</a>
			<a href="<c:url value="/result?page=1"/>">result</a>
</body>
</html>