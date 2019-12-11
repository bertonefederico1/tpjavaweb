package datos;

import java.sql.*;
import java.util.ArrayList;

import entidades.*;

public class DatosReparacion {
	
	public int buscarIndiceArreglomisReparaciones(
			ArrayList<Reparacion> misReparaciones, int nro_reparacion)
			throws Exception {
		
		int indice = 0;
		boolean band = false;
		while (band == false) {
			if (misReparaciones.get(indice).getNroReparacion() == nro_reparacion) {
				band = true;
			} else {
				indice++;
			}
		}
		return indice;
	}

	public ArrayList<Reparacion> traerFacturasPorFecha(String dia, String mes,
			String anio) throws Exception {
		
		ArrayList<Reparacion> misReparaciones = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT * "
				+ "FROM reparaciones rep "
				+ "INNER JOIN autos a "
					+ "ON rep.patente = a.patente "
				+ "INNER JOIN clientes c "
					+ "ON a.dni = c.dni "
				+ "WHERE year(rep.fecha_entrega) = ? AND month(rep.fecha_entrega) = ? "
				+ "AND day(rep.fecha_entrega) = ? AND rep.activa = 'si' AND rep.estado = 'Entregada' ORDER BY rep.nro_reparacion ASC";
		pstmt = Conexion.getInstancia().getConn().prepareStatement(query);
		pstmt.setString(1, anio);
		pstmt.setString(2, mes);
		pstmt.setString(3, dia);
		rs = pstmt.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				Reparacion repa = new Reparacion();
				Cliente cli = new Cliente();
				Auto auto = new Auto();

				cli.setDni(rs.getString("dni"));
				cli.setNombre_y_apellido(rs.getString("nombre_y_apellido"));
				cli.setDireccion(rs.getString("direccion"));
				cli.setMail(rs.getString("mail"));
				cli.setTelefono(rs.getString("telefono"));

				auto.setPatente(rs.getString("patente"));
				auto.setMarca(rs.getString("marca"));
				auto.setModelo(rs.getString("modelo"));
				auto.setAnio(rs.getInt("anio_fabricacion"));
				auto.setCli(cli);

				repa.setNroReparacion(rs.getInt("nro_reparacion"));
				repa.setAuto(auto);
				misReparaciones.add(repa);
			}
		}
		pstmt.close();
		rs.close();
		Conexion.getInstancia().releaseConn();

		query = "SELECT * FROM repa_repuestos rr " + "INNER JOIN repuestos r "
				+ "ON rr.cod_repuesto = r.cod_repuesto "
				+ "AND rr.nro_reparacion = ? " + "ORDER BY rr.nro_reparacion";
		for (Reparacion miReparacion : misReparaciones) {
			pstmt = Conexion.getInstancia().getConn().prepareStatement(query);
			pstmt.setInt(1, miReparacion.getNroReparacion());
			rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					LineaDeRepuesto ldr = new LineaDeRepuesto();
					Repuesto rep = new Repuesto();
					rep.setCodigo(rs.getInt("cod_repuesto"));
					rep.setDescripcion(rs.getString("descripcion"));
					rep.setPrecio(rs.getFloat("precio"));
					ldr.setCantidad(rs.getInt("cantidad"));
					ldr.setRepuesto(rep);
					miReparacion.setLinea(ldr);
				}
			}
			pstmt.close();
			rs.close();
			Conexion.getInstancia().releaseConn();
		}
		return misReparaciones;
	}

	public void facturarReparacion(Reparacion repa, String estado) throws Exception {
		PreparedStatement pstmt = null;
		String sql = ("UPDATE reparaciones SET fecha_entrega= ?, estado = ? WHERE nro_reparacion= ?");
		pstmt = Conexion.getInstancia().getConn().prepareStatement(sql);
		java.sql.Date fecha_entrega = new java.sql.Date(repa.getFechaEntrega().getTime());
		pstmt.setDate(1, fecha_entrega);
		pstmt.setString(2, estado);
		pstmt.setInt(3, repa.getNroReparacion());
		pstmt.executeUpdate();
		pstmt.close();
		Conexion.getInstancia().releaseConn();
	}

	public ArrayList<Reparacion> traerReparacionesAModificar() throws Exception {
		ArrayList<Reparacion> misReparaciones = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT rep.nro_reparacion, rep.fecha_ingreso, c.nombre_y_apellido, a.patente, a.marca, a.modelo, a.anio_fabricacion, rep.estado "
				+ "FROM reparaciones rep "
				+ "INNER JOIN autos a "
					+ "ON rep.patente = a.patente "
				+ "INNER JOIN clientes c "
					+ "ON a.dni = c.dni "
				+ "WHERE rep.activa = 'si' AND rep.estado IN ('Finalizada','En Curso') "
				+ "ORDER BY rep.nro_reparacion";
		stmt = Conexion.getInstancia().getConn().createStatement();
		rs = stmt.executeQuery(query);
		if (rs != null) {
			while (rs.next()) {
				Reparacion rep = new Reparacion();
				Cliente cli = new Cliente();
				Auto auto = new Auto();
				rep.setEstado(rs.getString("rep.estado"));
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
		stmt.close();
		rs.close();
		Conexion.getInstancia().releaseConn();
		return misReparaciones;
	}

	public double precioManoDeObra(int cod_reparacion) throws Exception {
		double mano_de_obra = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT mano_de_obra " + "FROM reparaciones rep "
				+ "WHERE rep.activa = 'si' AND rep.nro_reparacion = ? ";
		pstmt = Conexion.getInstancia().getConn().prepareStatement(query);
		pstmt.setInt(1, cod_reparacion);
		rs = pstmt.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				mano_de_obra = rs.getDouble("mano_de_obra");
			}
		}
		pstmt.close();
		rs.close();
		Conexion.getInstancia().releaseConn();
		return mano_de_obra;
	}

	public void agregarReparacion(ArrayList<LineaDeRepuesto> repuestosSeleccionados, Reparacion rep,
		Mecanico mec, String estado) throws Exception {
		
		PreparedStatement pstmt = null;
		String actualiza_reparacion;
		if (estado.equalsIgnoreCase("Finalizada")) {
			actualiza_reparacion = ("UPDATE reparaciones SET fecha_inicio= ?, estado= ?, descripcion_final= ?, mano_de_obra= ?, fecha_fin= ?, matricula = ?  WHERE nro_reparacion= ?");
			pstmt = Conexion.getInstancia().getConn().prepareStatement(actualiza_reparacion);
			java.sql.Date fecha_inicio = new java.sql.Date(rep.getFechaInicio().getTime());
			java.sql.Date fecha_fin = new java.sql.Date(rep.getFechaFin().getTime());
			pstmt.setDate(1, fecha_inicio);
			pstmt.setString(2, estado);
			pstmt.setString(3, rep.getDescFinal());
			pstmt.setFloat(4, rep.getPrecioManoDeObra());
			pstmt.setDate(5, fecha_fin);
			pstmt.setInt(6, mec.getMatricula());
			pstmt.setInt(7, rep.getNroReparacion());
			pstmt.executeUpdate();
			pstmt.close();
			Conexion.getInstancia().releaseConn();
		} else {
			actualiza_reparacion = ("UPDATE reparaciones SET fecha_inicio= ?, estado= ?, descripcion_final= ?, mano_de_obra= ?, matricula = ?  WHERE nro_reparacion= ?");
			pstmt = Conexion.getInstancia().getConn().prepareStatement(actualiza_reparacion);
			java.sql.Date fecha_inicio = new java.sql.Date(rep.getFechaInicio().getTime());
			pstmt.setDate(1, fecha_inicio);
			pstmt.setString(2, estado);
			pstmt.setString(3, rep.getDescFinal());
			pstmt.setFloat(4, rep.getPrecioManoDeObra());
			pstmt.setInt(5, mec.getMatricula());
			pstmt.setInt(6, rep.getNroReparacion());
			pstmt.executeUpdate();
			pstmt.close();
			Conexion.getInstancia().releaseConn();
		}
		String carga_repuestos_seleccionados = ("INSERT INTO repa_repuestos (nro_reparacion, cod_repuesto, cantidad) values(?,?,?)");
		for (LineaDeRepuesto ldr : repuestosSeleccionados) {
			pstmt = Conexion.getInstancia().getConn().prepareStatement(carga_repuestos_seleccionados);
			pstmt.setInt(1, rep.getNroReparacion());
			pstmt.setInt(2, ldr.getRepuesto().getCodigo());
			pstmt.setInt(3, ldr.getCantidad());
			pstmt.executeUpdate();
			pstmt.close();
			Conexion.getInstancia().releaseConn();
		}
		String actualiza_stock = ("UPDATE repuestos SET stock = (stock-?) WHERE cod_repuesto = ?");
		for (LineaDeRepuesto ldr : repuestosSeleccionados) {
			pstmt = Conexion.getInstancia().getConn().prepareStatement(actualiza_stock);
			pstmt.setInt(1, ldr.getCantidad());
			pstmt.setInt(2, ldr.getRepuesto().getCodigo());
			pstmt.executeUpdate();
			pstmt.close();
			Conexion.getInstancia().releaseConn();
		}
	}

	public ArrayList<Reparacion> reparacionesFiltradas(String nombuscar)
			throws Exception {

		ArrayList<Reparacion> misReparaciones = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT * "
				+ "FROM reparaciones rep "
				+ "INNER JOIN autos a "
				+ "ON rep.patente = a.patente "
				+ "INNER JOIN clientes c "
				+ "ON a.dni = c.dni "
				+ "WHERE rep.activa = 'si' AND (c.nombre_y_apellido LIKE ? OR a.patente LIKE ?)"
				+ "ORDER BY rep.nro_reparacion";

		pstmt = Conexion.getInstancia().getConn().prepareStatement(query);
		pstmt.setString(1, "%" + nombuscar + "%");
		pstmt.setString(2, "%" + nombuscar + "%");
		rs = pstmt.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				Reparacion rep = new Reparacion();
				Cliente cli = new Cliente();
				Auto auto = new Auto();
				rep.setEstado(rs.getString("rep.estado"));
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
		pstmt.close();
		rs.close();
		Conexion.getInstancia().releaseConn();
		return misReparaciones;
	}

	public void eliminarReparacion(int nro_reparacion) throws Exception {
		PreparedStatement pstmt = null;
		String sql = ("UPDATE reparaciones SET activa= ? WHERE nro_reparacion= ?");
		pstmt = Conexion.getInstancia().getConn().prepareStatement(sql);
		pstmt.setString(1, "no");
		pstmt.setInt(2, nro_reparacion);
		pstmt.executeUpdate();
		pstmt.close();
		Conexion.getInstancia().releaseConn();
	}

	public ArrayList<Reparacion> reparacionesFinalizadasPorCliente(String dni)
			throws Exception {
		
		ArrayList<Reparacion> misReparaciones = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT rep.nro_reparacion, rep.fecha_ingreso, c.nombre_y_apellido, a.patente, a.marca, a.modelo, a.anio_fabricacion "
				+ "FROM reparaciones rep "
				+ "INNER JOIN autos a "
				+ "ON rep.patente = a.patente "
				+ "INNER JOIN clientes c "
				+ "ON a.dni = c.dni "
				+ "WHERE rep.activa = 'si' AND rep.estado = 'Finalizada' AND c.dni = ?"
				+ "ORDER BY rep.nro_reparacion";
		pstmt = Conexion.getInstancia().getConn().prepareStatement(query);
		pstmt.setString(1, dni);
		rs = pstmt.executeQuery();
		if (rs != null) {
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
		pstmt.close();
		rs.close();
		Conexion.getInstancia().releaseConn();
		return misReparaciones;
	}

	public ArrayList<Reparacion> reparacionesPorCliente(String dni) throws Exception {
		ArrayList<Reparacion> misReparaciones = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT rep.nro_reparacion, rep.fecha_ingreso, c.nombre_y_apellido, a.patente, a.marca, a.modelo, a.anio_fabricacion "
				+ "FROM reparaciones rep "
				+ "INNER JOIN autos a "
					+ "ON rep.patente = a.patente "
				+ "INNER JOIN clientes c "
					+ "ON a.dni = c.dni "
				+ "WHERE rep.activa = 'si' AND rep.estado = 'Ingresada' AND c.dni = ?"
				+ "ORDER BY rep.nro_reparacion";
		pstmt = Conexion.getInstancia().getConn().prepareStatement(query);
		pstmt.setString(1, dni);
		rs = pstmt.executeQuery();
		if (rs != null) {
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
		pstmt.close();
		rs.close();
		Conexion.getInstancia().releaseConn();
		return misReparaciones;
	}

	public Reparacion traerReparacionPorNro(int nro_reparacion) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Reparacion rep = new Reparacion();
		Cliente cli = new Cliente();
		Auto auto = new Auto();
		Mecanico mec = new Mecanico();
		String query = "SELECT * " + "FROM reparaciones rep "
				+ "INNER JOIN autos a " 
					+ "ON a.patente = rep.patente "
				+ "INNER JOIN clientes c " 
					+ "ON a.dni = c.dni "
				+ "LEFT JOIN mecanicos mec "
					+ "ON mec.matricula = rep.matricula "
				+ "WHERE rep.nro_reparacion = ? AND rep.activa = 'si'";
		pstmt = Conexion.getInstancia().getConn().prepareStatement(query);
		pstmt.setInt(1, nro_reparacion);
		rs = pstmt.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				rep.setNroReparacion(rs.getInt("nro_reparacion"));
				rep.setFechaIngreso(rs.getDate("fecha_ingreso"));
				rep.setFechaInicio(rs.getDate("fecha_inicio"));
				rep.setFechaFin(rs.getDate("fecha_fin"));
				rep.setDescFinal(rs.getString("descripcion_final"));
				rep.setDetalleInicial(rs.getString("detalle_inicial"));
				rep.setObservaciones(rs.getString("observaciones"));
				rep.setPrecioManoDeObra(rs.getFloat("mano_de_obra"));

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
		pstmt.close();
		rs.close();
		Conexion.getInstancia().releaseConn();
		return rep;
	}

	public ArrayList<Reparacion> traerReparaciones() throws Exception {
		ArrayList<Reparacion> misReparaciones = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT rep.nro_reparacion, rep.fecha_ingreso, c.nombre_y_apellido, c.mail, a.patente, a.marca, a.modelo, a.anio_fabricacion, rep.estado "
				+ "FROM reparaciones rep "
				+ "INNER JOIN autos a "
					+ "ON rep.patente = a.patente "
				+ "INNER JOIN clientes c "
					+ "ON a.dni = c.dni "
				+ "WHERE rep.activa = 'si' "
				+ "ORDER BY rep.nro_reparacion";
		stmt = Conexion.getInstancia().getConn().createStatement();
		rs = stmt.executeQuery(query);
		if (rs != null) {
			while (rs.next()) {
				Reparacion rep = new Reparacion();
				Cliente cli = new Cliente();
				Auto auto = new Auto();
				rep.setEstado(rs.getString("rep.estado"));
				rep.setNroReparacion(rs.getInt("nro_reparacion"));
				rep.setFechaIngreso(rs.getDate("fecha_ingreso"));
				cli.setNombre_y_apellido(rs.getString("nombre_y_apellido"));
				cli.setMail(rs.getString("mail"));
				auto.setPatente(rs.getString("patente"));
				auto.setMarca(rs.getString("marca"));
				auto.setModelo(rs.getString("modelo"));
				auto.setAnio(rs.getInt("anio_fabricacion"));
				auto.setCli(cli);
				rep.setAuto(auto);
				misReparaciones.add(rep);
			}
		}
		stmt.close();
		rs.close();
		Conexion.getInstancia().releaseConn();
		return misReparaciones;
	}

	public void agregarNuevoIngreso(Reparacion repa) throws Exception {
		PreparedStatement pstmt = null;
		String sql = ("INSERT INTO reparaciones (fecha_ingreso, estado, detalle_inicial, observaciones, patente, activa) VALUES (?,?,?,?,?,?)");
		pstmt = Conexion.getInstancia().getConn().prepareStatement(sql);
		java.sql.Date d2 = new java.sql.Date(repa.getFechaIngreso().getTime());
		pstmt.setDate(1, d2);
		pstmt.setString(2, repa.getEstado());
		pstmt.setString(3, repa.getDetalleInicial());
		pstmt.setString(4, repa.getObservaciones());
		pstmt.setString(5, repa.getAuto().getPatente());
		pstmt.setString(6, "si");
		pstmt.executeUpdate();
		pstmt.close();
		Conexion.getInstancia().releaseConn();
	}

	public void modificarReparacion(ArrayList<LineaDeRepuesto> repuestosModificados,ArrayList<LineaDeRepuesto> repuestosOriginal, Reparacion rep,
			String estado) throws Exception {
		
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		String elimina_repa_repuestos = ("DELETE FROM repa_repuestos WHERE nro_reparacion = ?");
		String actualiza_stock_mas = ("UPDATE repuestos SET stock = (stock + ?) WHERE cod_repuesto = ?");
		String actualiza_stock_menos = ("UPDATE repuestos SET stock = (stock - ?) WHERE cod_repuesto = ?");
		String inserta_repa_repuestos = ("INSERT INTO repa_repuestos (nro_reparacion, cod_repuesto, cantidad) VALUES (?,?,?)");
		String actualiza_reparacion = ("UPDATE reparaciones SET fecha_fin = ?, estado = ?, descripcion_final = ?, mano_de_obra = ? WHERE nro_reparacion = ?");
		pstmt = Conexion.getInstancia().getConn().prepareStatement(elimina_repa_repuestos);
		pstmt.setInt(1, rep.getNroReparacion());
		pstmt.executeUpdate();
		pstmt.close();
		Conexion.getInstancia().releaseConn();
		for (LineaDeRepuesto ldr : repuestosOriginal) {
			pstmt = Conexion.getInstancia().getConn().prepareStatement(actualiza_stock_mas);
			pstmt.setInt(1, ldr.getCantidad());
			pstmt.setInt(2, ldr.getRepuesto().getCodigo());
			pstmt.executeUpdate();
			pstmt.close();
			Conexion.getInstancia().releaseConn();
		}
		for (LineaDeRepuesto ldr : repuestosModificados) {
			pstmt = Conexion.getInstancia().getConn().prepareStatement(inserta_repa_repuestos);
			pstmt.setInt(1, rep.getNroReparacion());
			pstmt.setInt(2, ldr.getRepuesto().getCodigo());
			pstmt.setInt(3, ldr.getCantidad());
			pstmt.executeUpdate();
			
			pstmt1 = Conexion.getInstancia().getConn().prepareStatement(actualiza_stock_menos);
			pstmt1.setInt(1, ldr.getCantidad());
			pstmt1.setInt(2, ldr.getRepuesto().getCodigo());
			pstmt1.executeUpdate();

			pstmt.close();
			pstmt1.close();
			Conexion.getInstancia().releaseConn();
			Conexion.getInstancia().releaseConn();
		}
		if (estado.equalsIgnoreCase("Finalizada")) {
			java.sql.Date fecha_fin = new java.sql.Date(rep.getFechaFin().getTime());
			pstmt = Conexion.getInstancia().getConn().prepareStatement(actualiza_reparacion);
			pstmt.setDate(1, fecha_fin);
			pstmt.setString(2, estado);
			pstmt.setString(3, rep.getDescFinal());
			pstmt.setFloat(4, rep.getPrecioManoDeObra());
			pstmt.setInt(5, rep.getNroReparacion());
			pstmt.executeUpdate();
			pstmt.close();
			Conexion.getInstancia().releaseConn();
		} else {
			pstmt1 = Conexion.getInstancia().getConn().prepareStatement(actualiza_reparacion);
			pstmt1.setDate(1, null);
			pstmt1.setString(2, estado);
			pstmt1.setString(3, rep.getDescFinal());
			pstmt1.setFloat(4, rep.getPrecioManoDeObra());
			pstmt1.setInt(5, rep.getNroReparacion());
			pstmt1.executeUpdate();

			pstmt1.close();
			Conexion.getInstancia().releaseConn();
		}
	}
}
