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

import sun.security.util.Length;
import logica.*;
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
		String dni, fecha_inicio, fecha_fin, reparaciones_realizadas, cod_reparacion_string;
		float mano_de_obra = 0;
		request.getSession().setAttribute("reparaciones_realizadas", request.getParameter("reparaciones_realizadas"));	
		request.getSession().setAttribute("mano_de_obra", request.getParameter("mano_de_obra"));
		dni = request.getParameter("dni_cliente");
		cod_reparacion_string = request.getParameter("cod_reparacion");
		ValidacionesIngresoDatos valida = new ValidacionesIngresoDatos();
		if(valida.ingresoYClienteVacio(dni, cod_reparacion_string)){
			response.sendRedirect("NuevaReparacion.jsp");
		}else{ 
			int cod_reparacion = Integer.parseInt(cod_reparacion_string);
			reparaciones_realizadas = request.getParameter("reparaciones_realizadas");
			if (request.getParameter("mano_de_obra") != null && request.getParameter("mano_de_obra").length() > 0){
				mano_de_obra = Float.parseFloat(request.getParameter("mano_de_obra"));
			}
			fecha_inicio = request.getParameter("fecha_inicio");
			fecha_fin = request.getParameter("fecha_fin");
			Date fecha_fin_formateada = null;
			Date fecha_inicio_formateada = null;
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			try {
				fecha_fin_formateada = formatter.parse(fecha_fin);
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
			rep.setPrecioManoDeObra(mano_de_obra);
			rep.setFechaFin(fecha_fin_formateada);
			switch (request.getParameter("btn_reparacion")){
			case "agregar":{
				request.getRequestDispatcher("SeleccionRepuesto.jsp").forward(request, response);
				break;
			}
			case "guardar":{
				cr.agregarReparacion(repuestosSeleccionados, rep,"En curso");
				request.getRequestDispatcher("DatosGuardados.html").forward(request, response);
				break;
			}
			case "finalizar":{
				cr.agregarReparacion(repuestosSeleccionados, rep, "Finalizada");
				request.getRequestDispatcher("DatosGuardados.html").forward(request, response);
				break;
			}
			case "guardarReparacionModificada": {
				ArrayList<LineaDeRepuesto> repuestosOriginal = (ArrayList<LineaDeRepuesto>)request.getSession().getAttribute("repuestosSeleccionadosOriginal");
				cr.modificarReparacion(repuestosSeleccionados, repuestosOriginal, rep, "En Curso");
				request.getRequestDispatcher("DatosGuardados.html").forward(request, response);
				break;
			}
			case "finalizarReparacionModificada": {
				ArrayList<LineaDeRepuesto> repuestosOriginal = (ArrayList<LineaDeRepuesto>)request.getSession().getAttribute("repuestosSeleccionadosOriginal");
				cr.modificarReparacion(repuestosSeleccionados, repuestosOriginal, rep, "Finalizada");
				request.getRequestDispatcher("DatosGuardados.html").forward(request, response);
				break;
			}
			}	
		}
	}
}
