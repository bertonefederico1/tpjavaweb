package datos;

import java.sql.*;
import java.util.ArrayList;

import entidades.LineaDeRepuesto;
import entidades.Repuesto;

public class DatosLineaDeRepuesto {
	
	public LineaDeRepuesto agregarLinea(int cantidad, int cod_repuesto){
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
	 	return linea;
	}
	
	
	public ArrayList<LineaDeRepuesto> inicializarLineas(){
		ArrayList<LineaDeRepuesto> misLineas = new ArrayList<LineaDeRepuesto>();
		return misLineas;
	}
}
