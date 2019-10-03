package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.ControladorRepuesto;
import logica.Ingreso;
import entidades.*;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet({ "/SignIn", "/SIGNIN", "/signin", "/SIGNin" })
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignIn() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("usuario");
		String password = request.getParameter("contrasenia");
		Usuario u = new Usuario();
		Ingreso ingreso = new Ingreso();
		u.setUser(user);
		u.setPassword(password);
		if (ingreso.validaLogin(u)){
			ControladorRepuesto cr = new ControladorRepuesto();
			request.getSession().setAttribute("misRepuestos", cr.traerRepuestos());
			request.getSession().setAttribute("usuario", u);
			request.getRequestDispatcher("Principal.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("ErrorLogin.html").forward(request, response);
			}
		
	}
}
