<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Admin's page | Global3dmod</title>
<!-- Init search variable -->
<spring:message code="headerWithSearch.header.search" var="search" />
<spring:message code="moderator.menu.postsunpublished" var="unpblsd" />
<spring:message code="moderator.menu.postspublished" var="publics" />
<spring:message code="moderator.menu.users" var="users" />
<spring:message code="moderator.menu.designer" var="designers" />
<spring:message code="admin.menu.moderators" var="moderators" />
<spring:message code="admin.menu.designers" var="designers" />
<spring:message code="admin.menu.users" var="users" />
<spring:message code="admin.menu.advertisement" var="advertisement" />
<spring:message code="admin.advertisement.addadvertisement" var="addadvertisement" />
<spring:message code="form.title" var="title" />
<spring:message code="form.miniature" var="miniature" />
<spring:message code="form.description" var="description" />
<spring:message code="form.client" var="client" />
<spring:message code="admin.menu.moderators.dateregister" var="dateregister" />
<spring:message code="form.expirationdate" var="expirationdate" />
<spring:message code="form.edit" var="edit" />
<spring:message code="admin.advertisement.confirm" var="confirm" />
<spring:message code="admin.advertisement.deletemessage" var="deletemessage" />
<spring:message code="form.close" var="close" />
<spring:message code="admin.advertisement.deletebutton" var="deletebutton" />
<spring:message code="admin.advertisement.editmessage" var="editmessage" />
<spring:message code="admin.advertisement.editbutton" var="editbutton" />
<meta name="keywords" content="3d printer, 3d model, 3d model free, 3d model download, 3d model download free, model to print 3d printer free, stl, stl download,stl download free, 3d designer, 3d model robot, 3д модель, 3д принтер, 3д модель скачать, 3д модель скачать напечатать, 3д дизайнер, stl бесплатные, stl скачать, global3dmod, global 3d mod, admin"> 
<meta name="description" content=""> 

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="global3dmod team">
<link href="<c:url value="/resources/css/bootstrap.min.css"  />"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/cabinets/designer.css"  />"
	rel="stylesheet" />
<link
	href="<c:url value="/resources/css/fontawesome430/css/font-awesome.css"  />"
	rel="stylesheet" />

<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
<link rel="icon" href="<c:url value="/resources/images/favicon.png" />"
	type="image/x-icon">
