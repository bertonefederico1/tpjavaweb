package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.ControladorMecanico;
import entidades.*;

/**
 * Servlet implementation class MecanicoFiltro
 */
@WebServlet({ "/MecanicoFiltro", "/MECANICOFILTRO", "/mecanicofiltro" })
public class MecanicoFiltro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MecanicoFiltro() {
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
		String buscamecanico = request.getParameter("txtbuscar");
		ControladorMecanico cm = new ControladorMecanico();
		ArrayList<Mecanico> misMecanicos;
		try {
			misMecanicos = cm.mecanicosFiltrados(buscamecanico);
			request.getSession().setAttribute("misMecanicos", misMecanicos);
			request.getRequestDispatcher("BusquedaFiltradaMecanicos.jsp").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("ErrorGeneral.html").forward(request, response);
		}
	}

}
