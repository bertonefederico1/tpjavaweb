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
 * Servlet implementation class EliminarCliente
 */
@WebServlet({ "/EliminarCliente", "/ELIMINARCLIENTE", "/eliminarcliente", "/ELIMINARcliente" })
public class EliminarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dni= Integer.parseInt(request.getParameter("dni"));
		PreparedStatement pstmt = null;
		String sql = ("DELETE FROM clientes WHERE dni="+dni);
		try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(sql);
			int rs= pstmt.executeUpdate();
			if (rs > 0){
				request.getRequestDispatcher("Clientes.jsp").forward(request, response);
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
