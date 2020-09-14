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


import cl.inacap.deliveryModel.dao.RepartidorDAOLocal;

import cl.inacap.deliveryModel.dto.Repartidor;

/**
 * Servlet implementation class AgregarRepartidorController
 */
@WebServlet("/AgregarRepartidorController.do")
public class AgregarRepartidorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @Inject
       RepartidorDAOLocal repartidorDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarRepartidorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/paginas/agregarRepartidores.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<String> errores= new ArrayList<String>();
		
		
		String nombre = request.getParameter("nombreTxt").trim();
		if(nombre.isEmpty()) {
			errores.add("Debe ingresar un nombre");
		}
		String apellido = request.getParameter("apellidoTxt").trim();
		if(apellido.isEmpty()) {
			errores.add("Debe ingresar Apellido");
		}
		String numero_telefonico = request.getParameter("numContactoTxt").trim();
		int numero_tel=999;
		if(numero_telefonico.isEmpty()) {
			errores.add("Debe ingresar un numero de contacto");
		}else {
			
			try {
				numero_tel = Integer.parseInt(numero_telefonico);
			}catch(Exception e) {
				errores.add("Ingrese bien debe ser numero");
			}
		}
		String vehiculo = "";
		if(request.getParameter("bicicletaCheck")!=null) {
		vehiculo =	vehiculo+request.getParameter("bicicletaCheck");
		}
		if(request.getParameter("automovilCheck")!=null) {
		vehiculo =  vehiculo+", "+request.getParameter("automovilCheck");
	}
		if(request.getParameter("motocicletaCheck")!=null) {
		vehiculo =  vehiculo+", "+request.getParameter("motocicletaCheck");
		}
		vehiculo = vehiculo.trim();
		if(vehiculo.isEmpty()) {
			errores.add("Debe seleccionar al menos 1 vehiculo");
		}
		String disponibilidad = ""+request.getParameter("disponibilidadRadio");
		int numeroDisponibilidad = 0;
		if(disponibilidad.equalsIgnoreCase("Media Jornada Tarde")) {
			numeroDisponibilidad = 2;
		}else if(disponibilidad.equalsIgnoreCase("Media Jornada Mañana")){
			numeroDisponibilidad = 1;
		}else if(disponibilidad.equalsIgnoreCase("full time")){
			numeroDisponibilidad = 3;
		}
		if(numeroDisponibilidad==0){
			errores.add("Debe seleccionar disponibilidad"); //grande profe seba
		}
		
		
		
		if(errores.isEmpty()) {
			Repartidor r = new Repartidor();
			r.setNombre(nombre);
			r.setApellido(apellido);
			r.setVehiculo(vehiculo);
			r.setDisponibilidad(numeroDisponibilidad);
			r.setNumero_telefonico(numero_tel);
			repartidorDAO.guardar(r);
			
			
			response.sendRedirect("ListarRepartidorController.do");
		}else {
			
			request.setAttribute("errores", errores);
		
		
		
		doGet(request, response);
	}

	}
}
