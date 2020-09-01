/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.controlador;

import co.edu.ucentral.dao.ClienteDAO;
import co.edu.ucentral.dao.RolDAO;
import co.edu.ucentral.dao.UsuarioDAO;
import co.edu.ucentral.modelo.Cliente;
import co.edu.ucentral.modelo.Rol;
import co.edu.ucentral.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "ClienteCtrl", urlPatterns = {"/ClienteCtrl"})
public class ClienteCtrl extends HttpServlet {

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
            HttpSession sesion = request.getSession();
            Usuario objusuario = (Usuario) sesion.getAttribute("usuario");
            Cliente objCliente = ClienteDAO.instancia().buscarXID(objusuario.getIdUsuario());
            request.setAttribute("cliente", objCliente);
            request.getRequestDispatcher("WEB-INF/Cliente/consultaCliente.jsp").forward(request, response);
        } else {

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
        if (request.getParameter("accion") != null) {
            String accion = (String) request.getParameter("accion");
            if (accion.equals("guardar")) {
                actualizarCliente(request, response);
                response.sendRedirect("ClienteCtrl");
            }
        }
    }

    private void actualizarCliente(HttpServletRequest request, HttpServletResponse response) {
        String tipoDocumento = request.getParameter("tipoDocumento");
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
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
        Cliente cliente = new Cliente(idCliente, tipoDocumento, numeroDocuemnto, nombre, apellido, fechaNacimiento, direccion, email);
        String mensajeClinte = ClienteDAO.instancia().actualizarCliente(cliente);
        request.setAttribute("Mensaje", mensajeClinte);
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

}
