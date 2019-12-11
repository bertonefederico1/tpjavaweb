package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.ControladorProveedor;
import entidades.Proveedor;

/**
 * Servlet implementation class ProveedorFiltro
 */
@WebServlet({ "/ProveedorFiltro", "/PROVEEDORFILTRO", "/PROVEEDORFiltro", "/proveedorFILTRO" })
public class ProveedorFiltro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProveedorFiltro() {
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
		// TODO Auto-generated method stub
		String razonSocialBuscar = request.getParameter("txtbuscar");
		ControladorProveedor cp = new ControladorProveedor();
		ArrayList<Proveedor> misProveedores;
		try {
			misProveedores = cp.proveedoresFiltrados(razonSocialBuscar);
			request.getSession().setAttribute("misProveedores", misProveedores);
			request.getRequestDispatcher("BusquedaFiltradaProveedores.jsp").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("ErrorGeneral.html").forward(request, response);
		}
	}

}
