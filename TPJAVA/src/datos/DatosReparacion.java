package datos;

import java.sql.*;
import java.util.ArrayList;

import entidades.*;

public class DatosReparacion {
	
	public void facturarReparacion(Reparacion repa, String estado){
		PreparedStatement pstmt = null;
		String sql= ("UPDATE reparaciones SET fecha_entrega= ?, estado = ? WHERE nro_reparacion= ?");
		try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(sql);
			java.sql.Date fecha_entrega= new java.sql.Date(repa.getFechaEntrega().getTime());
			pstmt.setDate(1, fecha_entrega);
			pstmt.setString(2, estado);
			pstmt.setInt(3, repa.getNroReparacion());
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
	
	public ArrayList <Reparacion> traerReparacionesAModificar(){
		ArrayList<Reparacion> misReparaciones= new ArrayList<>();
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
	 	try {
			stmt= Conexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery(query);
			if (rs!=null){
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
	
	public double precioManoDeObra(int cod_reparacion) {
		double mano_de_obra = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT mano_de_obra "
				+ "FROM reparaciones rep "
				+ "WHERE rep.activa = 'si' AND rep.nro_reparacion = ? ";
	 	try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(query);
			pstmt.setInt(1, cod_reparacion);
			rs = pstmt.executeQuery();
			if (rs!=null){
				while (rs.next()) {
					mano_de_obra = rs.getDouble("mano_de_obra");
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
		return mano_de_obra;
	}
	
	
	public void agregarReparacion(ArrayList<LineaDeRepuesto> repuestosSeleccionados, Reparacion rep, String estado){
		PreparedStatement pstmt = null;
		String actualiza_reparacion;
		if (estado.equalsIgnoreCase("Finalizada")){
			actualiza_reparacion= ("UPDATE reparaciones SET fecha_inicio= ?, estado= ?, descripcion_final= ?, mano_de_obra= ?, fecha_fin= ?  WHERE nro_reparacion= ?");
			try {
				pstmt= Conexion.getInstancia().getConn().prepareStatement(actualiza_reparacion);
				java.sql.Date fecha_inicio= new java.sql.Date(rep.getFechaInicio().getTime());
				java.sql.Date fecha_fin= new java.sql.Date(rep.getFechaFin().getTime());
				pstmt.setDate(1, fecha_inicio);
				pstmt.setString(2, estado);
				pstmt.setString(3, rep.getDescFinal());
				pstmt.setFloat(4, rep.getPrecioManoDeObra());
				pstmt.setDate(5, fecha_fin);
				pstmt.setInt(6, rep.getNroReparacion());
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
		} else{
			actualiza_reparacion= ("UPDATE reparaciones SET fecha_inicio= ?, estado= ?, descripcion_final= ?, mano_de_obra= ?  WHERE nro_reparacion= ?");
			try {
				pstmt= Conexion.getInstancia().getConn().prepareStatement(actualiza_reparacion);
				java.sql.Date fecha_inicio= new java.sql.Date(rep.getFechaInicio().getTime());
				pstmt.setDate(1, fecha_inicio);
				pstmt.setString(2, estado);
				pstmt.setString(3, rep.getDescFinal());
				pstmt.setFloat(4, rep.getPrecioManoDeObra());
				pstmt.setInt(5, rep.getNroReparacion());
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
		
		String carga_repuestos_seleccionados = ("INSERT INTO repa_repuestos (nro_reparacion, cod_repuesto, cantidad) values(?,?,?)");
		try {
			for (LineaDeRepuesto ldr : repuestosSeleccionados){
				pstmt= Conexion.getInstancia().getConn().prepareStatement(carga_repuestos_seleccionados);
				pstmt.setInt(1, rep.getNroReparacion());
				pstmt.setInt(2, ldr.getRepuesto().getCodigo());
				pstmt.setInt(3, ldr.getCantidad());
				pstmt.executeUpdate();
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
		String actualiza_stock = ("UPDATE repuestos SET stock = (stock-?) WHERE cod_repuesto = ?");
		try {
			for (LineaDeRepuesto ldr : repuestosSeleccionados) {
				pstmt = Conexion.getInstancia().getConn().prepareStatement(actualiza_stock);
				pstmt.setInt(1, ldr.getCantidad());
				pstmt.setInt(2, ldr.getRepuesto().getCodigo());
				pstmt.executeUpdate();
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
	}
	
	public ArrayList<Reparacion> reparacionesFiltradas(String nombuscar) {
		
		ArrayList<Reparacion> misReparaciones= new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT * "
				+ "FROM reparaciones rep "
				+ "INNER JOIN autos a "
					+ "ON rep.patente = a.patente "
				+ "INNER JOIN clientes c "
					+ "ON a.dni = c.dni "
				+ "WHERE rep.activa = 'si' AND c.nombre_y_apellido LIKE ? "
				+ "ORDER BY rep.nro_reparacion";
	 	try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(query);
			pstmt.setString(1,"%"+ nombuscar + "%");
			rs = pstmt.executeQuery();
			if (rs!=null){
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
	 	return misReparaciones;
		}
	
	public void eliminarReparacion(int nro_reparacion){
		PreparedStatement pstmt = null;
		String sql= ("UPDATE reparaciones SET activa= ? WHERE nro_reparacion= ?");
		try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(sql);
			pstmt.setString(1, "no");
			pstmt.setInt(2, nro_reparacion);
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
	
	public ArrayList<Reparacion> reparacionesFinalizadasPorCliente(String dni){
		ArrayList<Reparacion> misReparaciones= new ArrayList<>();
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
	 	try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(query);
			pstmt.setString(1,dni);
			rs = pstmt.executeQuery();
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
				pstmt.close();
				rs.close();
				Conexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 	return misReparaciones;
	}
	
	public ArrayList<Reparacion> reparacionesPorCliente(String dni){
		ArrayList<Reparacion> misReparaciones= new ArrayList<>();
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
	 	try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(query);
			pstmt.setString(1,dni);
			rs = pstmt.executeQuery();
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
				pstmt.close();
				rs.close();
				Conexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 	return misReparaciones;
	}
	
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
				+ "LEFT JOIN mecanicos mec "
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
		String query = "SELECT rep.nro_reparacion, rep.fecha_ingreso, c.nombre_y_apellido, a.patente, a.marca, a.modelo, a.anio_fabricacion, rep.estado "
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
	
	public void modificarReparacion (ArrayList<LineaDeRepuesto> repuestosModificados, ArrayList<LineaDeRepuesto> repuestosOriginal, Reparacion rep, String estado) {
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		String elimina_repa_repuestos = ("DELETE FROM repa_repuestos WHERE nro_reparacion = ?");
		String actualiza_stock_mas = ("UPDATE repuestos SET stock = (stock + ?) WHERE cod_repuesto = ?");
		String actualiza_stock_menos = ("UPDATE repuestos SET stock = (stock - ?) WHERE cod_repuesto = ?");
		String inserta_repa_repuestos = ("INSERT INTO repa_repuestos (nro_reparacion, cod_repuesto, cantidad) VALUES (?,?,?)");
		String actualiza_reparacion = ("UPDATE reparaciones SET fecha_fin = ?, estado = ?, descripcion_final = ?, mano_de_obra = ? WHERE nro_reparacion = ?");
		try {
			pstmt = Conexion.getInstancia().getConn().prepareStatement(elimina_repa_repuestos);
			pstmt.setInt(1, rep.getNroReparacion());
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
		for (LineaDeRepuesto ldr : repuestosOriginal) {
			try {
				pstmt = Conexion.getInstancia().getConn().prepareStatement(actualiza_stock_mas);
				pstmt.setInt(1, ldr.getCantidad());
				pstmt.setInt(2, ldr.getRepuesto().getCodigo());
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
		for (LineaDeRepuesto ldr : repuestosModificados) {
			try {
				pstmt = Conexion.getInstancia().getConn().prepareStatement(inserta_repa_repuestos);
				pstmt.setInt(1, rep.getNroReparacion());
				pstmt.setInt(2, ldr.getRepuesto().getCodigo());
				pstmt.setInt(3, ldr.getCantidad());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt1 = Conexion.getInstancia().getConn().prepareStatement(actualiza_stock_menos);
				pstmt1.setInt(1, ldr.getCantidad());
				pstmt1.setInt(2, ldr.getRepuesto().getCodigo());
				pstmt1.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					pstmt.close();
					pstmt1.close();
					Conexion.getInstancia().releaseConn();
					Conexion.getInstancia().releaseConn();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if (estado.equalsIgnoreCase("Finalizada")) {
			try {
				java.sql.Date fecha_fin= new java.sql.Date(rep.getFechaFin().getTime());
				pstmt = Conexion.getInstancia().getConn().prepareStatement(actualiza_reparacion);
				pstmt.setDate(1, fecha_fin);
				pstmt.setString(2, estado);
				pstmt.setString(3, rep.getDescFinal());
				pstmt.setFloat(4, rep.getPrecioManoDeObra());
				pstmt.setInt(5, rep.getNroReparacion());
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
		} else {
			try {
				pstmt1 = Conexion.getInstancia().getConn().prepareStatement(actualiza_reparacion);
				pstmt1.setDate(1, null);
				pstmt1.setString(2, estado);
				pstmt1.setString(3, rep.getDescFinal());
				pstmt1.setFloat(4, rep.getPrecioManoDeObra());
				pstmt1.setInt(5, rep.getNroReparacion());
				pstmt1.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					pstmt1.close();
					Conexion.getInstancia().releaseConn();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
