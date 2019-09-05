package entidades;

public class LineaDeRepuesto {
	private int cantidad;
	private Repuesto repuesto;

	
	
	public Repuesto getRepuesto() {
		return repuesto;
	}

	public void setRepuesto(Repuesto repuesto) {
		this.repuesto = repuesto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
