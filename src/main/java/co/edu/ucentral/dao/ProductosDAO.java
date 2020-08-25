package co.edu.ucentral.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import co.edu.ucentral.modelo.Producto;
import co.edu.ucentral.servicio.ConexionJPA;

public class ProductosDAO {

	private static ProductosDAO productoJPA;
	private EntityManager em;

	public ProductosDAO() {

	}

	public static ProductosDAO instancia() {
		if (productoJPA == null) {
			productoJPA = new ProductosDAO();
		}
		return productoJPA;
	}

	public String insertarProducto(Producto producto) {
		EntityManagerFactory factoriaSesion = ConexionJPA.getJPAFactory();
		em = factoriaSesion.createEntityManager();
		EntityTransaction tx = null;
		String mensaje ="";
		try {
			tx = em.getTransaction();
			tx.begin();
			em.merge(producto);
			tx.commit();
			mensaje = "insertado";
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			mensaje = null;
		} finally {
			em.close();
		}
		return mensaje;
	}

	public List<Producto> litadoProductos() {
		EntityManagerFactory factoriaSesion = ConexionJPA.getJPAFactory();
		em = factoriaSesion.createEntityManager();
		try {
			return em.createNamedQuery("Producto.findAll", Producto.class).getResultList();
		} catch (PersistenceException e) {
			return null;
		} finally {
			em.close();
		}
	}

}
