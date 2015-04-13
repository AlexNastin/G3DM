<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<title>Test</title>
</head>
<body>
<h1>
	This is test page
</h1>

	<p class="color">Language :</p>
	<a href="?locale=en">English</a>|
	<a href="?locale=ru">Russian</a>
	<br />
	
	
	<form:form method="POST" action="upload" enctype="multipart/form-data">
  <input type="text" name="description" />  
  <input type="file" name="file" />
  <input type="submit" />
</form:form>
</body>
</html>
