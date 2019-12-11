package Servlets;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.ControladorCliente;
import entidades.*;

/**
 * Servlet implementation class EnviarMail
 */
@WebServlet({ "/EnviarMail", "/enviarmail", "/ENVIARMAIL" })
public class EnviarMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnviarMail() {
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
		String asunto = request.getParameter("asunto");
		String mensaje = request.getParameter("mensaje");
		boolean enviado = true;
		Email email = new Email();
		ControladorCliente cc = new ControladorCliente();
		try {
			ArrayList<Cliente> destinatarios = cc.clientesConReparacionesFinalizadasParaEnviarEmail();
			if (destinatarios.size() > 0) {
				for (Cliente cl : destinatarios){
					enviado = email.enviarCorreo(asunto, mensaje, cl.getMail());
				}
				if (enviado) {
					request.getRequestDispatcher("EnvioMailSatisfactorio.html").forward(request, response);
				} else {
					request.getRequestDispatcher("EmailNoEnviado.html").forward(request, response);
				}
			} else {
				request.getRequestDispatcher("SinClienteReparacionTerminada.html").forward(request, response);
			}
		} catch (Exception e) {
			request.getRequestDispatcher("ErrorGeneral.html").forward(request, response);
		}
	}

}
