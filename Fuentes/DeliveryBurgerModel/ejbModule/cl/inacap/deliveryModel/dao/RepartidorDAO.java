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
 * Session Bean implementation class RepartidorDAO
 */
@Stateless
@LocalBean
public class RepartidorDAO implements RepartidorDAOLocal {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeliveryBurgerModel");
    /**
     * Default constructor. 
     */
    public RepartidorDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void guardar(Repartidor r) {
		
		EntityManager em = this.emf.createEntityManager();
		try {
			em.persist(r);
			em.flush();
		}catch(Exception ex) {
			
		}finally {
			em.close();
		}
	}

	@Override
	public void remove(Repartidor r) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.remove(em.find(Repartidor.class, r.getId_repartidor()));
			em.flush();
		}catch(Exception ex) {
			
		}finally {
			em.close();
		}
	}

	@Override
	public List<Repartidor> getAll() {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			return em.createNamedQuery("Repartidor.findAll", Repartidor.class).getResultList();
		}catch(Exception ex) {
			return null;
		}finally {
			em.close();
		}
	}

	@Override
	public Repartidor findById(int id) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			return em.find(Repartidor.class, id); 
		}catch(Exception ex) {
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public List<Repartidor> getRepartidoresByDisponibilidad(int numeroDisponibilidad) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			return em.createNamedQuery("Repartidor.findAllByDispo", Repartidor.class)
					.setParameter("disponibilidad", numeroDisponibilidad)
					.getResultList(); 
		}catch(Exception ex) {
			return null;
		} finally {
			em.close();
		}
	}
	}


