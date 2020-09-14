package cl.inacap.deliveryModel.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="hamburgesas")
@NamedQueries({
	@NamedQuery(name = "Burger.findAll", query= "SELECT b FROM Burger b"),
	@NamedQuery(name = "Burger.findByDescripcion"
		, query = "SELECT b FROM Burger b WHERE b.descripcion = :descripcion")
})

public class Burger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_burger;
	public int getId_burger() {
		return id_burger;
	}
	public void setId_burger(int id_burger) {
		this.id_burger = id_burger;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	private String nombre;
	private int precio;
	private String descripcion;

}