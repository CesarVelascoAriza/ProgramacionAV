package co.edu.ucentral.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import co.edu.ucentral.modelo.Usuario;
import co.edu.ucentral.servicio.ConexionJPA;

public class UsuarioDAO {

	private static UsuarioDAO usuarioDAO;
	private EntityManager em;

	public UsuarioDAO() {

	}

	private static UsuarioDAO instancia() {
		if (usuarioDAO == null)
			usuarioDAO = new UsuarioDAO();
		return usuarioDAO;
	}

	public String insetarUsuario(Usuario usuario) {
		EntityManagerFactory factoriaSesion = ConexionJPA.getJPAFactory();
		em = factoriaSesion.createEntityManager();
		EntityTransaction tx = null;
		String mensaje = "";
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(usuario);
			tx.commit();
			mensaje = "El usuario ha sido creado exitosamente";
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			mensaje = "El usuario no ha sido posible crearlospor favor intentelo de nuevo";
		} finally {
			em.close();
		}
		return mensaje;

	}
	
	public Usuario buscarUsuario(String nombre, String pass) {
		EntityManagerFactory factoriaSesion = ConexionJPA.getJPAFactory();
		em = factoriaSesion.createEntityManager();
		Usuario usuario = new Usuario();
		Query query = em.createNamedQuery("Producto.findByIdProducto", Usuario.class);
		query.setParameter("nombreUsuario", nombre);
		query.setParameter("contrasenia", pass);
		try {
			usuario =(Usuario) query.getSingleResult();
		} finally {
			em.close();
		}
		return usuario;
	}
	public String modificarUsuario(Usuario usuario) {
		String message = "";
		EntityManagerFactory factoriaSesion = ConexionJPA.getJPAFactory();
		em = factoriaSesion.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.merge(usuario);
			tx.commit();
			message = "El usuario ha sido Modificado exitosamente";
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			message = "El usuario no ha sido posible Modificarlo por favor intentelo de nuevo";
		} finally {
			em.close();
		}
		return message;
		
		
		
	}
	
	
	
	
}
