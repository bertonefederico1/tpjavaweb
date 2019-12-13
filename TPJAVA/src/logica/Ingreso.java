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
		rs= stmt.executeQuery("SELECT * FROM usuario_y_contrasenia");
		while (rs.next()){
			if (rs.getString("usuario").equalsIgnoreCase(u.getUser()) && rs.getString("contrasenia").equalsIgnoreCase(u.getPassword())){
			band = true;
			break;
			}
		}
		return band;
	}
	
	public int traerNivel(int matricula) throws Exception {
		int nivel = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = ("SELECT nivel FROM usuario_y_contrasenia WHERE usuario = ?");
		pstmt = Conexion.getInstancia().getConn().prepareStatement(sql);
		pstmt.setInt(1, matricula);
		rs = pstmt.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				nivel = rs.getInt("nivel");
			}
		}
		return nivel;
	}
}
