package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.*;

import java.util.ArrayList;

import entidades.*;

/**
 * Servlet implementation class ClienteFiltro
 */
@WebServlet({ "/ClienteFiltro", "/CLIENTEFILTRO", "/clientefiltro" })
public class ClienteFiltro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteFiltro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombuscar = request.getParameter("txtbuscar");
		ClienteFiltrar c = new ClienteFiltrar();
		ArrayList<Cliente> misClientes= c.traerClientes(nombuscar);
		request.getSession().setAttribute("misClientes", misClientes);
		request.getRequestDispatcher("BusquedaFiltradaClientes.jsp").forward(request, response);
		
	}

}
