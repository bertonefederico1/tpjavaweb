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
		request.getSession().setAttribute("error", "validaRepuesto");
		int cod_repuesto = Integer.parseInt(request.getParameter("codigo"));
		String descripcion = request.getParameter("descripcion");
		String precio = request.getParameter("precio");
		String cantidad = request.getParameter("stock");
		String cuit = request.getParameter("cuit");
		if (request.getParameter("codigo") != null && request.getParameter("descripcion") != null 
			&& request.getParameter("precio") != null && request.getParameter("stock") != null && request.getParameter("cuit") != null){
			request.getSession().setAttribute("descripcion", descripcion);
			request.getSession().setAttribute("precio", precio);
			request.getSession().setAttribute("stock", cantidad);
			request.getSession().setAttribute("cod_repuesto", cod_repuesto);
			request.getSession().setAttribute("cuit", cuit);
		}
		boolean band = true;
		Repuesto rep = new Repuesto();
		switch (request.getParameter("btn_guardar_repuesto")){
		case "guardar":{
			if(cantidad != null && cantidad.length() > 0 && precio != null && precio.length() > 0 
					   && descripcion != null && descripcion.length() > 0){
						if(ValidacionesIngresoDatos.validaSoloNumerosFloat(precio) && ValidacionesIngresoDatos.validaLongitudHasta100(precio)
						   && ValidacionesIngresoDatos.validaSoloNumeros(cantidad) && ValidacionesIngresoDatos.validaLongitudHasta12(cantidad)
						   && ValidacionesIngresoDatos.validaLongitudHasta100(descripcion)){
							rep.setCodigo(cod_repuesto);
							rep.setStock(Integer.parseInt(cantidad));
							rep.setPrecio(Float.parseFloat(precio));
							rep.setDescripcion(descripcion);
							Proveedor prov = new Proveedor();
							prov.setCuit(cuit);
							rep.setProveedor(prov);
						} else {
							band = false;
						}
							} else{
								band = false;
							}
							
					if(band){
						ControladorRepuesto cr = new ControladorRepuesto();
						try {
							cr.modificarRepuesto(rep);
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
		case "agregar_proveedor":{
			request.getSession().setAttribute("tipo", "editar_repuesto");
			response.sendRedirect("SeleccionProveedor.jsp");
			break;
		}
		}
		
	}

}
