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
        <div class="container">
            <br>
            <div class="jumbotron p-2">
                <div class="container">
                    <h1 class="display-5">Formulario de Registro</h1>
                    <p class="lead">Con este formulario podra inscribirse a la pagina para recibir ofertas y manejar sus productos</p>
                </div>
            </div>
            <br>
            <form action="UsuarioCtr" method="post" style="min-height: 450px;">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputEmail4">Tipo de Documento</label>
                        <select name="tipoDocumento" class="form-control">
                            <option>seleccione</option>
                            <option value="1">Cedula de Ciudadania</option>
                            <option value="2" >Cedula Extranjeria</option>
                            <option value="3">Nit</option>
                            <option value="4">Pasaporte</option>
                        </select>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputPassword4">Documento</label>
                        <input type="number" class="form-control" maxlength="11" id="documento" name="documento">
                    </div>

                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputEmail4">Nombre</label>
                        <input type="text" class="form-control" id="nombre" name="nombre">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputPassword4">Apellido</label>
                        <input type="text" class="form-control" id="apellido" name="apellido">
                    </div>

                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputCity">Fecha nacimiento</label>
                        <input type="date" class="form-control" id="fechaNaciento" name="fechaNaciento">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputState">Direccion</label>
                        <input type="text" class="form-control" id="direccion" name="direccion">
                    </div>

                </div>
                <div class="form-group">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputEmail4">Email</label>
                            <input type="email" class="form-control" id="email" name="email" >
                        </div>
                        <div class="form-group col-md-6">
                            <label for="inputPassword4">Contraseña</label>
                            <input type="password" class="form-control" id="password" name="password" >
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary" name="accion" value="adicionar" >Guardar</button>
            </form>
            <br>
        </div>

        <%@ include file="../includ/footer.jspf"%>
    </body>
</html>