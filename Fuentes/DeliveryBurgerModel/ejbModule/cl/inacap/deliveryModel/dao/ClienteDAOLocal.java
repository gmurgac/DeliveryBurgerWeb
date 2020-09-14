package cl.inacap.deliveryModel.dao;

import java.util.List;

import javax.ejb.Local;

import cl.inacap.deliveryModel.dto.Cliente;

@Local
public interface ClienteDAOLocal {
	void guardar(Cliente c);
	void remove(Cliente c);
	List<Cliente> getAll();
	Cliente findById(String id);
	List<Cliente> getById(String filtro);


}
