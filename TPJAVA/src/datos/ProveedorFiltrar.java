package datos;

import java.util.ArrayList;
import java.sql.*;
import entidades.Proveedor;

public class ProveedorFiltrar {
	
	public ArrayList <Proveedor> traerProveedores (String razonSocialBuscar) {
		
		ArrayList<Proveedor> misProveedores = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String query = "SELECT * FROM proveedores WHERE razon_social LIKE ? AND activo = 'si' ORDER BY razon_social";
		if (razonSocialBuscar != null) {
			try {
				pstmt= Conexion.getInstancia().getConn().prepareStatement(query);
				pstmt.setString(1, "%"+razonSocialBuscar+"%");
				rs= pstmt.executeQuery();
				while (rs.next()) {
					Proveedor p = new Proveedor();
					p.setCuit(rs.getString("cuit"));
					p.setRazonSocial(rs.getString("razon_social"));
					p.setDireccion(rs.getString("direccion"));
					p.setTelefono(rs.getString("telefono"));
					p.setMail(rs.getString("mail"));
					misProveedores.add(p);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
		         	rs.close();
					pstmt.close();
					Conexion.getInstancia().releaseConn();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		 }

		return misProveedores;
	}

}
