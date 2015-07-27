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
	<div class="container modelmain">
		<div class="row">
			<div class="col-md-4">
				<h3>${post.title}</h3>
				<a href="#" data-toggle="modal" data-target="#lightbox"><img
					src="<c:url value="/resources/images/logosign.jpg" />"
					class="img-responsive margination" alt="Responsive image"> </a>
				<div>
					<button class="btn btn-primary fa fa-download"> ${down}</button>
					<security:authorize
						access="hasAnyRole('ROLE_DESIGNER','ROLE_USER', 'ROLE_MODERATOR', 'ROLE_ADMIN')">
						<a href="<c:url value="/like?id=${post.idPost}" />"> <i
							class="btn btn-success fa fa-thumbs-o-up"> ${like} <span
								class="badge">${countLike} </span></i>
						</a>
												<button type="button" class="btn btn-danger fa fa-exclamation-circle" data-toggle="modal" data-target="#myModal"> ${issue}</button>
					</security:authorize>
					<security:authorize access="isAnonymous()">
						<a href="<c:url value="/go/signin" />"> <i
							class="btn btn-success fa fa-thumbs-o-up"> ${like} <span
								class="badge">${countLike} </span></i>
						</a>
						<a href="<c:url value="/go/signin" />"
						class="btn btn-danger fa fa-exclamation-circle" > ${issue}
						</a>
					</security:authorize>

					
				</div>

			</div>
			
			
			
			<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog modal-sm">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Confirm</h4>
      </div>
      <div class="modal-body">
        <p>Are you really wanna to complain this post?</p>
      </div>
      <div class="modal-footer">
      <a href="<c:url value="/complain?id=${post.idPost}" />"
						class="btn btn-danger"> ${issue}
						</a>
        <button type="button" class="btn btn-info" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div> 
			<div class="col-md-8">
				<h3>${info}</h3>

				<div class="tabbable-panel">
					<div class="tabbable-line">
						<ul class="nav nav-tabs ">
							<li class="active"><a href="#tab_default_1"
								data-toggle="tab"> ${info} </a></li>
							<li><a href="#tab_default_2" data-toggle="tab">
									${instruct} </a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="tab_default_1">
								<p>
									<i class="fa fa-user"></i> ${author}: <a
										href="<c:url value="/guest/designerProfile?id=${post.user.idUser }"  />">${post.user.nickName}</a>
								</p>
								<p>
									<i class="fa fa-cubes"></i> ${category}: <a
										href="<c:url value="/result?idCategory=${post.category.idCategory}" />">${post.category.title}</a>
								</p>
								<p>
									<i class="fa fa-slack"></i> ${id}: ${post.numberPost}
								</p>
								<p>
									<i class="fa fa-file"></i> ${soft}: ${post.disProgram.title}
								</p>
								<p>
									<i class="fa fa-align-justify"></i> ${desc}:
									${post.description}
								</p>
							</div>
							<div class="tab-pane" id="tab_default_2">
								<p>${post.instruction}</p>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	

	<div id="lightbox" class="modal fade" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<button type="button" class="close hidden" data-dismiss="modal"
				aria-hidden="true">×</button>
			<div class="modal-content">
				<div class="modal-body">
					<img src="" alt="" />
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<h3>
						<small class="pull-right">${sizeComments} comments</small>
						Comments
					</h3>
				</div>
				<div class="comments-list">
					<c:forEach items="${listCommentsLimit10}" var="comment">
						<div style="padding-bottom: 1em;" class="media">
							<p class="pull-right">
								<small> ${comment.dateTime }</small>
							</p>
							<a class="media-left" href="#"> <img
								style="float: left; margin-right: 1em; width: 6em;"
								src="<c:url value="${comment.user.avatar.avatarPath }"/>">
							</a>
							<div class="media-body">

								<h4 class="media-heading user_name">${comment.user.nickName }</h4>
								${comment.text }

								
							</div>
						</div>
					</c:forEach>
					<security:authorize access="isAnonymous()">
						<p>
							<a href="<c:url value="/go/signin"/>">Войдите</a> или <a
								href="<c:url value="/signup"/>">зарегистрируйтесь</a> для
							отправления комментариев
						</p>
					</security:authorize>
					<security:authorize
						access="hasAnyRole('ROLE_DESIGNER','ROLE_USER', 'ROLE_MODERATOR', 'ROLE_ADMIN')">
						<form:form id="comment-form" name="comment-form"
							class="form-horizontal" modelAttribute="commentForm"
							method="POST">
							<div class="form-group sign-feld-margin-top"></div>
							<div class="form-group">
								<div class="col-md-6">
									<div class="height-input-comments">
										<form:textarea id="text" name="text" style="resize:none"
											class="form-control input-md" path="text"
											placeholder="Type your comment here" rows="5" cols="30"></form:textarea>
									</div>
									<form:input type="hidden" id="idPost" name="idPost"
										path="idPost" value="${post.idPost }"></form:input>
									<span class="error"><form:errors path="text" /></span> <br>
									<input type="submit" class="btn btn-primary" value="Write" />
								</div>
							</div>
						</form:form>
					</security:authorize>

					<c:if test="${sizeComments != 0}">
						<nav style="text-align: center">
							<ul class="pagination">
								<c:if test="${thisPage>1}">
									<li><a
										href="<c:url value="/model?page=${thisPage-1}&id=${post.idPost}" />"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a></li>
								</c:if>
								<c:forEach begin="${startPage}" end="${endPage}" var="page">

									<li <c:if test="${page==thisPage}">class="active"</c:if>><a
										href="<c:url value="/model?page=${page}&id=${post.idPost}" />">${page}</a></li>
								</c:forEach>

								<c:if test="${thisPage!=maxPage}">
									<li><a
										href="<c:url value="/model?page=${thisPage+1}&id=${post.idPost}" />"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
									</a></li>
								</c:if>
							</ul>
						</nav>
					</c:if>
				</div>



			</div>
		</div>
	</div>
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