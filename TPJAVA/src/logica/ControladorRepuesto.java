package logica;

import datos.*;

import java.util.*;

import entidades.*;

public class ControladorRepuesto {
	
	DatosRepuesto dr;
	
	public ControladorRepuesto(){
		dr = new DatosRepuesto();
	}
	
	
	public ArrayList<Repuesto> traerRepuestosBajoStock() throws Exception{
		return dr.traerRepuestosBajoStock();
	}
	
	public ArrayList<Repuesto> traerRepuestos()throws Exception {
		return dr.traerRepuestos();
	}
	
	public ArrayList<Repuesto> repuestosFiltrados(String desc_buscar) throws Exception{
		return dr.traerRepuestos(desc_buscar);
	}
	
	public void agregarRepuesto (Repuesto rep) throws Exception{
		dr.agregarRepuesto(rep);
	}
	
	public void modificarRepuesto (Repuesto rep) throws Exception{
		dr.modificarRepuesto(rep);
	}
	
	public void eliminarRepuesto (int cod_repuesto) throws Exception{
		dr.eliminarRepuesto(cod_repuesto);
	}

}
