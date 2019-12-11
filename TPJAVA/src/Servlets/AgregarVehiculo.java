package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.ControladorVehiculo;
import logica.ValidacionesIngresoDatos;
import entidades.*;

/**
 * Servlet implementation class NuevoVehiculo
 */
@WebServlet({ "/AgregarVehiculo", "/agregarvehiculo", "/AGREGARVEHICULO" })
public class AgregarVehiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarVehiculo() {
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
		String dni = request.getParameter("dni");
		String patente = request.getParameter("patente");
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		String anio_fabricacion_string = request.getParameter("anio_fabricacion");
		String cantidad_km_string = request.getParameter("cantidad_km");
		boolean band = true;
		Auto auto = new Auto();
		if (patente != null && patente.length() > 0 && marca != null && marca.length() > 0 && modelo != null && modelo.length() > 0){
			if (ValidacionesIngresoDatos.validaLongitudHasta9(patente) && ValidacionesIngresoDatos.validaLongitudHasta100(marca)
				&& ValidacionesIngresoDatos.validaLongitudHasta100(modelo)){
			} else{
				band = false;
			}
			if (anio_fabricacion_string != null && anio_fabricacion_string.length() > 0){
				if (ValidacionesIngresoDatos.validaSoloNumeros(anio_fabricacion_string) && ValidacionesIngresoDatos.validaLongitudIgualA4(anio_fabricacion_string)){
					auto.setAnio(Integer.parseInt(anio_fabricacion_string));
				} else {
					band = false;
				}
			if (cantidad_km_string != null && cantidad_km_string.length() > 0){
				if (ValidacionesIngresoDatos.validaSoloNumeros(cantidad_km_string) && ValidacionesIngresoDatos.validaLongitudHasta10(cantidad_km_string)){
					auto.setCantKM(Integer.parseInt(cantidad_km_string));
				} else {
					band = false;
				}
			}
			}
		} else {
			band = false;
		}
		
		if (band){
			ControladorVehiculo cv = new ControladorVehiculo();
			Cliente cli = new Cliente();
			auto.setMarca(marca);
			auto.setModelo(modelo);
			auto.setPatente(patente);
			cli.setDni(dni);
			auto.setCli(cli);
			try {
				cv.agregarVehiculo(auto);
				request.getRequestDispatcher("MostrarVehiculosPorCliente.jsp").forward(request, response);
			} catch (Exception e) {
				request.getRequestDispatcher("ErrorGeneral.html").forward(request, response);
			}
			
		} else {
			request.getRequestDispatcher("ErrorValidacion.jsp").forward(request, response);
		}
		
	}

}
