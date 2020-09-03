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
                    <h4 class="title">Factura cabeza</h2>
                </div>
            </div>
            <input type="hidden" name="idCliente" value="${cliente.idCliente}">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputEmail4">Tipo de Documento</label>
                    <select  class="form-control"  readonly="readonly" >
                        <option>seleccione</option>
                        <option ${cliente.tipoDocumento==1?'selected="selected"':''}  value="1">Cedula de Ciudadania</option>
                        <option ${cliente.tipoDocumento==2?'selected="selected"':''} value="2" >Cedula Extranjeria</option>
                        <option ${cliente.tipoDocumento==3?'selected="selected"':''} value="3">Nit</option>
                        <option ${cliente.tipoDocumento==4?'selected="selected"':''} value="4">Pasaporte</option>
                    </select>
                </div>
                <div class="form-group col-md-6">
                    <label for="inputPassword4">Documento</label>
                    <input type="number" class="form-control" maxlength="11" readonly="readonly" value="${cliente.documentoCliente}" name="documento">
                </div>

            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputEmail4">Nombre</label>
                    <input type="text" class="form-control" id="nombre" readonly="readonly" value="${cliente.nombreCliente}">
                </div>
                <div class="form-group col-md-6">
                    <label for="inputPassword4">Apellido</label>
                    <input type="text" class="form-control" id="apellido" readonly="readonly" value="${cliente.apellidoCliente}">
                </div>

            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputState">Direccion</label>
                    <input type="text" class="form-control" id="direccion" readonly="readonly" value="${cliente.direccionCliente}">
                </div>

                <div class="form-group col-md-6">
                    <label for="inputEmail4">Email</label>
                    <input type="email" class="form-control" id="email" readonly="readonly" value="${cliente.emailCliente}" >
                </div>
            </div>


            <div class="row">
                <div class="col-md-12 text-center">
                    <h4 class="title">Productos facturados</h2>
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
                            ${productos.cantidaProducto}
                        </div>
                        <div class="col-md-1 text-right">
                            ${productos.total}
                        </div>
                    </div>
                </c:forEach>
            </div>
            <br/>
            <div class="row w-100 mt-4 pt-2">
                <div class="col-md-2 text-right">
                    <strong>Total pagado:</strong>
                </div>
                <div class="col-md-2 text-right">
                    ${total}  
                </div>
                <div class="col-md-5">

                </div>
                <div class="col-md-3">
                    <button type="submit" class="btn btn-sm btn-success w-100">
                        Generar factura
                    </button>
                </div>
            </div>
        </div>
    </div>


    <%@include file="../includ/footer.jspf"%>
</body>
</html>