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
 * Servlet implementation class ModificarProveedor
 */
@WebServlet({ "/ModificarProveedor", "/MODIFICARPROVEEDOR", "/MODIFICARproveedor", "/modificarproveedor" })
public class ModificarProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarProveedor() {
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
		String cuit = request.getParameter("cuit");
		String razon_social = request.getParameter("razon_social");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String mail = request.getParameter("mail");
		PreparedStatement pstmt = null;
		String sql= ("UPDATE proveedores SET razon_social='"+razon_social+"',cuit='"+cuit+"',direccion='"+direccion+"',telefono='"
				+telefono+"',mail='"+mail+"'WHERE cuit="+cuit);
		try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(sql);
			int rs = pstmt.executeUpdate();
			if (rs > 0){
				request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
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
