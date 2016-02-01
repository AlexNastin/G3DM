<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>

<spring:message code="footer.footer.about" var="about" />
<spring:message code="footer.footer.contact" var="contact" />
<spring:message code="footer.footer.ourmission" var="ourmission" />
<spring:message code="footer.footer.team" var="team" />
<spring:message code="footer.footer.jobs" var="jobs" />
<spring:message code="footer.footer.blog" var="blog" />
<spring:message code="footer.footer.tocustomers" var="tocustomers" />
<spring:message code="footer.footer.tocustomershowitworks"
	var="tocustomershowitworks" />
<spring:message code="footer.footer.tocustomerssafety"
	var="tocustomerssafety" />
<spring:message code="footer.footer.todesigners" var="todesigners" />
<spring:message code="footer.footer.todesignershowitworks"
	var="todesignershowitworks" />
<spring:message code="footer.footer.todesignerslicense"
	var="todesignerslicense" />
<spring:message code="footer.footer.questions" var="questions" />
<spring:message code="footer.footer.needhelp" var="needhelp" />
<spring:message code="footer.footer.support" var="support" />
<spring:message code="footer.footer.fileconversions"
	var="fileconversions" />
<spring:message code="footer.footer.privacypolicy" var="privacypolicy" />
<spring:message code="blog" var="blogLink" />



</head>
<body>
	<div class="footer position-sign sign-footer-margin">
		<div class="container">
			<div class="footer_grids">
				<div class="footer-grid">
					<h4>${about}</h4>
					<ul class="list1">
						<li><a href="<c:url value="/contact" />">${contact}</a></li>
						<li><a href="<c:url value="/mission" />">${ourmission}</a></li>
						<li><a href="<c:url value="/team" />">${team}</a></li>
						<li><a href="<c:url value="/jobs" />">${jobs}</a></li>
						<li><a href="<c:url value="${blogLink}" />">${blog}</a></li>
					</ul>
				</div>
				<div class="footer-grid">
					<h4>${tocustomers}</h4>
					<ul class="list1">
						<li><a href="<c:url value="/license#user" />">${tocustomershowitworks}</a></li>
						<li><a href="<c:url value="/safety" />">${tocustomerssafety}</a></li>
					</ul>
				</div>
				<div class="footer-grid">
					<h4>${todesigners}</h4>
					<ul class="list1">
						<li><a href="<c:url value="/license#designer" />">${todesignershowitworks}</a></li>
						<li><a href="<c:url value="/license" />">${todesignerslicense}</a></li>
					</ul>
				</div>
				<div class="footer-grid">
					<h4>${questions}</h4>
					<ul class="list1">
						<li><a href="<c:url value="/help" />">${needhelp}</a></li>
						<li><a href="<c:url value="/support" />">${support}</a></li>
						<li><a href="<c:url value="/fileConversions" />">${fileconversions}</a></li>
						<li><a href="<c:url value="/policy" />">${privacypolicy}</a></li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		© 2016 Global3Dmod.com
	</div>




</body>
</html>