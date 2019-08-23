package Servlets;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.*;

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
		PreparedStatement pstmt = null;
		String sql = ("UPDATE mecanicos SET nombre_y_apellido=?,matricula=?,direccion=?,telefono=?,mail=? WHERE matricula=?");
		try {
			pstmt = Conexion.getInstancia().getConn().prepareStatement(sql);
			pstmt.setString(1, nombre_y_apellido);
			pstmt.setInt(2, matricula);
			pstmt.setString(3, direccion);
			pstmt.setString(4, telefono);
			pstmt.setString(5, mail);
			pstmt.setInt(6, matricula);
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				request.getRequestDispatcher("Mecanicos.jsp").forward(request,
						response);
			} else {
				request.getRequestDispatcher("DatosNoGuardados.html").forward(
						request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				Conexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
