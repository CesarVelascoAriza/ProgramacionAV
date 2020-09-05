package co.edu.ucentral.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.ucentral.dao.ClienteDAO;
import co.edu.ucentral.dao.FacturaDAO;
import co.edu.ucentral.dao.ProductosDAO;
import co.edu.ucentral.modelo.Cliente;
import co.edu.ucentral.modelo.DetalleFactura;
import co.edu.ucentral.modelo.Factura;
import co.edu.ucentral.modelo.Producto;
import co.edu.ucentral.modelo.Usuario;

/**
 * Servlet implementation class HistorialProductos
 */
@WebServlet("/HistorialProductos")
public class HistorialProductos extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistorialProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Usuario objusuario = (Usuario) sesion.getAttribute("usuario");
        Cliente objCliente = ClienteDAO.instancia().buscarXID(objusuario.getIdUsuario());
        List<DetalleFactura> detalle = new ArrayList<DetalleFactura>();
        List<Producto> listadoProductos = new ArrayList<Producto>();
        List<Factura> factura = FacturaDAO.instancia().listadoFacturaUsuario(objCliente.getIdCliente());
        factura.sort((a, b) -> {
            if (a.getIdFactura() < b.getIdFactura()) {
                return 1;
            }
            if (a.getIdFactura() > b.getIdFactura()) {
                return -1;
            }
            return 0;
        });
        for (Factura factura2 : factura) {
            detalle = factura2.getDetalleFacturaList();
        }
        for (DetalleFactura detalleFactura : detalle) {
            listadoProductos.add(detalleFactura.getIdProducto());
            detalleFactura.setIdProducto(ProductosDAO.instancia().buscarProducto(detalleFactura.getIdProducto().getIdProducto()));
        }
        sesion.setAttribute("usuario", objusuario);
        sesion.setAttribute("cliente", objCliente);
        sesion.setAttribute("ListadoFactura", listadoProductos);
        request.setAttribute("Facturas", factura);
        request.getRequestDispatcher("WEB-INF/Cliente/HistoriaCompras.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
