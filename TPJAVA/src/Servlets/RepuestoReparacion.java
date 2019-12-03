package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entidades.*;
import logica.*;

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
		String cantidad_string = request.getParameter("cantidad");
		boolean band = true;
		boolean band2 = true;
		ArrayList <LineaDeRepuesto> repuestosSeleccionados = new ArrayList<LineaDeRepuesto>();
		ArrayList <Repuesto> misRepuestos = new ArrayList<Repuesto>();
		ControladorRepuesto cr = new ControladorRepuesto();
		if(cantidad_string != null && cantidad_string.length() > 0){
			if(ValidacionesIngresoDatos.validaLongitudHasta4(cantidad_string) && ValidacionesIngresoDatos.validaSoloNumeros(cantidad_string)){	
			} else {
				band = false;
			}
		} else {
			band = false;
		}
		
		if (band){
			repuestosSeleccionados = (ArrayList<LineaDeRepuesto>)request.getSession().getAttribute("repuestosSeleccionados");
			misRepuestos = cr.traerRepuestos();
			//misRepuestos = (ArrayList<Repuesto>)request.getSession().getAttribute("misRepuestos");
			ControladorLineaDeRepuesto cldr = new ControladorLineaDeRepuesto();
			int cantidad = Integer.parseInt(request.getParameter("cantidad"));
			if(cldr.hayStock(repuestosSeleccionados, misRepuestos, cod_repuesto, cantidad)){
				if (cldr.repuestoNoRepetido(repuestosSeleccionados, cod_repuesto, cantidad)){
					request.getSession().setAttribute("repuestosSeleccionados", cldr.agregarLinea(repuestosSeleccionados, cantidad, cod_repuesto));
				}
			} else {
				band2 = false;
				request.getRequestDispatcher("ErrorStock.jsp").forward(request, response);
			}
			if (band2){
				if (((String)request.getSession().getAttribute("tipo")).equalsIgnoreCase("nueva_reparacion")) {
					response.sendRedirect("NuevaReparacion.jsp");
				} else {
					response.sendRedirect("EditarReparacion.jsp");
				}
			}
		} else {
			request.getRequestDispatcher("SeleccionRepuesto.jsp").forward(request, response);
		}
					
	}

}
