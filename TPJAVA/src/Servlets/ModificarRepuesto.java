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
 * Servlet implementation class ModificarRepuesto
 */
@WebServlet({ "/ModificarRepuesto", "/MODIFICARREPUESTO", "/modificarrepuesto", "/MODIFICARrepuesto" })
public class ModificarRepuesto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarRepuesto() {
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
		int cod_repuesto = Integer.parseInt(request.getParameter("codigo"));
		String descripcion = request.getParameter("descripcion");
		Float precio = Float.parseFloat(request.getParameter("precio"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		PreparedStatement pstmt = null;
		String sql= ("UPDATE repuestos SET descripcion=?,cod_repuesto=?,precio=?,stock=? WHERE cod_repuesto=?");
		try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(sql);
			pstmt.setString(1, descripcion);
			pstmt.setInt(2, cod_repuesto);
			pstmt.setFloat(3, precio);
			pstmt.setInt(4, stock);
			pstmt.setInt(5, cod_repuesto);
			int rs = pstmt.executeUpdate();
			if (rs > 0){
				request.getRequestDispatcher("Repuestos.jsp").forward(request, response);
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
