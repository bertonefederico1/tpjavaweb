package logica;

import datos.*;
import java.util.*;
import entidades.*;

public class ControladorRepuesto {
	
	DatosRepuesto dr;
	RepuestoFiltrar rf;
	
	public ControladorRepuesto(){
		dr = new DatosRepuesto();
		rf = new RepuestoFiltrar();
	}
	
	public ArrayList<Repuesto> traerRepuestos(){
		return dr.traerRepuestos();
	}
	
	public ArrayList<Repuesto> repuestosFiltrados(String desc_buscar){
		return rf.traerRepuestos(desc_buscar);
	}
	

}
