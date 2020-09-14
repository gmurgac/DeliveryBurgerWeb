package cl.inacap.deliveryModel.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cl.inacap.deliveryModel.dto.Burger;
import cl.inacap.deliveryModel.dto.Cliente;
import cl.inacap.deliveryModel.dto.Repartidor;

/**
 * Session Bean implementation class ClienteDAO
 */
@Stateless
@LocalBean
public class ClienteDAO implements ClienteDAOLocal {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeliveryBurgerModel");
    /**
     * Default constructor. 
     */
    public ClienteDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void guardar(Cliente c) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.persist(c);
			em.flush();
		}catch(Exception ex) {
			
		}finally {
			em.close();
		}
	}

	@Override
	public void remove(Cliente c) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.remove(em.find(Cliente.class, c.getId_cliente()));
			em.flush();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}finally {
			em.close();
		}
	}

	@Override
	public List<Cliente> getAll() {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			return em.createNamedQuery("Cliente.findAll", Cliente.class).getResultList();
		}catch(Exception ex) {
			return null;
		}finally {
			em.close();
		}
	}

	@Override
	public Cliente findById(String id) {
		
		EntityManager em = this.emf.createEntityManager();
		try {
			return em.find(Cliente.class, id); 
		}catch(Exception ex) {
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public List<Cliente> getById(String id) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			return em.createNamedQuery("Cliente.findAllById", Cliente.class)
					.setParameter("id_cliente", id)
					.getResultList(); 
		}catch(Exception ex) {
			return null;
		} finally {
			em.close();
		}
	}

	

	
}
