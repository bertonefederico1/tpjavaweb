package datos;

import java.sql.*;
import java.util.ArrayList;

import entidades.*;

public class DatosPersona {
	
	public ArrayList<Cliente> traerClientes() {
		
	ArrayList<Cliente> misClientes= new ArrayList<>();
	Statement stmt = null;
	ResultSet rs = null;
 	try {
		stmt= Conexion.getInstancia().getConn().createStatement();
		rs = stmt.executeQuery("SELECT * FROM clientes");
		if (rs!=null){
			while (rs.next()) {
				Cliente cli = new Cliente();
				cli.setDni(rs.getString("dni"));
				cli.setNombre(rs.getString("nombre"));
				cli.setApellido(rs.getString("apellido"));
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
}
