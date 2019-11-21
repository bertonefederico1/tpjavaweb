package Servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Reparacion;
import logica.*;

/**
 * Servlet implementation class FacturarReparacion
 */
@WebServlet({ "/FacturarReparacion", "/facturarReparacion", "/facturarreparacion", "/FACTURARREPARACION", "/FACTURARreparacion", "/facturarREPARACION" })
public class FacturarReparacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacturarReparacion() {
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
		String nro_reparacion_string = request.getParameter("cod_reparacion");
		int nro_reparacion = Integer.parseInt(nro_reparacion_string);
		String dni = request.getParameter("dni_cliente");
		ValidacionesIngresoDatos valida = new ValidacionesIngresoDatos();
		ControladorReparacion cr = new ControladorReparacion();
		ControladorLineaDeRepuesto cldr = new ControladorLineaDeRepuesto();
		request.getSession().setAttribute("manoDeObra", cr.precioManoDeObra(nro_reparacion));
		request.getSession().setAttribute("repuestosFactura", cldr.traerRepuestosFactura(nro_reparacion));
		if(valida.ingresoYClienteVacio(dni, nro_reparacion_string)){
			response.sendRedirect("Facturar.jsp");
		}else{
			switch (request.getParameter("btn_facturar")){
			case "traer":{
				request.getSession().setAttribute("precio_total", cldr.getPrecioTotal(nro_reparacion));
				request.getSession().setAttribute("manoDeObra", cr.precioManoDeObra(nro_reparacion));
				request.getRequestDispatcher("Facturar.jsp").forward(request, response);;
				break;
			}
			case "facturar":{
				String fecha_factura = request.getParameter("fecha_factura");
				Date fecha_factura_formateada = null;
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				try {
					fecha_factura_formateada = formatter.parse(fecha_factura);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				Reparacion repa = new Reparacion();
				repa.setNroReparacion(nro_reparacion);
				repa.setFechaEntrega(fecha_factura_formateada);
				cr.facturarReparacion(repa, "Entregada");
				request.getRequestDispatcher("ReparacionFacturada.html").forward(request, response);
				break;
			}
			}
		}
	}
}
