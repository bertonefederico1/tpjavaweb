package logica;

import java.sql.*;

import datos.*;
import entidades.*;

public class Ingreso {
	
	public boolean validaLogin (Usuario u) throws Exception{
		
		Statement stmt = null;
		ResultSet rs = null;
		boolean band = false;

			stmt= Conexion.getInstancia().getConn().createStatement();
		
		
				rs= stmt.executeQuery("SELECT * FROM mecanicos");
				while (rs.next()){
					if (rs.getString("matricula").equalsIgnoreCase(u.getUser()) && rs.getString("contrasenia").equalsIgnoreCase(u.getPassword())){
					band = true;
					break;
					}
				}
			
			
		return band;
	}
}
