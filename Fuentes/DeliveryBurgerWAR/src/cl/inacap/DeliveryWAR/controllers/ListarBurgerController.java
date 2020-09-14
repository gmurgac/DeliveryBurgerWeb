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
 * Servlet implementation class ListarBurgerController
 */
@WebServlet("/ListarBurgerController.do")
public class ListarBurgerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @Inject
       BurgerDAOLocal burgersDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarBurgerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Burger> burgers = new ArrayList<Burger>();
			
		String filtro = request.getParameter("filtroBurger");
		if(filtro != null) {
			for(Burger b: burgersDAO.getAll()) {
				if(b.getDescripcion().contains(filtro)) {  //en vista del tiempo no alcancé a realizar bien este filtro, asi que lo dejare ahi
					burgers.add(b);
				}
			}
			request.setAttribute("burgers", burgers);
		}else {
		
		burgers = burgersDAO.getAll();
		}
		request.setAttribute("burgers", burgers);
		
		
		
		request.getRequestDispatcher("WEB-INF/paginas/listarBurgers.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		
		
		
		String idEliminar = request.getParameter("idEliminarTxt");
		if(idEliminar != null) {
			try {
				int idEliminarInt = Integer.parseInt(idEliminar.trim());
				Burger b = burgersDAO.findById(idEliminarInt);
				burgersDAO.remove(b);
			}catch(Exception e) {
				
			}
		}
		
		
		doGet(request, response);
	}

}
