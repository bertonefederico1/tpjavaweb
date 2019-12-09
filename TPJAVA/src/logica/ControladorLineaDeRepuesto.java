package logica;

import datos.*;
import entidades.*;

import java.util.*;

public class ControladorLineaDeRepuesto {
	
	DatosLineaDeRepuesto dldr= new DatosLineaDeRepuesto();
	
	public ArrayList<LineaDeRepuesto> repuestosEntreFechas(String dia_inicio, String mes_inicio, String anio_inicio, String dia_fin, String mes_fin, String anio_fin){
		return dldr.repuestosEntreFechas(dia_inicio, mes_inicio, anio_inicio, dia_fin, mes_fin, anio_fin);
	}
	
	public Float getPrecioTotal(int nro_reparacion){
		return dldr.getPrecioTotal(nro_reparacion);
	}
	
	public ArrayList<LineaDeRepuesto> traerRepuestosReparacion(int nro_reparacion){
		return dldr.traerRepuestosReparacion(nro_reparacion);
	}
	
	public boolean hayStock(ArrayList<LineaDeRepuesto> repuestosSeleccionados, ArrayList<Repuesto> misRepuestos, int cod_repuesto, int cantidad){
		boolean band = true;
		int i = 0;
		for (Repuesto rep : misRepuestos){
			if(rep.getCodigo() == cod_repuesto){
				break;
			}else {
				i++;
			}
		}
			
		
		if (repuestosSeleccionados.isEmpty()){
			if (misRepuestos.get(i).getStock() < cantidad){
				band = false;
			}
		}
		
		
		if (!(repuestosSeleccionados.isEmpty())){
			for(LineaDeRepuesto ldr : repuestosSeleccionados){
				if(ldr.getRepuesto().getCodigo() == cod_repuesto){
					if((ldr.getCantidad() + cantidad) > (misRepuestos.get(i).getStock())){
						band = false;
						break;
					}	
				} else {
					if (misRepuestos.get(i).getStock() < cantidad){
						band = false;
					}
				}
			}
		}
		
		return band;
	}
	
	public boolean repuestoNoRepetido(ArrayList<LineaDeRepuesto> repuestosSeleccionados, int cod_repuesto, int cantidad){
		boolean band = true;
		for(LineaDeRepuesto ldr : repuestosSeleccionados){
			if(ldr.getRepuesto().getCodigo() == cod_repuesto){
				ldr.setCantidad(ldr.getCantidad() + cantidad);
				band = false;
				break;
			}
		}
		return band;	
	}
					
	
	public ArrayList<LineaDeRepuesto> traerRepuestosFactura(int cod_reparacion) {
		return dldr.traerRepuestosFactura(cod_reparacion);
	}
	
	public ArrayList<LineaDeRepuesto> traerRepuestosUtilizados(int cod_reparacion) {
		return dldr.traerRepuestosUtilizados(cod_reparacion);
	}
	
	public ArrayList<LineaDeRepuesto> agregarLinea(ArrayList<LineaDeRepuesto> repuestosSeleccionados, int cantidad, int cod_repuesto){
		return dldr.agregarLinea(repuestosSeleccionados, cantidad, cod_repuesto);
	}
	
	public ArrayList<LineaDeRepuesto> inicializarLineas(){
		return dldr.inicializarLineas();
	}
	
	public ArrayList<LineaDeRepuesto> eliminarRepuestoSeleccionado(int cod_repuesto, ArrayList<LineaDeRepuesto> repuestosSeleccionados){
		return dldr.eliminarRepuestoSeleccionado(cod_repuesto, repuestosSeleccionados);
	}
}
