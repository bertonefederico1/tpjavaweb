package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.ControladorVehiculo;

/**
 * Servlet implementation class VehiculosPorClienteFiltro
 */
@WebServlet({ "/VehiculosPorClienteFiltro", "/VEHICULOSPORCLIENTEFILTRO", "/vehiculosporclientefiltro" })
public class VehiculosPorClienteFiltro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehiculosPorClienteFiltro() {
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
		ControladorVehiculo cv = new ControladorVehiculo();
		request.getSession().setAttribute("misAutos", cv.vehiculosFiltrados(nombuscar));
		request.getRequestDispatcher("VehiculosPorClienteFiltrados.jsp").forward(request, response);
	}

}
