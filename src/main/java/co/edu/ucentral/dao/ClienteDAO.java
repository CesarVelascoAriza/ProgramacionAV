package co.edu.ucentral.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import co.edu.ucentral.modelo.Cliente;
import co.edu.ucentral.servicio.ConexionJPA;
import java.io.Console;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;

public class ClienteDAO {
    
    private static ClienteDAO clienteDAO;
    private EntityManager em;
    
    public ClienteDAO() {
    }
    
    public static ClienteDAO instancia() {
        if (clienteDAO == null) {
            clienteDAO = new ClienteDAO();
        }
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
    
    public Cliente buscarXID(Integer IDCliente) {
        EntityManagerFactory factoriaSesion = ConexionJPA.getJPAFactory();
        em = factoriaSesion.createEntityManager();
        Cliente cliente = new Cliente();
        Query query = em.createNamedQuery("Cliente.findByIdCliente", Cliente.class);
        query.setParameter("idCliente", IDCliente);
        try {
            List<Cliente> listado = (List<Cliente>) query.getResultList();
            if (!listado.isEmpty()) {
                cliente = listado.get(0);
            } else {
                cliente.setIdCliente(IDCliente);
                cliente.setFechaNacimento(Date.from(Instant.now()));
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        } finally {
            if (cliente != null) {
                em.close();
            }
        }
        return cliente;
    }
    
    public String actualizarCliente(Cliente cliente) {
        EntityManagerFactory factoriaSesion = ConexionJPA.getJPAFactory();
        em = factoriaSesion.createEntityManager();
        EntityTransaction tx = null;
        String mensaje = "";
        try {
            tx = em.getTransaction();
            tx.begin();
            em.merge(cliente);
            tx.commit();
            mensaje = "El usuario se ha actualizado exitosamente";
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            mensaje = "El usuario no ha sido posible crearlospor favor intentelo de nuevo";
        } finally {
            em.close();
        }
        return mensaje;
    }
    
}
