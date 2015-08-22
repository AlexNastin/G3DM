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
<spring:message code="headerWithSearch.header.search" var="search" />
<spring:message code="designer.menu.works" var="works" />
<spring:message code="designer.menu.data" var="data" />
<spring:message code="designer.menu.add" var="add" />
<spring:message code="designer.menu.personalsecurity"
	var="personalsecurity" />
<spring:message code="form.project" var="project" />
<spring:message code="form.category" var="category" />
<spring:message code="form.subcategory" var="subcategory" />
<spring:message code="form.date" var="date" />
<spring:message code="form.number" var="number" />
<spring:message code="form.download" var="download" />
<spring:message code="form.status" var="status" />
<spring:message code="form.edit" var="edit" />
<spring:message code="designer.mywork.published" var="published" />
<spring:message code="designer.mywork.moderating" var="moderating" />
<spring:message code="designer.mywork.rejected" var="rejected" />
<spring:message code="designer.mywork.confirm" var="confirm" />
<spring:message code="designer.mywork.close" var="close" />
<spring:message code="designer.mywork.delmessage" var="delmessage" />
<spring:message code="designer.mywork.deletepost" var="deletepost" />
<spring:message code="designer.mywork.editmessage" var="editmessage" />
<spring:message code="form.edit" var="edit" />
<spring:message code="designer.mywork.empty" var="myWorkEmpty" />

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="global3dmod team">
 <meta name="keywords" content="3d printer, 3d model, 3d model free, 3d model download, 3d model download free, model to print 3d printer free, stl, stl download,stl download free, 3d designer, 3d model robot, 3д модель, 3д принтер, 3д модель скачать, 3д модель скачать напечатать, 3д дизайнер, stl бесплатные, stl скачать, global3dmod, global 3d mod, designer "> 
    <meta name="description" content=""> 
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
	<!-- Menu -->
	<div class="row footerpadding">
		<div class="col-md-2 nopadding1">
			<div class="list-group">
				<img src="<c:url value="${user.avatar.avatarPath}" />"
					class="img-responsive avatar-img img-thumbnail" alt="Global3Dmod avatar">
				<a href="<c:url value="/designer/profile?sort=date&page=1" />"
					class="list-group-item active"> <i class="fa fa-briefcase"></i>
					${works}
				</a> <a href="<c:url value="/designer/personalData" />"
					class="list-group-item"><i class="fa fa-cogs"></i> ${data} </a> <a
					href="<c:url value="/designer/secure/personalSecurity" />"
					class="list-group-item"><i class="fa fa-lock"></i>
					${personalsecurity} </a> <a href="<c:url value="/designer/addPost" />"
					class="list-group-item"><i class="fa fa-plus-square"></i>
					${add} </a>

			</div>
		</div>
		<!--main content start-->

		<div class="row">
			<div class="col-md-10 nopadding2">

				<div class="mt">
					<div class="col-md-12 nopadding2">
						<div class="content-panel">
							<table class="table table-striped table-advance table-hover">
								<div>
									<h2>${works}</h2>

									<thead>
										<c:if test="${sizePosts != 0}">
											<nav style="text-align: center">
												<ul class="pagination">
													<c:if test="${thisPage>1}">
														<li><a
															href="<c:url value="/designer/profile?sort=${sortType}&page=${thisPage-1}&desc=${descPage}" />"
															aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
														</a></li>
													</c:if>
													<c:forEach begin="${startPage}" end="${endPage}" var="page">

														<li <c:if test="${page==thisPage}">class="active"</c:if>><a
															href="<c:url value="/designer/profile?sort=${sortType}&page=${page}&desc=${descPage}" />">${page}</a></li>
													</c:forEach>

													<c:if test="${thisPage!=maxPage}">
														<li><a
															href="<c:url value="/designer/profile?sort=${sortType}&page=${thisPage+1}&desc=${descPage}" />"
															aria-label="Next"> <span aria-hidden="true">&raquo;</span>
														</a></li>
													</c:if>
												</ul>
											</nav>
										</c:if>
										<tr class="background-user-string">
											<th><i class="fa fa-folder-open-o"></i><a
												href="<c:url value="/designer/profile?sort=title&desc=${titleDesc}" />">
													${project}</a></th>
											<th><i class="fa fa-th-list"></i><a
												href="<c:url value="/designer/profile?sort=category&desc=${categoryDesc}" />">
													${category}</a></th>
											<th><i class="fa fa-list-alt"></i><a
												href="<c:url value="/designer/profile?sort=subcategory&desc=${subcategoryDesc}" />">
													${subcategory}</a></th>
											<th><i class="fa fa-calendar"></i><a
												href="<c:url value="/designer/profile?sort=date&desc=${dateDesc}" />">
													${date}</a></th>
											<th><i class="fa fa-book"></i> ${number}</th>
											<th><i class="fa fa-cloud-download"></i><a
												href="<c:url value="/designer/profile?sort=downloads&desc=${downloadsDesc}" />">
													${download}</a></th>
											<th><i class=" fa fa-edit"></i><a
												href="<c:url value="/designer/profile?sort=status&desc=${statusDesc}" />">
													${status}</a></th>
											<th><i class="fa fa-pencil"></i> ${edit}</th>
										</tr>
									</thead>
									<tbody>
							

										<c:forEach items="${listPostsLimit10}" var="post">
											<tr>
												<td><a
													href="<c:url value="/model?id=${post.idPost}" />">${post.title}</a></td>
												<td class="hidden-phone">${post.category.title}</td>
												<td>${post.subcategory.title}</td>
												<td>${post.dateUpdate}</td>
												<td>${post.numberPost}</td>
												<td>${post.countDownload}</td>
												<c:if test="${post.isDisplay == 3}">
													<td><span class="label label-success label-mini">${published}</span></td>
												</c:if>
												<c:if test="${post.isDisplay == 2}">
													<td><span class="label label-warning label-mini">${moderating}</span></td>
												</c:if>
												<c:if test="${post.isDisplay == 1}">
													<td><span class="label label-warning label-danger">${rejected}</span>
														<i class="fa fa-question-circle" style="color: #357ebd;"
														data-toggle="tooltip" data-placement="top"
														title="${post.rejectMessage.message}"></i></td>
												</c:if>

												<td>
													<button class="btn btn-primary btn-xs" data-toggle="modal"
														data-target="#edit${post.idPost}">
														<i class="fa fa-pencil"></i>
													</button>
													<button class="btn btn-danger btn-xs" data-toggle="modal"
														data-target="#myModal${post.idPost}">
														<i class="fa fa-trash-o "></i>
													</button>
												</td>
											</tr>
											<!-- Delete modal -->
											<div class="modal fade" id="myModal${post.idPost}"
												tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
												aria-hidden="true">
												<div class="modal-dialog">
													<div class="modal-content">
														<div class="modal-header">
															<button type="button" class="close" data-dismiss="modal"
																aria-label="Close">
																<span aria-hidden="true">&times;</span>
															</button>
															<h4 class="modal-title" id="myModalLabel">${confirm}</h4>
														</div>
														<div class="modal-body">${delmessage}</div>
														<div class="modal-footer">
															<a type="button" class="btn btn-default"
																data-dismiss="modal">${close}</a> <a
																href="<c:url value="/designer/deletePost?id=${post.idPost}" />"
																type="button" class="btn btn-danger">${deletepost}</a>
														</div>
													</div>
												</div>
											</div>
											<!-- Edit modal -->
											<div class="modal fade" id="edit${post.idPost}" tabindex="-1"
												role="dialog" aria-labelledby="myModalLabel"
												aria-hidden="true">
												<div class="modal-dialog">
													<div class="modal-content">
														<div class="modal-header">
															<button type="button" class="close" data-dismiss="modal"
																aria-label="Close">
																<span aria-hidden="true">&times;</span>
															</button>
															<h4 class="modal-title" id="myModalLabel">${confirm}</h4>
														</div>
														<div class="modal-body">${editmessage}</div>
														<div class="modal-footer">
															<a type="button" class="btn btn-default"
																data-dismiss="modal">${close}</a> <a
																href="<c:url value="/designer/updatePost?id=${post.idPost}" />"
																type="button" class="btn btn-primary">${edit}</a>
														</div>
													</div>
												</div>
											</div>
										</c:forEach>
							</table>
						</div>
			<c:if test="${empty listPostsLimit10}">
   								 <div class="alert alert-info" role="alert" style="margin-top: 3%; padding:1%; text-align:center">${myWorkEmpty}</div>
								</c:if>
						<c:if test="${sizePosts != 0}">
							<nav style="text-align: center">
								<ul class="pagination">
									<c:if test="${thisPage>1}">
										<li><a
											href="<c:url value="/designer/profile?sort=${sortType}&page=${thisPage-1}&desc=${descPage}" />"
											aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										</a></li>
									</c:if>
									<c:forEach begin="${startPage}" end="${endPage}" var="page">

										<li <c:if test="${page==thisPage}">class="active"</c:if>><a
											href="<c:url value="/designer/profile?sort=${sortType}&page=${page}&desc=${descPage}" />">${page}</a></li>
									</c:forEach>

									<c:if test="${thisPage!=maxPage}">
										<li><a
											href="<c:url value="/designer/profile?sort=${sortType}&page=${thisPage+1}&desc=${descPage}" />"
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
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
	<script src="<c:url value="/resources/js/jquery-1.7.min.js" />">
		
	</script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />">
		
	</script>
	<script src="<c:url value="/resources/js/tooltip.js" />"></script>
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
