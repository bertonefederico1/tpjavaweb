package logica;

import java.util.ArrayList;

import datos.*;
import entidades.Mecanico;

public class ControladorMecanico {
	
	DatosMecanico dm;
	
	public ControladorMecanico(){
		dm= new DatosMecanico();
	}
	
	public ArrayList<Mecanico> traerMecanicos(){
		return dm.traerMecanicos();
	}
	
	public ArrayList<Mecanico> mecanicosFiltrados(String buscamecanico){
		return dm.traerMecanicos(buscamecanico);
	}
	
	public void agregarMecanico (Mecanico mec){
		dm.agregarMecanico(mec);
	}
	
	public void modificarMecanico (Mecanico mec){
		dm.modificarMecanico(mec);
	}
	
	public void eliminarMecanico(int matricula){
		dm.eliminarMecanico(matricula);
	}
}
