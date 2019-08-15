package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Proveedor;

public class DatosProveedor {
	
	public ArrayList<Proveedor> traerProveedores() {
		
		ArrayList<Proveedor> misProveedores= new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
	 	try {
			stmt= Conexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT * FROM proveedores order by razon_social");
			if (rs!=null){
				while (rs.next()) {
					Proveedor prov = new Proveedor();
					prov.setCuit(rs.getString("cuit"));
					prov.setRazonSocial(rs.getString("razon_social"));
					prov.setMail(rs.getString("mail"));
					prov.setTelefono(rs.getString("telefono"));
					misProveedores.add(prov);
				}
		 	}
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
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
	 	return misProveedores;
		}

}
