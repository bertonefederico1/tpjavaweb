package logica;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.*;
import java.text.ParseException;

public class ValidacionesIngresoDatos {
	
	public static boolean fechaInicioMenorAFechaFin(String fecha_inicio, String fecha_fin){
		boolean band = true;
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    Date date_inicio = sdf.parse(fecha_inicio);
		    Date date_fin = sdf.parse(fecha_fin);
		    if(date_inicio.after(date_fin)){
		    	band = false;
		    }
		}
		catch(ParseException ex){
			ex.printStackTrace();
		}
		return band;	    
	}

	
	public static boolean ingresoYClienteVacio(String dni, String cod_reparacion_string){
		if(dni.equalsIgnoreCase("Cliente") || (cod_reparacion_string.equalsIgnoreCase("Reparacion"))){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean clienteYPatenteVacio (String dni, String patente) {
		if(dni.equalsIgnoreCase("Cliente") || patente.equalsIgnoreCase("Vehiculo")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean clienteVacio (String dni) {
		if (dni.equalsIgnoreCase("Cliente")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean validaSoloNumeros(String entrada){
		boolean band = true;
		long entrada_long;
		try{
			entrada_long = Long.parseLong(entrada);
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
	
	public static boolean validaLongitudHasta2(String entrada){
		boolean band = true;
		if (entrada.length() > 2){
			band = false;
		}
		return band;
	}
	
	public static boolean validaLongitudHasta4(String entrada){
		boolean band = true;
		if (entrada.length() > 4){
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
	
	public static boolean validaLongitudHasta1000 (String entrada) {
		if (entrada.length() > 1000) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean validaLongitudHasta45 (String entrada) {
		if (entrada.length() > 45) {
			return false;
		} else {
			return true;
		}
	}
}
