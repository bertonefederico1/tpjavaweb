package logica;


import java.util.ArrayList;

import entidades.*;
import datos.*;

public class ControladorCliente {
	
	DatosCliente dc;
	
	public ControladorCliente(){
		dc = new DatosCliente();
	}
	
	public ArrayList<Cliente> traerClientes(){
		return dc.traerClientes();
	}
}
