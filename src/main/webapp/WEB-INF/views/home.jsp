<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>


<div class = container>
	<p class="color">Language :</p>
	<a href="?locale=en">English</a>|
	<a href="?locale=ru">Russian</a>
	<br />
	
	
	<h3>
		<spring:message code="label.users" />
	</h3>
	<c:if test="${!empty userList}">
		<table class="data">
			<tr>
				<th><spring:message code="label.login" /></th>
				<th><spring:message code="label.password" /></th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.login}</td>
					<td>${user.password}</td>
					<td><a href="delete/user/${user.idUser}"><spring:message
								code="label.delete" /></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
