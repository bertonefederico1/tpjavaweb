package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.*;
import entidades.*;

/**
 * Servlet implementation class ModificarMecanico
 */
@WebServlet({ "/ModificarMecanico", "/MODIFICARMECANICO", "/modificarmecanico",
		"/MODIFICARmecanico" })
public class ModificarMecanico extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificarMecanico() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("error", "validaMecanico");
		int matricula = Integer.parseInt(request.getParameter("matricula"));
		String nombre_y_apellido = request.getParameter("nombre_y_apellido");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("mail");
		boolean band = true;
		Mecanico mec = new Mecanico();
		mec.setDireccion(direccion);
		mec.setMail(email);
		mec.setMatricula(matricula);
		mec.setNombre_y_apellido(nombre_y_apellido);
		mec.setTelefono(telefono);
		
		if (nombre_y_apellido != null && nombre_y_apellido.length() > 0 && direccion != null && direccion.length() > 0){
			if(ValidacionesIngresoDatos.validaLongitudHasta100(nombre_y_apellido) 
			   && ValidacionesIngresoDatos.validaLongitudHasta100(direccion)){
				if(email != null && email.length() > 0){
					if(ValidacionesIngresoDatos.validaEmail(email)){
					}else{
						band = false;
					}
				}
				if(telefono != null && telefono.length() > 0){
					if(ValidacionesIngresoDatos.validaSoloNumeros(telefono) && ValidacionesIngresoDatos.validaLongitudHasta12(telefono)){
					}else {
						band = false;
					}
				}
			}else {
				band = false;
			}
		}else {
			band = false;
		}
		
		if(band){
			ControladorMecanico cm = new ControladorMecanico();
			cm.modificarMecanico(mec);
			request.getRequestDispatcher("Mecanicos.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("ErrorValidacion.jsp").forward(request, response);
		}	
	}
}
