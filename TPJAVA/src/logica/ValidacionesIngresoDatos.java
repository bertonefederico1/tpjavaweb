package logica;

import java.util.regex.*;

public class ValidacionesIngresoDatos {
	
	public boolean ingresoYClienteVacio(String dni, String cod_reparacion_string){
		if(dni.equalsIgnoreCase("Cliente") || (cod_reparacion_string.equalsIgnoreCase("Reparacion"))){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean validaSoloNumeros(String entrada){
		boolean band = true;
		int entrada_int;
		try{
			entrada_int = Integer.parseInt(entrada);
		}catch (Exception e){
			band = false;
		}
		return band;
	}
	
	public static boolean validaSoloNumerosFloat(String entrada){
		boolean band = true;
		float entrada_float;
		try{
			entrada_float = Float.parseFloat(entrada);
		}catch (Exception e){
			band = false;
		}
		return band;
	}
	
	public static boolean validaLongitudIgualA8(String entrada){
		boolean band = true;
		if (entrada.length() != 8){
			band = false;
		}
		return band;
	}
	
	public static boolean validaLongitudIgualA2(String entrada){
		boolean band = true;
		if (entrada.length() != 2){
			band = false;
		}
		return band;
	}
	
	public static boolean validaLongitudIgualA1(String entrada){
		boolean band = true;
		if (entrada.length() != 1){
			band = false;
		}
		return band;
	}
	
	public static boolean validaLongitudHasta100(String entrada){
		boolean band = true;
		if (entrada.length() > 100){
			band = false;
		}
		return band;
	}
	
	public static boolean validaLongitudHasta9(String entrada){
		boolean band = true;
		if (entrada.length() > 9){
			band = false;
		}
		return band;
	}
	
	public static boolean validaLongitudHasta10(String entrada){
		boolean band = true;
		if (entrada.length() > 10){
			band = false;
		}
		return band;
	}
	
	public static boolean validaLongitudIgualA4(String entrada){
		boolean band = true;
		if (entrada.length() != 4){
			band = false;
		}
		return band;
	}
	
	public static boolean validaLongitudHasta12(String entrada){
		boolean band = true;
		if (entrada.length() > 12){
			band = false;
		}
		return band;
	}

	public static boolean validaEmail(String email){
		boolean band = true;
		String email_pattern = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(email_pattern);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()){
		}else {
			band = false;
		}
		return band;
	}
	
}
