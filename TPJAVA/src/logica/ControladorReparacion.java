package logica;

import java.util.ArrayList;

import datos.*;
import entidades.*;


public class ControladorReparacion {
	
	DatosReparacion dr = new DatosReparacion();
	
	public int buscarIndiceArreglomisReparaciones (ArrayList<Reparacion> misReparaciones, int nro_reparacion) throws Exception{
		return dr.buscarIndiceArreglomisReparaciones(misReparaciones, nro_reparacion);
	}
	
	public ArrayList<Reparacion> traerFacturasPorFecha (String dia, String mes, String anio) throws Exception{
		return dr.traerFacturasPorFecha(dia, mes, anio);
	}
	
	public void facturarReparacion (Reparacion repa, String estado) throws Exception{
		dr.facturarReparacion(repa, estado);
	}
	
	public double precioManoDeObra(int cod_reparacion) throws Exception {
		return dr.precioManoDeObra(cod_reparacion);
	}
	
	public ArrayList<Reparacion> traerReparacionesAModificar() throws Exception{
	return dr.traerReparacionesAModificar();	
	}
	
	public void agregarReparacion(ArrayList<LineaDeRepuesto> repuestosSeleccionados, Reparacion rep, Mecanico mec, String estado) throws Exception{
		dr.agregarReparacion(repuestosSeleccionados, rep, mec, estado);
	}
	
	public void agregarNuevoIngreso(Reparacion repa) throws Exception{
		dr.agregarNuevoIngreso(repa);
	}
	
	public ArrayList<Reparacion> traerReparaciones() throws Exception{
		return dr.traerReparaciones();
	}
	
	public Reparacion traerReparacionPorNro(int nro_reparacion) throws Exception {
		return dr.traerReparacionPorNro(nro_reparacion);
	}
	
	public ArrayList<Reparacion> reparacionesPorCliente(String dni) throws Exception{
		return dr.reparacionesPorCliente(dni);
	}
	
	public ArrayList<Reparacion> reparacionesFinalizadasPorCliente(String dni) throws Exception{
		return dr.reparacionesFinalizadasPorCliente(dni);
	}
	
	public void eliminarReparacion(int nro_reparacion) throws Exception{
		dr.eliminarReparacion(nro_reparacion);
	}
	
	public ArrayList<Reparacion> reparacionesFiltradas(String nombuscar) throws Exception{
		return dr.reparacionesFiltradas(nombuscar);
	}
											//sería el Array repuestosSeleccionados
	public void modificarReparacion (ArrayList<LineaDeRepuesto> repuestosModificados, ArrayList<LineaDeRepuesto> repuestosOriginal, Reparacion rep, String estado) throws Exception {
		dr.modificarReparacion(repuestosModificados, repuestosOriginal, rep, estado);
	}
}
