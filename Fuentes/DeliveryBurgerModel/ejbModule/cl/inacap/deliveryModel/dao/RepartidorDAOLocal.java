package cl.inacap.deliveryModel.dao;

import java.util.List;

import javax.ejb.Local;

import cl.inacap.deliveryModel.dto.Repartidor;

@Local
public interface RepartidorDAOLocal {
	void guardar(Repartidor r);
	void remove(Repartidor r);
	List<Repartidor> getAll();
	Repartidor findById(int idEliminarInt);
	List<Repartidor> getRepartidoresByDisponibilidad(int numeroDisponibilidad);

}
