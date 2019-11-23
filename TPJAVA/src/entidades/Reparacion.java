package entidades;

import java.util.ArrayList;
import java.util.Date;


public class Reparacion {
	private int nroReparacion;
	private Date fechaIngreso;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaEntrega;
	private String estado;
	private String descFinal;
	private String detalleInicial;
	private String observaciones;
	private float precioManoDeObra;
	private Mecanico mecanico;
	private Auto auto;
	private ArrayList<LineaDeRepuesto> misLineas = new ArrayList<LineaDeRepuesto>();

	
	
	public void setLinea(LineaDeRepuesto linea){
		misLineas.add(linea);
	}
	
	
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	
	public Mecanico getMecanico() {
		return mecanico;
	}
	public void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}
	public Auto getAuto() {
		return auto;
	}
	public void setAuto(Auto auto) {
		this.auto = auto;
	}
		
	
	public int getNroReparacion() {
		return nroReparacion;
	}
	public void setNroReparacion(int nroReparacion) {
		this.nroReparacion = nroReparacion;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDescFinal() {
		return descFinal;
	}
	public void setDescFinal(String descFinal) {
		this.descFinal = descFinal;
	}
	public String getDetalleInicial() {
		return detalleInicial;
	}
	public void setDetalleInicial(String detalleInicial) {
		this.detalleInicial = detalleInicial;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	public float getPrecioManoDeObra() {
		return precioManoDeObra;
	}
	public void setPrecioManoDeObra(float precioManoDeObra) {
		this.precioManoDeObra = precioManoDeObra;
	}
}
