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
 * Servlet implementation class ModificarCliente
 */
@WebServlet({ "/ModificarCliente", "/MODIFICARCLIENTE", "/modificarcliente" })
public class ModificarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarCliente() {
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
		String nombre_y_apellido = request.getParameter("nombre_y_apellido");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String mail = request.getParameter("mail");
		PreparedStatement pstmt = null;
		String sql= ("UPDATE clientes SET nombre_y_apellido='"+nombre_y_apellido+"',dni='"+dni+"',direccion='"+direccion+"',telefono='"
		+telefono+"',mail='"+mail+"'WHERE dni="+dni);
		try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(sql);
			int rs = pstmt.executeUpdate();
			if (rs > 0){
				request.getRequestDispatcher("Clientes.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("DatosNoGuardados.html").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				pstmt.close();
				Conexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
