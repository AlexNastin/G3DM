<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Designer's page | Global3dmod</title>
<!-- Init search variable -->
<spring:message code="headerWithSearch.header.search" var="search"/>
<spring:message code="addPost.menu.works" var="works"/>
<spring:message code="addPost.menu.data" var="data"/>
<spring:message code="addPost.menu.add" var="add"/>
<spring:message code="javascript.validation" var="validation" />
<spring:message code="designer.menu.personalsecurity" var="personalsecurity" />
<spring:message code="form.title" var="title" />
<spring:message code="form.description" var="description" />
<spring:message code="form.instruction" var="instruction" />
<spring:message code="designer.addwork.enterinformation" var="enterinformation" />
<spring:message code="designer.addwork.selecttechnologies" var="selecttechnologies" />
<spring:message code="designer.addwork.modeltoupload" var="modeltoupload" />
<spring:message code="designer.addwork.photomodeltoupload" var="photomodeltoupload" />
<spring:message code="form.add" var="addbutton" />

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="global3dmod team">
    <meta name="keywords" content="3d printer, 3d model, 3d model free, 3d model download, 3d model download free, model to print 3d printer free, stl, stl download,stl download free, 3d designer, 3d model robot, 3д модель, 3д принтер, 3д модель скачать, 3д модель скачать напечатать, 3д дизайнер, stl бесплатные, stl скачать, global3dmod, global 3d mod, designer "> 
    <meta name="description" content=""> 
    <link href="<c:url value="/resources/css/bootstrap.min.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/cabinets/designer.css"  />" rel="stylesheet" />
     <link href="<c:url value="/resources/css//fontawesome430/css/font-awesome.css"  />" rel="stylesheet" />
    
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    <link rel="icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon">
<c:url value="/get/subcategories" var="getSubcategories" />
<c:url value="/get/categories" var="getCategories" />



<body>
<%@include file="/WEB-INF/views/header/headerWithSearch.jsp" %>
 <!-- Menu -->     
 <div class="row footerpadding">
    <div class="col-md-2 nopadding1">
     <div class="list-group">
      <img src="<c:url value="${user.avatar.avatarPath}" />" class="img-responsive avatar-img img-thumbnail" alt="Global3Dmod avatar">    
  <a href="<c:url value="/designer/profile?sort=date&page=1" />" class="list-group-item">
    <i class="fa fa-briefcase"></i> ${works} 
  </a>
  
  <a href="<c:url value="/designer/personalData" />" class="list-group-item"><i class="fa fa-cogs"></i> ${data}  </a>
  <a href="<c:url value="/designer/secure/personalSecurity" />" class="list-group-item"><i class="fa fa-lock"></i> ${personalsecurity}  </a>
  <a href="<c:url value="/designer/addPost" />" class="list-group-item active"><i class="fa fa-plus-square"></i> ${add}  </a>
  
