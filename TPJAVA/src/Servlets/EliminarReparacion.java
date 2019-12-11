package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.ControladorReparacion;

/**
 * Servlet implementation class EliminarReparacion
 */
@WebServlet({ "/EliminarReparacion", "/ELIMINARREPARACION", "/eliminarreparacion" })
public class EliminarReparacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarReparacion() {
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
		int nro_reparacion= Integer.parseInt(request.getParameter("nro_reparacion"));
		ControladorReparacion cr= new ControladorReparacion();
		try {
			cr.eliminarReparacion(nro_reparacion);
		} catch (Exception e) {
			request.getRequestDispatcher("ErrorGeneral.html").forward(request, response);
		}
		request.getRequestDispatcher("Reparaciones.jsp").forward(request, response);
	}

}
