package Servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.ControladorReparacion;
import entidades.*;

/**
 * Servlet implementation class CargarReparacion
 */
@WebServlet({ "/CargarReparacion", "/cargarreparacion", "/CARGARREPARACION" })
public class CargarReparacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargarReparacion() {
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
		String dni, fecha_inicio, reparaciones_realizadas;
		dni = request.getParameter("dni_cliente");
		int cod_reparacion = Integer.parseInt(request.getParameter("cod_reparacion"));
		reparaciones_realizadas = request.getParameter("reparaciones_realizadas");
		fecha_inicio = request.getParameter("fecha_inicio");
		Date fecha_inicio_formateada = null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			fecha_inicio_formateada = formatter.parse(fecha_inicio);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Reparacion rep = new Reparacion();
		ControladorReparacion cr = new ControladorReparacion();
		ArrayList<LineaDeRepuesto> repuestosSeleccionados = (ArrayList<LineaDeRepuesto>)request.getSession().getAttribute("repuestosSeleccionados");
		rep.setNroReparacion(cod_reparacion);
		rep.setFechaInicio(fecha_inicio_formateada);
		rep.setDescFinal(reparaciones_realizadas);
		cr.agregarReparacion(repuestosSeleccionados, rep, dni);
		request.getRequestDispatcher("DatosGuardados.html").forward(request, response);
	}

}
