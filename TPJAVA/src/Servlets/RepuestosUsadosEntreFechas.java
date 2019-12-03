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

import logica.ControladorLineaDeRepuesto;
import logica.ControladorReparacion;
import logica.ControladorRepuesto;
import logica.ValidacionesIngresoDatos;

/**
 * Servlet implementation class RepuestosUsadosEntreFechas
 */
@WebServlet({ "/RepuestosUsadosEntreFechas", "/REPUESTOSUSADOSENTREFECHAS", "/repuestosusadosentrefechas" })
public class RepuestosUsadosEntreFechas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RepuestosUsadosEntreFechas() {
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
		request.getSession().setAttribute("error", "validaRepuestosEntreFechas");
		String dia_inicio, mes_inicio, anio_inicio, dia_fin, mes_fin, anio_fin;
		dia_inicio = request.getParameter("dia_inicio");
		mes_inicio = request.getParameter("mes_inicio");
		anio_inicio = request.getParameter("anio_inicio");
		dia_fin = request.getParameter("dia_fin");
		mes_fin = request.getParameter("mes_fin");
		anio_fin = request.getParameter("anio_fin");
		String fecha_inicio = anio_inicio + "-" + mes_inicio + "-" + dia_inicio;
		String fecha_fin = anio_fin + "-" + mes_fin + "-" + dia_fin;
		boolean band = true;
		if(dia_inicio != null & dia_inicio.length() > 0 && mes_inicio != null && mes_inicio.length() > 0 && anio_inicio != null 
			&& anio_inicio.length() > 0 && dia_fin != null & dia_fin.length() > 0 && mes_fin != null && mes_fin.length() > 0 
			&& anio_fin != null && anio_fin.length() > 0){
			if(ValidacionesIngresoDatos.validaSoloNumeros(dia_inicio) && ValidacionesIngresoDatos.validaLongitudHasta2(dia_inicio)
			   && ValidacionesIngresoDatos.validaSoloNumeros(mes_inicio) && ValidacionesIngresoDatos.validaLongitudHasta2(mes_inicio)
			   && ValidacionesIngresoDatos.validaSoloNumeros(anio_inicio) && ValidacionesIngresoDatos.validaLongitudIgualA4(anio_inicio)
			   && ValidacionesIngresoDatos.validaSoloNumeros(dia_fin) && ValidacionesIngresoDatos.validaLongitudHasta2(dia_fin)
			   && ValidacionesIngresoDatos.validaSoloNumeros(mes_fin) && ValidacionesIngresoDatos.validaLongitudHasta2(mes_fin)
			   && ValidacionesIngresoDatos.validaSoloNumeros(anio_fin) && ValidacionesIngresoDatos.validaLongitudIgualA4(anio_fin)
			   && ValidacionesIngresoDatos.fechaInicioMenorAFechaFin(fecha_inicio, fecha_fin)){
			} else {
				band = false;
			}
		} else {
			band = false;
		}
		
		if (band){
			ControladorLineaDeRepuesto cldr = new ControladorLineaDeRepuesto();
			request.getSession().setAttribute("repuestosEntreFechas", cldr.repuestosEntreFechas(dia_inicio, mes_inicio, anio_inicio, dia_fin, mes_fin, anio_fin));
			response.sendRedirect("RepuestosEntreFechas.jsp"); 	
		} else{
			request.getRequestDispatcher("ErrorValidacion.jsp").forward(request, response);
		}
	}

}
