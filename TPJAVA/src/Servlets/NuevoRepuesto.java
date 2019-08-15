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
 * Servlet implementation class NuevoRepuesto
 */
@WebServlet({ "/NuevoRepuesto", "/NUEVOREPUESTO", "/nuevorepuesto", "/nuevoREPUESTO" })
public class NuevoRepuesto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoRepuesto() {
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
		String descripcion = request.getParameter("descripcion");
		String cantidad = request.getParameter("cantidad");
		String precio = request.getParameter("precio");
		PreparedStatement pstmt = null;
		String insertar = ("insert into repuestos(descripcion,precio,stock) values(?,?,?)");
		try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(insertar);
			pstmt.setString(1, descripcion);
			pstmt.setDouble(2, Double.parseDouble(precio));
			pstmt.setInt(3, Integer.parseInt(cantidad));
			int resp = pstmt.executeUpdate();
			if (resp>0){
				request.getRequestDispatcher("Repuestos.jsp").forward(request,response);
				pstmt.close();
				Conexion.getInstancia().releaseConn();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
