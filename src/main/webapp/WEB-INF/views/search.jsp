<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Global3Dmod</title>
<!-- Init search variable -->
<spring:message code="main.search.search" var="search"/>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="global3dmod team">
   	<meta name="keywords" content="3d printer, 3d model, 3d model free, 3d model download, 3d model download free, model to print 3d printer free, stl, stl download,stl download free, 3d designer, 3d model robot, 3д модель, 3д принтер, 3д модель скачать, 3д модель скачать напечатать, 3д дизайнер, stl бесплатные, stl скачать, global3dmod, global 3d mod "> 
   
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/fontawesome430/css/font-awesome.min.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/search.css"  />" rel="stylesheet" />
     
    
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    <link rel="icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon">
    
    <spring:message code="result.searchbar.searchtitle" var="search"/>
    <spring:message code="result.search.result" var="result"/>
    <spring:message code="result.search.quantity" var="quantity"/>
    <spring:message code="result.item.author" var="author"/>
    <spring:message code="result.item.rating" var="rate"/>
    <spring:message code="result.item.downloads" var="downloads"/>
    <spring:message code="result.item.comments" var="comments"/>
    <spring:message code="result.searchbar.category" var="category"/>
    
    
   </head>
<body>
<%@include file="/WEB-INF/views/header/headerWithSearch.jsp" %>   


<div style="text-align:center; padding-top: 1em;">
	<div class="btn-group btn-group" role="group" aria-label="...">
	<c:forEach items="${listCategoryWithAllSubcategory}" var="category">
  <div class="btn-group btn-group" role="group">
    <button style="background-color: whitesmoke" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
      ${category.title}
      <span class="caret"></span>
    </button>
    <ul style="background-color: whitesmoke" class="dropdown-menu">
    <c:forEach items="${category.subcategories}" var="subcategory">
      <li><a href="<c:url value="/result?idCategory=${category.idCategory}&idSubcategory=${subcategory.idSubcategory}" />">${subcategory.title}</a></li>
    </c:forEach>
    </ul>
  </div>
  </c:forEach>
</div>
	</div>
<div class="container meow min-height-search-result">

    <hgroup class="mb20">
        <h1>${result}</h1>
        <h2 class="lead">${quantity}<strong class="text-danger">${sizePosts}</strong></h2>
    </hgroup>
    <c:if test="${sizePosts != 0}">
 <nav style="text-align:center">
  <ul class="pagination">
  <c:if test="${thisPage>1}">
    <li>
      <a href="<c:url value="/search?page=${thisPage-1}&text=${text}" />" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    </c:if>
    <c:forEach begin="${startPage}" end="${endPage}" var="page">
    
    <li <c:if test="${page==thisPage}">class="active"</c:if>><a href="<c:url value="/search?page=${page}&text=${text}" />">${page}</a></li>
    </c:forEach>
    
    <c:if test="${thisPage!=maxPage}">
    <li>
      <a href="<c:url value="/search?page=${thisPage+1}&text=${text}" />" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
    </c:if>
    
  </ul>
</nav>
</c:if>
    <section class="col-xs-12 col-sm-6 col-md-12">
    <c:forEach items="${listPostsLimit10}" var="post" varStatus="i">
        <article class="search-result row">
            <div class="col-xs-12 col-sm-12 col-md-3">
                <a href="<c:url value="/model?id=${post.idPost}" />" title="${post.title}" class="thumbnail"><img src="<c:url value="${post.postPhotos[0].photoPath}" />" alt="Lorem ipsum" /></a>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-2">
                <ul class="meta-search">
                    <li><i class="fa fa-star"></i><span>${rate} ${post.rating}</span></li>
                    <li><i class="fa fa-download"></i> <span>${downloads} ${post.countDownload}</span></li>
                    <li><i class="fa fa-user"></i> <span>${author} <a href="<c:url value="/guest/designerProfile?id=${post.user.idUser }"  />">${post.user.nickName}</a></span></li>
                </ul>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-7 excerpet">
                <h3><a href="<c:url value="/model?id=${post.idPost}" />" title="">${post.title}</a></h3>
                <p>${post.description}</p>

            </div>
            <span class="clearfix borda"></span>
        </article>
        </c:forEach>
    </section>
</div>
<c:if test="${sizePosts != 0}">
 <nav style="text-align:center">
  <ul class="pagination">
  <c:if test="${thisPage>1}">
    <li>
      <a href="<c:url value="/search?page=${thisPage-1}&text=${text}" />" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    </c:if>
    <c:forEach begin="${startPage}" end="${endPage}" var="page">
    
    <li <c:if test="${page==thisPage}">class="active"</c:if>><a href="<c:url value="/search?page=${page}&text=${text}" />">${page}</a></li>
    </c:forEach>
    
    <c:if test="${thisPage!=maxPage}">
    <li>
      <a href="<c:url value="/search?page=${thisPage+1}&text=${text}" />" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
    </c:if>
  </ul>
</nav>
</c:if>
<%@include file="/WEB-INF/views/footer.jsp" %>  
    <script src="<c:url value="/resources/js/jquery-1.7.min.js" />"> </script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script> 
    <script src="<c:url value="/resources/js/uisearch.js" />"> </script>
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