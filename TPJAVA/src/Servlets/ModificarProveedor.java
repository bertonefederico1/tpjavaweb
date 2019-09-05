package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.*;
import entidades.*;

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
		Proveedor prove = new Proveedor();
		ControladorProveedor cp = new ControladorProveedor();
		prove.setCuit(cuit);
		prove.setDireccion(direccion);
		prove.setMail(mail);
		prove.setRazonSocial(razon_social);
		prove.setTelefono(telefono);
		cp.modificarProveedor(prove);
		request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
	}

}
