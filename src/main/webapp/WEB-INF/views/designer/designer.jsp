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
     <link href="<c:url value="/resources/css/cabinets/font-awesome/css/font-awesome.css"  />" rel="stylesheet" />
    
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
    <i class="fa fa-briefcase"></i> ${works} 
  </a>
  
  <a href="#" class="list-group-item"><i class="fa fa-info-circle"></i> ${data}  </a>
  <a href="#" class="list-group-item"><i class="fa fa-plus-square"></i> ${add}  </a>
  
</div>
      </div>
      <!--main content start-->
      
          <div class="row">
		<div class="col-md-10 nopadding2">
			
			<div class="tabbable-panel">
				<div class="tabbable-line">
					<ul class="nav nav-tabs ">
						<li class="active">
							<a href="#tab_default_1" data-toggle="tab">
							List view <i class="fa fa-list"></i> </a>
						</li>
						<li>
							<a href="#tab_default_2" data-toggle="tab">
							Metro style <i class="fa fa-table"></i> </a>
						</li>
						
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="tab_default_1">
							<div class="mt">
                  <div class="col-md-12 nopadding2">
                      <div class="content-panel">
                          <table class="table table-striped table-advance table-hover">
                             <div> <h2><i class="fa fa-angle-right"></i> My works</h2>
                              <hr>
                              <thead>
                              <tr>
                                  <th><i class="fa fa-bullhorn"></i> Project</th>
                                  <th>Category</th>
                                  <th>Subcategory</th>
                                  <th>Date</th>
                                  <th>Number</th>
                                  <th><i class="fa fa-bookmark"></i> Downloads</th>
                                  <th><i class=" fa fa-edit"></i> Status</th>
                                  <th><i class="fa fa-pencil"></i>Edit</th>
                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach items="${listPostsByDesigner}" var="post" >
                              <tr>
                                  <td><a href="basic_table.html#">${post.title}</a></td>
                                  <td class="hidden-phone">${post.category.title}</td>
                                  <td>${post.subcategory.title}</td>
                                  <td>${post.dateUpdate}</td>
                                  <td>${post.numberPost}</td>
                                  <td>${post.countDownload}</td>
                                  <c:if test="${post.isDisplay}">
                                  	<td><span class="label label-success label-mini">published</span></td>
                                  </c:if>
                                  <c:if test="${!post.isDisplay}">
                                  	<td><span class="label label-warning label-mini">moderating</span></td>
                                  </c:if>
                                  <td>
                                      <button class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                              </c:forEach>
                              </tbody>
                          </table>
                      </div>
                  </div>
              </div>
              
						</div>
						<div class="tab-pane" id="tab_default_2">
							 <section id="portfolio">
        <div class="container">
            <div class="row portfolio-items"> <!--1st element-->
                <div class="portfolio-item apps  col-md-3">
                        <div class="item-inner">
                            <div class="portfolio-image">
                                <img src="<c:url value="/resources/images/auto.jpg" />" alt="">
                                <div class="overlay container">
                                    <div class="menuis">
                                    <a class="preview btn btn-primary" title="Lorem ipsum dolor sit amet">Avtomobilpppe</a>
                                    <p><a href="dsfds">mexico</a></p>
                                    </div>
                                </div>
                            </div>
                            <h5>1</h5>
                        </div>
                    </div>
                    <!--/.portfolio-item 2 -->
                <div class="portfolio-item apps  col-md-3">
                    <div class="item-inner">
                        <div class="portfolio-image">
                            <img src="<c:url value="/resources/images/auto.jpg" />" alt="">
                            <div class="overlay container">
                                <div class="menuis">
                                    <a class="preview btn btn-primary" title="Lorem ipsum dolor sit amet">Avtomobilpppe</a>
                                    <p><a href="dsfds">mexico</a></p>
                                </div>
                            </div>
                        </div>
                        <h5>2</h5>
                    </div>
                </div>
                     <!--/.portfolio-item 3 -->
                <div class="portfolio-item apps  col-md-3">
                    <div class="item-inner">
                        <div class="portfolio-image">
                            <img src="<c:url value="/resources/images/auto.jpg" />" alt="">
                            <div class="overlay container">
                                <div class="menuis">
                                    <a class="preview btn btn-primary" title="Lorem ipsum dolor sit amet">Avtomobilpppe</a>
                                    <p><a href="dsfds">mexico</a></p>
                                </div>
                            </div>
                        </div>
                        <h5>3</h5>
                    </div>
                </div>
                 <!--/.portfolio-item 4 -->
                         <div class="portfolio-item apps col-md-3">
                     <div class="item-inner">
                         <div class="portfolio-image">
                             <img src="<c:url value="/resources/images/auto.jpg" />" alt="">
                             <div class="overlay container">
                                 <div class="menuis">
                                     <a class="preview btn btn-primary" title="Lorem ipsum dolor sit amet">Avtomobile</a>
                                     <p><a href="dsfds">mexico</a></p>
                                 </div>
                             </div>
                         </div>

                         <h5>4</h5>
                     </div>
                             </div>
                         </div>
            <div class="row portfolio-items">
                <!--1st element-->
                <div class="portfolio-item apps  col-md-3">
                    <div class="item-inner">
                        <div class="portfolio-image">
                            <img src="<c:url value="/resources/images/auto.jpg" />" alt="">
                            <div class="overlay container">
                                <div class="menuis">
                                    <a class="preview btn btn-primary" title="Lorem ipsum dolor sit amet">Avtomobilpppe</a>
                                    <p><a href="dsfds">mexico</a></p>
                                </div>
                            </div>
                        </div>
                        <h5>5</h5>
                    </div>
                </div>
                <!--/.portfolio-item 2 -->
                <div class="portfolio-item apps  col-md-3">
                    <div class="item-inner">
                        <div class="portfolio-image">
                            <img src="<c:url value="/resources/images/auto.jpg" />" alt="">
                            <div class="overlay container">
                                <div class="menuis">
                                    <a class="preview btn btn-primary" title="Lorem ipsum dolor sit amet">Avtomobilpppe</a>
                                    <p><a href="dsfds">mexico</a></p>
                                </div>
                            </div>
                        </div>
                        <h5>6</h5>
                    </div>
                </div>
                <!--/.portfolio-item 3 -->
                <div class="portfolio-item apps  col-md-3">
                    <div class="item-inner">
                        <div class="portfolio-image">
                            <img src="<c:url value="/resources/images/auto.jpg" />" alt="">
                            <div class="overlay container">
                                <div class="menuis">
                                    <a class="preview btn btn-primary" title="Lorem ipsum dolor sit amet">Avtomobilpppe</a>
                                    <p><a href="dsfds">mexico</a></p>
                                </div>
                            </div>
                        </div>
                        <h5>Lorem ipsum dolor sit amet</h5>
                    </div>
                </div>
                <!--/.portfolio-item 4 -->
                <div class="portfolio-item apps col-md-3">
                    <div class="item-inner">
                        <div class="portfolio-image">
                            <img src="<c:url value="/resources/images/auto.jpg" />" alt="">
                            <div class="overlay container">
                                <div class="menuis">
                                    <a class="preview btn btn-primary" title="Lorem ipsum dolor sit amet">Avtomobile</a>
                                    <p><a href="dsfds">mexico</a></p>
                                </div>
                            </div>
                        </div>

                        <h5>Lorem ipsum dolor sit amet</h5>
                    </div>
                </div>
            </div>
            <!--3rd line-->
            <div class="row portfolio-items">
                <!--1st element-->
                <div class="portfolio-item apps  col-md-3">
                    <div class="item-inner">
                        <div class="portfolio-image">
                            <img src="<c:url value="/resources/images/auto.jpg" />" alt="">
                            <div class="overlay container">
                                <div class="menuis">
                                    <a class="preview btn btn-primary" title="Lorem ipsum dolor sit amet">Avtomobilpppe</a>
                                    <p><a href="dsfds">mexico</a></p>
                                </div>
                            </div>
                        </div>
                        <h5>Lorem ipsum dolor sit amet</h5>
                    </div>
                </div>
                <!--/.portfolio-item 2 -->
                <div class="portfolio-item apps  col-md-3">
                    <div class="item-inner">
                        <div class="portfolio-image">
                            <img src="<c:url value="/resources/images/auto.jpg" />" alt="">
                            <div class="overlay container">
                                <div class="menuis">
                                    <a class="preview btn btn-primary" title="Lorem ipsum dolor sit amet">Avtomobilpppe</a>
                                    <p><a href="dsfds">mexico</a></p>
                                </div>
                            </div>
                        </div>
                        <h5>Lorem ipsum dolor sit amet</h5>
                    </div>
                </div>
                <!--/.portfolio-item 3 -->
                <div class="portfolio-item apps  col-md-3">
                    <div class="item-inner">
                        <div class="portfolio-image">
                            <img src="<c:url value="/resources/images/auto.jpg" />" alt="">
                            <div class="overlay container">
                                <div class="menuis">
                                    <a class="preview btn btn-primary" title="Lorem ipsum dolor sit amet">Avtomobilpppe</a>
                                    <p><a href="dsfds">mexico</a></p>
                                </div>
                            </div>
                        </div>
                        <h5>Lorem ipsum dolor sit amet</h5>
                    </div>
                </div>
                <!--/.portfolio-item 4 -->
                <div class="portfolio-item apps col-md-3">
                    <div class="item-inner">
                        <div class="portfolio-image">
                            <img src="<c:url value="/resources/images/auto.jpg" />" alt="">
                            <div class="overlay container">
                                <div class="menuis">
                                    <a class="preview btn btn-primary" title="Lorem ipsum dolor sit amet">Avtomobile</a>
                                    <p><a href="dsfds">mexico</a></p>
                                </div>
                            </div>
                        </div>

                        <h5>Lorem ipsum dolor sit amet</h5>
                    </div>
                </div>
            </div>
                         </div>


    </section><!--/#portfolio-->
						</div>
						
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
