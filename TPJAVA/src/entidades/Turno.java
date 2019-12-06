package entidades;

import java.util.Date;

public class Turno {
	private int nroTurno;
	private Date fechaTurno;
	private Date fechaCancelacion;
	private Cliente cli;
	
	public int getNroTurno() {
		return nroTurno;
	}
	public void setNroTurno(int nroTurno) {
		this.nroTurno = nroTurno;
	}
	public Date getFechaTurno() {
		return fechaTurno;
	}
	public void setFechaTurno(Date fechaTurno) {
		this.fechaTurno = fechaTurno;
	}
	public Date getFechaCancelacion() {
		return fechaCancelacion;
	}
	public void setFechaCancelacion(Date fechaCancelacion) {
		this.fechaCancelacion = fechaCancelacion;
	}
	public Cliente getCliente() {
		return cli;
	}
	public void setCliente(Cliente cli) {
		this.cli = cli;
	}
	

}
