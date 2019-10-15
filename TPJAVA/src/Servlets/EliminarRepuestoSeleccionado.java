package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.ControladorLineaDeRepuesto;
import entidades.LineaDeRepuesto;

/**
 * Servlet implementation class EliminarRepuestoSeleccionado
 */
@WebServlet({ "/EliminarRepuestoSeleccionado", "/ELIMINARREPUESTOSELECCIONADO", "/eliminarrepuestoseleccionado" })
public class EliminarRepuestoSeleccionado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarRepuestoSeleccionado() {
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
		int cod_repuesto = Integer.parseInt(request.getParameter("cod_repuesto"));
		ArrayList<LineaDeRepuesto> repuestosSeleccionados = (ArrayList<LineaDeRepuesto>)request.getSession().getAttribute("repuestosSeleccionados");
		ControladorLineaDeRepuesto cldr = new ControladorLineaDeRepuesto();
		request.getSession().setAttribute("repuestosSeleccionados", cldr.eliminarRepuestoSeleccionado(cod_repuesto, repuestosSeleccionados));
		response.sendRedirect("NuevaReparacion.jsp");
	}

}
