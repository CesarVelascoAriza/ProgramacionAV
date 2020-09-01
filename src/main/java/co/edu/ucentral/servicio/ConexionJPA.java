package co.edu.ucentral.servicio;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionJPA {

	private static final EntityManagerFactory emf = buildEntityManagerFactory();

	private static EntityManagerFactory buildEntityManagerFactory() {
		try {
			return Persistence.createEntityManagerFactory("tiendaweb");
		} catch (Throwable e) {
                        System.out.print(e.getMessage());
			throw new RuntimeException("Error al crear la factoria JPA." + e.getMessage());
		}
	}

	public static EntityManagerFactory getJPAFactory() {
		return emf;
	}
}
