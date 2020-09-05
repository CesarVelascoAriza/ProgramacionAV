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

                    <ul>
                        <c:forEach items="${Facturas}" var="fatura">
                            <div class="card row mb-2">
                                <div class="card-header">
                                    <div class="card-title">
                                        <h3>
                                            <strong>Factura</strong> #${fatura.idFactura} - <small>Fecha factura:</small> ${fatura.getFechaString()} - <small>Total:</small> ${fatura.total}
                                        </h3>
                                    </div>
                                </div>
                                <div class="card-body">
                                        <c:forEach items="${fatura.detalleFacturaList}" var="productos">
                                            <div class="">
                                                <div class="row w-100">
                                                    <div class="col-3">
                                                        <img src="${productos.idProducto.rutaImagen}" style="width: 50px;height: 50px"  class="card-img" alt="...">
                                                    </div>
                                                    <div class="col-6">
                                                        ${productos.idProducto.nombreProducto}
                                                    </div>
                                                    <div class="col-3 text-right">
                                                        ${productos.total}
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                </div>
                            </div>
                        </c:forEach>
                    </ul>



                </div>
            </div>
        </div>	
        <br>
        <%@include file="../includ/footer.jspf"%>
    </body>
</html>