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
        <style>
            body{
                background-image: url('https://images.unsplash.com/photo-1540610410855-b4c8877b761c?ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80');
                background-origin: content-box;
                background-repeat: no-repeat;
                background-size: cover;
            }
        </style>
        <div class="container" style="min-height: 868px;">
            <div class="row mt-4 pt-4">
                <div class="col-md-4"></div>
                <div class="col-md-4 card">
                    <form action="UsuarioCtr" method="post">
                        <div class=" p-3 text-center">
                            <span class="fa fa-user" style="font-size: 10em"></span>
                        </div>
                        <div class=" p-3">
                            <strong class="card-title">
                                INICIO DE SESIÓN
                            </strong>
                        </div>
                        <div class="form-group">
                            <label>Email</label>
                            <input type="email"  name="email" required="required" id="email" class="form-control" >
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Contraseña</label>
                            <input type="password" name="password" required="required"  id="password" class="form-control" id="exampleInputPassword1">
                        </div>
                        <div class="form-group">
                            <button type="submit"  name="accion" value="valideUsuario"  class="btn btn-primary">
                                Iniciar sesión</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <%@ include file="../includ/footer.jspf" %>
    </body>
</html>