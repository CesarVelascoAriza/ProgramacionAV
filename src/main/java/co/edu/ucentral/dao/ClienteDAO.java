package co.edu.ucentral.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import co.edu.ucentral.modelo.Cliente;
import co.edu.ucentral.servicio.ConexionJPA;

public class ClienteDAO {

	private static ClienteDAO clienteDAO;
	private EntityManager em;

	public ClienteDAO() {
	}

	public static ClienteDAO instancia() {
		if (clienteDAO == null)
			clienteDAO = new ClienteDAO();
		return clienteDAO;
	}

	public String insertarCliente(Cliente cliente) {
		EntityManagerFactory factoriaSesion = ConexionJPA.getJPAFactory();
		em = factoriaSesion.createEntityManager();
		EntityTransaction tx = null;
		String mensaje = "";
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(cliente);
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

}
