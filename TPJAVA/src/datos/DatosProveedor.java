package datos;

import java.sql.*;
import java.util.ArrayList;

import entidades.Proveedor;

public class DatosProveedor {

	public ArrayList <Proveedor> traerProveedores (String razonSocialBuscar) throws Exception {
		ArrayList<Proveedor> misProveedores = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String query = "SELECT * FROM proveedores WHERE razon_social LIKE ? AND activo = 'si' ORDER BY razon_social";
		if (razonSocialBuscar != null) {
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
			rs.close();
			pstmt.close();
			Conexion.getInstancia().releaseConn();
		}
		return misProveedores;
	}

	public ArrayList<Proveedor> traerProveedores() throws Exception {
		ArrayList<Proveedor> misProveedores = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		stmt = Conexion.getInstancia().getConn().createStatement();
		rs = stmt.executeQuery("SELECT * FROM proveedores WHERE activo = 'si' ORDER BY razon_social");
		if (rs != null) {
			while (rs.next()) {
				Proveedor prov = new Proveedor();
				prov.setCuit(rs.getString("cuit"));
				prov.setDireccion(rs.getString("direccion"));
				prov.setRazonSocial(rs.getString("razon_social"));
				prov.setMail(rs.getString("mail"));
				prov.setTelefono(rs.getString("telefono"));
				misProveedores.add(prov);
			}
		}
		rs.close();
		stmt.close();
		Conexion.getInstancia().releaseConn();
		return misProveedores;
	}

	public void agregarProveedor(Proveedor prove) throws Exception {
		PreparedStatement pstmt = null;
		String insertar = ("INSERT INTO proveedores (cuit,razon_social,direccion,mail,telefono) VALUES (?,?,?,?,?)");
		pstmt = Conexion.getInstancia().getConn().prepareStatement(insertar);
		pstmt.setString(1, prove.getCuit());
		pstmt.setString(2, prove.getRazonSocial());
		pstmt.setString(3, prove.getDireccion());
		pstmt.setString(4, prove.getMail());
		pstmt.setString(5, prove.getTelefono());
		pstmt.executeUpdate();
		pstmt.close();
		Conexion.getInstancia().releaseConn();
	}

	public void modificarProveedor(Proveedor prove) throws Exception {
		PreparedStatement pstmt = null;
		String sql = ("UPDATE proveedores SET razon_social=?,direccion=?,telefono=?,mail=? WHERE cuit = ?");
		pstmt = Conexion.getInstancia().getConn().prepareStatement(sql);
		pstmt.setString(1, prove.getRazonSocial());
		pstmt.setString(2, prove.getDireccion());
		pstmt.setString(3, prove.getTelefono());
		pstmt.setString(4, prove.getMail());
		pstmt.setString(5, prove.getCuit());
		pstmt.executeUpdate();
		pstmt.close();
		Conexion.getInstancia().releaseConn();
	}

	public void eliminarProveedor(String cuit) throws Exception {
		PreparedStatement pstmt = null;
		String sql = ("UPDATE proveedores SET activo= 'no' WHERE cuit = ?");
		pstmt = Conexion.getInstancia().getConn().prepareStatement(sql);
		pstmt.setString(1, cuit);
		pstmt.executeUpdate();
		pstmt.close();
		Conexion.getInstancia().releaseConn();
	}

}
