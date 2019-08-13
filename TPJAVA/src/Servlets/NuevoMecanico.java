package Servlets;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Conexion;

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
		PreparedStatement pstmt = null;
		String insertarMecanico = ("insert into mecanicos(nombre_y_apellido, direccion, telefono, mail) values(?,?,?,?)");
		try {
			pstmt = Conexion.getInstancia().getConn().prepareStatement(insertarMecanico);
			pstmt.setString(1, nombre_y_apellido);
			pstmt.setString(2, direccion);
			pstmt.setString(3, telefono);
			pstmt.setString(4, mail);
			int resp = pstmt.executeUpdate();
			if (resp>0){
				request.getRequestDispatcher("DatosGuardados.html").forward(request, response);
				pstmt.close();
				Conexion.getInstancia().releaseConn();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

