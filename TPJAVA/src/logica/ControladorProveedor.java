package logica;

import datos.*;
import entidades.Proveedor;

import java.util.ArrayList;

public class ControladorProveedor {
	
	DatosProveedor dp;
	ProveedorFiltrar pf;
	
	public ControladorProveedor(){
		dp = new DatosProveedor();
		pf = new ProveedorFiltrar();
	}
	
	public ArrayList<Proveedor> traerProveedores(){
		return dp.traerProveedores();
	}
	
	public ArrayList<Proveedor> proveedoresFiltrados(String razonSocialBuscar){
		return pf.traerProveedores(razonSocialBuscar);
	}
	
	public void agregarProveedor (Proveedor prove){
		dp.agregarProveedor(prove);
	}
	
	public void modificarProveedor (Proveedor prove){
		dp.modificarProveedor(prove);
	}
	
	public void eliminarProveedor (String cuit){
		dp.eliminarProveedor(cuit);
	}
}
