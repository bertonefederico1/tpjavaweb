package datos;

import java.sql.*;
import entidades.*;
import java.util.ArrayList;

public class DatosMecanico {
	
	public ArrayList<Mecanico> traerMecanicos() {
		
		ArrayList<Mecanico> misMecanicos = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = Conexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from mecanicos");
			if (rs != null)
			{
				while (rs.next())
				{
					Mecanico mec = new Mecanico();
					mec.setMatricula(rs.getInt("matricula"));
					mec.setNombre_y_apellido(rs.getString("nombre_y_apellido"));
					mec.setDireccion(rs.getString("direccion"));
					mec.setTelefono(rs.getString("telefono"));
					mec.setMail(rs.getString("mail"));
					misMecanicos.add(mec);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			try {
				rs.close();
				stmt.close();
				Conexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return misMecanicos;
	}

}
