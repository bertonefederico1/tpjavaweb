package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.ControladorProveedor;
import logica.ValidacionesIngresoDatos;
import entidades.Proveedor;

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
		request.getSession().setAttribute("error", "validaProveedor");
		String razon_social = request.getParameter("razon_social");
		String cuit_prefijo = request.getParameter("cuit_prefijo");
		String cuit_mitad = request.getParameter("cuit_mitad");
		String cuit_sufijo = request.getParameter("cuit_sufijo");
		String cuit = cuit_prefijo+"-"+cuit_mitad+"-"+cuit_sufijo;
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("mail");
		boolean band = true;
		Proveedor prove = new Proveedor();
		if (cuit != null && cuit.length() > 0 && razon_social != null && razon_social.length() > 0 && direccion != null 
			&& direccion.length() > 0) {
			if (ValidacionesIngresoDatos.validaSoloNumeros(cuit_prefijo) && ValidacionesIngresoDatos.validaSoloNumeros(cuit_mitad)
				&& ValidacionesIngresoDatos.validaSoloNumeros(cuit_sufijo) && ValidacionesIngresoDatos.validaLongitudIgualA8(cuit_mitad)
				&& ValidacionesIngresoDatos.validaLongitudIgualA2(cuit_prefijo) && ValidacionesIngresoDatos.validaLongitudIgualA1(cuit_sufijo)
				&& ValidacionesIngresoDatos.validaLongitudHasta100(razon_social) && ValidacionesIngresoDatos.validaLongitudHasta100(direccion)) {
				if(email != null && email.length() > 0) {
					if(ValidacionesIngresoDatos.validaEmail(email) && ValidacionesIngresoDatos.validaLongitudHasta100(email)) {
						prove.setMail(email);
					} else {
						band = false;
					}
				}
				if (telefono != null && telefono.length() > 0) {
					if(ValidacionesIngresoDatos.validaSoloNumeros(telefono) && ValidacionesIngresoDatos.validaLongitudHasta12(telefono)) {
						prove.setTelefono(telefono);
					} else {
						band = false;
					}
				}
			} else {
				band = false;
			}
		} else {
			band = false;
		}
		
		if (band) {
			ControladorProveedor cp = new ControladorProveedor();
			prove.setCuit(cuit);
			prove.setDireccion(direccion);
			prove.setRazonSocial(razon_social);
			try {
				cp.agregarProveedor(prove);
				request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
			} catch (Exception e) {
				request.getRequestDispatcher("ErrorGeneral.html").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("ErrorValidacion.jsp").forward(request, response);
		}
	}

}
