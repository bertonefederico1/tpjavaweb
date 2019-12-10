package logica;

import java.util.ArrayList;

import datos.DatosVehiculo;
import entidades.Auto;

public class ControladorVehiculo {
	
	DatosVehiculo dv;
	
	public ControladorVehiculo(){
		dv = new DatosVehiculo();
	}
	
	public void modificarVehiculo(Auto auto, String patente_original){
		dv.modificarVehiculo(auto, patente_original);
	}
	
	public void eliminarVehiculo(String patente){
		dv.eliminarVehiculo(patente);
	}
	
	public void agregarVehiculo(Auto auto){
		dv.agregarVehiculo(auto);
	}
	
	public ArrayList<Auto> vehiculosPorCliente(String dni){
		return dv.vehiculosDelCliente(dni);
	}
	
	public ArrayList<Auto> vehiculosyClientes(){
		return dv.vehiculosYClientes();
	}
	
	public ArrayList<Auto> vehiculosFiltrados(String nombuscar){
		return dv.traerVehiculosFiltrados(nombuscar);
	}
}
