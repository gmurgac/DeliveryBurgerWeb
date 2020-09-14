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
import cl.inacap.deliveryModel.dto.Burger;
import cl.inacap.deliveryModel.dto.Cliente;

/**
 * Servlet implementation class ListarClienteController
 */
@WebServlet("/ListarClienteController.do")
public class ListarClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @Inject
       ClienteDAOLocal clienteDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarClienteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Cliente> clientes = new ArrayList<Cliente>();;
		
		String filtroRut=request.getParameter("filtroCliente");
		if(filtroRut!=null) {
			clientes = clienteDAO.getById(filtroRut);
			
			
		}else{
		
		
			clientes = clienteDAO.getAll();
		}
		request.setAttribute("clientes", clientes);
		
		
		request.getRequestDispatcher("WEB-INF/paginas/listarClientes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idEliminar = request.getParameter("idEliminarTxt");
		if(idEliminar != null) {
			
				Cliente c = clienteDAO.findById(idEliminar);
				clienteDAO.remove(c);
			
				
			}
		
		
		doGet(request, response);
	}

}
