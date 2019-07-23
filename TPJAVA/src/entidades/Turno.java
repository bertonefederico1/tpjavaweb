package entidades;

import java.util.Date;

public class Turno {
	private Date fechaHoraTurno;
	private Date fechaCancelacion;
	
	
	public Date getFechaHoraTurno() {
		return fechaHoraTurno;
	}
	public void setFechaHoraTurno(Date fechaHoraTurno) {
		this.fechaHoraTurno = fechaHoraTurno;
	}
	public Date getFechaCancelacion() {
		return fechaCancelacion;
	}
	public void setFechaCancelacion(Date fechaCancelacion) {
		this.fechaCancelacion = fechaCancelacion;
	}
}
