package co.edu.ucentral.testModel;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import co.edu.ucentral.dao.ProductosDAO;
import co.edu.ucentral.modelo.Producto;

public class testProducto {

	@Test
	public void testProductos() {
		List<Producto> listadoProducto= ProductosDAO.instancia().litadoProductos();
		listadoProducto.size();
		Assert.assertNotNull(listadoProducto);
	}
	@Test
	public void insertarProducto() {
		Producto p= new Producto(1, 1, "producto de prueba", "/imagen/image", 25000);
		String mensaje = ProductosDAO.instancia().insertarProducto(p);
		System.out.println(mensaje);
		Assert.assertNotNull(mensaje);
	}
}
