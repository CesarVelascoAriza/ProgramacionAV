<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Historil de compras</title>
<%@include file="../includ/head.jspf"%>
</head>
<body>
	<%@include file="../includ/header.jspf"%>
	<br>
		<div class="contenedor-full" >
			<div class="container-fluid" >
				<div class="container">
					<c:forEach items="${ListadoFactura}" var="productos">
						<div class="card mb-3" style="max-width: 540px;">
						  <div class="row no-gutters">
						    <div class="col-md-4">
						      <img src="${productos.rutaImagen}" class="card-img" alt="...">
						    </div>
						    <div class="col-md-8">
						      <div class="card-body">
						        <h5 class="card-title">${productos.nombreProducto}</h5>
						        <p class="card-text">${productos.descripcion}</p>
						        
						      </div>
						    </div>
						  </div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>	
	<br>
	  <%@include file="../includ/footer.jspf"%>
</body>
</html>