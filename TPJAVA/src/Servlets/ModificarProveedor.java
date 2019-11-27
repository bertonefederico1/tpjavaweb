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
		String email = request.getParameter("mail");
		boolean band = true;
		Proveedor prove = new Proveedor();
		prove.setCuit(cuit);
		prove.setDireccion(direccion);
		prove.setMail(email);
		prove.setRazonSocial(razon_social);
		prove.setTelefono(telefono);
		if (razon_social != null && razon_social.length() > 0 && direccion != null && direccion.length() > 0){
				if (ValidacionesIngresoDatos.validaLongitudHasta100(razon_social) && ValidacionesIngresoDatos.validaLongitudHasta100(direccion)){
					if(email != null && email.length() > 0){
						if(ValidacionesIngresoDatos.validaEmail(email) && ValidacionesIngresoDatos.validaLongitudHasta100(email)){
						} else {
							band = false;
						}
					}
					if (telefono != null && telefono.length() > 0){
						if(ValidacionesIngresoDatos.validaSoloNumeros(telefono) && ValidacionesIngresoDatos.validaLongitudHasta12(telefono)){
						} else {
							band = false;
						}
					}
				} else {
					band = false;
				}
			} else{
				band = false;
			}
			
			if (band){
				ControladorProveedor cp = new ControladorProveedor();
				cp.modificarProveedor(prove);
				request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("ErrorValidacion.jsp").forward(request, response);
			}
	}

}
