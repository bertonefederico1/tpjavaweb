package datos;

import java.sql.*;
import java.util.ArrayList;

import entidades.Proveedor;

public class DatosProveedor {
	
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

	
	public ArrayList<Proveedor> traerProveedores() {
		ArrayList<Proveedor> misProveedores= new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
	 	try {
			stmt= Conexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT * FROM proveedores WHERE activo = 'si' ORDER BY razon_social");
			if (rs!=null){
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
	
	public void agregarProveedor(Proveedor prove){
		PreparedStatement pstmt = null;
		String insertar = ("insert into proveedores(cuit,razon_social,direccion,mail,telefono) values(?,?,?,?,?)");
		try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(insertar);
			pstmt.setString(1, prove.getCuit());
			pstmt.setString(2, prove.getRazonSocial());
			pstmt.setString(3, prove.getDireccion());
			pstmt.setString(4, prove.getMail());
			pstmt.setString(5, prove.getTelefono());
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
	
	public void modificarProveedor(Proveedor prove){
		PreparedStatement pstmt = null;
		String sql= ("UPDATE proveedores SET razon_social=?,direccion=?,telefono=?,mail=? WHERE cuit = ?");
		try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(sql);
			pstmt.setString(1, prove.getRazonSocial());
			pstmt.setString(2, prove.getDireccion());
			pstmt.setString(3, prove.getTelefono());
			pstmt.setString(4, prove.getMail());
			pstmt.setString(5, prove.getCuit());
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
	
	public void eliminarProveedor (String cuit){
		PreparedStatement pstmt = null;
		String sql= ("UPDATE proveedores SET activo= 'no' WHERE cuit = ?");
		try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(sql);
			pstmt.setString(1, cuit);
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
