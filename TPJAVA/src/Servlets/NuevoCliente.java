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
 * Servlet implementation class NuevoCliente
 */
@WebServlet({"/NuevoCliente", "/NUEVOCLIENTE", "/nuevocliente"})
public class NuevoCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoCliente() {
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
		int dni = Integer.parseInt(request.getParameter("dni"));
		String nombre_y_apellido = request.getParameter("nombreYApellido");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String mail = request.getParameter("mail");
		PreparedStatement pstmt = null;
		String insertar = ("insert into clientes(dni,nombre_y_apellido,direccion,mail,telefono) values(?,?,?,?,?)");
		try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(insertar);
			pstmt.setInt(1, dni);
			pstmt.setString(2, nombre_y_apellido);
			pstmt.setString(3, direccion);
			pstmt.setString(4, mail);
			pstmt.setString(5, telefono);
			int resp = pstmt.executeUpdate();
			if (resp>0){
				request.getRequestDispatcher("Clientes.jsp").forward(request, response);
				pstmt.close();
				Conexion.getInstancia().releaseConn();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
