<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
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
        <title>Registro Usuario</title>
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
        <div class="container">
            <br>
            <div class="jumbotron jumbotron-fluid">
                <div class="container">
                    <h1 class="display-4">Formulario de Registro</h1>
                    <p class="lead">Con este formulario podra inscribirse a la pagina para recibir ofertas y manejar sus productos</p>
                </div>
            </div>
            <br>
            <form action="UsuarioCtr" method="post">
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