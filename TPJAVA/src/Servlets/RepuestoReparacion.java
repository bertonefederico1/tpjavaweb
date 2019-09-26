package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.LineaDeRepuesto;
import logica.ControladorLineaDeRepuesto;

/**
 * Servlet implementation class RepuestoReparacion
 */
@WebServlet({ "/RepuestoReparacion", "/repuestoreparacion", "/REPUESTOREPARACION" })
public class RepuestoReparacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RepuestoReparacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod_repuesto = Integer.parseInt(request.getParameter("cod_repuesto"));
		String dni = request.getParameter("dni");
		int nro_reparacion = Integer.parseInt(request.getParameter("nro_reparacion"));
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		ArrayList <LineaDeRepuesto> repuestosSeleccionados = new ArrayList<LineaDeRepuesto>();
		repuestosSeleccionados = (ArrayList<LineaDeRepuesto>)request.getSession().getAttribute("repuestosSeleccionados");
		ControladorLineaDeRepuesto cldr = new ControladorLineaDeRepuesto();
		repuestosSeleccionados.add(cldr.agregarLinea(cantidad, cod_repuesto));
		request.getSession().setAttribute("repuestosSeleccionados", repuestosSeleccionados);
		request.getRequestDispatcher("NuevaReparacion.jsp").forward(request,response);
	}

}
