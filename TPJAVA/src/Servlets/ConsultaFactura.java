package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.*;

/**
 * Servlet implementation class ConsultaFactura
 */
@WebServlet({ "/ConsultaFactura", "/CONSULTAFACTURA", "/consultafactura" })
public class ConsultaFactura extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaFactura() {
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
		request.getSession().setAttribute("error", "validaFechaFactura");
		String dia, mes, anio;
		dia = request.getParameter("dia");
		mes = request.getParameter("mes");
		anio = request.getParameter("anio");
		boolean band = true;
		if(dia != null & dia.length() > 0 && mes != null && mes.length() > 0 && anio != null && anio.length() > 0){
			if(ValidacionesIngresoDatos.validaSoloNumeros(dia) && ValidacionesIngresoDatos.validaLongitudHasta2(dia)
			   && ValidacionesIngresoDatos.validaSoloNumeros(mes) && ValidacionesIngresoDatos.validaLongitudHasta2(mes)
			   && ValidacionesIngresoDatos.validaSoloNumeros(anio) && ValidacionesIngresoDatos.validaLongitudIgualA4(anio)){
			} else {
				band = false;
			}
		} else {
			band = false;
		}
		
		try {
			if (band){
				ControladorReparacion cr = new ControladorReparacion();
				request.getSession().setAttribute("facturasPorFecha", cr.traerFacturasPorFecha(dia, mes, anio));
				response.sendRedirect("FacturasPorFecha.jsp"); 	
			} else{
				request.getRequestDispatcher("ErrorValidacion.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.getRequestDispatcher("ErrorGeneral.html").forward(request, response);
		}
	}

}
