<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Footer</title>
<spring:message code="footer.footer.about" var="about"/>
<spring:message code="footer.footer.contact" var="contact"/>
<spring:message code="footer.footer.ourmission" var="ourmission"/>
<spring:message code="footer.footer.team" var="team"/>
<spring:message code="footer.footer.whywe" var="whywe"/>
<spring:message code="footer.footer.jobs" var="jobs"/>
<spring:message code="footer.footer.blog" var="blog"/>
<spring:message code="footer.footer.tocustomers" var="tocustomers"/>
<spring:message code="footer.footer.tocustomershowitworks" var="tocustomershowitworks"/>
<spring:message code="footer.footer.tocustomerssafety" var="tocustomerssafety"/>
<spring:message code="footer.footer.tocustomerssignup" var="tocustomerssignup"/>
<spring:message code="footer.footer.todesigners" var="todesigners"/>
<spring:message code="footer.footer.todesignershowitworks" var="todesignershowitworks"/>
<spring:message code="footer.footer.todesignerslicense" var="todesignerslicense"/>
<spring:message code="footer.footer.todesignerssignup" var="todesignerssignup"/>
<spring:message code="footer.footer.questions" var="questions"/>
<spring:message code="footer.footer.needhelp" var="needhelp"/>
<spring:message code="footer.footer.support" var="support"/>
<spring:message code="footer.footer.fileconversions" var="fileconversions"/>
<spring:message code="footer.footer.privacypolicy" var="privacypolicy"/>

</head>


   </head>
<body>
<div class="footer">
    <div class="container">
        <div class="footer_grids">
            <div class="footer-grid">
                <h4>${about}</h4>
                <ul class="list1">
                    <li><a href="contact.html">${contact}</a></li>
                    <li><a href="#">${ourmission}</a></li>
                    <li><a href="#">${team}</a></li>
                    <li><a href="#">${whywe}</a></li>
                    <li><a href="#">${jobs}</a></li>
                    <li><a href="#">${blog}</a></li>
                 </ul>
            </div>
            <div class="footer-grid">
                <h4>${tocustomers}</h4>
                <ul class="list1">
                    <li><a href="#">${tocustomershowitworks}</a></li>
                    <li><a href="#">${tocustomerssafety}</a></li>
                    <li><a href="#">${tocustomerssignup}</a></li>
                </ul>
            </div>
            <div class="footer-grid">
                <h4>${todesigners}</h4>
                <ul class="list1">
                    <li><a href="#">${todesignershowitworks}</a></li>
                    <li><a href="#">${todesignerslicense}</a></li>
                    <li><a href="#">${todesignerssignup}</a></li>
                </ul>
            </div>
            <div class="footer-grid">
                <h4>${questions}</h4>
                <ul class="list1">
                    <li><a href="#">${needhelp}</a></li>
                    <li><a href="#">${support}</a></li>
                    <li><a href="#">${fileconversions}</a></li>
                    <li><a href="#">${privacypolicy}</a></li>
                </ul>
            </div>
            <div class="clearfix"> </div>
        </div>
      </div>
</div>
      
    
    
</body>
</html>