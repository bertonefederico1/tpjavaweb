package logica;


import java.util.ArrayList;

import entidades.*;
import datos.*;

public class ControladorCliente {
	
	DatosCliente dc;
	ClienteFiltrar cf;
	
	public ControladorCliente(){
		dc = new DatosCliente();
		cf = new ClienteFiltrar();
	}
	
	public ArrayList<Cliente> traerClientes(){
		return dc.traerClientes();
	}
	
	public ArrayList<Cliente> clientesFiltrados(String nombuscar){
		return cf.traerClientes(nombuscar);
	}
	
	public void agregarCliente(Cliente cli){
		dc.agregarCliente(cli);
	}
	
	public void modificarCliente(Cliente cli){
		dc.modificarCliente(cli);
	}
	
	public void eliminarCliente(int dni){
		dc.eliminarCliente(dni);
	}
	
	
}
