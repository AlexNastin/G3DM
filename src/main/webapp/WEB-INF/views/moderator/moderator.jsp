<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Admin's page | Global3dmod</title>
<!-- Init search variable -->
<spring:message code="headerWithSearch.header.search" var="search"/>
<spring:message code="moderator.menu.postsunpublished" var="unpblsd"/>
<spring:message code="moderator.menu.postspublished" var="publics"/>
<spring:message code="moderator.menu.users" var="users"/>
<spring:message code="moderator.menu.designer" var="designers"/>


 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="global3dmod team">
    <link href="<c:url value="/resources/css/bootstrap.css"  />" rel="stylesheet" />
    <link href="<c:url value="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/cabinets/designer.css"  />" rel="stylesheet" />
     <link href="<c:url value="/resources/css/fontawesome430/css/font-awesome.css"  />" rel="stylesheet" />
    
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
  <a href="#" class="list-group-item active">
    <i class="fa fa-exclamation-triangle"></i> ${unpblsd}
  </a>
  <a href="<c:url value="/moderator/userstable" />" class="list-group-item"> <i class="fa fa-check-circle"></i> ${publics}</a>
  <a href="#" class="list-group-item"> <i class="fa fa-users"></i> ${users}</a>
  <a href="#" class="list-group-item"><i class="fa fa-pencil-square"></i> ${designers}</a>
  
</div>
      </div>
      <!--main content start-->
      
      <div class="nopadding2 col-md-10 ">
          <div class="mt">
                  <div class="col-md-12 nopadding2">
                      <div class="content-panel">
                          <table class="table table-striped table-advance table-hover">
                             <h2><i class="fa fa-angle-right"></i> Posts</h2>
                              <hr>
                              <!-- Some sorts for table -->
                              <div class="row">  
											  <div class="col-md-3">
											    <div class="input-group">
											      <input type="text" class="form-control" aria-label="..." placeholder="Sort posts...">
											      <div class="input-group-btn">
											        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Sort by: <span class="caret"></span></button>
											        <ul class="dropdown-menu dropdown-menu-right" role="menu">
											          <li><a href="#">By date</a></li>
											          <li><a href="#">By rating</a></li>
											          <li><a href="#">By downloads</a></li>											          
											          <li><a href="#">By name</a></li>
											        </ul>
											      </div><!-- /btn-group -->
											    </div><!-- /input-group -->
											  </div><!-- /.col-lg-6 -->
											</div><!-- /.row -->
                              <thead>
                              <tr>
                                  <th><i class="fa fa-bullhorn"></i> Project</th>
                                  <th class="hidden-phone"><i class="fa fa-question-circle"></i> Description</th>
                                  <th>Number</th>
                                  <th> Date </th>
                                  <th><i class="fa fa-bookmark"></i> Downloads</th>
                                  <th><i class=" fa fa-edit"></i> Status</th>
                                  <th><i class="fa fa-pencil"></i>Edit</th>
                              </tr>
                              </thead>
                              <tbody>
                              <tr>
                                  <td><a href="basic_table.html#">Draw</a></td>
                                  <td class="hidden-phone">Lorem Ipsum dolor</td>
                                  <td>1</td>
                                  <td>25-01.2015</td>
                                  <td>12000 </td>
                                  <td><span class="label label-success label-mini">published</span></td>
                                  <td>
                                      <button class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                              <tr>
                                  <td>
                                      <a href="basic_table.html#">
                                          Cup of tea
                                      </a>
                                  </td>
                                  <td>Lorem Ipsum dolor</td>
                                  <td>74</td>
                                  <td>25-01.2015</td>
                                  <td>17900 </td>
                                  <td><span class="label label-warning label-mini">moderating</span></td>
                                  <td>
                                      <button class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                              <tr>
                                  <td>
                                      <a href="basic_table.html#">
                                          Another Cup
                                      </a>
                                  </td>
                                  <td>Lorem Ipsum dolor</td>
                                  <td>752</td>
                                  <td>25-01.2015</td>
                                  <td>14400 </td>
                                  <td><span class="label label-success label-mini">Published</span></td>
                                  <td>
                                      <button class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                              <tr>
                                  <td>
                                      <a href="basic_table.html#">
                                          Bottle for dragons
                                      </a>
                                  </td>
                                  <td>Lorem Ipsum dolor</td>
                                  <td>78</td>
                                  <td>25-01.2015</td>
                                  <td>22000</td>
                                  <td><span class="label label-success label-mini">Published</span></td>
                                  <td>
                                      <button class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                              <tr>
                                  <td><a href="basic_table.html#">Total Ltd</a></td>
                                  <td>Lorem Ipsum dolor</td>
                                  <td>555</td>
                                  <td>25-01.2015</td>
                                  <td>12120</td>
                                  <td><span class="label label-warning label-mini">moderating</span></td>
                                  <td>
                                      <button class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                              </tbody>
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
