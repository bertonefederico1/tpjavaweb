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
		int matricula = Integer.parseInt(request.getParameter("matricula"));
		String nombre_y_apellido = request.getParameter("nombre_y_apellido");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String mail = request.getParameter("mail");
		Mecanico mec = new Mecanico();
		ControladorMecanico cm = new ControladorMecanico();
		mec.setDireccion(direccion);
		mec.setMail(mail);
		mec.setMatricula(matricula);
		mec.setNombre_y_apellido(nombre_y_apellido);
		mec.setTelefono(telefono);
		cm.modificarMecanico(mec);
		request.getRequestDispatcher("Mecanicos.jsp").forward(request,response);
	}
}
