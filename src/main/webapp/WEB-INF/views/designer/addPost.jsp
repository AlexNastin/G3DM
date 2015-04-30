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
<body>
<form:form modelAttribute="postForm" method="POST" id="add-post-form" name="add-post-form" enctype="multipart/form-data">
	<form:input id="title" name="title" path="title" placeholder="title"></form:input>
	<form:input id="description" name="description" path="description" placeholder="description"></form:input>
	<form:input id="instruction" name="instruction" path="instruction" placeholder="instruction"></form:input>
	<form:select id="disProgram_idDisProgram" name="disProgram_idDisProgram" path="disProgram_idDisProgram">
		<c:forEach items="${listDisProgram}" var="disProgram" >
		<form:option value="${disProgram.idDisProgram}">${disProgram.title}</form:option>
		</c:forEach>
	</form:select>
	<form:select id="category_idCategory" name="category_idCategory" path="category_idCategory">
		<c:forEach items="${listCategory}" var="category" >
		<form:option value="${category.idCategory}">${category.title}</form:option>
		</c:forEach>
	</form:select>
	<form:select id="subcategory_idSubcategory" name="subcategory_idSubcategory" path="subcategory_idSubcategory">
		<c:forEach items="${listCategory}" var="category" >
			<c:forEach items="${category.subcategories}" var="subcategory">
					<form:option value="${subcategory.idSubcategory}">${subcategory.title}</form:option>
			</c:forEach>
		</c:forEach>
	</form:select>
	<br>
	<c:forEach items="${listPrinter}" var="printer" >
		<form:checkbox path="printersId" value="${printer.idPrinter}" />${printer.title}<br>
	</c:forEach>
	<br>
        File to upload: <input type="file" name="file">
	<input type="submit" value="Add" />
</form:form>
</body>
</html>