package logica;

public class ValidacionesIngresoDatos {
	
	public boolean ingresoYClienteVacio(String dni, String cod_reparacion_string){
		if((dni.equalsIgnoreCase("Cliente") || (cod_reparacion_string.equalsIgnoreCase("Reparacion")))){
			return true;
		}else{
			return false;
		}
	}

	
	
}
