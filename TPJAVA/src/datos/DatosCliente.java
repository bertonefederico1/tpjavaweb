package datos;

import java.sql.*;
import java.util.ArrayList;

import entidades.*;

public class DatosCliente {
	
	public ArrayList <Cliente> traerClientes(String nombuscar){
		
		ArrayList <Cliente> misClientes= new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String query = "SELECT * FROM clientes WHERE nombre_y_apellido LIKE ? AND activo = 'si' ORDER BY nombre_y_apellido";
		if (nombuscar != null){
			try {
				pstmt= Conexion.getInstancia().getConn().prepareStatement(query);
				pstmt.setString(1, "%"+nombuscar+"%");
				rs= pstmt.executeQuery();
				while(rs.next()){
					Cliente c= new Cliente();
					c.setNombre_y_apellido(rs.getString("nombre_y_apellido"));
					c.setDireccion(rs.getString("direccion"));
					c.setDni(rs.getString("dni"));
					c.setTelefono(rs.getString("telefono"));
					c.setMail(rs.getString("mail"));
					misClientes.add(c);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				try {
					rs.close();
					pstmt.close();
					Conexion.getInstancia().releaseConn();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return misClientes;
		}
	
	public ArrayList<Cliente> traerClientes() {
		
	ArrayList<Cliente> misClientes= new ArrayList<>();
	Statement stmt = null;
	ResultSet rs = null;
 	try {
		stmt= Conexion.getInstancia().getConn().createStatement();
		rs = stmt.executeQuery("SELECT * FROM clientes WHERE activo = 'si' ORDER BY nombre_y_apellido");
		if (rs!=null){
			while (rs.next()) {
				Cliente cli = new Cliente();
				cli.setDni(rs.getString("dni"));
				cli.setNombre_y_apellido(rs.getString("nombre_y_apellido"));
				cli.setDireccion(rs.getString("direccion"));
				cli.setMail(rs.getString("mail"));
				cli.setTelefono(rs.getString("telefono"));
				misClientes.add(cli);
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
 	return misClientes;
	}
	
	
	
	public void agregarCliente(Cliente cli) {
		PreparedStatement pstmt = null;
		String insertar = ("insert into clientes(dni,nombre_y_apellido,direccion,mail,telefono) values(?,?,?,?,?)");
		try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(insertar);
			pstmt.setInt(1, Integer.parseInt(cli.getDni()));
			pstmt.setString(2, cli.getNombre_y_apellido());
			pstmt.setString(3, cli.getDireccion());
			pstmt.setString(4, cli.getMail());
			pstmt.setString(5, cli.getTelefono());
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
	
	public void modificarCliente (Cliente cli){
		PreparedStatement pstmt = null;
		String sql= ("UPDATE clientes SET nombre_y_apellido=?,dni=?,direccion=?,telefono=?,mail=? WHERE dni=?");
		try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(sql);
			pstmt.setString(1, cli.getNombre_y_apellido());
			pstmt.setInt(2, Integer.parseInt(cli.getDni()));
			pstmt.setString(3, cli.getDireccion());
			pstmt.setString(4, cli.getTelefono());
			pstmt.setString(5, cli.getMail());
			pstmt.setInt(6, Integer.parseInt(cli.getDni()));
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
	
	public void eliminarCliente (int dni){
		PreparedStatement pstmt = null;
		String sql= ("UPDATE clientes c SET activo= 'no' WHERE c.dni = ?");
		try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(sql);
			pstmt.setInt(1, dni);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		sql= ("UPDATE clientes c "
			   + "INNER JOIN autos a "
			   + "ON c.dni = a.dni "
			   + "SET a.activo = 'no' "
			   + "WHERE c.dni = ?");
		try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(sql);
			pstmt.setInt(1, dni);
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
