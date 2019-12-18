package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.DatosTurno;
import logica.ControladorCliente;
import logica.ControladorTurno;
import logica.ControladorVehiculo;


/**
 * Servlet implementation class EliminarCliente
 */
@WebServlet({ "/EliminarCliente", "/ELIMINARCLIENTE", "/eliminarcliente", "/ELIMINARcliente" })
public class EliminarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dni= Integer.parseInt(request.getParameter("dni"));
		ControladorCliente cc= new ControladorCliente();
		ControladorVehiculo cv= new ControladorVehiculo();
		ControladorTurno ct = new ControladorTurno();
		try {
			cc.eliminarCliente(dni);
			cv.eliminarVehiculoCliente(dni);
			ct.eliminarTurno(dni);
			request.getRequestDispatcher("Clientes.jsp").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("ErrorGeneral.html").forward(request, response);
		}
		
	}

}
