<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<security:authorize access="hasRole('ROLE_USER')" var="userBool"/>
<security:authorize access="hasRole('ROLE_DESIGNER')" var="designerBool"/>
<security:authorize access="hasRole('ROLE_MODERATOR')" var="moderatorBool"/>
<security:authorize access="hasRole('ROLE_ADMIN')" var="adminBool"/>


<c:if test="${userBool}">
<c:set value="/user/profile" var="profileURL" />
</c:if>
<c:if test="${designerBool}">
<c:set value="/designer/profile" var="profileURL" />
</c:if>
<c:if test="${moderatorBool}">
<c:set value="/moderator/profile" var="profileURL" />
</c:if>
<c:if test="${adminBool}">
<c:set value="/admin/profile" var="profileURL" />
</c:if>

<div class="row nomargin placeForAds"> </div> 
<nav class="navbar navbar-default">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile and tablet display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-2">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="<c:url value="/"  />"><img class="navbar-brand" src="<c:url value="/resources/images/logo1.png" />" href="<c:url value="/"  />"></img></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbar-collapse-2">
            <ul class="nav navbar-nav navbar-left">
                <!-- put some links here -->
                <li><a class="fa fa-facebook-official fa-2x"></a></li>
                <li><a class="fa fa-twitter fa-2x"></a></li>
                <li><a class="fa fa-vk fa-2x"></a></li>
                
                
            </ul>
            <ul class="nav navbar-nav navbar-right">
           		<li><a href="<c:url value="/test"/>">TEST</a></li>
                <li><a href="<c:url value="/about"/>"><spring:message code="header.header.about" /></a></li>
                <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Partners <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">3d-hunters</a></li>
            <li><a href="#">print-me.org</a></li>
            <li><a href="#">you-do.info</a></li>
            <li class="divider"></li>
            <li><a href="#">hey-designer.me</a></li>
            <li class="divider"></li>
            <li><a href="#">One-3d.net</a></li>
          </ul>
        </li>
                <li><a href="<c:url value="/contact"/>"><spring:message code="header.header.contact" /></a></li>
                <li><a class="supernav" href="?locale=en">EN |</a>
                <li><a href="?locale=ru">RU</a></li>
                   
                    <li>
                   <security:authorize access="isAnonymous()">
                    <button type="button" class="btn btn-default btn-outline btn-circle navi" onClick='location.href="<c:url value="/go/signin" />"'>
      				<spring:message code="header.header.signin" />
      				</button>
      				</security:authorize>
      				<security:authorize access="hasAnyRole('ROLE_DESIGNER','ROLE_USER', 'ROLE_MODERATOR', 'ROLE_ADMIN')">
                    <button type="button" class="btn btn-default btn-outline btn-circle" onClick='location.href="<c:url value="/logout" />"'>
      				Logout
      				</button>
      				</security:authorize>
                </li>
                  <li>
      				<security:authorize access="hasAnyRole('ROLE_DESIGNER','ROLE_USER', 'ROLE_MODERATOR', 'ROLE_ADMIN')">
                    <button type="button" class="btn btn-default btn-outline btn-circle"  onClick='location.href="<c:url value="${profileURL}" />"'>
      				Profile
      				</button>
      				</security:authorize>
      		
                </li>
                
            </ul>

        </div><!-- /.navbar-collapse -->
    </div><!-- /.container -->
</nav><!-- /.navbar -->    
