package Servlets;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.*;
import entidades.*;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet({ "/ServletLogin", "/Login", "/login", "/LOGIN" })
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
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
		String password = request.getParameter("password");
		Statement stmt=null;
		ResultSet rs=null;
		//System.out.println(user);
		try {
			stmt= Conexion.getInstancia().getConn().createStatement();
			System.out.println(user);
			rs= stmt.executeQuery("SELECT * FROM usuario_y_contrasenia");
			while (rs.next()){
				if (rs.getString("usuario").equals(user) && rs.getString("contrasenia").equals(password)){
					//request.getRequestDispatcher("Principal.jsp").forward(request, response);
					System.out.println("CORRECTO");
				} else {
					System.out.println("INCORRECTO");
				}
					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
