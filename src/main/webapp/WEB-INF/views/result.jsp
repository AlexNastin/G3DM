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

 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="global3dmod team">
   
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
<%@include file="/WEB-INF/views/categoryMenu.jsp" %> 


</div>
<div class="container meow">

    <hgroup class="mb20">
        <h1>${result}</h1>
        <h2 class="lead"><strong class="text-danger">${sizePosts}</strong> ${quantity}</h2>
    </hgroup>
 <nav style="text-align:center">
  <ul class="pagination">
  <c:if test="${thisPage>1}">
    <li>
      <a href="<c:url value="/result?page=${thisPage-1}&idCategory=${idCategory}&idSubcategory=${idSubcategory}" />" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    </c:if>
    <c:forEach begin="${startPage}" end="${endPage}" var="page">
    
    <li <c:if test="${page==thisPage}">class="active"</c:if>><a href="<c:url value="/result?page=${page}&idCategory=${idCategory}&idSubcategory=${idSubcategory}" />">${page}</a></li>
    </c:forEach>
    
    <c:if test="${thisPage!=maxPage}">
    <li>
      <a href="<c:url value="/result?page=${thisPage+1}&idCategory=${idCategory}&idSubcategory=${idSubcategory}" />" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
    </c:if>
  </ul>
</nav>
    <section class="col-xs-12 col-sm-6 col-md-12">
    <c:forEach items="${listPostsLimit10}" var="post" varStatus="i">
        <article class="search-result row">
            <div class="col-xs-12 col-sm-12 col-md-3">
                <a href="<c:url value="/model?id=${post.idPost}" />" title="${post.title}" class="thumbnail"><img src="<c:url value="/resources/images/auto.jpg" />" alt="Lorem ipsum" /></a>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-2">
                <ul class="meta-search">
                    <li><i class="fa fa-star"></i><span>${rate} 464</span></li>
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
 <nav style="text-align:center">
  <ul class="pagination">
  <c:if test="${thisPage>1}">
    <li>
      <a href="<c:url value="/result?page=${thisPage-1}&idCategory=${idCategory}&idSubcategory=${idSubcategory}" />" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    </c:if>
    <c:forEach begin="${startPage}" end="${endPage}" var="page">
    
    <li <c:if test="${page==thisPage}">class="active"</c:if>><a href="<c:url value="/result?page=${page}&idCategory=${idCategory}&idSubcategory=${idSubcategory}" />">${page}</a></li>
    </c:forEach>
    
    <c:if test="${thisPage!=maxPage}">
    <li>
      <a href="<c:url value="/result?page=${thisPage+1}&idCategory=${idCategory}&idSubcategory=${idSubcategory}" />" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
    </c:if>
  </ul>
</nav>
<%@include file="/WEB-INF/views/footer.jsp" %>  
    <script src="<c:url value="/resources/js/jquery-1.7.min.js" />"> </script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script> 
    <script src="<c:url value="/resources/js/uisearch.js" />"> </script> 
</body>
</html>