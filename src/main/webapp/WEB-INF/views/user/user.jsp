<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Users | Global3dmod</title>

<!-- Init search variable -->
<spring:message code="headerWithSearch.header.search" var="search"/>
<spring:message code="user.menu.mybookmarks" var="mybookmarks"/>
<spring:message code="user.menu.personaldata" var="personaldata"/>
<spring:message code="user.menu.project" var="project"/>
<spring:message code="user.menu.description" var="description"/>
<spring:message code="user.menu.number" var="number"/>
<spring:message code="user.menu.rating" var="rating"/>
<spring:message code="user.menu.miniature" var="miniature"/>
<spring:message code="user.menu.designer" var="designer"/>
<spring:message code="designer.menu.personalsecurity" var="personalsecurity" />
<spring:message code="user.post.empty" var="postEmpty" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="global3dmod team">
    <meta name="keywords" content="3d printer, 3d model, 3d model free, 3d model download, 3d model download free, model to print 3d printer free, stl, stl download,stl download free, 3d designer, 3d model robot, 3д модель, 3д принтер, 3д модель скачать, 3д модель скачать напечатать, 3д дизайнер, stl бесплатные, stl скачать, global3dmod, global 3d mod, user"> 
    <meta name="description" content="">    
        <link href="<c:url value="/resources/css/bootstrap.min.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/cabinets/designer.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/cabinets/user.css"  />" rel="stylesheet" />
     <link href="<c:url value="/resources/css/fontawesome430/css/font-awesome.css" />" rel="stylesheet" />
    
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    <link rel="icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon">
   </head>
<body>
<!-- Here some place for ads. After placing ads you may delete "placeforads" css class in header -->

	<%@include file="/WEB-INF/views/header/headerWithSearch.jsp" %>  
	<!-- User's page will start here -->
	     
	      <!--sidebar start-->
     
      <div class="row footerpadding">
      <div class="col-md-2 nopadding1">
      <div class="list-group">
      
      <img src="<c:url value="${user.avatar.avatarPath}" />" class="img-responsive avatar-img img-thumbnail" alt="Global3Dmod avatar">      
  <a href="<c:url value="/user/profile" />" class="list-group-item active "><i class="fa fa-briefcase"></i> ${mybookmarks}</a>
 <a href="<c:url value="/user/personalData" />" class="list-group-item"><i class="fa fa-cogs"></i> ${personaldata}  </a>
  <a href="<c:url value="/user/secure/personalSecurity" />" class="list-group-item"><i class="fa fa-lock"></i> ${personalsecurity}  </a>
  </div>
      </div>
      <!--main content start-->
      
      <div class="nopadding2 col-md-10 ">
          <div class="mt">
                  <div class="col-md-12 nopadding2">
                      <div class="content-panel">
                          <table class="table table-striped table-advance table-hover">
                             <div> <h2> ${mybookmarks}</h2>
                              <thead>
                              <c:if test="${sizePosts != 0}">
                               <nav style="text-align:center">
  <ul class="pagination">
  <c:if test="${thisPage>1}">
    <li>
      <a href="<c:url value="/user/profile?sort=${sortType}&page=${thisPage-1}&desc=${descPage}" />" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    </c:if>
    <c:forEach begin="${startPage}" end="${endPage}" var="page">
    
    <li <c:if test="${page==thisPage}">class="active"</c:if>><a href="<c:url value="/user/profile?sort=${sortType}&page=${page}&desc=${descPage}" />">${page}</a></li>
    </c:forEach>
    
    <c:if test="${thisPage!=maxPage}">
    <li>
      <a href="<c:url value="/user/profile?sort=${sortType}&page=${thisPage+1}&desc=${descPage}" />" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
    </c:if>
  </ul>
</nav>
</c:if>
                              <tr class="background-user-string">
                                  <th><i class="fa fa-bullhorn"></i><a href="<c:url value="/user/profile?sort=title&desc=${titleDesc}" />"> ${project}</a></th>
                                  <th class="hidden-phone"><i class="fa fa-question-circle"></i> ${description}</th>
                                  <th><i class="fa fa-book"></i> ${number}</th>
                                  <th><i class="fa fa-star"></i><a href="<c:url value="/user/profile?sort=rating&desc=${ratingDesc}" />"> ${rating}</a></th>
                                  <th><i class="fa fa-file-image-o"></i> ${miniature}</th>
                                  <th><i class="fa fa-user"></i><a href="<c:url value="/user/profile?sort=designer&desc=${designerDesc}" />"> ${designer}</a></th>
                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach items="${listPostsLimit10}" var="post" >
                             <tr>
                                  <td><a href="<c:url value="/model?id=${post.idPost}" />">${post.title}</a></td>
                                  <td class="hidden-phone">${post.description}</td>
                                  <td>${post.numberPost}</td>
                                  <td>${post.rating}</td>
                                  <td><img style="max-width: 5em;"alt="" src="<c:url value="${post.postPhotos[0].photoPath}" />"></td>
                                  <td>${post.user.nickName}</td>
                              </tr>
                              </c:forEach>
                              </tbody>
                              </div>
                          </table>
                      </div>
                	<c:if test="${empty listPostsLimit10}">
   								 ${postEmpty}
								</c:if>
                      <c:if test="${sizePosts != 0}">
                      <nav style="text-align:center">
  <ul class="pagination">
  <c:if test="${thisPage>1}">
    <li>
      <a href="<c:url value="/user/profile?sort=${sortType}&page=${thisPage-1}&desc=${descPage}" />" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    </c:if>
    <c:forEach begin="${startPage}" end="${endPage}" var="page">
    
    <li <c:if test="${page==thisPage}">class="active"</c:if>><a href="<c:url value="/user/profile?sort=${sortType}&page=${page}&desc=${descPage}" />">${page}</a></li>
    </c:forEach>
    
    <c:if test="${thisPage!=maxPage}">
    <li>
      <a href="<c:url value="/user/profile?sort=${sortType}&page=${thisPage+1}&desc=${descPage}" />" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
    </c:if>
  </ul>
</nav>
</c:if>
                  </div>
              </div>
        </div>
  </div> 
  
  <div class="clearfix"> </div>
	<%@include file="/WEB-INF/views/footer.jsp" %>  
    <script src="<c:url value="/resources/js/jquery-1.7.min.js" />"> </script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script> 
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
