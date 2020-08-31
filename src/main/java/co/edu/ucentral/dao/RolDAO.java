package co.edu.ucentral.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import co.edu.ucentral.modelo.Rol;
import co.edu.ucentral.servicio.ConexionJPA;

public class RolDAO {

	private static RolDAO rolDAO;
	private EntityManager em;
	
	public RolDAO() {
	
	}
	public static RolDAO instancia() {
		if(rolDAO == null)
			rolDAO = new RolDAO();
		return rolDAO;
	}
	
	
	public Rol getRol(int id) {
		EntityManagerFactory factoriaSesion = ConexionJPA.getJPAFactory();
		em = factoriaSesion.createEntityManager();
		Rol rol = new Rol();
		Query query = em.createNamedQuery("Rol.findByIdRol", Rol.class);
		query.setParameter("idRol", id);
		
		try {
			rol =(Rol) query.getSingleResult();
		} finally {
			em.close();
		}
		return rol;
	}
	
	
	
}
