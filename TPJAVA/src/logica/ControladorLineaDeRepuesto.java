package logica;

import datos.*;
import entidades.*;
import java.util.*;

public class ControladorLineaDeRepuesto {
	
	DatosLineaDeRepuesto dldr= new DatosLineaDeRepuesto();
	
	public LineaDeRepuesto agregarLinea(int cantidad, int cod_repuesto){
		return dldr.agregarLinea(cantidad, cod_repuesto);
	}
	
	public ArrayList<LineaDeRepuesto> inicializarLineas(){
		return dldr.inicializarLineas();
	}
	
	public ArrayList<LineaDeRepuesto> eliminarRepuestoSeleccionado(int cod_repuesto, ArrayList<LineaDeRepuesto> repuestosSeleccionados){
		return dldr.eliminarRepuestoSeleccionado(cod_repuesto, repuestosSeleccionados);
	}
}
