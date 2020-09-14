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


import cl.inacap.deliveryModel.dao.BurgerDAOLocal;
import cl.inacap.deliveryModel.dto.Burger;

/**
 * Servlet implementation class AgregarBurgerController
 */
@WebServlet("/AgregarBurgerController.do")
public class AgregarBurgerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @Inject
       BurgerDAOLocal burgersDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarBurgerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		request.getRequestDispatcher("WEB-INF/paginas/agregarBurgers.jsp").forward(request, response);
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
		String descripcion = request.getParameter("descripcionTxt").trim();
		if(descripcion.isEmpty()) {
			errores.add("Debe ingresar descripcion");
		}
		String precio = request.getParameter("precioTxt").trim();
		int precioI=999;
		if(precio.isEmpty()) {
			errores.add("Debe asignarle un precio");
		}else {
			
			try {
				precioI = Integer.parseInt(precio);
			}catch(Exception e) {
				errores.add("Ingrese bien debe ser numero");
			}
		}
		
		if(errores.isEmpty()) {
			Burger b = new Burger();
			b.setNombre(nombre);
			b.setDescripcion(descripcion);
			b.setPrecio(precioI);
			burgersDAO.guardar(b);
			
			response.sendRedirect("ListarBurgerController.do");
		}else {
			
			request.setAttribute("errores", errores);
		
		
		
		doGet(request, response);
	}

	}}
