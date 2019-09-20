package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;

import logica.*;
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
		String nombuscar = request.getParameter("txtbuscar");
		String tipo = request.getParameter("tipo");
		System.out.println(tipo);
		ControladorCliente cc = new ControladorCliente();
		ArrayList<Cliente> misClientes= cc.clientesFiltrados(nombuscar);
		request.getSession().setAttribute("misClientes", misClientes);
		request.getRequestDispatcher("SeleccionClientesFiltrados.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombuscar = request.getParameter("txtbuscar");
		ControladorCliente cc = new ControladorCliente();
		ArrayList<Cliente> misClientes= cc.clientesFiltrados(nombuscar);
		request.getSession().setAttribute("misClientes", misClientes);
		request.getRequestDispatcher("BusquedaFiltradaClientes.jsp").forward(request, response);
		
	}

}
