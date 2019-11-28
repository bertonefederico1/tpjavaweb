package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.*;
import logica.*;

/**
 * Servlet implementation class ModificarVehiculo
 */
@WebServlet({ "/ModificarVehiculo", "/modificarvehiculo", "/MODIFICARVEHICULO" })
public class ModificarVehiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarVehiculo() {
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
		request.getSession().setAttribute("error", "validaVehiculo");
		String patente = request.getParameter("patente");
		String patente_original = request.getParameter("patente_original");
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		String anio = request.getParameter("anio");
		String cantidad_km = request.getParameter("cantidad_km");
		boolean band = true;
		Auto auto = new Auto();
		auto.setPatente(patente);
		auto.setModelo(modelo);
		auto.setMarca(marca);
		if(patente != null && patente.length() > 0 && marca != null && marca.length() > 0 && modelo != null && modelo.length() > 0){
			if(ValidacionesIngresoDatos.validaLongitudHasta9(patente) && ValidacionesIngresoDatos.validaLongitudHasta100(marca)
			   && ValidacionesIngresoDatos.validaLongitudHasta100(modelo)){
				if(anio != null && anio.length() > 0){
					if(ValidacionesIngresoDatos.validaLongitudIgualA4(anio) && ValidacionesIngresoDatos.validaSoloNumeros(anio)){
						auto.setAnio(Integer.parseInt(anio));
					}else {
						band = false;
					}
				}
				if(cantidad_km != null && cantidad_km.length() > 0){
					if(ValidacionesIngresoDatos.validaSoloNumerosFloat(cantidad_km) && ValidacionesIngresoDatos.validaLongitudHasta10(cantidad_km)){
						auto.setCantKM(Float.parseFloat(cantidad_km));
					}else {
						band = false;
					}
				}
			} else {
				band = false;
			}
		} else {
			band = false;
		}
		
		if (band){
			ControladorVehiculo cv = new ControladorVehiculo ();
			cv.modificarVehiculo(auto, patente_original);
			request.getRequestDispatcher("MostrarVehiculosPorCliente.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("ErrorValidacion.jsp").forward(request, response);
		}
	}

}
