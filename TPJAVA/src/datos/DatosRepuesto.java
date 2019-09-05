package datos;

import java.sql.*;
import java.util.ArrayList;

import entidades.Repuesto;

public class DatosRepuesto {
	
	public ArrayList<Repuesto> traerRepuestos() {
		
		ArrayList<Repuesto> misRepuestos = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = Conexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT * FROM repuestos order by descripcion");
			if (rs!=null)
			{
				while (rs.next())
				{
					Repuesto rep = new Repuesto();
					rep.setCodigo(rs.getInt("cod_repuesto"));
					rep.setDescripcion(rs.getString("descripcion"));
					rep.setPrecio(rs.getFloat("precio"));
					rep.setStock(rs.getInt("stock"));
					misRepuestos.add(rep);
				}
			}
			
		} catch (SQLException e){
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
		return misRepuestos;
	}

	
	public void agregarRepuesto (Repuesto rep){
		PreparedStatement pstmt = null;	
		String insertar = ("insert into repuestos(descripcion,precio,stock) values(?,?,?)");
		try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(insertar);
			pstmt.setString(1, rep.getDescripcion());
			pstmt.setFloat(2, rep.getPrecio());
			pstmt.setInt(3, rep.getStock());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				Conexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void modificarRepuesto(Repuesto rep){
		PreparedStatement pstmt = null;
		String sql= ("UPDATE repuestos SET descripcion=?,cod_repuesto=?,precio=?,stock=? WHERE cod_repuesto=?");
		try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(sql);
			pstmt.setString(1, rep.getDescripcion());
			pstmt.setInt(2, rep.getCodigo());
			pstmt.setFloat(3, rep.getPrecio());
			pstmt.setInt(4, rep.getStock());
			pstmt.setInt(5, rep.getCodigo());
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
	
	public void eliminarRepuesto(int cod_repuesto){
		PreparedStatement pstmt = null;
		String sql = ("DELETE FROM repuestos WHERE cod_repuesto= ?");
		try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(sql);
			pstmt.setInt(1, cod_repuesto);
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
}
