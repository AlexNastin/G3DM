<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/fontawesome430/css/font-awesome.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/otherpage.css"  />" rel="stylesheet" />
<link rel="icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon">
<meta name="keywords" content="3d printer, 3d model, 3d model free, 3d model download, 3d model download free, model to print 3d printer free, stl, stl download,stl download free, 3d designer, 3d model robot, 3д модель, 3д принтер, 3д модель скачать, 3д модель скачать напечатать, 3д дизайнер, stl бесплатные, stl скачать, global3dmod, global 3d mod "> 

<spring:message code="aboutus.title" var="title" />
<title>Team | Global3dMod</title>
<spring:message code="headerWithSearch.header.search" var="search"/>
</head>
<body>
<%@include file="/WEB-INF/views/header/headerWithSearch.jsp" %>
<div class="container">
  <div class="row">
    <div class="col-lg-12">
      <h3 class="text-center">Our Team</h3>
      
      <ul class="timeline">
        <li>
          <div class="timeline-image">
            <img class="img-circle img-responsive" src="<c:url value="/resources/images/team/alexey.jpg" />" alt="Alexey Nastin">
          </div>
          <div class="timeline-panel">
            <div class="timeline-heading">
              <h4 class="subheading">Alex Nastin</h4>
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
              <h4 class="subheading">Philip Fursov</h4>
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
              <h4 class="subheading">Nikita Stepanov</h4>
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
              
              <h4 class="subheading">Dmitriy Gusev</h4>
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
              
              <h4 class="subheading">Yury Bolshynov</h4>
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
</body>
</html>