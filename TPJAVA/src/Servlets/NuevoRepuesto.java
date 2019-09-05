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
		Repuesto rep = new Repuesto();
		ControladorRepuesto cr = new ControladorRepuesto();
		rep.setDescripcion(descripcion);
		rep.setStock(Integer.parseInt(cantidad));
		rep.setPrecio(Float.parseFloat(precio));
		cr.agregarRepuesto(rep);
		request.getRequestDispatcher("Repuestos.jsp").forward(request,response);
	}

}