</head>
<body>
	<!-- Here some place for ads. After placing ads you may delete "placeforads" css class in header -->

	<%@include file="/WEB-INF/views/header/headerWithSearch.jsp"%>
	<!-- Designer's page will start here -->

	<!--sidebar start-->

	<!-- Menu -->
	<div class="row footerpadding">
		<div class="col-md-2 nopadding1">
			<div class="list-group">
				<img src="<c:url value="${user.avatar.avatarPath}" />"
					class="img-responsive img-thumbnail" alt="Global3Dmod avatar">
				<a href="<c:url value="/admin/profile" />"
					class="list-group-item"> <i
					class="fa fa-exclamation-triangle"></i> ${moderators}
				</a> <a href="<c:url value="/admin/designers" />"
					class="list-group-item"> <i class="fa fa-ban"></i> ${designers}
				</a> <a href="<c:url value="/admin/users" />" class="list-group-item">
					<i class="fa fa-user-plus"></i> ${users}
				</a> <a href="<c:url value="/admin/advertisements" />" class="list-group-item active">
					<i class="fa fa-user-plus"></i> ${advertisement}
				</a>
			</div>
		</div>
		<!--main content start-->

		<div class="nopadding2 col-md-10 ">
			<div class="mt">
				<div class="col-md-12 nopadding2">
					<div class="content-panel">
						<table class="table table-striped table-advance table-hover">
						<div class="row">			
						<h2>
						<div class="col-md-12">
						${advertisement}
						
						
						<a href="<c:url value="/admin/addAdvertisement.html" />" class="btn btn-success admin-addModerator-float"> <i class="fa fa-user-plus"></i>
						${addadvertisement}
						</a>
						</div>
						</h2>
                        </div>
							<!-- Some sorts for table -->

							<thead>
								<c:if test="${sizeAdvertisements != 0}">
									<nav style="text-align: center">
										<ul class="pagination">
											<c:if test="${thisPage>1}">
												<li><a
													href="<c:url value="/admin/advertisements?sort=${sortType}&page=${thisPage-1}&desc=${descPage}" />"
													aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
												</a></li>
											</c:if>
											<c:forEach begin="${startPage}" end="${endPage}" var="page">

												<li <c:if test="${page==thisPage}">class="active"</c:if>><a
													href="<c:url value="/admin/advertisements?sort=${sortType}&page=${page}&desc=${descPage}" />">${page}</a></li>
											</c:forEach>

											<c:if test="${thisPage!=maxPage}">
												<li><a
													href="<c:url value="/admin/advertisements?sort=${sortType}&page=${thisPage+1}&desc=${descPage}" />"
													aria-label="Next"> <span aria-hidden="true">&raquo;</span>
												</a></li>
											</c:if>
										</ul>
									</nav>
								</c:if>

								<tr class="background-user-string">
									<th><i class="fa fa-bullhorn"></i><a
										href="<c:url value="/admin/advertisements?sort=title&desc=${titleDesc}" />">
											${title}</a></th>
									<th class="hidden-phone"><i class="fa fa-question-circle"></i> ${miniature}</th>
									<th>${description}</th>
									<th><i class="fa fa-calendar"></i><a
										href="<c:url value="/admin/advertisements?sort=client&desc=${clientDesc}" />">
											${client}</a></th>
									<th><i class="fa fa-th-list"></i><a
										href="<c:url value="/admin/advertisements?sort=dateRegistration&desc=${dateRegistrationDesc}" />">
											${dateregister}</a></th>
									<th><i class="fa fa-list-alt"></i> <a
										href="<c:url value="/admin/advertisements?sort=dateExpiration&desc=${dateExpirationDesc}" />">
											${expirationdate}</a></th>
											<th><i class="fa fa-pencil"></i> ${edit}</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listAdvertisementsLimit10}" var="advertisement">
									<tr>
										<td>${advertisement.title}</td>
										<td><img alt="" src="<c:url value="${advertisement.filePath}" />"></td>
										<td>${advertisement.description}</td>
										<td>${advertisement.client}</td>
										<td>${advertisement.registrationDate}</td>
										<td>${advertisement.expirationDate}</td>
										<td>
                                      <button class="btn btn-primary btn-xs" data-toggle="modal" data-target="#edit${advertisement.idAdvertisement}"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-xs" data-toggle="modal" data-target="#myModal${advertisement.idAdvertisement}"><i class="fa fa-trash-o "></i></button>
                                  </td>
									</tr>
									<!-- Delete modal -->                
   <div class="modal fade" id="myModal${advertisement.idAdvertisement}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">${confirm}</h4>
      </div>
      <div class="modal-body">
        ${deletemessage}
      </div>
      <div class="modal-footer">
        <a type="button" class="btn btn-default" data-dismiss="modal">${close}</a>
        <a href="<c:url value="/admin/deleteAdvertisement.html?id=${advertisement.idAdvertisement}" />" type="button" class="btn btn-danger">${deletebutton}</a>
      </div>
    </div>
  </div>
</div>
<!-- Edit modal -->
<div class="modal fade" id="edit${advertisement.idAdvertisement}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">${confirm}</h4>
      </div>
      <div class="modal-body">
        ${editmessage}
      </div>
      <div class="modal-footer">
        <a type="button" class="btn btn-default" data-dismiss="modal">${close}</a>
        <a href="<c:url value="/admin/updateAdvertisement.html?id=${advertisement.idAdvertisement}" />" type="button" class="btn btn-primary">${editbutton}</a>
      </div>
    </div>
  </div>
</div>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<c:if test="${sizeAdvertisements != 0}">
						<nav style="text-align: center">
							<ul class="pagination">
								<c:if test="${thisPage>1}">
									<li><a
										href="<c:url value="/admin/advertisements?sort=${sortType}&page=${thisPage-1}&desc=${descPage}" />"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a></li>
								</c:if>
								<c:forEach begin="${startPage}" end="${endPage}" var="page">

									<li <c:if test="${page==thisPage}">class="active"</c:if>><a
										href="<c:url value="/admin/advertisements?sort=${sortType}&page=${page}&desc=${descPage}" />">${page}</a></li>
								</c:forEach>

								<c:if test="${thisPage!=maxPage}">
									<li><a
										href="<c:url value="/admin/advertisements?sort=${sortType}&page=${thisPage+1}&desc=${descPage}" />"
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


	<div class="clearfix"></div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
	<script src="<c:url value="/resources/js/jquery-1.7.min.js" />">
		
	</script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />">
		
	</script>



</body>
</html>
