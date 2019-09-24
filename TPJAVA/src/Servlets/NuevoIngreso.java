package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.*;
import logica.ControladorReparacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class NuevoIngreso
 */
@WebServlet({ "/NuevoIngreso", "/NUEVOINGRESO", "/nuevoingreso" })
public class NuevoIngreso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoIngreso() {
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
		String fecha_ingreso, patente, reparacionesARealizar, observaciones;
		fecha_ingreso= request.getParameter("fecha");
		patente= request.getParameter("patente");
		reparacionesARealizar= request.getParameter("reparacionesARealizar");
		observaciones= request.getParameter("observaciones");
		ControladorReparacion cr = new ControladorReparacion();
		Reparacion repa = new Reparacion();
		Date date=null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	    try {
	    	date = formatter.parse(fecha_ingreso);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }   
		repa.setEstado("Ingresada");
		repa.setFechaIngreso(date);
		repa.setDetalleInicial(reparacionesARealizar);
		repa.setObservaciones(observaciones);
		Auto auto = new Auto();
		auto.setPatente(patente);
		repa.setAuto(auto);
		cr.agregarNuevoIngreso(repa);
		request.getRequestDispatcher("DatosGuardados.html").forward(request, response);
	}

}
