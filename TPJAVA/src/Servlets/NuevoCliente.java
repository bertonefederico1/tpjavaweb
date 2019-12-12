package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.ControladorCliente;
import logica.ValidacionesIngresoDatos;
import entidades.Cliente;

/**
 * Servlet implementation class NuevoCliente
 */
@WebServlet({"/NuevoCliente", "/NUEVOCLIENTE", "/nuevocliente"})
public class NuevoCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoCliente() {
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
		request.getSession().setAttribute("error", "validaCliente");
		String dni = request.getParameter("dni");
		String nombre_y_apellido = request.getParameter("nombreYApellido");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("mail");
		boolean band = true;
		Cliente cli = new Cliente();
		if (dni != null && dni.length() > 0 && nombre_y_apellido != null && nombre_y_apellido.length() > 0 
			&& direccion != null && direccion.length() > 0) {
			if(ValidacionesIngresoDatos.validaSoloNumeros(dni) && ValidacionesIngresoDatos.validaLongitudIgualA8(dni)
			   && ValidacionesIngresoDatos.validaLongitudHasta100(nombre_y_apellido) 
			   && ValidacionesIngresoDatos.validaLongitudHasta100(direccion)) {
				if(email != null && email.length() > 0){
					if(ValidacionesIngresoDatos.validaEmail(email) && ValidacionesIngresoDatos.validaLongitudHasta100(email)) {
					} else {
						band = false;
					}
				}
				if(telefono != null && telefono.length() > 0) {
					if(ValidacionesIngresoDatos.validaSoloNumeros(telefono) && ValidacionesIngresoDatos.validaLongitudHasta12(telefono)){
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
		if(band) {
			ControladorCliente cc = new ControladorCliente();
			cli.setDni(dni);
			cli.setNombre_y_apellido(nombre_y_apellido);
			cli.setDireccion(direccion);
			cli.setMail(email);
			cli.setTelefono(telefono);
			try {
				cc.agregarCliente(cli);
				request.getRequestDispatcher("Clientes.jsp").forward(request, response);
			} catch (Exception e) {
				request.getRequestDispatcher("ErrorGeneral.html").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("ErrorValidacion.jsp").forward(request, response);
		}	
	}

}
