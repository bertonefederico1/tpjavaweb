package datos;

import java.sql.*;
import java.util.ArrayList;

import entidades.Repuesto;

public class DatosRepuesto {
	
	public ArrayList<Repuesto> traerRepuestos(String desc_buscar)
			throws Exception {
		ArrayList<Repuesto> misRepuestos = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM repuestos WHERE descripcion LIKE ? AND activo = 'si' ORDER BY descripcion";
		if (desc_buscar != null) {
			pstmt = Conexion.getInstancia().getConn().prepareStatement(query);
			pstmt.setString(1, "%" + desc_buscar + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Repuesto r = new Repuesto();
				r.setCodigo(Integer.parseInt(rs.getString("cod_repuesto")));
				r.setDescripcion(rs.getString("descripcion"));
				r.setPrecio(rs.getFloat("precio"));
				r.setStock(Integer.parseInt(rs.getString("stock")));
				misRepuestos.add(r);
			}
		rs.close();
		pstmt.close();
		Conexion.getInstancia().releaseConn();
		}
		return misRepuestos;
	}

	public ArrayList<Repuesto> traerRepuestosBajoStock() throws Exception {
		ArrayList<Repuesto> misRepuestos = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		stmt = Conexion.getInstancia().getConn().createStatement();
		rs = stmt.executeQuery("call rep_stock_minimo()");
		if (rs != null) {
			while (rs.next()) {
				Repuesto rep = new Repuesto();
				rep.setCodigo(rs.getInt("cod_repuesto"));
				rep.setDescripcion(rs.getString("descripcion"));
				rep.setPrecio(rs.getFloat("precio"));
				rep.setStock(rs.getInt("stock"));
				misRepuestos.add(rep);
			}
		}
		rs.close();
		stmt.close();
		Conexion.getInstancia().releaseConn();
		return misRepuestos;
	}

	public ArrayList<Repuesto> traerRepuestos() throws Exception {
		ArrayList<Repuesto> misRepuestos = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		stmt = Conexion.getInstancia().getConn().createStatement();
		rs = stmt.executeQuery("SELECT * FROM repuestos WHERE activo = 'si' ORDER BY descripcion");
		if (rs != null) {
			while (rs.next()) {
				Repuesto rep = new Repuesto();
				rep.setCodigo(rs.getInt("cod_repuesto"));
				rep.setDescripcion(rs.getString("descripcion"));
				rep.setPrecio(rs.getFloat("precio"));
				rep.setStock(rs.getInt("stock"));
				misRepuestos.add(rep);
			}
		}
		rs.close();
		stmt.close();
		Conexion.getInstancia().releaseConn();
		return misRepuestos;
	}

	public void agregarRepuesto(Repuesto rep) throws Exception {
		PreparedStatement pstmt = null;
		String insertar = ("insert into repuestos(descripcion,precio,stock,activo) values(?,?,?,?)");
		pstmt = Conexion.getInstancia().getConn().prepareStatement(insertar);
		pstmt.setString(1, rep.getDescripcion());
		pstmt.setFloat(2, rep.getPrecio());
		pstmt.setInt(3, rep.getStock());
		pstmt.setString(4,"si");
		pstmt.executeUpdate();
		pstmt.close();
		Conexion.getInstancia().releaseConn();
		
		insertar = ("call insertar_provee(?)");
		pstmt = Conexion.getInstancia().getConn().prepareStatement(insertar);
		pstmt.setString(1, rep.getProveedor().getCuit());
		pstmt.executeUpdate();
		pstmt.close();
		Conexion.getInstancia().releaseConn();
	}

	public void modificarRepuesto(Repuesto rep) throws Exception {
		PreparedStatement pstmt = null;
		String sql = ("UPDATE repuestos SET descripcion=?,cod_repuesto=?,precio=?,stock=? WHERE cod_repuesto=?");
		pstmt = Conexion.getInstancia().getConn().prepareStatement(sql);
		pstmt.setString(1, rep.getDescripcion());
		pstmt.setInt(2, rep.getCodigo());
		pstmt.setFloat(3, rep.getPrecio());
		pstmt.setInt(4, rep.getStock());
		pstmt.setInt(5, rep.getCodigo());
		pstmt.executeUpdate();
		pstmt.close();
		Conexion.getInstancia().releaseConn();
	}

	public void eliminarRepuesto(int cod_repuesto) throws Exception {
		PreparedStatement pstmt = null;
		String sql = ("UPDATE repuestos SET activo = 'no' WHERE cod_repuesto = ?");
		pstmt = Conexion.getInstancia().getConn().prepareStatement(sql);
		pstmt.setInt(1, cod_repuesto);
		pstmt.executeUpdate();
		pstmt.close();
		Conexion.getInstancia().releaseConn();
	}
}
