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
		Repuesto rep = new Repuesto();
		rep.setCodigo(cod_repuesto);
		rep.setDescripcion(descripcion);
		rep.setPrecio(precio);
		rep.setStock(stock);
		ControladorRepuesto cr = new ControladorRepuesto();
		cr.modificarRepuesto(rep);
		request.getSession().setAttribute("misRepuestos", cr.traerRepuestos());
		request.getRequestDispatcher("Repuestos.jsp").forward(request, response);
	}

}
