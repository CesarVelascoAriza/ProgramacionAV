package co.edu.ucentral.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ucentral.dao.ProductosDAO;
import co.edu.ucentral.modelo.Producto;

/**
 * Servlet implementation class AdministradorCtrl
 */
@WebServlet("/AdministradorCtrl")
public class AdministradorCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministradorCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("accion");
		if(accion != null){
			if(accion.equals("nuevo")) {
				request.setAttribute("tipoFormulario", "Crear");
				request.getRequestDispatcher("WEB-INF/Administrador/crearProducto.jsp").forward(request, response);
			}
			else if(accion.equals("editar")) {
				int id = Integer.parseInt( request.getParameter("idProducto"));
				Producto producto=ProductosDAO.instancia().buscarProducto(id);
				request.setAttribute("tipoFormulario", "Modificar");
				request.setAttribute("producto", producto);
				request.getRequestDispatcher("WEB-INF/Administrador/crearProducto.jsp").forward(request, response);
			}else if(accion.equals("eliminar")) {
				elimarProducto(request,response);
			}
		}else{
			List<Producto> listadoProducto = ProductosDAO.instancia().litadoProductos();
			request.setAttribute("listadoProducto", listadoProducto);
			request.getRequestDispatcher("WEB-INF/Administrador/administrarProducto.jsp").forward(request, response);
			
		}
		
		
	}

	private void elimarProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt( request.getParameter("idProducto"));
		Producto producto=ProductosDAO.instancia().buscarProducto(id);
		String mensaje = ProductosDAO.instancia().deleteProducto(producto);
		request.setAttribute("mensaje", mensaje);
		response.sendRedirect("AdministradorCtrl");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		if(accion.equals("Crear")) {
			crearProducto(request,response);
		}else if(accion.equals("Modificar")) {
			modificarProducto(request,response);
		}
		
	}

	private void modificarProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt( request.getParameter("id"));
		String nombreProducto= request.getParameter("nombreProducto");
		int precioUnitario = Integer.parseInt( request.getParameter("precioUnitario"));
		String descripcion = request.getParameter("descripcion");
		String rutaImagen = request.getParameter("rutaImagen");
		int cantidadProducto = Integer.parseInt(request.getParameter("cantidadProducto"));
		
		Producto producto= new Producto(id, nombreProducto, descripcion, rutaImagen, precioUnitario,cantidadProducto);
		String mensaje = ProductosDAO.instancia().actualizarProducto(producto);
		request.setAttribute("message", mensaje);
		response.sendRedirect("AdministradorCtrl");
		
	}

	private void crearProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt( request.getParameter("id"));
		String nombreProducto= request.getParameter("nombreProducto");
		int precioUnitario = Integer.parseInt( request.getParameter("precioUnitario"));
		String descripcion = request.getParameter("descripcion");
		String rutaImagen = request.getParameter("rutaImagen");
		int cantidadProducto = Integer.parseInt(request.getParameter("cantidadProducto"));
		
		Producto producto= new Producto(id, nombreProducto, descripcion, rutaImagen, precioUnitario,cantidadProducto);
		String mensaje = ProductosDAO.instancia().insertarProducto(producto);
		request.setAttribute("message", mensaje);
		response.sendRedirect("AdministradorCtrl");
		
	}

}
