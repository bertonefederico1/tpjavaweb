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
}
