package datos;

import java.sql.*;
import java.sql.SQLException;

import entidades.Reparacion;

public class DatosReparacion {
	
	public void agregarNuevoIngreso(Reparacion repa){
		PreparedStatement pstmt = null;
		String sql = ("insert into reparaciones(fecha_ingreso, estado, detalle_inicial, observaciones, patente, activa) values(?,?,?,?,?,?)");
		try {
			pstmt = Conexion.getInstancia().getConn().prepareStatement(sql);
			java.sql.Date d2= new java.sql.Date(repa.getFechaIngreso().getTime());
			pstmt.setDate(1, d2);
			pstmt.setString(2, repa.getEstado());
			pstmt.setString(3, repa.getDetalleInicial());
			pstmt.setString(4, repa.getObservaciones());
			pstmt.setString(5, repa.getAuto().getPatente());
			pstmt.setString(6, "si");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				Conexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	}
