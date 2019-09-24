package logica;

import java.util.ArrayList;

import datos.DatosVehiculo;
import datos.VehiculosFiltrar;
import entidades.Auto;

public class ControladorVehiculo {
	DatosVehiculo dv = new DatosVehiculo();
	VehiculosFiltrar vf = new VehiculosFiltrar();
	
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
