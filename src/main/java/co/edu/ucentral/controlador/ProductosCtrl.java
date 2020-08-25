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
import co.edu.ucentral.modelo.Producto;

/**
 *
 * @author Adolfo
 */
@WebServlet(name = "ProductosCtrl", urlPatterns = {"/"})
public class ProductosCtrl extends HttpServlet {

   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	List<Producto> listadoProducto= new ArrayList<Producto>();
    	if(listadoProducto.isEmpty()) {
    		listadoProducto =ProductosDAO.instancia().litadoProductos();
    	
    	}
    	request.setAttribute("listadoProducto", listadoProducto);
    	request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    	
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   

}
