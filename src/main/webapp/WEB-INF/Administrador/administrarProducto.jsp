<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <%@include file="../includ/head.jspf"%>
    <body>
        <%@include file="../includ/header.jspf"%>
        <div class="container">
            <div class="jumbotron jumbotron-fluid">
                <div class="container">
                    <h1 class="display-4">Gestion de productos Productos</h1>
                    <p class="lead">Aqui puede gestionar los productos </p>
                </div>
                <form action="AdministradorCtrl" method="get">
                    <input class="btn btn-success"  type="submit" name="accion" value="nuevo">
                </form>
                <table class="table table-striped">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">id</th>
                            <th scope="col">nombre</th>
                            <th scope="col">descripcion</th>
                            <th scope="col"> imagen</th>
                            <th scope="col" >precioUnidad</th>
                            <th scope="col">cantidad </th>
                            <th scope="col">opcion Editar</th>
                            <th scope="col">opcion Eliminar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listadoProducto}" var="producto">
                            <tr>
                                <td scope="row">${producto.idProducto }</td>
                                <td>${producto.nombreProducto }</td>
                                <td>${producto.descripcion }</td>
                                <td>${producto.rutaImagen }</td>
                                <td>${producto.precioUnidad }</td>
                                <td>${producto.catidadProducto }</td>
                                <td>
                                    <form action="AdministradorCtrl" method="get">
                                        <input type="hidden" name="idProducto" value="${producto.idProducto}">
                                        <input type="submit" name="accion" id="accion" value="editar" class="btn btn-success" >
                                    </form>
                                </td>
                                <td>
                                    <form action="AdministradorCtrl" method="get">
                                        <input type="hidden" name="idProducto" value="${producto.idProducto}">
                                        <input type="submit" name="accion" id="accion" value="eliminar" class="btn btn-danger" >
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </div>
        </div>
        <br>
        <%@ include file="../includ/footer.jspf" %>
    </body>
</html>