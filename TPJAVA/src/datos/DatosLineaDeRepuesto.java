package datos;

import java.util.ArrayList;


import java.sql.*;

import entidades.*;

public class DatosLineaDeRepuesto {
	
	public Float getPrecioTotal(int nro_reparacion){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		float total = 0;
		String query = ("SELECT SUM(rep.precio*rr.cantidad) + repara.mano_de_obra AS total "
						+ "FROM repa_repuestos rr "
						+ "INNER JOIN repuestos rep "
						+ "ON rr.cod_repuesto = rep.cod_repuesto "
						+ "INNER JOIN reparaciones repara "
						+ "ON rr.nro_reparacion = repara.nro_reparacion "
						+ "WHERE rr.nro_reparacion = ?");
		try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(query);
			pstmt.setInt(1, nro_reparacion);
			rs = pstmt.executeQuery();
			if (rs!=null){
				while (rs.next()) {
					total = rs.getFloat("total");
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
		return total;
	}
	
	public ArrayList<LineaDeRepuesto> traerRepuestosReparacion(int nro_reparacion){
		ArrayList<LineaDeRepuesto> misLineas = new ArrayList<LineaDeRepuesto>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM repuestos rep "
				+ "INNER JOIN repa_repuestos rr "
					+ "ON rep.cod_repuesto = rr.cod_repuesto "
				+ "INNER JOIN reparaciones repa "
					+ "ON repa.nro_reparacion = rr.nro_reparacion "
				+ "WHERE repa.nro_reparacion = ?";
	 	try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(query);
			pstmt.setInt(1, nro_reparacion);
			rs = pstmt.executeQuery();
			if (rs!=null){
				while (rs.next()) {
					LineaDeRepuesto linea = new LineaDeRepuesto();
					Repuesto rep = new Repuesto();
					rep.setCodigo(rs.getInt("cod_repuesto"));
					rep.setDescripcion(rs.getString("descripcion"));
					rep.setPrecio(rs.getFloat("precio"));
					linea.setRepuesto(rep);
					linea.setCantidad(rs.getInt("cantidad"));
					misLineas.add(linea);
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
		return misLineas;
	}
	
	public ArrayList<LineaDeRepuesto> eliminarRepuestoSeleccionado(int cod_repuesto, ArrayList<LineaDeRepuesto> repuestosSeleccionados){
		int i=0;
		for (LineaDeRepuesto ldr : repuestosSeleccionados){
			if (ldr.getRepuesto().getCodigo() == cod_repuesto){
				break;
			}else{
				i++;
			}
		};
		repuestosSeleccionados.remove(i);
		return repuestosSeleccionados;
	}
	
	public ArrayList<LineaDeRepuesto> agregarLinea(ArrayList<LineaDeRepuesto> repuestosSeleccionados, int cantidad, int cod_repuesto){
		LineaDeRepuesto linea = new LineaDeRepuesto();
		Repuesto rep = new Repuesto();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM repuestos WHERE cod_repuesto = ?";
	 	try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(query);
			pstmt.setInt(1, cod_repuesto);
			rs = pstmt.executeQuery();
			if (rs!=null){
				while (rs.next()) {
					rep.setCodigo(rs.getInt("cod_repuesto"));
					rep.setDescripcion(rs.getString("descripcion"));
					rep.setPrecio(rs.getFloat("precio"));
					linea.setRepuesto(rep);
					linea.setCantidad(cantidad);
				}
				repuestosSeleccionados.add(linea);
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
	 	return repuestosSeleccionados;
	}
	
	public ArrayList<LineaDeRepuesto> traerRepuestosFactura(int cod_reparacion) {
		ArrayList<LineaDeRepuesto> repuestosFactura = new ArrayList<LineaDeRepuesto>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT r.cod_repuesto, r.descripcion, r.precio, rp.cantidad FROM reparaciones rep "
				+ "INNER JOIN repa_repuestos rp "
					+ "ON rep.nro_reparacion = rp.nro_reparacion "
				+ "INNER JOIN repuestos r "
					+ "ON rp.cod_repuesto = r.cod_repuesto "
				+ "WHERE rep.nro_reparacion = ? AND rep.estado = ? AND activa = ?";
		try {
			pstmt = Conexion.getInstancia().getConn().prepareStatement(query);
			pstmt.setInt(1, cod_reparacion);
			pstmt.setString(2, "Finalizada");
			pstmt.setString(3, "si");
			rs = pstmt.executeQuery();
			if(rs != null) {
				while (rs.next()) {
					Repuesto rep = new Repuesto();
					LineaDeRepuesto ldr = new LineaDeRepuesto();
					rep.setCodigo(rs.getInt("cod_repuesto"));
					rep.setDescripcion(rs.getString("descripcion"));
					rep.setPrecio(rs.getFloat("precio"));
					ldr.setRepuesto(rep);
					ldr.setCantidad(rs.getInt("cantidad"));
					repuestosFactura.add(ldr);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return repuestosFactura;
	}
	
	public ArrayList<LineaDeRepuesto> inicializarLineas(){
		ArrayList<LineaDeRepuesto> misLineas = new ArrayList<LineaDeRepuesto>();
		return misLineas;
	}
}
