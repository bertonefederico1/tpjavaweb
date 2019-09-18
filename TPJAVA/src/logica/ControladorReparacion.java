package logica;

import java.util.ArrayList;

import datos.*;
import entidades.Reparacion;

public class ControladorReparacion {
	
	DatosReparacion dr = new DatosReparacion();
	
	public void agregarNuevoIngreso(Reparacion repa){
		dr.agregarNuevoIngreso(repa);
	}
	
	public ArrayList<Reparacion> traerReparaciones(){
		return dr.traerReparaciones();
	}
}
