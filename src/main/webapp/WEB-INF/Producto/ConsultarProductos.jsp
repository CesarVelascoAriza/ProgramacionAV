<%--
    Document   : index
    Created on : 23/08/2020, 11:56:14 a. m.
    Author     : Adolfo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <%@include file="../includ/head.jspf"%>
    <body>

        <%@include file="../includ/header.jspf"%>


        <%--Para el body  --%>
        <div id="carousel-example-2"
             class="carousel slide carousel-fade z-depth-1-half container mt-4 mb-4 pt-2 pb-2"
             data-ride="carousel">
            <div class="row">
                <div class="col-md-12 text-center">
                    <h4 class="title">Resultados</h2>
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
                            <form action="ProductosCtrl" method="POST">
                                <input type="hidden" value="${productos.idProducto}" name="idProducto" >
                                <input type="hidden" value="${productos.precioUnidad}" name="precioUnidad" >
                                <input type="submit" class="btn btn-success btn-sm" name="accion" value="Agregar producto">
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>


        <%@include file="../includ/footer.jspf"%>
    </body>
</html>