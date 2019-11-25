package logica;

public class ValidacionesIngresoDatos {
	
	public boolean ingresoYClienteVacio(String dni, String cod_reparacion_string){
		if(dni.equalsIgnoreCase("Cliente") || (cod_reparacion_string.equalsIgnoreCase("Reparacion"))){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean validaDni(String dni){
		boolean band = true;
		if (dni.length() != 8){
			band = false;
		}else {
			try{
				int dni_int = Integer.parseInt(dni);
			}catch (Exception e){
				band = false;
			}
		}
		return band;
	}

	
	
}
