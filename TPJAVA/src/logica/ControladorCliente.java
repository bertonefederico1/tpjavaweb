package logica;


import java.util.ArrayList;

import entidades.*;
import datos.*;

public class ControladorCliente {
	
	DatosCliente dc;
	ClienteFiltrar cf;
	VehiculosPorCliente vc;
	
	public ControladorCliente(){
		dc = new DatosCliente();
		cf = new ClienteFiltrar();
		vc = new VehiculosPorCliente();
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
	
	public ArrayList<Auto> vehiculosPorCliente(String dni){
		return vc.vehiculosDelCliente(dni);
	}
}
