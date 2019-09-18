package logica;

import java.util.ArrayList;

import datos.*;
import entidades.Reparacion;

public class ControladorReparacion {
	
	DatosReparacion dr;
	
	public void agregarNuevoIngreso(Reparacion repa){
		dr = new DatosReparacion();
		dr.agregarNuevoIngreso(repa);
	}
	
	public ArrayList<Reparacion> traerReparaciones(){
		return dr.traerReparaciones();
	}
}
