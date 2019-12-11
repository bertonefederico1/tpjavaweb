package logica;

import datos.*;
import entidades.Proveedor;

import java.util.ArrayList;

public class ControladorProveedor {
	
	DatosProveedor dp;
	
	public ControladorProveedor(){
		dp = new DatosProveedor();
	}
	
	public ArrayList<Proveedor> traerProveedores() throws Exception{
		return dp.traerProveedores();
	}
	
	public ArrayList<Proveedor> proveedoresFiltrados(String razonSocialBuscar) throws Exception{
		return dp.traerProveedores(razonSocialBuscar);
	}
	
	public void agregarProveedor (Proveedor prove) throws Exception{
		dp.agregarProveedor(prove);
	}
	
	public void modificarProveedor (Proveedor prove) throws Exception{
		dp.modificarProveedor(prove);
	}
	
	public void eliminarProveedor (String cuit) throws Exception{
		dp.eliminarProveedor(cuit);
	}
}
