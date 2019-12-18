package datos;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

import entidades.Cliente;
import entidades.Turno;

public class DatosTurno {

	public void registrarTurno(String fecha_turno, String dni_cliente)
			throws Exception {
		
		PreparedStatement pstmt = null;
		String insertar = ("INSERT INTO turnos (fecha_turno, dni, estado) VALUES (?,?,?)");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date_turno = sdf.parse(fecha_turno);
		pstmt = Conexion.getInstancia().getConn().prepareStatement(insertar);
		java.sql.Date fechaTurno = new java.sql.Date(date_turno.getTime());
		pstmt.setDate(1, fechaTurno);
		pstmt.setInt(2, Integer.parseInt(dni_cliente));
		pstmt.setString(3, "En espera");
		pstmt.executeUpdate();
		pstmt.close();
		Conexion.getInstancia().releaseConn();
	}

	public boolean disponibilidadTurnosAFecha(String fecha_turno)
			throws Exception {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String disponible;
		boolean estaDisponible = true;
		String query = ("CALL disponibilidad_turnos_a_la_fecha (?)");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date_turno = sdf.parse(fecha_turno);
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
		pstmt.close();
		Conexion.getInstancia().releaseConn();
		return estaDisponible;
	}

	public boolean existeTurnoClienteYFecha(String dni_cliente,
			String fecha_turno) throws Exception {
		boolean existe = true;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = ("SELECT fecha_turno, dni FROM turnos WHERE dni = ? AND fecha_turno = ? AND fecha_cancelacion is null AND estado LIKE '%En espera%'");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date_turno = sdf.parse(fecha_turno);
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
		pstmt.close();
		Conexion.getInstancia().releaseConn();
		return existe;
	}

	public ArrayList<Turno> traerTurnos() throws Exception {
		ArrayList<Turno> misTurnos = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		String query = ("SELECT * "
				+ "FROM turnos tur "
				+ "INNER JOIN clientes cli "
					+ "ON tur.dni = cli.dni "
				+ "WHERE tur.fecha_cancelacion is null AND tur.estado LIKE '%En espera%' ORDER BY tur.fecha_turno");
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
		rs.close();
		stmt.close();
		Conexion.getInstancia().releaseConn();
		return misTurnos;
	}

	public void cancelarTurno(int nro_turno) throws Exception {
		PreparedStatement pstmt = null;
		String dar_de_baja = ("UPDATE turnos SET fecha_cancelacion = ?, estado = 'Cancelado' WHERE nro_turno = ?");
		Date fecha = new Date(Calendar.getInstance().getTimeInMillis());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String fechaHoy = formatter.format(fecha);
		java.sql.Date fechaCancelacion = new java.sql.Date(formatter.parse(fechaHoy).getTime());
		pstmt = Conexion.getInstancia().getConn().prepareStatement(dar_de_baja);
		pstmt.setDate(1, fechaCancelacion);
		pstmt.setInt(2, nro_turno);
		pstmt.executeUpdate();
		pstmt.close();
		Conexion.getInstancia().releaseConn();

	}

	public boolean verificarTurno(String dni) throws Exception {
		boolean coincide = true;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = ("SELECT * FROM turnos WHERE fecha_turno = current_date() AND dni = ? AND fecha_cancelacion is null AND estado LIKE '%En espera%'");
		pstmt = Conexion.getInstancia().getConn().prepareStatement(query);
		pstmt.setInt(1, Integer.parseInt(dni));
		rs = pstmt.executeQuery();
		if (rs.next()) {
			coincide = true;
		} else {
			coincide = false;
		}
		pstmt.close();
		Conexion.getInstancia().releaseConn();
		return coincide;
	}

	public void actualizarTurno(String dni_cliente) throws Exception {
		PreparedStatement pstmt = null;
		String actualizar = ("UPDATE turnos SET estado = 'Ingresado' WHERE fecha_turno = current_date() AND dni = ?");
		pstmt = Conexion.getInstancia().getConn().prepareStatement(actualizar);
		pstmt.setInt(1, Integer.parseInt(dni_cliente));
		pstmt.executeUpdate();
		pstmt.close();
		Conexion.getInstancia().releaseConn();
	}

	public ArrayList<Turno> turnosFiltrados(String buscaTurno, String tipo)
			throws Exception {
		ArrayList<Turno> misTurnos = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query_por_fecha = ("SELECT * FROM turnos tur "
				+ "INNER JOIN clientes cli "
					+ "ON tur.dni = cli.dni "
				+ "WHERE tur.fecha_turno = ? AND tur.fecha_cancelacion is null AND tur.estado LIKE '%En espera%' "
				+ "ORDER BY tur.fecha_turno");
		String query_por_cliente = ("SELECT * FROM turnos tur "
				+ "INNER JOIN clientes cli "
					+ "ON tur.dni = cli.dni "
				+ "WHERE cli.nombre_y_apellido LIKE ? AND tur.fecha_cancelacion is null AND tur.estado LIKE '%En espera%' "
				+ "ORDER BY tur.fecha_turno");
		if (buscaTurno != null) {
			if (tipo.equalsIgnoreCase("fecha")) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = sdf.parse(buscaTurno);
				pstmt = Conexion.getInstancia().getConn().prepareStatement(query_por_fecha);
				java.sql.Date fechaTurno = new java.sql.Date(date.getTime());
				pstmt.setDate(1, fechaTurno);
				rs = pstmt.executeQuery();
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
				pstmt.close();
				Conexion.getInstancia().releaseConn();
			} else {
				pstmt = Conexion.getInstancia().getConn().prepareStatement(query_por_cliente);
				pstmt.setString(1, "%" + buscaTurno + "%");
				rs = pstmt.executeQuery();
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
				pstmt.close();
				Conexion.getInstancia().releaseConn();
			}
		}
		return misTurnos;
	}

	public void eliminarTurno (int dni) throws Exception {
		PreparedStatement pstmt = null;
		String elimina = ("DELETE FROM turnos WHERE dni = ? and estado = 'En espera'");
		pstmt = Conexion.getInstancia().getConn().prepareStatement(elimina);
		pstmt.setInt(1, dni);
		pstmt.close();
		Conexion.getInstancia().releaseConn();
	}
}
