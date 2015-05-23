<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Posts control page | Global3dmod</title>
<!-- Init search variable -->

<spring:message code="moderator.menu.postsunpublished" var="unpblsd"/>
<spring:message code="moderator.menu.postspublished" var="publics"/>
<spring:message code="moderator.menu.users" var="users"/>
<spring:message code="moderator.menu.designer" var="designers"/>
<spring:message code="headerWithSearch.header.search" var="search"/>

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
    <link rel="icon" href="<c:url value="resources/images/favicon.png" />" type="image/x-icon">
   </head>
<body>
<!-- Here some place for ads. After placing ads you may delete "placeforads" css class in header -->

	<%@include file="/WEB-INF/views/header/headerWithSearch.jsp" %>  
	<!-- Designer's page will start here -->
            
      <div class="row">
      <div class="col-md-2 nopadding1">
      <div class="list-group">
      <img src="<c:url value="/resources/images/auto.jpg" />" class="img-responsive img-thumbnail" alt="Responsive image">      
  <a href="<c:url value="/moderator/profile" />" class="list-group-item">
    <i class="fa fa-exclamation-triangle"></i> ${unpblsd}
  </a>
  <a href="<c:url value="/moderator/userstable" />" class="list-group-item active"> <i class="fa fa-check-circle"></i> ${publics}</a>
  <a href="#" class="list-group-item"> <i class="fa fa-users"></i> ${users}</a>
  <a href="#" class="list-group-item"><i class="fa fa-paint-brush"></i> ${designers}</a>
</div>
      </div>
      <!--main content start-->
      
      <div class="nopadding2 col-md-10 ">
          <div class="mt">
                  <div class="col-md-12 nopadding2">
                      <div class="content-panel">
                          <table class="table table-striped table-advance table-hover">
                             <div> <h2><i class="fa fa-angle-right"></i> Users</h2>
                              <hr>
                              
                              
                              <div class="row">
                              <form class="form-horizontal">
								<fieldset>
<!-- Select Basic -->
									<div class="row">
									<div class="control-group">
									  <label class="control-label" for="selectbasic">Sort by</label>
									  <div class="controls">
									    <select id="selectbasic" name="selectbasic" class="input-xlarge">
									      <option>ID</option>
									      <option>Rating</option>
									    </select>
									  </div>
									</div>

<!-- Multiple Checkboxes (inline) -->
									<div class="control-group">
									  <label class="control-label" for="checkboxes">Choose type</label>
									  <div class="controls">
									    <label class="checkbox-inline" for="checkboxes-0">
									      <input type="checkbox" name="checkboxes" id="checkboxes-0" value="1">
									      Not active
									    </label>
									    <label class="checkbox-inline" for="checkboxes-1">
									      <input type="checkbox" name="checkboxes" id="checkboxes-1" value="2">
									      Blocked
									    </label>
									    <label class="checkbox-inline" for="checkboxes-2">
									      <input type="checkbox" name="checkboxes" id="checkboxes-2" value="3">
									      Active
									    </label>
									    
									  </div>
									</div>
									</div>
									
									</fieldset>
									<input class="btn btn-default" type="submit" value="Submit">
									</form>
									                              
                              <thead>
                              <tr>
                                  <th><i class="fa fa-bullhorn"></i> Name</th>
                                  <th class="hidden-phone"><i class="fa fa-question-circle"></i> Login</th>
                                  <th><i class="glyphicon glyphicon-user"></i>ID</th>
                                  <th><i class="fa fa-bookmark"></i> Role</th>
                                  <th><i class="glyphicon glyphicon-calendar"></i> Date of sign up</th>
                                  <th><i class="glyphicon glyphicon-thumbs-up"></i>Rating</th>
                                  <th><i class=" fa fa-edit"></i> Status</th>
                                  <th><i class="fa fa-pencil"></i>Edit</th>
                              </tr>
                              </thead>
                              <tbody>
                              <tr>
                                  <td><a href="basic_table.html#">Christoph Shmidt</a></td>
                                  <td class="hidden-phone">Lorem Ipsum dolor</td>
                                  <td>1</td>
                                  <td>12000 </td>
                                  <td>25-02-2012</td>
                                  <td>111</td>
                                  <td><span class="label label-success label-mini">Active</span></td>
                                  <td>
                                      <button class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                              <tr>
                                  <td>
                                      <a href="basic_table.html#">
                                          Cabaka
                                      </a>
                                  </td>
                                  <td>Lorem Ipsum dolor</td>
                                  <td>74</td>
                                  <td>17900 </td>
                                  <td>25-02-2012</td>
                                  <td>111</td>
                                  <td><span class="label label-warning label-mini">Blocked</span></td>
                                  <td>
                                      <button class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                              <tr>
                                  <td>
                                      <a href="basic_table.html#">
                                          CreaRec
                                      </a>
                                  </td>
                                  <td>Lorem Ipsum dolor</td>
                                  <td>752</td>
                                  <td>14400 </td>
                                  <td>25-02-2012</td>
                                  <td>111</td>
                                  <td><span class="label label-success label-mini">Active</span></td>
                                  <td>
                                      <button class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                              <tr>
                                  <td>
                                      <a href="basic_table.html#">
                                         Persyk
                                      </a>
                                  </td>
                                  <td>Lorem Ipsum dolor</td>
                                  <td>78</td>
                                  <td>22000</td>
                                  <td>25-02-2012</td>
                                  <td>111</td>
                                  <td><span class="label label-success label-mini">Active</span></td>
                                  <td>
                                      <button class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                              <tr>
                                  <td><a href="basic_table.html#">LostAngel</a></td>
                                  <td>Lorem Ipsum dolor</td>
                                  <td>555</td>
                                  <td>12120</td>
                                  <td>25-02-2012</td>
                                  <td>111</td>
                                  <td><span class="label label-info label-mini">Not active</span></td>
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
