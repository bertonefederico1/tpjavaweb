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
}
