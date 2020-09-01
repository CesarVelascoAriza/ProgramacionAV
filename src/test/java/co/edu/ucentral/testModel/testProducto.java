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
		System.out.println(listadoProducto.get(0).getNombreProducto());
		System.out.println(listadoProducto.get(0).getIdProducto());
		Assert.assertNotNull(listadoProducto);
	}
	
}
