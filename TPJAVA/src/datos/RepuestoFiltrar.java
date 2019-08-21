package datos;

import java.util.ArrayList;
import java.sql.*;

import entidades.Repuesto;

public class RepuestoFiltrar {

	public ArrayList<Repuesto> traerRepuestos(String desc_buscar) {

		ArrayList<Repuesto> misRepuestos = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM repuestos WHERE descripcion LIKE ? order by descripcion";
		if (desc_buscar != null) {
			try {
				pstmt = Conexion.getInstancia().getConn()
						.prepareStatement(query);
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					pstmt.close();
					Conexion.getInstancia().releaseConn();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return misRepuestos;
	}

}
