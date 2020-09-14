package cl.inacap.deliveryModel.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="repartidores")
@NamedQueries({
	@NamedQuery(name = "Repartidor.findAll", query = "SELECT r FROM Repartidor r"),
	@NamedQuery(name = "Repartidor.findAllByDispo", 
	query = "SELECT r FROM Repartidor r WHERE r.disponibilidad = :disponibilidad")
	
	
})
public class Repartidor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_repartidor;
	public int getId_repartidor() {
		return id_repartidor;
	}
	public void setId_repartidor(int id_repartidor) {
		this.id_repartidor = id_repartidor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}
	public int getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public int getNumero_telefonico() {
		return numero_telefonico;
	}
	public void setNumero_telefonico(int numero_telefonico) {
		this.numero_telefonico = numero_telefonico;
	}
	private String nombre;
	private String apellido;
	private String vehiculo;
	private int disponibilidad;
	private int numero_telefonico;

}

