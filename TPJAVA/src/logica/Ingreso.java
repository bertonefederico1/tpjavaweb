package logica;

import java.sql.*;

import datos.*;
import entidades.*;

public class Ingreso {
	
	public boolean validaLogin (Usuario u){
		
		Statement stmt = null;
		ResultSet rs = null;
		boolean band = false;
		try {
			stmt= Conexion.getInstancia().getConn().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			try {
				rs= stmt.executeQuery("SELECT * FROM usuario_y_contrasenia");
				while (rs.next()){
					if (rs.getString("usuario").equalsIgnoreCase(u.getUser()) && rs.getString("contrasenia").equalsIgnoreCase(u.getPassword())){
					band = true;
					break;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try{
					rs.close();
					stmt.close();
					Conexion.getInstancia().releaseConn();
					}
				 catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				 }
			}
		return band;
	}
}
