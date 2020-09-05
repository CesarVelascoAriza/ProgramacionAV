/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.controlador;

import co.edu.ucentral.dao.ClienteDAO;
import co.edu.ucentral.dao.FacturaDAO;
import co.edu.ucentral.dao.ProductosDAO;
import co.edu.ucentral.modelo.Cliente;
import co.edu.ucentral.modelo.DetalleFactura;
import co.edu.ucentral.modelo.Factura;
import co.edu.ucentral.modelo.Producto;
import co.edu.ucentral.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fredyalejandrogutierrezvelasquez
 */
@WebServlet(name = "FacturacionCtrl", urlPatterns = {"/FacturacionCtrl"})
public class FacturacionCtrl extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("accion") == null) {
            cargarDetalleProductos(request, response);
            request.getRequestDispatcher("WEB-INF/Facturacion/productosSeleccionados.jsp").forward(request, response);
        } else {
            String accion = request.getParameter("accion");
            if (accion.equals("facturarAutomatica")) {
                generarFactura(request, response);
            }
            if (accion.equals("facturar")) {
                cargarCliente(request,response);
                cargarDetalleProductos(request,response);
                request.getRequestDispatcher("WEB-INF/Facturacion/facturarproductos.jsp").forward(request, response);
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        if (request.getParameter("accion") != null) {
            if (request.getParameter("accion").equals("Agregar")) {
                agregarProductos(request, response);
            }
            if (request.getParameter("accion").equals("Eliminar")) {
                eliminarProductos(request, response);
            }
            if (request.getParameter("accion").equals("+")) {
                sumarProductos(request, response);
            }
            if (request.getParameter("accion").equals("-")) {
                restarProductos(request, response);
            }
            if (request.getParameter("accion").equals("Pagar")) {
                generarFactura(request, response);
            }
            if (request.getParameter("accion").equals("sesion")) {
                sesion.setAttribute("enviaAFactura", true);
                response.sendRedirect("UsuarioCtr?accion=sesion");
            }if(request.getParameter("accion").equals("pagarFactura")) {
            	generarPagoFactura(request,response);
            }
        }
    }

    private void generarPagoFactura(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sesion = request.getSession();
		Usuario usuario = (Usuario) sesion.getAttribute("usuario");
		Cliente cliente =(Cliente) sesion.getAttribute("cliente");
		List<DetalleFactura> detallesFactura = (List<DetalleFactura>) sesion.getAttribute("productosCompra");
		
		Date fecha = new Date();
		BigDecimal totalFactura=BigDecimal.valueOf(Double.parseDouble(request.getParameter("totalFacturaApagar"))) ;
		
		Factura factura = new Factura();
		factura.setIdFactura(1);
		factura.setFechaFactura(fecha);
		factura.setIdCliente(cliente);
		factura.setTotal(totalFactura);
		int idfactura = FacturaDAO.instancia().insertarFactura(factura);
		SimpleDateFormat formatDate  = new SimpleDateFormat("dd-MM-yyyy");
		
		for (DetalleFactura detalle : detallesFactura) {
			detalle.setIdFactura(factura);
			Producto cantstock= ProductosDAO.instancia().buscarProducto(detalle.getIdProducto().getIdProducto());
			
			int cantidad =cantstock.getCatidadProducto()-detalle.getCantidaProducto();
			detalle.getIdProducto().setCatidadProducto(cantidad);
			ProductosDAO.instancia().actualizarcatidadProducto(detalle.getIdProducto());
		}
		factura.setDetalleFacturaList(detallesFactura);
		String message2 = FacturaDAO.instancia().actualizarFactura(factura);
		detallesFactura.clear();
		sesion.setAttribute("productosCompra", detallesFactura);
		response.sendRedirect("HistorialProductos");
		 
		
	}

	private void generarFactura(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion = request.getSession();
        response.sendRedirect("FacturacionCtrl?accion=facturar");
    }

    private void sumarProductos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion = request.getSession();
        if (sesion.getAttribute("productosCompra") == null) {
            List<DetalleFactura> listado = new ArrayList<>();
            sesion.setAttribute("productosCompra", listado);
        }
        List<DetalleFactura> listadoSesion = (List<DetalleFactura>) sesion.getAttribute("productosCompra");
        Integer IdUnico = Integer.parseInt(request.getParameter("idUnico"));

        boolean existe = false;
        for (int i = 0; i < listadoSesion.size() && existe == false; i++) {
            if (IdUnico == listadoSesion.get(i).getIdProducto().getIdProducto().intValue()) {
                existe = true;
                listadoSesion.get(i).setCantidaProducto(listadoSesion.get(i).getCantidaProducto() + 1);
                listadoSesion.get(i).setTotal(listadoSesion.get(i).getPrecioCantidad().multiply(new BigDecimal(listadoSesion.get(i).getCantidaProducto())));
            }
        }
        sesion.setAttribute("productosCompra", listadoSesion);
        response.sendRedirect("FacturacionCtrl");
    }

    private void restarProductos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion = request.getSession();
        if (sesion.getAttribute("productosCompra") == null) {
            List<DetalleFactura> listado = new ArrayList<>();
            sesion.setAttribute("productosCompra", listado);
        }
        List<DetalleFactura> listadoSesion = (List<DetalleFactura>) sesion.getAttribute("productosCompra");
        Integer IdUnico = Integer.parseInt(request.getParameter("idUnico"));

        boolean existe = false;
        for (int i = 0; i < listadoSesion.size() && existe == false; i++) {
            if (IdUnico == listadoSesion.get(i).getIdProducto().getIdProducto().intValue()) {
                existe = true;
                listadoSesion.get(i).setCantidaProducto(listadoSesion.get(i).getCantidaProducto() + 1);
                listadoSesion.get(i).setTotal(listadoSesion.get(i).getPrecioCantidad().multiply(new BigDecimal(listadoSesion.get(i).getCantidaProducto())));
            }
        }
        sesion.setAttribute("productosCompra", listadoSesion);
        response.sendRedirect("FacturacionCtrl");
    }

    private void eliminarProductos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion = request.getSession();
        if (sesion.getAttribute("productosCompra") == null) {
            List<DetalleFactura> listado = new ArrayList<>();
            sesion.setAttribute("productosCompra", listado);
        }
        List<DetalleFactura> listadoSesion = (List<DetalleFactura>) sesion.getAttribute("productosCompra");
        Integer IdUnico = Integer.parseInt(request.getParameter("idUnico"));

        boolean existe = false;
        for (int i = 0; i < listadoSesion.size() && existe == false; i++) {
            if (IdUnico == listadoSesion.get(i).getIdProducto().getIdProducto().intValue()) {
                existe = true;
                listadoSesion.remove(listadoSesion.get(i));
            }
        }
        sesion.setAttribute("productosCompra", listadoSesion);
        response.sendRedirect("FacturacionCtrl");
    }

    private void agregarProductos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion = request.getSession();
        if (sesion.getAttribute("productosCompra") == null) {
            List<DetalleFactura> listado = new ArrayList<>();
            sesion.setAttribute("productosCompra", listado);
        }
        List<DetalleFactura> listadoSesion = (List<DetalleFactura>) sesion.getAttribute("productosCompra");
        Integer idProducto = Integer.parseInt(request.getParameter("idProducto"));
        BigDecimal precioProducto = BigDecimal.valueOf(Double.parseDouble(request.getParameter("precioUnidad")));
        String nombreProducto = request.getParameter("nombreProducto");
        String urlimagen = request.getParameter("rutaImagen");
        String descripcion = request.getParameter("descripcion");
        Producto producto = new Producto();
        producto.setIdProducto(idProducto);
        producto.setNombreProducto(nombreProducto);
        producto.setDescripcion(descripcion);
        producto.setRutaImagen(urlimagen);
        producto.setPrecioUnidad(Integer.parseInt(request.getParameter("precioUnidad")));

        boolean existe = false;
        DetalleFactura objExiste = null;

        for (int i = 0; i < listadoSesion.size() && existe == false; i++) {
            if (Objects.equals(listadoSesion.get(i).getIdProducto().getIdProducto(), producto.getIdProducto())) {
                existe = true;
                objExiste = listadoSesion.get(i);
            }
        }
        if (existe) {
            objExiste.setCantidaProducto(objExiste.getCantidaProducto() + 1);
        } else {
            listadoSesion.add(new DetalleFactura(0, 1, precioProducto, precioProducto, producto));
        }
        sesion.setAttribute("productosCompra", listadoSesion);
        String filtro = (String) sesion.getAttribute("filtro");
        response.sendRedirect("ProductosCtrl?busqueda=" + filtro);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void cargarDetalleProductos(HttpServletRequest request, HttpServletResponse response) {
        HttpSession sesion = request.getSession();
        List<DetalleFactura> listadoProducto = (List<DetalleFactura>) sesion.getAttribute("productosCompra");
        request.setAttribute("listadoProducto", listadoProducto);
        BigDecimal total = new BigDecimal(0);
        for (int i = 0; i < listadoProducto.size(); i++) {
            total = total.add(listadoProducto.get(i).getTotal());
        }
        request.setAttribute("total", total);
    }
    
    
    private void cargarCliente(HttpServletRequest request, HttpServletResponse response) {
        HttpSession sesion = request.getSession();
            Usuario objusuario = (Usuario) sesion.getAttribute("usuario");
            Cliente objCliente = ClienteDAO.instancia().buscarXID(objusuario.getIdUsuario());
           // request.setAttribute("cliente", objCliente);
            sesion.setAttribute("cliente", objCliente);
    }

}
