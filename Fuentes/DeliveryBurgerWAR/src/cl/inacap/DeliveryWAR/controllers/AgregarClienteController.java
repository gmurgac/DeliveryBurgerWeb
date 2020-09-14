package cl.inacap.DeliveryWAR.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.deliveryModel.dao.ClienteDAOLocal;
import cl.inacap.deliveryModel.dto.Cliente;

/**
 * Servlet implementation class AgregarClienteController
 */
@WebServlet("/AgregarClienteController.do")
public class AgregarClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @Inject
       ClienteDAOLocal clientesDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarClienteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/paginas/agregarClientes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<String> errores = new ArrayList<String>();
		String rut = request.getParameter("rutTxt").trim();
		String nombre = request.getParameter("nombreTxt").trim();
		String apellido = request.getParameter("apellidoTxt").trim();
		String edad = request.getParameter("edadTxt").trim();
		String direccion = request.getParameter("direccionTxt").trim();
		String numeroContacto = request.getParameter("telefonoTxt").trim();
		char[] numero = new char[8];
		if(rut.isEmpty()) {
			errores.add("Rut vacio");
		}
		if(rut.length()>10) {    //Solo mayores a los 10 millones
			
			errores.add("Formato incorrecto rut");
		}
		
		while(rut.length()<10) {  //do while
			rut = "0"+rut;
		}
		if(rut.length()==10 && rut.charAt(8)=='-' &&(rut.charAt(9)=='k' 
				 || rut.charAt(9)=='0' || rut.charAt(9)=='1' || rut.charAt(9)=='2'
				 || rut.charAt(9)=='5' || rut.charAt(9)=='4' || rut.charAt(9)=='3'
				 || rut.charAt(9)=='6' || rut.charAt(9)=='9' || rut.charAt(9)=='9'
				 || rut.charAt(9)=='7' || rut.charAt(9)=='8')) {
			rut.getChars(0, 8, numero, 0);
			String s = String.valueOf(numero);
			try {
				int num = Integer.parseInt(s);
				int i=7;
				int suma=0;
				int j=2;
				for(i=7;i>1;i--) {
					suma = suma+(Character.getNumericValue(numero[i])*(j));
					j=j+1;
				}
				j=2;
				for(i=1;i>-1;i--) {
					suma = suma+(Character.getNumericValue(numero[i])*(j));
					j=j+1;
				}
				int modulo = Math.floorDiv(suma, 11);     
				int multi = 11*modulo;
				int sum2 = suma - multi;
				
				int resultado = 11-Math.abs(sum2);
				if(rut.charAt(9)=='k' && resultado!=10) {
					
						errores.add("Digito verificador incorrecto");
					
				}
				if(rut.charAt(9)=='0') {
					if(resultado!=10 || resultado!=0) {
						errores.add("Digito verificador incorrecto");
					}
				}
				if(rut.charAt(9)!='k' && rut.charAt(9)!='0' && resultado!=Character.getNumericValue(rut.charAt(9))) {
					errores.add("Digito verificador incorrecto ");
				}
				
			}catch(Exception e) {
				errores.add("Rut formato incorrecto");
			}
		}else {
			errores.add("Rut incorrecto");
		}
		if(nombre.isEmpty()) {
			errores.add("Nombre vacio");
		}
		if(apellido.isEmpty()) {
			errores.add("Apellido vacio");
		}
		if(edad.isEmpty()) {
			errores.add("Edad vacia");
		}
		int anios=0;
		try {
			anios = Integer.parseInt(edad);
		}catch(Exception e) {
			errores.add("Edad formato incorrecto");
		}
		if (anios>120){
			errores.add("Edad supera el limite");
		}
		
		if(direccion.isEmpty()) {
			errores.add("Direccion vacia");
		}
		int telefono=0;
		if(numeroContacto.isEmpty()) {
			errores.add("Numero vacio");
		}else {
			try {
				telefono=Integer.parseInt(numeroContacto);
		if(numeroContacto.length()!=9) {
			errores.add("Formato incorrecto de telefono");
		}
			}catch(Exception e){
				errores.add("Numero invalido");
			}
		}
		
		if(errores.isEmpty()) {
			Cliente c = new Cliente();
			
				
			while(rut.charAt(0)=='0') {
				char[] rutChar = new char[rut.length()];
				rut.getChars(1, rut.length(), rutChar, 0);
				rut=String.valueOf(rutChar);
			}
			
			
			
			
			c.setId_cliente(rut.trim());
			c.setNombre(nombre);
			c.setApellido(apellido);
			c.setDireccion(direccion);
			c.setEdad(anios);
			c.setNumero_contacto(telefono);
			if(clientesDAO.findById(rut.trim())==null) {
				clientesDAO.guardar(c);
			response.sendRedirect("ListarClienteController.do");
			}else {
				errores.add("No se pudo agregar, porque ya existe");
				request.setAttribute("errores", errores);
				doGet(request, response);
			}
			
		}else {
			
			request.setAttribute("errores", errores);
			doGet(request, response);
		}
		
		
		
		
		
	}

}