</div>
      </div>
  <div class="row">
  
		<div class="col-md-10 nopadding2" style="padding-left:9%">
		<h2>${enterinformation}</h2>
				
	<form:form role="form" modelAttribute="postForm" method="POST" id="add-post-form"
		name="add-post-form" enctype="multipart/form-data">
		<div class="row">
		<div class="col-md-7">
		<div class="form-group height-input-string-addpost">
		<form:input class="form-control" id="title" name="title" path="title" placeholder="${title}"></form:input>
		<label class="error" generated="true" for="title" style="font-size:9pt; line-height: 1.2;"></label>
		<span class="error"><form:errors path="title" /></span>
		</div>
		<div class="form-group height-input-string-addpost-description">
		<form:textarea class="form-control" id="description" name="description" path="description"
			placeholder="${description}"  rows="5" cols="30"></form:textarea>
		<label class="error" generated="true" for="description" style="font-size:9pt; line-height: 1.2;"></label>
		<span class="error"><form:errors path="description" /></span>
		</div>
		<div class="form-group height-input-string-addpost-instruction">
		<form:textarea class="form-control" id="instruction" name="instruction" path="instruction"
			placeholder="${instruction}"></form:textarea>
		<label class="error" generated="true" for="instruction" style="font-size:9pt; line-height: 1.2;"></label>
		<span class="error"><form:errors path="instruction" /></span>
		</div>
		<div class="form-group height-input-string-addpost-category">
		<form:select class="form-control" id="disProgram_idDisProgram"
			name="disProgram_idDisProgram" path="disProgram_idDisProgram">
			<c:forEach items="${listDisProgram}" var="disProgram">
				<form:option value="${disProgram.idDisProgram}">${disProgram.title}</form:option>
			</c:forEach>
		</form:select>
			<span class="error"><form:errors path="disProgram_idDisProgram" /></span>
		</div>
		<fieldset>
			<div>
				<div class="form-group height-input-string-addpost-category">
				<form:select class="form-control" id="idCategory" path="category_idCategory">
				</form:select>
					<label class="error" generated="true" for="idCategory" style="font-size:9pt; line-height: 1.2;"></label>
					<span class="error"><form:errors path="category_idCategory" /></span>
				</div>
				<div class="form-group height-input-string-addpost-subcategory">
				<form:select class="form-control" id="idSubcategory" path="subcategory_idSubcategory">
					<form:option value="0">Subcategory</form:option>
				</form:select>
				    <label class="error" generated="true" for="idSubcategory" style="font-size:9pt; line-height: 1.2;"></label>
					<span class="error"><form:errors path="subcategory_idSubcategory" /></span>
				</div>
			</div>
		</fieldset>

		
      </div>
		
		<div class="col-md-4">
		<div class="height-input-string-addpost-technologies">
		<h3 style="margin-top:0px">${selecttechnologies}</h3>
		
		<c:forEach items="${listTechnologies}" var="technology">
			<form:checkbox id="technologiesId"  path="technologiesId" value="${technology.idTechnology}" />${technology.title}<br>
		</c:forEach>
		<span class="error"><form:errors path="technologiesId" /></span>
		<label for="technologiesId" class="error" generated="true" style="font-size:9pt; line-height: 1.2;"></label>
		</div>
		<br>
		<div class="height-input-string-addpost-stl">
		${modeltoupload}<input type="file" name="model" style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis; width: 100%;">
		<label class="error" generated="true" for="model" style="font-size:9pt; line-height: 1.2;"></label>
		<span class="error"><form:errors path="model" /></span>
		</div>
		<br>
		<div class="height-input-string-addpost-img">
        ${photomodeltoupload} <input type="file" name="firstPhoto" style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis; width: 100%;">
		<label class="error" generated="true" for="firstPhoto" style="font-size:9pt; line-height: 1.2;"></label>
		<span class="error"><form:errors path="firstPhoto" /></span>
		</div>
		<br>
		<input class="btn btn-primary" type="submit" value="${addbutton}" />
		</div>
		</div>
	</form:form>
	
	
</div>
</div>
</div>
	<%@include file="/WEB-INF/views/footer.jsp" %>  
    <!-- scripts -->
    <script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"> </script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script> 
    <script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#idCategory')
								.change(
										function() {
											$
													.getJSON(
															'${getSubcategories}',
															{
																idCategory : $(
																		this)
																		.val(),
																ajax : 'true'
															},
															function(data) {
																var html = '<option value="0">Subcategory</option>';
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
<script src="<c:url value="/resources/js/jquery.validate.min.js" />"> </script>
<script src="<c:url value="/resources/js/${validation}.js" />"> </script>
<script>
    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
    (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
    m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
    })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
    ga('create', 'UA-66505156-1', 'auto');
    ga('send', 'pageview');
    </script>
    <!-- Yandex.Metrika counter -->
    <script type="text/javascript">
    (function (d, w, c) {
        (w[c] = w[c] || []).push(function() {
            try {
                w.yaCounter32035491 = new Ya.Metrika({
                    id:32035491,
                    clickmap:true,
                    trackLinks:true,
                    accurateTrackBounce:true
                });
            } catch(e) { }
        });

        var n = d.getElementsByTagName("script")[0],
            s = d.createElement("script"),
            f = function () { n.parentNode.insertBefore(s, n); };
        s.type = "text/javascript";
        s.async = true;
        s.src = "https://mc.yandex.ru/metrika/watch.js";

        if (w.opera == "[object Opera]") {
            d.addEventListener("DOMContentLoaded", f, false);
        } else { f(); }
    })(document, window, "yandex_metrika_callbacks");
    </script>
    <noscript><div><img src="https://mc.yandex.ru/watch/32035491" style="position:absolute; left:-9999px;" alt="" /></div></noscript>
    <!-- /Yandex.Metrika counter -->
</body>
</html>
