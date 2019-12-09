package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Turno;
import logica.ControladorTurno;

/**
 * Servlet implementation class TurnoFiltro
 */
@WebServlet({ "/TurnoFiltro", "/TURNOFILTRO", "/TURNOfiltro", "/turnoFILTRO", "/turnofiltro", "/turnoFiltro", "/Turnofiltro" })
public class TurnoFiltro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TurnoFiltro() {
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
		ControladorTurno ct = new ControladorTurno();
		ArrayList<Turno> misTurnos = new ArrayList<Turno>();
		
		switch (request.getParameter("buscar")) {
		case "Buscar Por Fecha": {
			String buscaTurno = request.getParameter("buscar_por_fecha");
			misTurnos = ct.turnosFiltrados(buscaTurno, "fecha");
			break;
		}
		case "Buscar Por Cliente": {
			String buscaTurno = request.getParameter("buscar_por_cliente");
			misTurnos = ct.turnosFiltrados(buscaTurno, "cliente");
			break;
		}
		}		
		request.getSession().setAttribute("misTurnos", misTurnos);
		request.getRequestDispatcher("BusquedaFiltradaTurnos.jsp").forward(request, response);
	}

}
