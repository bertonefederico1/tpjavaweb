package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.ControladorMecanico;

/**
 * Servlet implementation class EliminarMecanico
 */
@WebServlet({ "/EliminarMecanico", "/ELIMINARMECANICO", "/eliminarmecanico", "/ELIMINARmecanico" })
public class EliminarMecanico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarMecanico() {
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
		int matricula= Integer.parseInt(request.getParameter("matricula"));
		ControladorMecanico cm = new ControladorMecanico();
		try {
			cm.eliminarMecanico(matricula);
			cm.eliminarUsuarioYContrasenia (matricula);
			request.getRequestDispatcher("Mecanicos.jsp").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("ErrorGeneral.html").forward(request, response);
		}
	}

}
