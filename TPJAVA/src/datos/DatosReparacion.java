package datos;

import java.sql.*;
import java.util.ArrayList;

import entidades.*;

public class DatosReparacion {
	
	public Reparacion traerReparacionPorNro(int nro_reparacion){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Reparacion rep = new Reparacion();
		Cliente cli = new Cliente();
		Auto auto = new Auto();
		Mecanico mec = new Mecanico();
		String query = "SELECT * "
				+ "FROM reparaciones rep "
				+ "INNER JOIN autos a "
					+ "ON a.patente = rep.patente "
				+ "INNER JOIN clientes c "
					+ "ON a.dni = c.dni "
				+ "INNER JOIN mecanicos mec "
					+ "ON mec.matricula = rep.matricula "
				+ "WHERE rep.nro_reparacion = ? AND rep.activa = 'si'";
		try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(query);
			pstmt.setInt(1,nro_reparacion);
			rs= pstmt.executeQuery();
			if(rs != null){
				while (rs.next()){
					rep.setNroReparacion(rs.getInt("nro_reparacion"));
					rep.setFechaIngreso(rs.getDate("fecha_ingreso"));
					rep.setFechaInicio(rs.getDate("fecha_inicio"));
					rep.setFechaFin(rs.getDate("fecha_fin"));
					rep.setDescFinal(rs.getString("descripcion_final"));
					rep.setDetalleInicial(rs.getString("detalle_inicial"));
					rep.setObservaciones(rs.getString("observaciones"));
					
					cli.setDni(rs.getString("dni"));
					cli.setNombre_y_apellido(rs.getString("nombre_y_apellido"));
					cli.setDireccion(rs.getString("direccion"));
					cli.setTelefono(rs.getString("telefono"));
					cli.setMail(rs.getString("mail"));
					
					auto.setPatente(rs.getString("patente"));
					auto.setMarca(rs.getString("marca"));
					auto.setModelo(rs.getString("modelo"));
					auto.setAnio(rs.getInt("anio_fabricacion"));
					
					mec.setNombre_y_apellido(rs.getString("mec.nombre_y_apellido"));
					
					auto.setCli(cli);
					rep.setAuto(auto);
					rep.setMecanico(mec);
				}
					}
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	finally {
			try {
				pstmt.close();
				rs.close();
				Conexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 	return rep;
	}

	public ArrayList<Reparacion> traerReparaciones() {
		
		ArrayList<Reparacion> misReparaciones= new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT rep.nro_reparacion, rep.fecha_ingreso, c.nombre_y_apellido, a.patente, a.marca, a.modelo, a.anio_fabricacion "
				+ "FROM reparaciones rep "
				+ "INNER JOIN autos a "
					+ "ON rep.patente = a.patente "
				+ "INNER JOIN clientes c "
					+ "ON a.dni = c.dni "
				+ "WHERE rep.activa = 'si' "
				+ "ORDER BY rep.nro_reparacion";
	 	try {
			stmt= Conexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery(query);
			if (rs!=null){
				while (rs.next()) {
					Reparacion rep = new Reparacion();
					Cliente cli = new Cliente();
					Auto auto = new Auto();
					rep.setNroReparacion(rs.getInt("nro_reparacion"));
					rep.setFechaIngreso(rs.getDate("fecha_ingreso"));
					cli.setNombre_y_apellido(rs.getString("nombre_y_apellido"));
					auto.setPatente(rs.getString("patente"));
					auto.setMarca(rs.getString("marca"));
					auto.setModelo(rs.getString("modelo"));
					auto.setAnio(rs.getInt("anio_fabricacion"));
					auto.setCli(cli);
					rep.setAuto(auto);
					misReparaciones.add(rep);
				}
		 	}
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	finally {
			try {
				stmt.close();
				rs.close();
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
