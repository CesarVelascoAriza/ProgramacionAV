/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ucentral.dao.ProductosDAO;
import co.edu.ucentral.modelo.DetalleFactura;
import co.edu.ucentral.modelo.Producto;
import java.math.BigDecimal;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Adolfo
 */
@WebServlet(name = "ProductosCtrl", urlPatterns = {"/ProductosCtrl"})
public class ProductosCtrl extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Producto> listadoProducto = ProductosDAO.instancia().litadoProductos();
        request.setAttribute("listadoProducto", listadoProducto);
        request.getRequestDispatcher("WEB-INF/Producto/ConsultarProductos.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("accion") != null) {
            if (request.getParameter("accion").equals("Agregar producto")) {
                agregarProductos(request, response);
                response.sendRedirect("ProductoCtrl");
            }
        }
    }

    private void agregarProductos(HttpServletRequest request, HttpServletResponse response) {
        HttpSession sesion = request.getSession();
        if (sesion.getAttribute("productocompra") == null) {
            List<DetalleFactura> listado = new ArrayList<>();
            sesion.setAttribute("productocompra", listado );
        }
        List<DetalleFactura> listadoSesion = (List<DetalleFactura>)sesion.getAttribute("productocompra");
        Integer idProducto = Integer.parseInt(request.getParameter("idProducto"));
        BigDecimal precioProducto = BigDecimal.valueOf(Double.parseDouble(request.getParameter("precioUnidad")));
        Producto producto = new Producto();
        listadoSesion.add(new DetalleFactura(0, 1,precioProducto,precioProducto,producto ));
    }

}
