<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Designer's page | Global3dmod</title>
<!-- Init search variable -->
<spring:message code="headerWithSearch.header.search" var="search"/>
<spring:message code="designer.menu.works" var="works"/>
<spring:message code="designer.menu.data" var="data"/>
<spring:message code="designer.menu.add" var="add"/>



 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="global3dmod team">
    <link href="<c:url value="/resources/css/bootstrap.css"  />" rel="stylesheet" />
    <link href="<c:url value="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"  />" rel="stylesheet" />
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
	     
	    
     
 <div class="row footerpadding">
    <div class="col-md-2 nopadding1">
     <div class="list-group">
      <img src="<c:url value="/resources/images/auto.jpg" />" class="img-responsive img-thumbnail" alt="Responsive image">      
  <a href="<c:url value="/designer/profile" />" class="list-group-item active">
    <i class="fa fa-briefcase"></i> ${works} 
  </a>
  
  <a href="#" class="list-group-item"><i class="fa fa-cogs"></i> ${data}  </a>
  <a href="<c:url value="/designer/addPost" />" class="list-group-item"><i class="fa fa-plus-square"></i> ${add}  </a>
  
	 </div>
    </div>
      <!--main content start-->
      
          <div class="row">
		<div class="col-md-10 nopadding2">
				
							<div class="mt">
                  <div class="col-md-12 nopadding2">
                      <div class="content-panel">
                          <table class="table table-striped table-advance table-hover">
                             <div> <h2> My works</h2>
                             
                              <thead>
                              <nav style="text-align:center">
  <ul class="pagination">
  <c:if test="${thisPage>1}">
    <li>
      <a href="<c:url value="/designer/profile?sort=${sortType}&page=${thisPage-1}" />" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    </c:if>
    <c:forEach begin="${startPage}" end="${endPage}" var="page">
    
    <li <c:if test="${page==thisPage}">class="active"</c:if>><a href="<c:url value="/designer/profile?sort=${sortType}&page=${page}" />">${page}</a></li>
    </c:forEach>
    
    <c:if test="${thisPage!=maxPage}">
    <li>
      <a href="<c:url value="/designer/profile?sort=${sortType}&page=${thisPage+1}" />" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
    </c:if>
  </ul>
</nav>
                              <tr class="background-user-string">
                              <th><i class="fa fa-folder-open-o"></i><a href="<c:url value="/designer/profile?sort=title&desc=${titleDesc}" />"> Project</a></th>
                              <th><i class="fa fa-th-list"></i><a href="<c:url value="/designer/profile?sort=category&desc=${categoryDesc}" />"> Category</a></th>
                              <th><i class="fa fa-list-alt"></i><a href="<c:url value="/designer/profile?sort=subcategory&desc=${subcategoryDesc}" />"> Subcategory</a></th>
                              <th><i class="fa fa-calendar"></i><a href="<c:url value="/designer/profile?sort=date&desc=${dateDesc}" />"> Date</a></th>
                              <th><i class="fa fa-book"></i> Number</th>
                              <th><i class="fa fa-cloud-download"></i><a href="<c:url value="/designer/profile?sort=downloads&desc=${downloadsDesc}" />"> Downloads</a></th>
                              <th><i class=" fa fa-edit"></i><a href="<c:url value="/designer/profile?sort=status&desc=${statusDesc}" />"> Status</a></th>
                              <th><i class="fa fa-pencil"></i> Edit</th>
                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach items="${listPostsLimit10}" var="post" >
                              <tr>
                                  <td><a href="basic_table.html#">${post.title}</a></td>
                                  <td class="hidden-phone">${post.category.title}</td>
                                  <td>${post.subcategory.title}</td>
                                  <td>${post.dateUpdate}</td>
                                  <td>${post.numberPost}</td>
                                  <td>${post.countDownload}</td>
                                  <c:if test="${post.isDisplay == 2}">
                                  	<td><span class="label label-success label-mini">published</span></td>
                                  </c:if>
                                     <c:if test="${post.isDisplay == 1}">
                                  	<td><span class="label label-warning label-danger">Rejected</span></td>
                                  </c:if>
                                  <c:if test="${post.isDisplay == 0}">
                                  	<td><span class="label label-warning label-mini">moderating</span></td>
                                  </c:if>
                                  <td>
                                      <button class="btn btn-primary btn-xs" data-toggle="modal" data-target="#edit"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-xs" data-toggle="modal" data-target="#myModal"><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                              </c:forEach>
                              </tbody>
                          </table>
                      </div>
      <!-- Delete modal -->                
   <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Confirm?</h4>
      </div>
      <div class="modal-body">
        Are you realy wanna delete this file?
      </div>
      <div class="modal-footer">
        <a type="button" class="btn btn-default" data-dismiss="modal">Close</a>
        <a type="button" class="btn btn-danger">Delete post</a>
      </div>
    </div>
  </div>
</div>
<!-- Edit modal -->
<div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Confirm?</h4>
      </div>
      <div class="modal-body">
        After edditing, your post will go to the moderator
      </div>
      <div class="modal-footer">
        <a type="button" class="btn btn-default" data-dismiss="modal">Close</a>
        <a type="button" class="btn btn-primary">Edit</a>
      </div>
    </div>
  </div>
</div>
                      <nav style="text-align:center">
  <ul class="pagination">
  <c:if test="${thisPage>1}">
    <li>
      <a href="<c:url value="/designer/profile?sort=${sortType}&page=${thisPage-1}" />" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    </c:if>
    <c:forEach begin="${startPage}" end="${endPage}" var="page">
    
    <li <c:if test="${page==thisPage}">class="active"</c:if>><a href="<c:url value="/designer/profile?sort=${sortType}&page=${page}" />">${page}</a></li>
    </c:forEach>
    
    <c:if test="${thisPage!=maxPage}">
    <li>
      <a href="<c:url value="/designer/profile?sort=${sortType}&page=${thisPage+1}" />" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
    </c:if>
  </ul>
</nav>
                  </div>
              </div>
              
						
			</div>
			
  </div> 
  
  
  <div class="clearfix"> </div>
  </div>
	<%@include file="/WEB-INF/views/footer.jsp" %>  
    <script src="<c:url value="/resources/js/jquery-1.7.min.js" />"> </script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script> 
   
	  

</body>
</html> 
