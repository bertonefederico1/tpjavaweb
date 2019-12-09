package logica;

import datos.DatosTurno;
import entidades.Turno;
import java.util.*;

public class ControladorTurno {
	
	DatosTurno dt;
	
	public ControladorTurno() {
		dt = new DatosTurno();
	}
	
	public void registrarTurno (String fecha_turno, String dni_cliente) {
		dt.registrarTurno(fecha_turno, dni_cliente);
	}

	public boolean disponibilidadTurnosAFecha (String fecha_turno) {
		return dt.disponibilidadTurnosAFecha (fecha_turno);
	}
	
	public boolean existeTurnoClienteYFecha (String dni_cliente, String fecha_turno) {
		return dt.existeTurnoClienteYFecha (dni_cliente, fecha_turno);
	}
	
	public ArrayList<Turno> traerTurnos() {
		return dt.traerTurnos();
	}
	
	public void cancelarTurno(int nro_turno) {
		dt.cancelarTurno (nro_turno);
	}
	
	public boolean verificarTurno (String dni_cliente) {
		return dt.verificarTurno (dni_cliente);
	}
	
	public void actualizarTurno (String dni_cliente) {
		dt.actualizarTurno(dni_cliente);
	}
	
	public ArrayList<Turno> turnosFiltrados (String buscaTurno, String tipo) {
		return dt.turnosFiltrados (buscaTurno, tipo);
	}
}
