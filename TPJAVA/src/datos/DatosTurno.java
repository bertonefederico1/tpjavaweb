package datos;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

import entidades.Cliente;
import entidades.Turno;

public class DatosTurno {
	
	public void registrarTurno (String fecha_turno, String dni_cliente) {
		PreparedStatement pstmt = null;
		String insertar = ("INSERT INTO turnos (fecha_turno, dni, estado) VALUES (?,?,?)");
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    Date date_turno = sdf.parse(fecha_turno);
		    try {
		    	pstmt = Conexion.getInstancia().getConn().prepareStatement(insertar);
				java.sql.Date fechaTurno = new java.sql.Date(date_turno.getTime());
				pstmt.setDate(1, fechaTurno);
				pstmt.setInt(2, Integer.parseInt(dni_cliente));
				pstmt.setString(3, "En espera");
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
	
	public boolean disponibilidadTurnosAFecha (String fecha_turno) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String disponible;
		boolean estaDisponible = true;
		String query = ("CALL disponibilidad_turnos_a_la_fecha (?)");
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    Date date_turno = sdf.parse(fecha_turno);
		    try {
		    	pstmt = Conexion.getInstancia().getConn().prepareStatement(query);
				java.sql.Date fechaTurno = new java.sql.Date(date_turno.getTime());
				pstmt.setDate(1, fechaTurno);
				rs = pstmt.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						disponible = rs.getString("disponible");
						if (disponible.equalsIgnoreCase("si")) {
							estaDisponible = true;
						} else {
							estaDisponible = false;
						}
					}
				}
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
		return estaDisponible;
	}
	
	public boolean existeTurnoClienteYFecha (String dni_cliente, String fecha_turno) {
		boolean existe = true;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = ("SELECT fecha_turno, dni FROM turnos WHERE dni = ? AND fecha_turno = ? AND fecha_cancelacion is null AND estado LIKE '%En espera%'");
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    Date date_turno = sdf.parse(fecha_turno);
		    try {
		    	pstmt = Conexion.getInstancia().getConn().prepareStatement(query);
				java.sql.Date fechaTurno = new java.sql.Date(date_turno.getTime());
				pstmt.setInt(1, Integer.parseInt(dni_cliente));
				pstmt.setDate(2, fechaTurno);
				rs = pstmt.executeQuery();
				if (rs.next()) {
						existe = true;
				} else {
					existe = false;
				}
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
		} catch(ParseException ex){
			ex.printStackTrace();
		}
		return existe;
	}
	
	public ArrayList<Turno> traerTurnos() {
		ArrayList<Turno> misTurnos = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		String query = ("SELECT * "
						+ "FROM turnos tur "
						+ "INNER JOIN clientes cli "
							+ "ON tur.dni = cli.dni "
						+ "WHERE tur.fecha_cancelacion is null AND tur.estado LIKE '%En espera%' ORDER BY tur.fecha_turno");
		try {
			stmt = Conexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery(query);
			if (rs != null) {
				while (rs.next()) {
					Turno turno = new Turno();
					Cliente cli = new Cliente();
					turno.setNroTurno(rs.getInt("nro_turno"));
					turno.setFechaTurno(rs.getDate("fecha_turno"));
					cli.setDni(rs.getString("dni"));
					cli.setNombre_y_apellido(rs.getString("nombre_y_apellido"));
					turno.setCliente(cli);
					misTurnos.add(turno);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				stmt.close();
				Conexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return misTurnos;
	}
	
	public void cancelarTurno (int nro_turno) {
		PreparedStatement pstmt = null;
		String dar_de_baja = ("UPDATE turnos SET fecha_cancelacion = ?, estado = 'Cancelado' WHERE nro_turno = ?");
		Date fecha = new Date(Calendar.getInstance().getTimeInMillis());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String fechaHoy = formatter.format(fecha);
		try {
			try {
				java.sql.Date fechaCancelacion = new java.sql.Date(formatter.parse(fechaHoy).getTime());
				pstmt = Conexion.getInstancia().getConn().prepareStatement(dar_de_baja);
				pstmt.setDate(1, fechaCancelacion);
				pstmt.setInt(2, nro_turno);
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
		} catch(ParseException ex){
			ex.printStackTrace();
		}
	}
	
	public boolean verificarTurno (String dni) {
		boolean coincide = true;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = ("SELECT * FROM turnos WHERE fecha_turno = current_date() AND dni = ? AND fecha_cancelacion is null AND estado LIKE '%En espera%'");
		try {
			pstmt = Conexion.getInstancia().getConn().prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(dni));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				coincide = true;
			} else {
				coincide = false;
			}
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
		return coincide;
	}
	
	public void actualizarTurno (String dni_cliente) {
		PreparedStatement pstmt = null;
		String actualizar = ("UPDATE turnos SET estado = 'Ingresado' WHERE fecha_turno = current_date() AND dni = ?");
		try {
			pstmt = Conexion.getInstancia().getConn().prepareStatement(actualizar);
			pstmt.setInt(1, Integer.parseInt(dni_cliente));
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

