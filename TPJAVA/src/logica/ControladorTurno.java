package logica;

import datos.DatosTurno;

public class ControladorTurno {
	
	DatosTurno dt;
	
	public ControladorTurno() {
		dt = new DatosTurno();
	}
	
	public void registrarTurno (String fecha_turno, String dni_cliente) {
		dt.registrarTurno(fecha_turno, dni_cliente);
	}

}
