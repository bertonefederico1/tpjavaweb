package datos;

import java.sql.*;
import java.util.ArrayList;


import entidades.*;

public class DatosCliente {
	
	public ArrayList<Cliente> traerClientes() {
		
	ArrayList<Cliente> misClientes= new ArrayList<>();
	Statement stmt = null;
	ResultSet rs = null;
 	try {
		stmt= Conexion.getInstancia().getConn().createStatement();
		rs = stmt.executeQuery("SELECT * FROM clientes order by nombre_y_apellido");
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
			int resp = pstmt.executeUpdate();
			if (resp>0){
				pstmt.close();
				Conexion.getInstancia().releaseConn();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
