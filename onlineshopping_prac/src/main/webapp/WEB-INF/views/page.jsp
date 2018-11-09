<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Online Shopping Website Using Spring MVC and Hibernate">
<meta name="author" content="Khozema Nullwala">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

<title>Shop Homepage - ${title}</title>
<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>


<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->
		<div class="content">
			<!-- loading the home content -->
			<c:if test="${userClickHome == true}">
				<%@include file="./home.jsp"%>
			</c:if>


			<c:if test="${userClickAbout == true}">
				<%@include file="./about.jsp"%>
			</c:if>

			<c:if test="${userClickContact == true}">
				<%@include file="./contact.jsp"%>
			</c:if>
			
			<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true }">
				<%@include file="listProducts.jsp" %>
			</c:if>
			
			<c:if test="${userClickShowProduct == true }">
				<%@include file="singleProduct.jsp" %>
			</c:if>
		</div>
		<!-- footer comes here -->
		<%@include file="./shared/footer.jsp"%>
		
		<script src="${js}/jquery.js"></script>
		
		<!-- Bootstrap core JavaScript -->
		<%-- <script src="${js}/jquery.min.js"></script>
		
		 <script src="${js}/bootstrap.bundle.min.js"></script>--%>
		
		<script src="${js}/bootstrap.min.js"></script> 
		
		<script src="${js}/jquery.dataTables.js"></script>
		<%-- <script src="${js}/dataTables.bootstrap.js"></script> --%>
		
		
		<!--self coded java script  -->
		<script src="${js}/myapp.js"></script>

	</div>
</body>

</html>

<%-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Shopping</title>
</head>
<body>
	${contextRoot} says - ${greeting}
</body>
</html> --%>