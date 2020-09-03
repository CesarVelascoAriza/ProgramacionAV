package co.edu.ucentral.controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.ucentral.dao.ClienteDAO;
import co.edu.ucentral.dao.RolDAO;
import co.edu.ucentral.dao.UsuarioDAO;
import co.edu.ucentral.modelo.Cliente;
import co.edu.ucentral.modelo.Rol;
import co.edu.ucentral.modelo.Usuario;

/**
 * Servlet implementation class UsuarioCtr
 */
@WebServlet(name = "/UsuarioCtr", urlPatterns = {"/UsuarioCtr"})
public class UsuarioCtr extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private boolean validacion;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioCtr() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        String accion = request.getParameter("accion");
        if (accion != null) {
            if (accion.equals("registro")) {
                request.getRequestDispatcher("WEB-INF/usuario/registroUsuario.jsp").forward(request, response);
            } else if (accion.equals("sesion")) {
                request.getRequestDispatcher("WEB-INF/usuario/iniciarSesion.jsp").forward(request, response);
            } else if (accion.equals("validasesionfactura")) {
                HttpSession sesion = request.getSession();
                boolean validado = false;
                if (sesion.getAttribute("validacion") != null) {
                    validado = (boolean) sesion.getAttribute("validacion");
                }
                if (validado) {
                    response.sendRedirect("FacturacionCtrl");
                } else {
                    response.sendRedirect("UsuarioCtr?accion=sesion");
                }
            }
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("accion").equals("adicionar")) {
            crearUsuario(request, response);
            response.sendRedirect("UsuarioCtr");
        } else if (request.getParameter("accion").equals("valideUsuario")) {
            validarUsuario(request, response);
        } else if (request.getParameter("accion").equals("cerrarSesion")) {
            HttpSession sesion = request.getSession();
            sesion.invalidate();
            response.sendRedirect("InicioCtrl");
        }

    }

    private void validarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            Usuario usuario = UsuarioDAO.instancia().buscarUsuario(email, password);
            if (usuario != null) {
                validacion = true;
                HttpSession sesion = request.getSession();
                if (sesion != null) {
                    sesion.setAttribute("validacion", validacion);
                    sesion.setAttribute("usuario", usuario);

                    boolean enviaAFactura = false;
                    if (sesion.getAttribute("enviaAFactura") != null) {
                        enviaAFactura = (boolean) sesion.getAttribute("enviaAFactura");
                    }
                    if (usuario.getRol().getRol() == 2) {
                        sesion.setAttribute("rol", "cliente");
                    }
                    if (usuario.getRol().getRol() == 1) {
                        sesion.setAttribute("rol", "administrador");
                    }
                    if (enviaAFactura) {
                        response.sendRedirect("FacturacionCtrl?accion=facturarAutomatica");
                    } else {
                        response.sendRedirect("InicioCtrl");
                    }
                }
            } else {

            }
        } catch (Exception e) {
            request.setAttribute("mensaje", "Usuario y contraseña invalidos");
            request.getRequestDispatcher("WEB-INF/usuario/iniciarSesion.jsp").forward(request, response);
        }

    }

    private void crearUsuario(HttpServletRequest request, HttpServletResponse response) {
        String tipoDocumento = request.getParameter("tipoDocumento");
        int numeroDocuemnto = Integer.parseInt(request.getParameter("documento"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento = new Date();
        try {
            fechaNacimiento = formatDate.parse(request.getParameter("fechaNaciento"));
            // Date fecha = Date.valueOf(request.getParameter("fecha"));

        } catch (ParseException e) {
            System.err.println("la feha no se pudo parsear : " + e.getMessage());
        }
        String direccion = request.getParameter("direccion");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Rol rol = RolDAO.instancia().getRol(2);
        Usuario usuario = new Usuario(nombre, email, password, rol);
        Cliente cliente = new Cliente(1, tipoDocumento, numeroDocuemnto, nombre, apellido, fechaNacimiento, direccion,
                email);
        String mensaje = UsuarioDAO.instancia().insetarUsuario(usuario);
        String mensajeClinte = ClienteDAO.instancia().insertarCliente(cliente);
        request.setAttribute("Mensaje", mensajeClinte);

    }

}
