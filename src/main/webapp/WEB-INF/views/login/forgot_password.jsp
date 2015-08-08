<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Forgot password | Global3DMod</title>
<!-- Init search variable -->

 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="global3dmod team">
    <meta name="keywords" content="3d printer, 3d model, 3d model free, 3d model download, 3d model download free, model to print 3d printer free, stl, stl download,stl download free, 3d designer, 3d model robot, 3д модель, 3д принтер, 3д модель скачать, 3д модель скачать напечатать, 3д дизайнер, stl бесплатные, stl скачать, global3dmod, global 3d mod "> 
    
    <spring:message code="email.message.resetPassword.enteremailmessage" var="enteremailmessage"/>
   
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/404.css"  />" rel="stylesheet" />
     <link href="<c:url value="/resources/css/fontawesome430/css/font-awesome.min.css"  />" rel="stylesheet" />
     <link rel="icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon">
   
<body>
<%@include file="/WEB-INF/views/header/header.jsp" %>   
<div class="container">
    <div class="row">
        <div class="col-md-12" style="padding-top: 3em;" >
    <h1 style="text-align:center"><i class="fa fa-envelope-o"></i> ${enteremailmessage} <i class="fa fa-envelope-o"></i></h1>
    <div class="col-md-4"></div>
    <div class="col-md-4">
            <div class="error-template" style="min-height:45em;">
               
               <form action="<c:url value="/resetPassword"></c:url>" method="POST">
				<input class="form-control" required id="email" name="email"	type="email" value="" placeholder="Email" />
				<input style="margin-top: 10px;" type="submit"  class="btn btn-primary" />
			   </form>
			   <c:if  test="${message != null}">
			  <div class="alert alert-info" role="alert" style="margin-top: 3%; padding:1%">${message}</div> 
			   </c:if>
		</div>
	</div>
	</div>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script type="text/javascript">
		function resetPass() {
			var email = $("#email").val();
			$.post("<c:url value="/resetPassword"></c:url>",{email : email},
					function(data){
	            window.location.href = 
	              "<c:url value="/go/signin"></c:url>" + "?message=" + data.message;
	    })
	    .fail(function(data) {
	        if(data.responseJSON.error.indexOf("MailError") > -1) {
	            window.location.href = 
	              "<c:url value="/emailError.html"></c:url>";
	        }
	        else {
	            window.location.href = 
	              "<c:url value="/login.html"></c:url>" + "?message=" + data.responseJSON.message;
	        }
	    });
	}
	</script>
            </div>
        </div>
   

<%@include file="/WEB-INF/views/footer.jsp" %>  
    <script src="<c:url value="/resources/js/jquery-1.7.min.js" />"> </script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script> 
    <script src="<c:url value="/resources/js/slider/modernizr.custom.63321.js" />"> </script> 
    <script src="<c:url value="/resources/js/slider/jquery.catslider.js" />"> </script> 
</body>
</html>