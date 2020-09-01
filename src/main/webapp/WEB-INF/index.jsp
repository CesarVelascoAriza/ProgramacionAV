<%--
    Document   : index
    Created on : 23/08/2020, 11:56:14 a. m.
    Author     : Adolfo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <%@include file="./includ/head.jspf"%>
    <body>

        <%@include file="./includ/header.jspf"%>

        <div id="carousel-example-2"
             class="carousel slide carousel-fade z-depth-1-half container mt-4 mb-4 pt-2 pb-2"
             data-ride="carousel">
            <!--Indicators-->
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-2" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-2" data-slide-to="1"></li>
                <li data-target="#carousel-example-2" data-slide-to="2"></li>
            </ol>
            <!--/.Indicators-->
            <!--Slides-->
            <div class="carousel-inner" role="listbox">
                <div class="carousel-item active">
                    <div class="view">
                        <img class="d-block w-100" height="500" src="https://cdn.pixabay.com/photo/2018/01/29/19/45/people-3116994_960_720.jpg" alt="Gente, Mercado, Vender, Mexicanos, México, Noticias, Cerámica">
                        <div class="mask rgba-black-light"></div>
                    </div>
                    <div class="carousel-caption">
                        <h3 class="h3-responsive">¿Hay alguna razón por la que, si le damos el producto a este precio, no aceptaría trabajar con nosotros?</h3>
                        <p>La inacción genera dudas y miedo. La acción genera confianza y coraje. Si quieres conquistar el miedo, no te sientes en casa y pienses en ello. Sal fuera  y busca algo que hacer</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <!--Mask color-->
                    <div class="view">
                        <img class="d-block w-100"
                             height="500"
                             src="https://cdn.pixabay.com/photo/2017/08/22/16/06/market-2669499_960_720.jpg" alt="Mercado, frutos secos, vender, comida, puesto en el mercado, selección, comprar">
                        <div class="mask rgba-black-light"></div>
                    </div>
                    <div class="carousel-caption">
                        <h3 class="h3-responsive">Aproveche nuestros mejores productos...!</h3>
                        <p>Cualquier cosa que la mente del hombre pueda concebir y creer, puede lograr</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <!--Mask color-->
                    <div class="view">
                        <img class="d-block w-100"
                             height="500"
                             src="https://cdn.pixabay.com/photo/2014/09/04/11/03/supermarket-435452_960_720.jpg" alt="Supermercado, compras, ventas, tienda, compra, tienda">
                        <div class="mask rgba-black-light"></div>
                    </div>
                    <div class="carousel-caption">
                        <h3 class="h3-responsive">Crezca con nostros.</h3>
                        <p>uando todo parezca ir en tu contra, recuerda que los aviones siempre despegan contra el viento, no a favor</p>
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


        <%--Para el body  --%>
        <div id="carousel-example-2"
             class="carousel slide carousel-fade z-depth-1-half container mt-4 mb-4 pt-2 pb-2"
             data-ride="carousel">
            <div class="row">
                <div class="col-md-12 text-center">
                    <h4 class="title">Lo mas vendido...!</h2>
                </div>
            </div>
            <div class="row text-center">
                <c:forEach items="${listadoProducto}" var="productos">
                    <div class="card col-md-3 pt-3" style="width: 18rem;">
                        <img src="${productos.rutaImagen}" height="250" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title"> ${productos.nombreProducto} </h5>
                            <p class="card-text text-truncate" style="height-min: 50px">${productos.descripcion} </p>
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