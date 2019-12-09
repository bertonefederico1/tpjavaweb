package datos;

import java.sql.*;
import java.util.ArrayList;

import entidades.Cliente;

public class ClienteFiltrar {
	
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
}
