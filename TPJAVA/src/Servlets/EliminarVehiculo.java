package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.ControladorVehiculo;

/**
 * Servlet implementation class EliminarVehiculo
 */
@WebServlet({ "/EliminarVehiculo", "/ELIMINARVEHICULO", "/eliminarvehiculo" })
public class EliminarVehiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarVehiculo() {
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
		String patente = request.getParameter("patente");
		ControladorVehiculo cv = new ControladorVehiculo();
		cv.eliminarVehiculo(patente);
		request.getRequestDispatcher("MostrarVehiculosPorCliente.jsp").forward(request, response);
	}

}
