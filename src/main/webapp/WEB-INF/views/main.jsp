<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Global3Dmod | 3D printable models repository</title>
<!-- Init search variable -->
<spring:message code="main.search.search" var="search" />
<spring:message code="main.search.searchInto" var="searchmain" />
<spring:message code="main.top.topModels" var="topmodel" />
<spring:message code="main.top.topDesigners" var="topdesigner" />
<spring:message code="main.top.ourtops" var="ourtops" />

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content=" Global3Dmod is a new global 3D printer's model bank, and here you can share your projects or you can download models you like.">
<meta name="author" content="global3dmod team">
<meta name="keywords" content="3d printer, 3d model, 3d model free, 3d model download, 3d model download free, model to print 3d printer free, stl, stl download,stl download free, 3d designer, 3d model robot, 3д модель, 3д принтер, 3д модель скачать, 3д модель скачать напечатать, 3д дизайнер, stl бесплатные, stl скачать, global3dmod, global 3d mod "> 


<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
<link	href="<c:url value="/resources/css/fontawesome430/css/font-awesome.min.css"  />"	rel="stylesheet" />


<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
<link rel="icon" href="<c:url value="/resources/images/favicon.png" />"
	type="image/x-icon">

</head>
<body>
	<!-- Here some place for ads -->

	<%@include file="/WEB-INF/views/header/header.jsp"%>

	<div class="banner">
		<div class="container_wrap">
			<h1 style="color:#000000">
				<spring:message code="main.search.searchUp" />
			</h1>
			<div class="col-md-4"></div>
			<form class="col-md-4" action="<c:url value="/search"/>" method="GET">
				<div class="input-group"
					style="width: 100%; text-align: center; margin: 0 auto;">
					<input class="form-control input-lg" name="text" placeholder="${searchmain}"
					 value="" type="text" >
					<span class="input-group-btn"><button type="submit"  class="btn btn-lg btn-primary" > ${search} </button> </span>
				</div>
			</form>

			<div class="col-md-4"></div>
			<div class="clearfix"></div>
		</div>
	</div>


	<div class="group container categories">
		<div class="item line1"></div>
		<div class="item text">
			<spring:message code="main.categories.categories" />
		</div>
		<div class="item line1"></div>
	</div>
	<div class="container col-lg-12 nomargin">


		<section id="portfolio">
			<div class="row portfolio-items">
				<!--1st element-->
				<c:forEach items="${listCategory}" var="category">
					<div class="portfolio-item apps  col-md-3">
						<div class="item-inner">
							<div class="portfolio-image">
								<img src=<c:url value="${category.imagePath}" /> alt="">
								<div class="overlay container">
									<div class="menuis">
										<a
											href="<c:url value="/result?idCategory=${category.idCategory}" />"
											class="preview btn btn-primary mainbutton"
											title="${category.title}">${category.title}</a>
										<c:forEach items="${category.subcategories}" var="subcategory">
											<p>
												<a class="categorytxt"
													href="<c:url value="/result?idCategory=${category.idCategory}&idSubcategory=${subcategory.idSubcategory}" />">${subcategory.title }</a>
											</p>

										</c:forEach>
									</div>
								</div>
							</div>
							<h5><a href="<c:url value="/result?idCategory=${category.idCategory}" />"
											
											>${category.title}</a></h5>
						</div>
					</div>
				</c:forEach>
		</section>

	</div>
	<div class="tops">
	<div class="group container">
		<div class="item line1"></div>
		<div class="item text">${ourtops}</div>
		<div class="item line1"></div>
	</div>
	<div class="clearfix"></div>

	<div class="backgroundslider" style="max-height: 24em;">
		<div class="container topslider">
			<div class="row nomargin">
				<div class="carousel-container contanier col-md-12 sliderup">

					<!-- Codrops top bar -->


					<div id="mi-slider" class="mi-slider respimg" style="max-height: 26em;">
						<ul>
							<c:forEach items="${listTop4Posts}" var="post">
								<li><a href="<c:url value="/model?id=${post.idPost}"/>"><img style="max-height: 120px;"
										class="respimg"
										src=<c:url value="${post.postPhotos[0].photoPath}" /> alt="">
									<h4>${post.title}</h4></a></li>
							</c:forEach>
						</ul>
						<ul>
							<c:forEach items="${listTop4Users}" var="user">
								<li><a href="<c:url value="/guest/designerProfile?id=${user.idUser}"/>"><img
										class="respimg"
										src=<c:url value="${user.avatar.avatarPath}" /> alt="">
									<h4>${user.nickName}</h4></a></li>
							</c:forEach>
						</ul>


						<nav>
							<a href="#">${topmodel}</a> <a href="#">${topdesigner}</a>

						</nav>
					</div>
				</div>
			</div>
			<!-- /container -->
		</div>
	</div>
</div>
	<div class="clearfix"></div>
	<br>
	<div class="row nomargin"><%@include file="/WEB-INF/views/adslider.jsp"%>

	</div>
	<div class="clearfix"></div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
	<script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"> </script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />">
		
	</script>
	<script
		src="<c:url value="/resources/js/slider/modernizr.custom.63321.js" />">
		
	</script>
	<script
		src="<c:url value="/resources/js/slider/jquery.catslider.js" />">
		
	</script>
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
