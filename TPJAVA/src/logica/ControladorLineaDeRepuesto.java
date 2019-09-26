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
}
