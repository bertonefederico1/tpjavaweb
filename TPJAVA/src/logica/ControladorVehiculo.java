package logica;

import java.util.ArrayList;

import datos.DatosVehiculo;
import entidades.Auto;

public class ControladorVehiculo {
	
	DatosVehiculo dv;
	
	public ControladorVehiculo(){
		dv = new DatosVehiculo();
	}
	
	public void modificarVehiculo(Auto auto, String patente_original) throws Exception{
		dv.modificarVehiculo(auto, patente_original);
	}
	
	public void eliminarVehiculo(String patente) throws Exception{
		dv.eliminarVehiculo(patente);
	}
	
	public void eliminarVehiculoCliente(int dni) throws Exception{
		dv.eliminarVehiculoCliente(dni);
	}
	
	public void agregarVehiculo(Auto auto) throws Exception{
		dv.agregarVehiculo(auto);
	}
	
	public ArrayList<Auto> vehiculosPorCliente(String dni) throws Exception{
		return dv.vehiculosDelCliente(dni);
	}
	
	public ArrayList<Auto> vehiculosyClientes() throws Exception{
		return dv.vehiculosYClientes();
	}
	
	public ArrayList<Auto> vehiculosFiltrados(String nombuscar) throws Exception{
		return dv.traerVehiculosFiltrados(nombuscar);
	}
}
