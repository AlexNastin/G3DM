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
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="global3dmod team">
    <link href="<c:url value="/resources/css/bootstrap.css"  />" rel="stylesheet" />
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
	<!-- Designer's page will start here -->
	     
	      <!--sidebar start-->
     
      <div class="row">
      <div class="col-md-2 nopadding1">
      <div class="list-group">
      
      <img src="<c:url value="/resources/images/auto.jpg" />" class="img-responsive img-thumbnail" alt="Responsive image">      
  <a href="#" class="list-group-item active ">
    <i class="fa fa-briefcase"></i> ${mybookmarks}</a>
  <a href="#" class="list-group-item">
  <i class="fa fa-info-circle"></i> ${personaldata}</a>
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
                              <tr class="background-user-string">
                                  <th><i class="fa fa-bullhorn"></i> ${project}</th>
                                  <th class="hidden-phone"><i class="fa fa-question-circle"></i> ${description}</th>
                                  <th><i class="fa fa-book"></i> ${number}</th>
                                  <th><i class="fa fa-star"></i> ${rating}</th>
                                  <th><i class="fa fa-file-image-o"></i> ${miniature}</th>
                                  <th><i class="fa fa-user"></i> ${designer}</th>
                              </tr>
                              </thead>
                              <tbody>
                              <tr>
                                  <td><a href="basic_table.html#">Draw</a></td>
                                  <td class="hidden-phone col-md-3"> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed blandit eros sed ante pulvinar molestie. Donec id commodo purus. Sed nec quam velit. Fusce nec lacinia magna, id tempor lorem. Sed quis aliquam ipsum. Cras eu velit a sapien placerat efficitur sit amet eget neque. Mauris vulputate purus auctor</td>
                                  <td>1</td>
                                  <td>12000 </td>
                                  <td><img src="<c:url value="/resources/images/auto.jpg" />" class="img-responsive img-thumbnail miniature-image" alt="Responsive image"> </td>
                                  <td>Designer1</td>
                              </tr>
                              <tr>
                                  <td>
                                      <a href="basic_table.html#">
                                          Cup of tea
                                      </a>
                                  </td>
                                  <td class="col-md-3">Ut convallis purus tortor, in ornare mi fringilla sit amet. Nam id faucibus nisi. Mauris arcu diam, pulvinar id iaculis sed, volutpat quis lectus. Nulla dictum laoreet ipsum, rutrum porta erat maximus at. Aenean tincidunt nulla sit amet ligula pharetra, sit amet fermentum lectus fermentum. </td>
                                  <td>74</td>
                                  <td>17900 </td>
                                  <td><img src="<c:url value="/resources/images/auto.jpg" />" class="img-responsive img-thumbnail miniature-image" alt="Responsive image"> </td>
                                  <td>Designer2</td>
                              </tr>
                              <tr>
                                  <td>
                                      <a href="basic_table.html#">
                                          Another Cup
                                      </a>
                                  </td>
                                  <td class="col-md-3">Lorem Ipsum dolor</td>
                                  <td>752</td>
                                  <td>14400 </td>
                                  <td><img src="<c:url value="/resources/images/auto.jpg" />" class="img-responsive img-thumbnail miniature-image" alt="Responsive image"> </td>
                                  <td>Designer3</td>
                              </tr>
                              <tr>
                                  <td>
                                      <a href="basic_table.html#">
                                          Bottle for dragons
                                      </a>
                                  </td>
                                  <td class="col-md-3">Lorem Ipsum dolor</td>
                                  <td>78</td>
                                  <td>22000</td>
                                  <td><img src="<c:url value="/resources/images/auto.jpg" />" class="img-responsive img-thumbnail miniature-image" alt="Responsive image"></td>
                                  <td>Designer4</td>
                              </tr>
                              <tr>
                                  <td><a href="basic_table.html#">Total Ltd</a></td>
                                  <td class="col-md-3">Lorem Ipsum dolor</td>
                                  <td>555</td>
                                  <td>12120</td>
                                  <td> <img src="<c:url value="/resources/images/auto.jpg" />" class="img-responsive img-thumbnail miniature-image" alt="Responsive image"></td>
                                  <td>Designer5</td>
                              </tr>
                              </tbody>
                              </div>
                          </table>
                      </div>
                  </div>
              </div>
        </div>
  </div> 
  
  <div class="clearfix"> </div>
	<%@include file="/WEB-INF/views/footer.jsp" %>  
    <script src="<c:url value="/resources/js/jquery-1.7.min.js" />"> </script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script> 
   
	  

</body>
</html> 
