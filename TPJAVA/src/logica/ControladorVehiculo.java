package logica;

import java.util.ArrayList;

import datos.DatosVehiculo;
import datos.VehiculosFiltrar;
import entidades.Auto;

public class ControladorVehiculo {
	DatosVehiculo dv = new DatosVehiculo();
	VehiculosFiltrar vf = new VehiculosFiltrar();
	
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
		return vf.traerVehiculosFiltrados(nombuscar);
	}
}
