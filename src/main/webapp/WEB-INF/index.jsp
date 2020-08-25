<%-- 
    Document   : index
    Created on : 23/08/2020, 11:56:14 a. m.
    Author     : Adolfo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Tienda web Entel</title>
</head>
<body>
	<%@include file="./includ/head.jspf"%>
	<div class="container">
		<%--Para el body  --%>
		<c:forEach  items="${listadoProducto}" var="producto">
			<div class="card" style="width: 18rem;">
				<img src="..." class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title"><c:out value="${listado.nombreProducto}" /> </h5>
					<p class="card-text"><c:out value="${listado.descripcion}" />  </p>
					<a href="#" class="btn btn-primary">Añador al carrito</a>
				</div>
			</div>
		</c:forEach>

	</div>


	<%@include file="./includ/footer.jspf"%>
</body>
</html>
