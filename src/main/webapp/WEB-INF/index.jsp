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
<title>::: Tienda Entel ::: - Bienvenido</title>

<base target="_parent">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.11.0/css/all.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&amp;display=swap">
<link rel="stylesheet"
	href="https://mdbootstrap.com/api/snippets/static/download/MDB-Pro_4.19.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://mdbootstrap.com/api/snippets/static/download/MDB-Pro_4.19.1/css/mdb.min.css">
<link rel="stylesheet"
	href="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/css/compiled-addons-4.19.1.min.css">
<link rel="stylesheet" type="text/css"
	href="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/css/mdb-plugins-gathered.min.css">
<style></style>
<style type="text/css">
/* Chart.js */
@-webkit-keyframes chartjs-render-animation {
	from {opacity: 0.99
}

to {
	opacity: 1
}

}
@keyframes chartjs-render-animation {
	from {opacity: 0.99
}

to {
	opacity: 1
}

}
.chartjs-render-monitor {
	-webkit-animation: chartjs-render-animation 0.001s;
	animation: chartjs-render-animation 0.001s;
}
</style>
<link rel="icon" type="image/png"
	href="https://icons.iconarchive.com/icons/aha-soft/business-toolbar/48/payment-icon.png" />

</head>
<body>



	<%@include file="./includ/head.jspf"%>

	<div id="carousel-example-2"
		class="carousel slide carousel-fade z-depth-1-half"
		data-ride="carousel">
		<!--Indicators-->
		<ol class="carousel-indicators">
			<li data-target="#carousel-example-2" data-slide-to="0"
				class="active"></li>
			<li data-target="#carousel-example-2" data-slide-to="1"></li>
			<li data-target="#carousel-example-2" data-slide-to="2"></li>
		</ol>
		<!--/.Indicators-->
		<!--Slides-->
		<div class="carousel-inner" role="listbox">
			<div class="carousel-item active">
				<div class="view">
					<img class="d-block w-100"
						src="https://mdbootstrap.com/img/Photos/Slides/img%20(105).jpg"
						alt="First slide">
					<div class="mask rgba-black-light"></div>
				</div>
				<div class="carousel-caption">
					<h3 class="h3-responsive">This is the first title</h3>
					<p>First text</p>
				</div>
			</div>
			<div class="carousel-item">
				<!--Mask color-->
				<div class="view">
					<img class="d-block w-100"
						src="https://mdbootstrap.com/img/Photos/Slides/img%20(115).jpg"
						alt="Second slide">
					<div class="mask rgba-black-light"></div>
				</div>
				<div class="carousel-caption">
					<h3 class="h3-responsive">Thir is the second title</h3>
					<p>Secondary text</p>
				</div>
			</div>
			<div class="carousel-item">
				<!--Mask color-->
				<div class="view">
					<img class="d-block w-100"
						src="https://mdbootstrap.com/img/Photos/Slides/img%20(108).jpg"
						alt="Third slide">
					<div class="mask rgba-black-light"></div>
				</div>
				<div class="carousel-caption">
					<h3 class="h3-responsive">This is the third title</h3>
					<p>Third text</p>
				</div>
			</div>
		</div>
		<!--/.Slides-->
		<!--Controls-->
		<a class="carousel-control-prev" href="#carousel-example-2"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carousel-example-2"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
		<!--/.Controls-->
	</div>

	<div>
		<%--Para el body  --%>
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center">
					<h2>Lo mas vendido...!</h2>
				</div>
			</div>
			<div class="row">
				<c:forEach items="${listadoProducto}" var="productos">
				<div class="card col-md-3 pt-3 m-3" style="width: 18rem;">
					<img src="..." class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title"> ${productos.nombreProducto} </h5>
						<p class="card-text">${productos.descripcion} </p>
						<h5 class="card-title">Precio  ${productos.precioUnidad} </h5>
						<a href="#" class="btn btn-primary">Anadir al carrito</a>
					</div>
				</div>
				</c:forEach>
			</div>
		</div>



		<%@include file="./includ/footer.jspf"%>
</body>
</html>
