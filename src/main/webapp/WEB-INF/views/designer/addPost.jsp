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
<spring:url value="/get/subCategories" var="subCategoriesUrl" />
<script type="text/javascript">
	function updateSelectOptions(lookupUrl, parentSelectElementId,
			childSelectElementId) {
		var parentSelectRef = $('#' + parentSelectElementId);
		var childSelectRef = $('#' + childSelectElementId);
		var el = document.getElementById('names');
		alert(parentSelectRef)
		alert(childSelectRef)
		$.getJSON(lookupUrl, {
			searchId : 1
		}, function(data) {
			alert(data)
			var html = '<option value=""></option>';
			var len = data.length;
			for (var i = 0; i < len; i++) {
				alert(data[i].idSubcategory)
				html += '<option value="' + data[i].idSubcategory + '">'
						+ data[i].title + '</option>';
				alert(data[i].title)
			}
			alert(1123)
			childSelectRef.html(html);
			alert(2)
		});
	}
</script>
<body>


	<form:form modelAttribute="postForm" method="POST" id="add-post-form"
		name="add-post-form" enctype="multipart/form-data">
		<form:input id="title" name="title" path="title" placeholder="title"></form:input>
		<span class="error"><form:errors path="title" /></span>
		<form:input id="description" name="description" path="description"
			placeholder="description"></form:input>
			<span class="error"><form:errors path="description" /></span>
		<form:input id="instruction" name="instruction" path="instruction"
			placeholder="instruction"></form:input>
			<span class="error"><form:errors path="instruction" /></span>
		<form:select id="disProgram_idDisProgram"
			name="disProgram_idDisProgram" path="disProgram_idDisProgram">
			<c:forEach items="${listDisProgram}" var="disProgram">
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
		<c:forEach items="${listPrinter}" var="printer">
			<form:checkbox path="printersId" value="${printer.idPrinter}" />${printer.title}<br>
		</c:forEach>
		<span class="error"><form:errors path="printersId" /></span>
		<br>
        Model to upload: <input type="file" name="model">
        <span class="error"><form:errors path="model" /></span>
        <br>
        Photo model to upload: <input type="file" name="firstPhotoModel">
        <span class="error"><form:errors path="firstPhoto" /></span>
        <br>
        Photo model to upload: <input type="file" name="secondPhotoModel">
        <span class="error"><form:errors path="secondPhoto" /></span>
        <br>
        Photo model to upload: <input type="file" name="thirdPhotoModel">
        <span class="error"><form:errors path="thirdPhoto" /></span>
        <br>
		<input type="submit" value="Add" />
	</form:form>
</body>
</html>