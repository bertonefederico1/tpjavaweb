package logica;

import java.util.ArrayList;

import datos.*;
import entidades.Mecanico;

public class ControladorMecanico {
	
	DatosMecanico dm;
	
	public ControladorMecanico(){
		dm= new DatosMecanico();
	}
	
	public ArrayList<Mecanico> traerMecanicos() throws Exception {
		return dm.traerMecanicos();
	}
	
	public ArrayList<Mecanico> mecanicosFiltrados(String buscamecanico) throws Exception {
		return dm.traerMecanicos(buscamecanico);
	}
	
	public void agregarMecanico (Mecanico mec) throws Exception {
		dm.agregarMecanico(mec);
	}
	
	public void modificarMecanico (Mecanico mec) throws Exception {
		dm.modificarMecanico(mec);
	}
	
	public void eliminarMecanico(int matricula) throws Exception {
		dm.eliminarMecanico(matricula);
	}
	
	public void agregarUsuarioYContrasenia (String pass, int nivel) throws Exception {
		dm.agregarUsuarioYContrasenia (pass, nivel);
	}
}
