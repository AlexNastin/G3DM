<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Complained posts | Global3dmod</title>
<!-- Init search variable -->
<spring:message code="headerWithSearch.header.search" var="search" />
<spring:message code="moderator.menu.postsunpublished" var="unpblsd" />
<spring:message code="moderator.menu.postspublished" var="publics" />
<spring:message code="moderator.menu.users" var="users" />
<spring:message code="moderator.menu.designer" var="designers" />
<spring:message code="moderator.menu.rejectingposts"
	var="rejectingposts" />
<spring:message code="moderator.menu.complainedposts"
	var="complainedposts" />
<spring:message code="moderator.postsunpublished.posts" var="posts" />
<spring:message code="form.project" var="project" />
<spring:message code="form.description" var="description" />
<spring:message code="form.number" var="number" />
<spring:message code="form.date" var="date" />
<spring:message code="form.category" var="category" />
<spring:message code="form.subcategory" var="subcategory" />
<spring:message code="form.author" var="author" />
<spring:message code="form.check" var="check" />
<spring:message code="form.complain" var="complain" />
<spring:message code="moderator.complainedpost.checkintable"
	var="checkintable" />

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="global3dmod team">
<meta name="keywords"
	content="3d printer, 3d model, 3d model free, 3d model download, 3d model download free, model to print 3d printer free, stl, stl download,stl download free, 3d designer, 3d model robot, 3д модель, 3д принтер, 3д модель скачать, 3д модель скачать напечатать, 3д дизайнер, stl бесплатные, stl скачать, global3dmod, global 3d mod, moderator ">
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

	<!--sidebar start-->

	<!-- Menu -->
	<div class="row footerpadding">
		<div class="col-md-2 nopadding1">
			<div class="list-group">
				<img src="<c:url value="${user.avatar.avatarPath}" />"
					class="img-responsive avatar-img img-thumbnail"
					alt="Global3Dmod avatar"> <a
					href="<c:url value="/moderator/profile" />"
					class="list-group-item "> <i class="fa fa-exclamation-triangle"></i>
					${unpblsd}
				</a> <a href="<c:url value="/moderator/rejectingPosts" />"
					class="list-group-item"> <i class="fa fa-ban"></i>
					${rejectingposts}
				</a> <a href="<c:url value="/moderator/complainedPosts" />"
					class="list-group-item active"> <i class="fa fa-ban"></i>
					${complainedposts}
				</a>

			</div>
		</div>
		<!--main content start-->

		<div class="nopadding2 col-md-10 ">
			<div class="mt">
				<div class="col-md-12 nopadding2">
					<div class="content-panel">
						<table class="table table-striped table-advance table-hover">
							<h2>${posts}</h2>

							<!-- Some sorts for table -->

							<thead>

								<c:if test="${sizePosts != 0}">
									<nav style="text-align: center">
										<ul class="pagination">
											<c:if test="${thisPage>1}">
												<li><a
													href="<c:url value="/moderator/complainedPosts?sort=${sortType}&page=${thisPage-1}&desc=${descPage}" />"
													aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
												</a></li>
											</c:if>
											<c:forEach begin="${startPage}" end="${endPage}" var="page">

												<li <c:if test="${page==thisPage}">class="active"</c:if>><a
													href="<c:url value="/moderator/complainedPosts?sort=${sortType}&page=${page}&desc=${descPage}" />">${page}</a></li>
											</c:forEach>

											<c:if test="${thisPage!=maxPage}">
												<li><a
													href="<c:url value="/moderator/complainedPosts?sort=${sortType}&page=${thisPage+1}&desc=${descPage}" />"
													aria-label="Next"> <span aria-hidden="true">&raquo;</span>
												</a></li>
											</c:if>
										</ul>
									</nav>
								</c:if>

								<tr class="background-user-string">
									<th><i class="fa fa-bullhorn"></i><a
										href="<c:url value="/moderator/complainedPosts?sort=title&desc=${titleDesc}" />">
											${project}</a></th>
									<th class="hidden-phone"><i class="fa fa-question-circle"></i>
										${description}</th>
									<th>${number}</th>
									<th><i class="fa fa-calendar"></i><a
										href="<c:url value="/moderator/complainedPosts?sort=date&desc=${dateDesc}" />">
											${date}</a></th>
									<th><i class="fa fa-th-list"></i><a
										href="<c:url value="/moderator/complainedPosts?sort=category&desc=${categoryDesc}" />">
											${category}</a></th>
									<th><i class="fa fa-list-alt"></i> <a
										href="<c:url value="/moderator/complainedPosts?sort=subcategory&desc=${subcategoryDesc}" />">
											${subcategory}</a></th>
									<th><i class="fa fa-user"></i><a
										href="<c:url value="/moderator/complainedPosts?sort=designer&desc=${designerDesc}" />">
											${author}</a></th>
									<th><i class="fa fa-user"></i><a
										href="<c:url value="/moderator/complainedPosts?sort=complain&desc=${complainDesc}" />">
											${complain}</a></th>
									<th class="hidden-phone"><i class="fa fa-question-circle"></i>
										${check}</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listPostsLimit10}" var="post">
									<tr>
										<td>${post.title}</td>
										<td style="max-width: 15em" class="hidden-phone">${post.description}</td>
										<td>${post.numberPost}</td>
										<td>${post.dateUpdate}</td>
										<td>${post.category.title}</td>
										<td>${post.subcategory.title}</td>
										<td>${post.user.nickName}</td>
										<td>${post.complain}</td>
										<td><a
											href="<c:url value="/moderator/moderationComplainPost?id=${post.idPost}" />"
											type="button" class="btn btn-success btn-xs">${checkintable}</a>
										</td>
										
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<c:if test="${sizePosts != 0}">
						<nav style="text-align: center">
							<ul class="pagination">
								<c:if test="${thisPage>1}">
									<li><a
										href="<c:url value="/moderator/complainedPosts?sort=${sortType}&page=${thisPage-1}&desc=${descPage}" />"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a></li>
								</c:if>
								<c:forEach begin="${startPage}" end="${endPage}" var="page">

									<li <c:if test="${page==thisPage}">class="active"</c:if>><a
										href="<c:url value="/moderator/complainedPosts?sort=${sortType}&page=${page}&desc=${descPage}" />">${page}</a></li>
								</c:forEach>

								<c:if test="${thisPage!=maxPage}">
									<li><a
										href="<c:url value="/moderator/complainedPosts?sort=${sortType}&page=${thisPage+1}&desc=${descPage}" />"
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
	<script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"> </script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />">
		
	</script>
	<script>
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		})(window, document, 'script',
				'//www.google-analytics.com/analytics.js', 'ga');
		ga('create', 'UA-66505156-1', 'auto');
		ga('send', 'pageview');
	</script>
	<!-- Yandex.Metrika counter -->
	<script type="text/javascript">
		(function(d, w, c) {
			(w[c] = w[c] || []).push(function() {
				try {
					w.yaCounter32035491 = new Ya.Metrika({
						id : 32035491,
						clickmap : true,
						trackLinks : true,
						accurateTrackBounce : true
					});
				} catch (e) {
				}
			});

			var n = d.getElementsByTagName("script")[0], s = d
					.createElement("script"), f = function() {
				n.parentNode.insertBefore(s, n);
			};
			s.type = "text/javascript";
			s.async = true;
			s.src = "https://mc.yandex.ru/metrika/watch.js";

			if (w.opera == "[object Opera]") {
				d.addEventListener("DOMContentLoaded", f, false);
			} else {
				f();
			}
		})(document, window, "yandex_metrika_callbacks");
	</script>
	<noscript>
		<div>
			<img src="https://mc.yandex.ru/watch/32035491"
				style="position: absolute; left: -9999px;" alt="" />
		</div>
	</noscript>
	<!-- /Yandex.Metrika counter -->
</body>
</html>
