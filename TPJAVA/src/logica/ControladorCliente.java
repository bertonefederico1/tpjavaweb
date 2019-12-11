package logica;


import java.util.ArrayList;

import entidades.*;
import datos.*;

public class ControladorCliente {
	
	DatosCliente dc;
	
	public ControladorCliente(){
		dc = new DatosCliente();
	}
	
	public ArrayList<Cliente> traerClientes() throws Exception{
		return dc.traerClientes();
	}
	
	public ArrayList<Cliente> clientesFiltrados(String nombuscar) throws Exception{
		return dc.traerClientes(nombuscar);
	}
	
	public void agregarCliente(Cliente cli) throws Exception{
		dc.agregarCliente(cli);
	}
	
	public void modificarCliente(Cliente cli) throws Exception{
		dc.modificarCliente(cli);
	}
	
	public void eliminarCliente(int dni) throws Exception{
		dc.eliminarCliente(dni);
	}
	
	public ArrayList<Cliente> clientesConReparacionesFinalizadasParaEnviarEmail() throws Exception{
		return dc.clientesConReparacionesFinalizadasParaEnviarEmail();
	}
}
