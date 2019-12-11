package entidades;

public class Auto {
	
	private String patente;
	private String marca;
	private String modelo;
	private int anio;
	private int cantKM;
	private Cliente cli;
	
	public Auto () {
		Cliente cli = new Cliente();
		this.cli = cli;
	}
	
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public int getCantKM() {
		return cantKM;
	}
	public void setCantKM(int cantKM) {
		this.cantKM = cantKM;
	}
	public Cliente getCli() {
		return cli;
	}
	public void setCli(Cliente cli) {
		this.cli = cli;
	}
}
