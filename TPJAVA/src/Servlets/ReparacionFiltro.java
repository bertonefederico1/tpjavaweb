package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.ControladorReparacion;

/**
 * Servlet implementation class ReparacionFiltro
 */
@WebServlet({ "/ReparacionFiltro", "/reparacionfiltro", "/REPARACIONFILTRO" })
public class ReparacionFiltro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReparacionFiltro() {
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
		ControladorReparacion cr = new ControladorReparacion();
		try {
			request.getSession().setAttribute("misReparaciones", cr.reparacionesFiltradas(nombuscar));
			request.getRequestDispatcher("BusquedaFiltradaReparaciones.jsp").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("ErrorGeneral.html").forward(request, response);
		}
	}

}
