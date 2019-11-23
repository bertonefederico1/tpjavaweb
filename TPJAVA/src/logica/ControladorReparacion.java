package logica;

import java.util.ArrayList;

import datos.*;
import entidades.*;


public class ControladorReparacion {
	
	DatosReparacion dr = new DatosReparacion();
	
	public ArrayList<Reparacion> traerFacturasPorFecha (String dia, String mes, String anio){
		return dr.traerFacturasPorFecha(dia, mes, anio);
	}
	
	public void facturarReparacion (Reparacion repa, String estado){
		dr.facturarReparacion(repa, estado);
	}
	
	public double precioManoDeObra(int cod_reparacion) {
		return dr.precioManoDeObra(cod_reparacion);
	}
	
	public ArrayList<Reparacion> traerReparacionesAModificar(){
	return dr.traerReparacionesAModificar();	
	}
	
	public void agregarReparacion(ArrayList<LineaDeRepuesto> repuestosSeleccionados, Reparacion rep, Mecanico mec, String estado){
		dr.agregarReparacion(repuestosSeleccionados, rep, mec, estado);
	}
	
	public void agregarNuevoIngreso(Reparacion repa){
		dr.agregarNuevoIngreso(repa);
	}
	
	public ArrayList<Reparacion> traerReparaciones(){
		return dr.traerReparaciones();
	}
	
	public Reparacion traerReparacionPorNro(int nro_reparacion){
		return dr.traerReparacionPorNro(nro_reparacion);
	}
	
	public ArrayList<Reparacion> reparacionesPorCliente(String dni){
		return dr.reparacionesPorCliente(dni);
	}
	
	public ArrayList<Reparacion> reparacionesFinalizadasPorCliente(String dni){
		return dr.reparacionesFinalizadasPorCliente(dni);
	}
	
	public void eliminarReparacion(int nro_reparacion){
		dr.eliminarReparacion(nro_reparacion);
	}
	
	public ArrayList<Reparacion> reparacionesFiltradas(String nombuscar){
		return dr.reparacionesFiltradas(nombuscar);
	}
											//sería el Array repuestosSeleccionados
	public void modificarReparacion (ArrayList<LineaDeRepuesto> repuestosModificados, ArrayList<LineaDeRepuesto> repuestosOriginal, Reparacion rep, String estado) {
		dr.modificarReparacion(repuestosModificados, repuestosOriginal, rep, estado);
	}
}
