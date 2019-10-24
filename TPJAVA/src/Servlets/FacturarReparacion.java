package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		String cod_reparacion_string = request.getParameter("cod_reparacion");
		String dni = request.getParameter("dni_cliente");
		ValidacionesIngresoDatos valida = new ValidacionesIngresoDatos();
		if(valida.ingresoYClienteVacio(dni, cod_reparacion_string)){
			response.sendRedirect("Facturar.jsp");
		}else{
			switch (request.getParameter("btn_facturar")){
			case "traer":{
				int cod_reparacion = Integer.parseInt(cod_reparacion_string);
				ControladorLineaDeRepuesto cldr = new ControladorLineaDeRepuesto();
				ControladorReparacion cr = new ControladorReparacion();
				request.getSession().setAttribute("repuestosFactura", cldr.traerRepuestosFactura(cod_reparacion));
				request.getSession().setAttribute("manoDeObra", cr.precioManoDeObra(cod_reparacion));
				request.getRequestDispatcher("Facturar.jsp").forward(request, response);;
				break;
			}
			case "facturar":{
				
				break;
			}
			}
		}
	}
}
