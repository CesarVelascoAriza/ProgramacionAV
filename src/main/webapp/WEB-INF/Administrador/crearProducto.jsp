<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <%@include file="../includ/head.jspf"%>
    <body>
        <%@include file="../includ/header.jspf"%>
        
        <br>
        <div class="container" style="min-height: 550px">
            <main role="main">
                <div class="container">
                    <div class="card">
                        <h4 class="card-header"><strong>Datos Productos</strong> </h4>
                        <div class="card-body">
                            <form action="AdministradorCtrl" method="post">

                                <div class="row">

                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="id">ID</label>
                                            <input type="number" class="form-control" id="id" name="id" 
                                                   value="${producto.idProducto}" placeholder="Codigo de la producto" 
                                                   required="required">
                                        </div>
                                        
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="id">Nombre de producto</label>
                                            <input type="text" class="form-control" id="nombreProducto" name="nombreProducto" 
                                                   value="${producto.nombreProducto}" placeholder="nombre del producto" 
                                                   required="required">
                                        </div>
                                        
                                    </div>
                                     <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="id">Precio</label>
                                            <input type="number" class="form-control" id="precioUnitario" name="precioUnitario" 
                                                   value="${producto.precioUnidad}" placeholder="precio del producto" 
                                                   required="required">
                                        </div>
                                        
                                    </div>
                                </div>
                                <div class="row">

                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="id">Descripcion</label>
                                            <input type="text" class="form-control" id="descripcion" name="descripcion" 
                                                   value="${producto.descripcion}" placeholder="Codigo de la producto" 
                                                   required="required">
                                        </div>
                                        
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="id">Imagen</label>
                                            <input type="text" class="form-control" id="rutaImagen" name="rutaImagen" 
                                                   value="${producto.rutaImagen}" placeholder="ruta de la imagen del pruducto" 
                                                   required="required">
                                        </div>
                                        
                                    </div>
                                     <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="id">cantidad del Producto</label>
                                            <input type="number" class="form-control" id="cantidadProducto" name="cantidadProducto" 
                                                   value="${producto.catidadProducto}" placeholder="catidad Del producto" 
                                                   required="required">
                                        </div>
                                        
                                    </div>
                                </div>
								<div class="row">
									<div class="cold-md-4">
										<div class="form-group">
											<button type="submit" value="${tipoFormulario}" name="accion" id="accion" 
                                    			class="btn btn-primary">${tipoFormulario}</button>  
										</div>
									</div>
								</div>
                            </form>
                        </div>


                    </div>
                </div>
            </main>
        </div>
        <br>
        <%@ include file="../includ/footer.jspf" %>
    </body>
</html>