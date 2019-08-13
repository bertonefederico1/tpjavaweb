package entidades;

import java.util.Date;

public class Turno {
	private Date fechaTurno;
	private Date fechaCancelacion;
	
	
	public Date getFechaHoraTurno() {
		return fechaTurno;
	}
	public void setFechaHoraTurno(Date fechaHoraTurno) {
		this.fechaTurno = fechaHoraTurno;
	}
	public Date getFechaCancelacion() {
		return fechaCancelacion;
	}
	public void setFechaCancelacion(Date fechaCancelacion) {
		this.fechaCancelacion = fechaCancelacion;
	}
}
