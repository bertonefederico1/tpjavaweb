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
 * Servlet implementation class ModificarCliente
 */
@WebServlet({ "/ModificarCliente", "/MODIFICARCLIENTE", "/modificarcliente" })
public class ModificarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarCliente() {
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
		request.getSession().setAttribute("error", "modificarCliente");
		String dni = request.getParameter("dni");
		String nombre_y_apellido = request.getParameter("nombre_y_apellido");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("mail");
		Cliente cli= new Cliente();
		cli.setDni(dni);
		cli.setDireccion(direccion);
		cli.setNombre_y_apellido(nombre_y_apellido);
		cli.setMail(email);
		cli.setTelefono(telefono);
		if (ValidacionesIngresoDatos.validaLongitudHasta100(nombre_y_apellido) 
			&& ValidacionesIngresoDatos.validaLongitudHasta100(direccion)
			&& ValidacionesIngresoDatos.validaSoloNumeros(telefono) && ValidacionesIngresoDatos.validaLongitudHasta12(telefono)
			&& ValidacionesIngresoDatos.validaEmail(email) && nombre_y_apellido != null && direccion != null){
			ControladorCliente cc = new ControladorCliente();
			cc.modificarCliente(cli);
			request.getRequestDispatcher("Clientes.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("ErrorValidacion.jsp").forward(request, response);
		}		
	}

}
