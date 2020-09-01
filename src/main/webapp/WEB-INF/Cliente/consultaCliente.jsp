<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <%@include file="../includ/head.jspf"%>
    <body>

        <%@include file="../includ/header.jspf"%>

        <div id="carousel-example-2" style="min-height: 768px;"
             class="carousel slide carousel-fade z-depth-1-half container mt-4 mb-4 pt-2 pb-2"
             data-ride="carousel">


            <strong>Mi información</strong>
            <hr/>
            <form action="ClienteCtrl" method="POST">
                <input type="hidden" name="idCliente" value="${cliente.idCliente}">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputEmail4">Tipo de Documento</label>
                        <select name="tipoDocumento" class="form-control"  >
                            <option>seleccione</option>
                            <option ${cliente.tipoDocumento==1?'selected="selected"':''}  value="1">Cedula de Ciudadania</option>
                            <option ${cliente.tipoDocumento==2?'selected="selected"':''} value="2" >Cedula Extranjeria</option>
                            <option ${cliente.tipoDocumento==3?'selected="selected"':''} value="3">Nit</option>
                            <option ${cliente.tipoDocumento==4?'selected="selected"':''} value="4">Pasaporte</option>
                        </select>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputPassword4">Documento</label>
                        <input type="number" class="form-control" maxlength="11" id="documento" value="${cliente.documentoCliente}" name="documento">
                    </div>

                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputEmail4">Nombre</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" value="${cliente.nombreCliente}">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputPassword4">Apellido</label>
                        <input type="text" class="form-control" id="apellido" name="apellido" value="${cliente.apellidoCliente}">
                    </div>

                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputCity">Fecha nacimiento</label>
                        <input type="date" class="form-control" id="fechaNaciento" name="fechaNaciento" value="" >
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputState">Direccion</label>
                        <input type="text" class="form-control" id="direccion" name="direccion" value="${cliente.direccionCliente}">
                    </div>

                </div>
                <div class="form-group">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputEmail4">Email</label>
                            <input type="email" class="form-control" id="email" name="email" value="${cliente.emailCliente}" >
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary" name="accion" value="guardar" >Guardar</button>
            </form>

        </div>

        <%@include file="../includ/footer.jspf"%>
    </body>
</html>