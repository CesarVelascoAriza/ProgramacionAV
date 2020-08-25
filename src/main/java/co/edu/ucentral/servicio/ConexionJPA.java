package co.edu.ucentral.servicio;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionJPA {

	private static final EntityManagerFactory emf = buildEntityManagerFactory();

	private static EntityManagerFactory buildEntityManagerFactory() {
		try {
			return Persistence.createEntityManagerFactory("tiendaweb");
		} catch (Throwable e) {
			throw new RuntimeException("Error al crear la factoria JPA");
		}
	}

	public static EntityManagerFactory getJPAFactory() {
		return emf;
	}
}
