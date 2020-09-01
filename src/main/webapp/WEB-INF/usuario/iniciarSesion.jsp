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

        <%@ include file="../includ/head.jspf"%>
        
        <div class="container" style="min-height: 568px;">
            <br>
            <form action="UsuarioCtr" method="post">
                <div class="form-group">
                    <label>Email</label>
                    <input type="email"  name="email" required="required" id="email" class="form-control" >
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Contraseña</label>
                    <input type="password" name="password" required="required"  id="password" class="form-control" id="exampleInputPassword1">
                </div>
                <div class="form-group">
                    <button type="submit"  name="accion" value="valideUsuario"  class="btn btn-primary">Iniciar sesion</button>
                </div>
            </form>
            <br>
        </div>

        <%@ include file="../includ/footer.jspf" %>
    </body>
</html>