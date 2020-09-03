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
        <style>
            .btnupdown{
                width: 20px;
                height: 20px;
                border: 1px solid #bfbfbf;
                border-radius: 2px;
                float: right;
            }
            .btnupdown:hover{
                cursor: pointer;
            }
        </style>

        <%--Para el body  --%>
        <div id="carousel-example-2"
             class="carousel slide carousel-fade z-depth-1-half container mt-4 mb-4 pt-2 pb-2"
             data-ride="carousel" style="min-height: 750px" >
            <div class="row">
                <div class="col-md-12 text-center">
                    <h4 class="title">Productos seleccionados</h2>
                </div>
            </div>
            <hr/>
            <div class="container">
                <div class="row text-center bg-light mb-2">
                    <div class="row w-100">
                        <div class="col-md-2">

                        </div>
                        <div class="col-md-5">
                            <strong>Nombre</strong>
                        </div>
                        <div class="col-md-1 text-center">
                            <strong>Precio</strong>
                        </div>
                        <div class="col-md-2">
                            <strong>Cantidad</strong>
                        </div>
                        <div class="col-md-1">
                            <strong>Total</strong>
                        </div>
                    </div>
                </div>

                <c:forEach items="${listadoProducto}" var="productos">
                    <div class="row w-100">
                        <div class="col-md-2">
                            <img src="${productos.idProducto.rutaImagen}" height="100" class="img" alt="...">
                        </div>
                        <div class="col-md-5">
                            ${productos.idProducto.nombreProducto}
                        </div>
                        <div class="col-md-1 text-center">
                            ${productos.idProducto.precioUnidad}
                        </div>
                        <div class="col-md-2 text-center">
                            <form action="FacturacionCtrl" method="post">
                                ${productos.cantidaProducto}
                                <input type="hidden" name="idUnico" value="${productos.idProducto.idProducto}">
                                <input type="submit" name="accion" value="+" class="fa fa-caret-up btnupdown" >
                                <input type="submit" name="accion" value="-" class="fa fa-caret-up btnupdown" >
                            </form>
                        </div>
                        <div class="col-md-1 text-right">
                            ${productos.total}
                        </div>
                        <div class="col-md-1">
                            <form action="FacturacionCtrl" method="post">
                                <input type="hidden" name="idUnico" value="${productos.idProducto.idProducto}">
                                <input type="submit" value="Eliminar" name="accion" class="btn btn-sm btn-danger">
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <br/>
            <div class="row w-100 mt-4 pt-2">
                <div class="col-md-2 text-right">
                    <strong>Total:</strong>
                </div>
                <div class="col-md-2 text-right">
                    ${total}  
                </div>
                <div class="col-md-6">

                </div>
                <div class="col-md-2">

                    <c:if test="${validacion}">
                        <form action="FacturacionCtrl" method="post">
                            <button type="submit" class="btn btn-sm btn-success" value="Pagar" name="accion" >
                                Iniciar pago
                            </button>
                        </form>
                    </c:if>
                    <c:if test="${!validacion}">
                        <form action="FacturacionCtrl" method="post">
                            <button type="submit" class="btn btn-sm btn-warning" value="sesion" name="accion" >
                                Iniciar sesión
                            </button>
                        </form>
                    </c:if>

                </div>
            </div>
        </div>
    </div>


    <%@include file="../includ/footer.jspf"%>
</body>
</html>