package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.ControladorTurno;

/**
 * Servlet implementation class CancelarTurno
 */
@WebServlet({ "/CancelarTurno", "/CANCELARTURNO", "/CANCELARturno", "/cancelarTURNO", "/cancelarTurno" })
public class CancelarTurno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelarTurno() {
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
		int nro_turno = Integer.parseInt(request.getParameter("nro_turno"));
		ControladorTurno ct = new ControladorTurno();
		try {
			ct.cancelarTurno(nro_turno);
			request.getSession().setAttribute("misTurnos", ct.traerTurnos());
			request.getRequestDispatcher("Turnos.jsp").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("ErrorGeneral.html").forward(request, response);
		}
	}

}
