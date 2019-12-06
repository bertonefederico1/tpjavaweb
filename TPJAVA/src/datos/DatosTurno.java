package datos;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatosTurno {
	
	public void registrarTurno (String fecha_turno, String dni_cliente) {
		PreparedStatement pstmt = null;
		String insertar = ("INSERT INTO turnos (fecha_turno, dni) VALUES (?,?)");
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    Date date_turno = sdf.parse(fecha_turno);
		    try {
		    	pstmt = Conexion.getInstancia().getConn().prepareStatement(insertar);
				java.sql.Date fechaTurno = new java.sql.Date(date_turno.getTime());
				pstmt.setDate(1, fechaTurno);
				pstmt.setInt(2, Integer.parseInt(dni_cliente));
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally{
				try {
					pstmt.close();
					Conexion.getInstancia().releaseConn();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		catch(ParseException ex){
			ex.printStackTrace();
		}
	}
	
}

