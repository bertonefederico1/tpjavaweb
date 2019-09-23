package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.ControladorVehiculo;
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
		String dni = request.getParameter("dni");
		String patente = request.getParameter("patente");
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		int anio_fabricacion = Integer.parseInt(request.getParameter("anio_fabricacion"));
		Float cantidad_km = Float.parseFloat(request.getParameter("cantidad_km"));
		Auto auto = new Auto();
		ControladorVehiculo cr = new ControladorVehiculo();
		Cliente cli = new Cliente();
		auto.setMarca(marca);
		auto.setModelo(modelo);
		auto.setPatente(patente);
		auto.setCantKM(cantidad_km);
		auto.setAnio(anio_fabricacion);
		cli.setDni(dni);
		auto.setCli(cli);
		cr.agregarVehiculo(auto);
	}

}
