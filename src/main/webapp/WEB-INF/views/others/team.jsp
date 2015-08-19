<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/fontawesome430/css/font-awesome.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/otherpage.css"  />" rel="stylesheet" />
<link rel="icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon">
<meta name="keywords" content="3d printer, 3d model, 3d model free, 3d model download, 3d model download free, model to print 3d printer free, stl, stl download,stl download free, 3d designer, 3d model robot, 3д модель, 3д принтер, 3д модель скачать, 3д модель скачать напечатать, 3д дизайнер, stl бесплатные, stl скачать, global3dmod, global 3d mod "> 

<spring:message code="aboutus.title" var="title" />
<title>Team | Global3dMod</title>
<spring:message code="headerWithSearch.header.search" var="search"/>
<spring:message code="other.team.ourteam" var="ourteam"/>
<spring:message code="other.team.name1" var="name1"/>
<spring:message code="other.team.name2" var="name2"/>
<spring:message code="other.team.name3" var="name3"/>
<spring:message code="other.team.name4" var="name4"/>
<spring:message code="other.team.name5" var="name5"/>
</head>
<body>
<%@include file="/WEB-INF/views/header/headerWithSearch.jsp" %>
<div class="container">
  <div class="row">
    <div class="col-lg-12">
      <h3 class="text-center">${ourteam}</h3>
      
      <ul class="timeline">
        <li>
          <div class="timeline-image">
            <img class="img-circle img-responsive" src="<c:url value="/resources/images/team/alexey.jpg" />" alt="Alexey Nastin">
          </div>
          <div class="timeline-panel">
            <div class="timeline-heading">
              <h4 class="subheading">${name1}</h4>
             </div>
            <div class="timeline-body">
              <p class="text-muted">
               Project manager, Java Developer, Database Architect
              </p>
            </div>
          </div>
          <div class="line"></div>
        </li>
        <li class="timeline-inverted">
          <div class="timeline-image">
            <img class="img-circle img-responsive" src="<c:url value="/resources/images/team/philip.jpg" />" alt="Philip Fursov">
          </div>
          <div class="timeline-panel">
            <div class="timeline-heading">
              <h4 class="subheading">${name2}</h4>
            </div>
            <div class="timeline-body">
              <p class="text-muted">Front-End Developer, QA Manager
              </p>
            </div>
          </div>
          <div class="line"></div>
        </li>
        <li>
          <div class="timeline-image">
            <img class="img-circle img-responsive" src="<c:url value="/resources/images/team/nickita.jpg" />" alt="Никита Степанов">
          </div>
          <div class="timeline-panel">
            <div class="timeline-heading">
              <h4 class="subheading">${name3}</h4>
            </div>
            <div class="timeline-body">
              <p class="text-muted">
                Java Developer.
              </p>
            </div>
          </div>
          <div class="line"></div>
        </li>
        <li class="timeline-inverted">
          <div class="timeline-image">
            <img class="img-circle img-responsive" src="<c:url value="/resources/images/team/dima.jpg" />" alt="Дмитрий Гусев">
          </div>
          <div class="timeline-panel">
            <div class="timeline-heading">
              
              <h4 class="subheading">${name4}</h4>
            </div>
            <div class="timeline-body">
              <p class="text-muted">
              Front-End Developer
              </p>
            </div>
          </div>
          <div class="line"></div>
        </li>
        <li>
          <div class="timeline-image">
            <img class="img-circle img-responsive" src="<c:url value="/resources/images/team/yuriy.jpg" />" alt="Юрий Большунов">
          </div>
          <div class="timeline-panel">
            <div class="timeline-heading">
              
              <h4 class="subheading">${name5}</h4>
            </div>
            <div class="timeline-body">
              <p class="text-muted">
              Web-Designer, UI/UX Designer
              </p>
            </div>
          </div>
        </li>
      </ul>
    </div>
  </div>
</div>
<%@include file="/WEB-INF/views/footer.jsp" %>
<script src="<c:url value="/resources/js/jquery.min.js" />"> </script>
<script src="<c:url value="/resources/js/jquery-2.1.1.js" />"> </script>
<script src="<c:url value="/resources/js/jquery.validate.min.js" />"> </script>
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