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
<c:url value="/get/subcategories" var="getSubcategories" />
<c:url value="/get/categories" var="getCategories" />


<script type="text/javascript">
	$(document)
		.ready(
			function() {$('#idCategory').change(
										function() {$.getJSON('${getSubcategories}',
															{
																stateName : $(this).val(),
																ajax : 'true'
															},
															function(data) {
																var html = '<option value="">Subcategory</option>';
																var len = data.length;
																for (var i = 0; i < len; i++) {
																	html += '<option value="' + data[i].idSubcategory + '">'
																			+ data[i].title
																			+ '</option>';
																}
																html += '</option>';
																$(
																		'#idSubcategory')
																		.html(
																				html);
															});
										});
					});
</script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$.getJSON('${getCategories}', {
					ajax : 'true'
				}, function(data) {
					var html = '<option value="">Category</option>';
					var len = data.length;
					for (var i = 0; i < len; i++) {
						html += '<option value="' + data[i].idCategory + '">'
								+ data[i].title + '</option>';
					}
					html += '</option>';
					$('#idCategory').html(html);
				});
			});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#idSubcategory").change(onSelectChange);
	});
	function onSelectChange() {
		var selected = $("#idSubcategory option:selected");
		var output = "";
		if (selected.val() != 0) {
			output = "You selected City " + selected.text();
		}
		$("#output").html(output);
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

		<fieldset>
			<div>

				<form:select id="idCategory" path="category_idCategory">
				</form:select>

				<form:select id="idSubcategory" path="subcategory_idSubcategory">
					<form:option value="0">Subcategory</form:option>
				</form:select>

			</div>
		</fieldset>

		<div id="output"></div>

		<br>
		<c:forEach items="${listPrinter}" var="printer">
			<form:checkbox path="printersId" value="${printer.idPrinter}" />${printer.title}<br>
		</c:forEach>
		<span class="error"><form:errors path="printersId" /></span>
		<br>
        Model to upload: <input type="file" name="model">
		<span class="error"><form:errors path="model" /></span>
		<br>
        Photo model to upload: <input type="file" name="firstPhoto">
		<span class="error"><form:errors path="firstPhoto" /></span>
		<br>
        Photo model to upload: <input type="file" name="secondPhoto">
		<span class="error"><form:errors path="secondPhoto" /></span>
		<br>
        Photo model to upload: <input type="file" name="thirdPhoto">
		<span class="error"><form:errors path="thirdPhoto" /></span>
		<br>
		<input type="submit" value="Add" />
	</form:form>
</body>
</html>