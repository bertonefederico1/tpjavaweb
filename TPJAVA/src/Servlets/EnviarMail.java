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
		Email email = new Email();
		ControladorCliente cc = new ControladorCliente();
		ArrayList<Cliente> destinatarios = cc.clientesConReparacionesFinalizadasParaEnviarEmail();
		boolean enviado = true;
		for (Cliente cl : destinatarios){
			if (email.enviarCorreo(asunto, mensaje, cl.getMail())) {
				enviado = true;
			} else {
				enviado = false;
			}
		}
		if (enviado) {
			request.getRequestDispatcher("EnvioMailSatisfactorio.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("EmailNoEnviado.jsp").forward(request, response);
		}
	}

}
