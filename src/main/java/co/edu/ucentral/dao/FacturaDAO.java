package co.edu.ucentral.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import co.edu.ucentral.modelo.Cliente;
import co.edu.ucentral.modelo.Factura;
import co.edu.ucentral.servicio.ConexionJPA;

public class FacturaDAO {

	private static FacturaDAO facturaDAO;
	private EntityManager em;

	public FacturaDAO() {

	}

	public static FacturaDAO instancia() {
		if (facturaDAO == null)
			facturaDAO = new FacturaDAO();
		return facturaDAO;
	}

	public int insertarFactura(Factura factura) {
		String message = "";
		EntityManagerFactory factoriaSesion = ConexionJPA.getJPAFactory();
		em = factoriaSesion.createEntityManager();
		EntityTransaction tx = null;

		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(factura);
			tx.commit();
			message = "El usuario ha sido creado exitosamente";
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			message = "El usuario no ha sido posible crearlospor favor intentelo de nuevo";
		} finally {
			em.close();
		}
		return factura.getIdFactura();
	}

	public Factura getFacturaIdcFecha(Date fecha, int id, BigDecimal total) {
		EntityManagerFactory factoriaSesion = ConexionJPA.getJPAFactory();
		em = factoriaSesion.createEntityManager();
		Factura factura = new Factura();
		try {
			Query query = em.createNamedQuery("Factura.findByIDClienteFechaFactura", Factura.class);
			query.setParameter("fechaFactura", fecha);
			query.setParameter("cliente", id);
			query.setParameter("total", total);
			factura = (Factura) query.setMaxResults(1).getResultList();
		} finally {
			em.close();
		}
		return factura;
	}
	
	public String actualizarFactura(Factura factura) {
		String message = "";
		EntityManagerFactory factoriaSesion = ConexionJPA.getJPAFactory();
		em = factoriaSesion.createEntityManager();
		EntityTransaction tx = null;

		try {
			tx = em.getTransaction();
			tx.begin();
			em.merge(factura);
			tx.commit();
			message = "El usuario ha sido creado exitosamente";
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			message = "El usuario no ha sido posible crearlospor favor intentelo de nuevo";
		} finally {
			em.close();
		}
		return message;
	}
	
	public List<Factura> listadoFacturaUsuario(int id){
		List<Factura> factura = new ArrayList<Factura>();
		
		
		EntityManagerFactory factoriaSesion = ConexionJPA.getJPAFactory();
		em = factoriaSesion.createEntityManager();

		try {
			Query query = em.createNamedQuery("Factura.findByIdCliente", Factura.class);
			query.setParameter("id", id);
			
			factura = query.getResultList();
		} finally {
			em.close();
		}
		return factura;
		
		
		
		
	}
	
	
}
