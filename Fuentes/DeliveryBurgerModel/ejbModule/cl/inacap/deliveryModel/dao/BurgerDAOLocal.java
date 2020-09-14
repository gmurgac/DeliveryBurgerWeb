package cl.inacap.deliveryModel.dao;

import java.util.List;

import javax.ejb.Local;

import cl.inacap.deliveryModel.dto.Burger;

@Local
public interface BurgerDAOLocal {
	void guardar(Burger b);
	void remove(Burger b);
	List<Burger> getAll();
	List<Burger> getBurgersByDescripcion(String descripcion);
	Burger findById(int idEliminarInt);

}
