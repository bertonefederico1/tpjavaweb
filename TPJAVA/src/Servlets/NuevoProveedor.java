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
 * Servlet implementation class NuevoProveedor
 */
@WebServlet({ "/NuevoProveedor", "/NUEVOPROVEEDOR", "/nuevoproveedor", "/Nuevoproveedor" })
public class NuevoProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoProveedor() {
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
		String razon_social = request.getParameter("razon_social");
		String cuit = request.getParameter("cuit");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String mail = request.getParameter("mail");
		PreparedStatement pstmt = null;
		String insertar = ("insert into proveedores(cuit,razon_social,direccion,mail,telefono) values(?,?,?,?,?)");
		try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(insertar);
			pstmt.setString(1, cuit);
			pstmt.setString(2, razon_social);
			pstmt.setString(3, direccion);
			pstmt.setString(4, mail);
			pstmt.setString(5, telefono);
			int resp = pstmt.executeUpdate();
			if (resp>0){
				request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
				pstmt.close();
				Conexion.getInstancia().releaseConn();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
