package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import logica.ControladorCliente;
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
		String dni = request.getParameter("dni");
		String nombre_y_apellido = request.getParameter("nombre_y_apellido");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String mail = request.getParameter("mail");
		Cliente cli= new Cliente();
		ControladorCliente cc = new ControladorCliente();
		cli.setDni(dni);
		cli.setDireccion(direccion);
		cli.setNombre_y_apellido(nombre_y_apellido);
		cli.setMail(mail);
		cli.setTelefono(telefono);
		cc.modificarCliente(cli);
		request.getRequestDispatcher("Clientes.jsp").forward(request, response);
		
	}

}
