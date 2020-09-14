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
import cl.inacap.deliveryModel.dto.Burger;
import cl.inacap.deliveryModel.dto.Repartidor;

/**
 * Servlet implementation class ListarRepartidorController
 */
@WebServlet("/ListarRepartidorController.do")
public class ListarRepartidorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	RepartidorDAOLocal repartidorDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListarRepartidorController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		List<Repartidor> repartidores = new ArrayList<Repartidor>();
		String filtro = request.getParameter("filtroSelect");
		if(filtro != null) {
			int numeroDisponibilidad=0;
			if(filtro.equalsIgnoreCase("media jornada mañana")) {
				numeroDisponibilidad=1;
			}
			if(filtro.equalsIgnoreCase("media jornada tarde")) {
				numeroDisponibilidad=2;
			}
			if(filtro.equalsIgnoreCase("full time")) {
				numeroDisponibilidad=3;
			}
			
			repartidores = repartidorDAO.getRepartidoresByDisponibilidad(numeroDisponibilidad);
			
			
		}else {
		
		repartidores = repartidorDAO.getAll();
		
		}
		request.setAttribute("repartidores", repartidores);

		request.getRequestDispatcher("WEB-INF/paginas/listarRepartidores.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idEliminar = request.getParameter("idEliminarTxt");
		if (idEliminar != null) {
			try {
				int idEliminarInt = Integer.parseInt(idEliminar.trim());
				Repartidor r = repartidorDAO.findById(idEliminarInt);
				repartidorDAO.remove(r);
			} catch (Exception e) {

			}
		}

		doGet(request, response);
	}

}
