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
 * Servlet implementation class NuevoMecanico
 */
@WebServlet("/NuevoMecanico")
public class NuevoMecanico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoMecanico() {
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
		String nombre_y_apellido = request.getParameter("nombreYApellido");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String mail = request.getParameter("mail");
		Mecanico mec = new Mecanico();
		ControladorMecanico cm = new ControladorMecanico();
		mec.setDireccion(direccion);
		mec.setMail(mail);
		mec.setNombre_y_apellido(nombre_y_apellido);
		mec.setTelefono(telefono);
		cm.agregarMecanico(mec);
		request.getRequestDispatcher("Mecanicos.jsp").forward(request, response);
	}
}

