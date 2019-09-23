package logica;

import java.util.ArrayList;

import datos.DatosVehiculo;
import entidades.Auto;

public class ControladorVehiculo {
	DatosVehiculo dv = new DatosVehiculo();
	
	public void agregarVehiculo(Auto auto){
		dv.agregarVehiculo(auto);
	}
	
	public ArrayList<Auto> vehiculosPorCliente(String dni){
		return dv.vehiculosDelCliente(dni);
	}
	
	public ArrayList<Auto> vehiculosyClientes(){
		return dv.vehiculosYClientes();
	}
}
