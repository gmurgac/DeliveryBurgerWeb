package cl.inacap.deliveryModel.dto;


	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

	@Entity
	@Table(name="clientes")
	@NamedQueries({
		@NamedQuery(name = "Cliente.findAll", query= "SELECT c FROM Cliente c"),
		@NamedQuery(name = "Cliente.findAllById", query= "SELECT c FROM Cliente c WHERE c.id_cliente = :id_cliente")
		
	})
	public class Cliente {
		@Id
		private String id_cliente;

		public String getId_cliente() {
			return id_cliente;
		}
		public void setId_cliente(String id_cliente) {
			this.id_cliente = id_cliente;
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
		public int getEdad() {
			return edad;
		}
		public void setEdad(int edad) {
			this.edad = edad;
		}
		public String getDireccion() {
			return direccion;
		}
		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}
		public int getNumero_contacto() {
			return numero_contacto;
		}
		public void setNumero_contacto(int numero_contacto) {
			this.numero_contacto = numero_contacto;
		}
		private String nombre;
		private String apellido;
		private int edad;
		private String direccion;
		private int numero_contacto;
	}


