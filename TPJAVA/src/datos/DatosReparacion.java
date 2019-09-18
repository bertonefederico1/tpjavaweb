package datos;

import java.sql.*;
import java.util.ArrayList;

import entidades.*;

public class DatosReparacion {

	public ArrayList<Reparacion> traerReparaciones() {
		
		ArrayList<Reparacion> misReparaciones= new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT rep.nro_reparacion, rep.fecha_ingreso, c.nombre_y_apellido, a.patente, a.marca, a.modelo, a.anio_fabricacion "
				+ "FROM reparaciones rep INNER JOIN autos a"
				+ "ON rep.patente = a.patente"
				+ "INNER JOIN clientes c"
				+ "ON c.dni = a.dni WHERE activa LIKE 'si' ORDER BY rep.nro_reparacion";
	 	try {
			stmt= Conexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery(query);
			if (rs!=null){
				while (rs.next()) {
					Reparacion rep = new Reparacion();
					Cliente cli = new Cliente();
					Auto auto = new Auto();
					rep.setNroReparacion(rs.getInt("rep.nro_reparacion"));
					rep.setFechaIngreso(rs.getDate("rep.fecha_ingreso"));
					cli.setNombre_y_apellido(rs.getString("c.nombre_y_apellido"));
					auto.setPatente(rs.getString("a.patente"));
					auto.setMarca(rs.getString("a.marca"));
					auto.setModelo(rs.getString("a.modelo"));
					auto.setAnio(rs.getInt("a.anio_fabricacion"));
					rep.setAuto(auto);
					auto.setCli(cli);
					misReparaciones.add(rep);
				}
		 	}
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	finally {
			try {
				rs.close();
				stmt.close();
				Conexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 	return misReparaciones;
		}
		
	
	
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
