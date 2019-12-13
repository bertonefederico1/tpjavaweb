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
		request.getSession().setAttribute("error", "validaRepuesto");
		String descripcion = request.getParameter("descripcion");
		String cantidad = request.getParameter("cantidad");
		String precio = request.getParameter("precio");
		String cuit = request.getParameter("cuit");
		Repuesto rep = new Repuesto();
		boolean band = true;
		switch (request.getParameter("btn_guardar_nuevoCliente")){
		case "agregar_proveedor":{
			response.sendRedirect("SeleccionProveedor.jsp");
			request.getSession().setAttribute("descripcion", descripcion);
			request.getSession().setAttribute("cantidad", cantidad);
			request.getSession().setAttribute("precio", precio);
		break;
		}
		case "guardar":{
			if(cantidad != null && cantidad.length() > 0 && precio != null && precio.length() > 0 
					   && descripcion != null && descripcion.length() > 0){
						if(ValidacionesIngresoDatos.validaSoloNumerosFloat(precio) && ValidacionesIngresoDatos.validaLongitudHasta100(precio)
						   && ValidacionesIngresoDatos.validaSoloNumeros(cantidad) && ValidacionesIngresoDatos.validaLongitudHasta12(cantidad)
						   && ValidacionesIngresoDatos.validaLongitudHasta100(descripcion)){
							rep.setStock(Integer.parseInt(cantidad));
							rep.setPrecio(Float.parseFloat(precio));
							rep.setDescripcion(descripcion);
							Proveedor proveedor = new Proveedor();
							proveedor.setCuit(cuit);
							rep.setProveedor(proveedor);
						} else {
							band = false;
						}
			} else{
				band = false;
			}
							
			if(band){
				ControladorRepuesto cr = new ControladorRepuesto();
				try {
					cr.agregarRepuesto(rep);
					request.getSession().setAttribute("misRepuestos", cr.traerRepuestos());
					request.getRequestDispatcher("Repuestos.jsp").forward(request, response);
				} catch (Exception e) {
					request.getRequestDispatcher("ErrorGeneral.html").forward(request, response);
				}
			}else {
				request.getRequestDispatcher("ErrorValidacion.jsp").forward(request, response);
			}
		break;
		}
		}
		
	}
}
