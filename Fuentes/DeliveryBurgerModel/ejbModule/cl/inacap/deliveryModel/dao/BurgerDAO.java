package cl.inacap.deliveryModel.dao;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import cl.inacap.deliveryModel.dto.Burger;

/**
 * Session Bean implementation class BurgerDAO
 */
@Stateless
@LocalBean
public class BurgerDAO implements BurgerDAOLocal {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeliveryBurgerModel");
    /**
     * Default constructor. 
     */
    public BurgerDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void guardar(Burger b) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.persist(b);
			em.flush();
		}catch(Exception ex) {
			
		}finally {
			em.close();
		}
	}

	@Override
	public void remove(Burger b) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.remove(em.find(Burger.class, b.getId_burger()));
			em.flush();
		}catch(Exception ex) {
			
		}finally {
			em.close();
		}
	}

	@Override
	public List<Burger> getAll() {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			return em.createNamedQuery("Burger.findAll", Burger.class).getResultList();
		}catch(Exception ex) {
			return null;
		}finally {
			em.close();
		}
	}

	@Override
	public List<Burger> getBurgersByDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			
			return em.createNamedQuery("Hamburgesa.findByDescripcion", Burger.class)
					.setParameter("descripcion", descripcion)
					.getResultList();
		}catch(Exception ex) {
			return null;
		}finally {
			em.close();
		}
	}

	@Override
	public Burger findById(int id) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			return em.find(Burger.class, id); 
		}catch(Exception ex) {
			return null;
		} finally {
			em.close();
		}
	}
	}
	


