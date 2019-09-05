package logica;

import java.util.ArrayList;

import datos.*;
import entidades.Mecanico;

public class ControladorMecanico {
	
	DatosMecanico dm;
	MecanicoFiltrar mf;
	
	public ControladorMecanico(){
		dm= new DatosMecanico();
		mf= new MecanicoFiltrar();
	}
	
	public ArrayList<Mecanico> traerMecanicos(){
		return dm.traerMecanicos();
	}
	
	public ArrayList<Mecanico> mecanicosFiltrados(String buscamecanico){
		return mf.traerMecanicos(buscamecanico);
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
