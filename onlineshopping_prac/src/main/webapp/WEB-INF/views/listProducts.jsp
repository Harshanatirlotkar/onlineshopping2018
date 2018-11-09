<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">


	<div class="row">

		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
			
	</div>
		<!-- to display actual products -->
		<div class="col-md-9">
			<div class="row">

				<div class="col-lg-12">
					<c:if test="${userClickAllProducts == true}">
					
					<script>
						window.categoryId = '';
					
					</script>
					<ol class="breadcrumb">

						<li><a href="${contextRoot}/home">Home</a></li>

						<li class="active">All Products</li>

					</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts == true }">
					<script>
						window.categoryId = ${category.id};
					
					</script>
					<ol class="breadcrumb">

						<li><a href="${contextRoot}/home">Home</a></li>
						<li class="active">Category</li>
						<li class="active">${category.name}</li>

					</ol>
					</c:if>
					
					
				</div>



			</div>

			<div class="row">
				<div class="col-xs-12">
				
					<table id="productListTable" class="table table-striped table-borderd">
						<thead>
							<tr>
							<td></td>
							<td>ID</td>
							<td>NAME</td>
							<td>Price</td>
							<td>Qty. available</td>
							<td></td>
							</tr>
						
						
						</thead>
						
						
						<tfoot>
							<tr>
							<td></td>
							<td>ID</td>
							<td>NAME</td>
							<td>Price</td>
							<td>Qty. available</td>
							<td></td>
							
							</tr>
						
						
						</tfoot>
					</table>
				
				</div>
			
			
			</div>
		</div>

	</div>



</div>