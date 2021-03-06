<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Personal data | Global3dmod</title>
<!-- Init search variable -->
<spring:message code="headerWithSearch.header.search" var="search"/>
<spring:message code="designer.menu.works" var="works"/>
<spring:message code="designer.menu.data" var="data"/>
<spring:message code="designer.menu.add" var="add"/>
<spring:message code="designer.menu.personalsecurity" var="personalsecurity" />
<spring:message code="form.city" var="city" />
<spring:message code="form.country" var="country" />
<spring:message code="form.login" var="login" />
<spring:message code="form.nickname" var="nickname" />
<spring:message code="form.name" var="name" />
<spring:message code="form.surname" var="surname" />
<spring:message code="form.datebirth" var="datebirth" />
<spring:message code="form.rating" var="rating" />
<spring:message code="form.gender.male" var="male" />
<spring:message code="form.gender.female" var="female" />
<spring:message code="form.gender" var="gender" />
<spring:message code="form.gender.none" var="none" />
<spring:message code="form.update" var="update" />
<spring:message code="designer.personaldata.deleteavatar" var="deleteavatar" />
<spring:message code="designeruser.personaldata.confirm" var="confirm" />
<spring:message code="designeruser.personaldata.confirmmessage" var="confirmmessage" />
<spring:message code="designeruser.personaldata.confirdelete" var="confirdelete" />
<spring:message code="form.close" var="close" />


     <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="global3dmod team">
     <meta name="keywords" content="3d printer, 3d model, 3d model free, 3d model download, 3d model download free, model to print 3d printer free, stl, stl download,stl download free, 3d designer, 3d model robot, 3д модель, 3д принтер, 3д модель скачать, 3д модель скачать напечатать, 3д дизайнер, stl бесплатные, stl скачать, global3dmod, global 3d mod, designer "> 
    <meta name="description" content=""> 
    <link href="<c:url value="/resources/css/bootstrap.min.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/cabinets/designer.css"  />" rel="stylesheet" />
     <link href="<c:url value="/resources/css//fontawesome430/css/font-awesome.css"  />" rel="stylesheet" />
    
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    <link rel="icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon">
   </head>
<body>
<!-- Here some place for ads. After placing ads you may delete "placeforads" css class in header -->

	<%@include file="/WEB-INF/views/header/headerWithSearch.jsp" %>  
	<!-- Designer's page will start here -->     
	        
 <!-- Menu -->     
 <div class="row footerpadding">
    <div class="col-md-2 nopadding1">
     <div class="list-group">
      <img src="<c:url value="${user.avatar.avatarPath}" />" class="img-responsive avatar-img img-thumbnail" alt="Global3Dmod avatar">    
  <a href="<c:url value="/designer/profile?sort=date&page=1" />" class="list-group-item">
    <i class="fa fa-briefcase"></i> ${works} 
  </a>
  
  <a href="<c:url value="/designer/personalData" />" class="list-group-item active"><i class="fa fa-cogs"></i> ${data}  </a>
  <a href="<c:url value="/designer/secure/personalSecurity" />" class="list-group-item"><i class="fa fa-lock"></i> ${personalsecurity}  </a>
  <a href="<c:url value="/designer/addPost" />" class="list-group-item"><i class="fa fa-plus-square"></i> ${add}  </a>
  
	 </div>
    </div>
    
      <!--main content start-->
      <div class="nopadding2 col-md-10 ">
          <div class="mt">
                  <div class="col-md-12 nopadding2">
                      <div class="col-md-4" style="padding-left:0px;">
                      <div class="content-pael">                      
                      <h2>${data}</h2>
                      
                          <table class="table table-striped table-advance table-hover">
                                                                                      
                              <tbody>
                              <tr>
                                  <td>${nickname}</td>
                                  <td class="hidden-phone">${user.nickName}</td>
                                  
                              </tr>
                              <tr>
                                   <td>${city}</td>
                                  	<td class="hidden-phone">${user.city.title}</td>
                                  
                              </tr>
                              <tr>
                                  <td>${country}</td>
                                  <td class="hidden-phone">${user.country.title}</td>
                                  
                              </tr>
                              <tr>
                                   <td>${login}</td>
                                  <td class="hidden-phone">${user.login}</td>
                              </tr>
                              <tr>
                                   <td>${name}</td>
                                  <td class="hidden-phone">${user.name}</td>
                                  
                              </tr>
                              <tr>
                                   <td>${surname}</td>
                                  <td class="hidden-phone">${user.surname}</td>
                                  
                              </tr>
                              <tr>
                                   <td>${datebirth}</td>
                                  <td class="hidden-phone">${user.dateBirth}</td>
                                  
                              </tr>
                              <tr>
                                   <td>${rating}</td>
                                  <td class="hidden-phone">${user.rating}</td>
                                  
                              </tr>
                              <tr>
                                   <td>${gender}</td>
                                  <td class="hidden-phone"><c:if test="${user.gender == 2}">
			${male}
		</c:if>
		<c:if test="${user.gender == 1}">
			${female}
		</c:if>
		<c:if test="${user.gender == 0}">
			${none}
		</c:if></td>
                                  
                              </tr>
                                  </tbody>
                          </table>
                      </div>
                      <div class="height-message-avatar">
                      <c:if  test="${message != null}">
			           <div class="alert alert-info" role="alert" style="margin-top: 0%; padding: 1%; text-align: center;">${message}</div> 
			          </c:if>
                      </div>
                     <div class="row">
                      <button type="button" style="text-align: center;" class="btn btn-primary left-designer"  onClick='location.href="<c:url value="/designer/personalData/updateForm"  />"'>
                       ${update}
                      </button>
                      <button type="button" style="text-align: center; margin-right: 1em;" class="btn btn-primary left-designer" data-toggle="modal" data-target="#myModal" >
                       ${deleteavatar}
                      </button>
                     </div>      
                     
                  </div>
              </div>
              
      </div>
      
		
     </div> 
          
  </div>
  
  <!-- Trigger the modal with a button -->

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog modal-sm">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">${confirm}</h4>
      </div>
      <div class="modal-body">
        <p>${confirmmessage}</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">${close}</button>
        <button type="button" class="btn btn-danger"  onClick='location.href="<c:url value="/designer/deleteAvatar"  />"'>${confirdelete}</button>
        
      </div>
    </div>

  </div>
</div>
  <div class="clearfix"> 
  
  </div>
 
	<%@include file="/WEB-INF/views/footer.jsp" %>  
    <script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"> </script>
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
