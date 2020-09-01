<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
              integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
              crossorigin="anonymous">
        <meta name="viewport"
              content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <title>Administrador</title>
        <base target="_parent">
        <link rel="stylesheet"
              href="https://use.fontawesome.com/releases/v5.11.0/css/all.css">
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&amp;display=swap">
        <link rel="stylesheet"
              href="https://mdbootstrap.com/api/snippets/static/download/MDB-Pro_4.19.1/css/bootstrap.min.css">
        <link rel="stylesheet"
              href="https://mdbootstrap.com/api/snippets/static/download/MDB-Pro_4.19.1/css/mdb.min.css">
        <link rel="stylesheet"
              href="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/css/compiled-addons-4.19.1.min.css">
        <link rel="stylesheet" type="text/css"
              href="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/css/mdb-plugins-gathered.min.css">
        <style></style>
        <style type="text/css">
            /* Chart.js */
            @-webkit-keyframes chartjs-render-animation {
                from {opacity: 0.99
                }

                to {
                    opacity: 1
                }

            }
            @keyframes chartjs-render-animation {
                from {opacity: 0.99
                }

                to {
                    opacity: 1
                }

            }
            .chartjs-render-monitor {
                -webkit-animation: chartjs-render-animation 0.001s;
                animation: chartjs-render-animation 0.001s;
            }
        </style>
        <link rel="icon" type="image/png"
              href="https://icons.iconarchive.com/icons/aha-soft/business-toolbar/48/payment-icon.png" />
    </head>
    <body>
        <%@ include file="../includ/head.jspf"%>
        <br>

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