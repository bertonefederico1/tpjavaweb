package Servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.ControladorTurno;
import logica.ValidacionesIngresoDatos;

/**
 * Servlet implementation class GenerarTurno
 */
@WebServlet({ "/GenerarTurno", "/GENERARTURNO", "/Generarturno", "/generarTurno" })
public class GenerarTurno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerarTurno() {
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
		request.getSession().setAttribute("error", "validaNuevoTurno");
		String dia_turno, mes_turno, anio_turno, dni_cliente;
		dia_turno = request.getParameter("dia_turno");
		mes_turno = request.getParameter("mes_turno");
		anio_turno = request.getParameter("anio_turno");
		dni_cliente = request.getParameter("dni_cliente");
		Date fecha = new Date(Calendar.getInstance().getTimeInMillis());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String fecha_hoy = formatter.format(fecha); 
		String fecha_turno = anio_turno + "-" + mes_turno + "-" + dia_turno;
		boolean band = true;
		if (ValidacionesIngresoDatos.clienteVacio(dni_cliente)) {
			response.sendRedirect("NuevoTurno.jsp");
		} else {
			if (dia_turno != null && dia_turno.length() > 0 && mes_turno != null && mes_turno.length() > 0 && anio_turno != null 
				&& anio_turno.length() > 0) {
				if (ValidacionesIngresoDatos.validaSoloNumeros(dia_turno) && ValidacionesIngresoDatos.validaLongitudHasta2(dia_turno) 
					&& ValidacionesIngresoDatos.validaSoloNumeros(mes_turno) && ValidacionesIngresoDatos.validaLongitudHasta2(mes_turno)
					&& ValidacionesIngresoDatos.validaSoloNumeros(anio_turno) && ValidacionesIngresoDatos.validaLongitudIgualA4(anio_turno)
					&& ValidacionesIngresoDatos.fechaInicioMenorAFechaFin(fecha_hoy, fecha_turno)) {
				} else {
					band = false;
				}
			} else {
				band = false;
			}
				
			if (band) {
				ControladorTurno ct = new ControladorTurno();
				ct.registrarTurno(fecha_turno, dni_cliente);
			} else {
				request.getRequestDispatcher("ErrorValidacion.jsp").forward(request, response);
			}
		}
	}

}
