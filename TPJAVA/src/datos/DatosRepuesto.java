package datos;

import java.sql.*;
import java.util.ArrayList;

import entidades.Repuesto;

public class DatosRepuesto {
	
	public ArrayList<Repuesto> traerRepuestos() {
		
		ArrayList<Repuesto> misRepuestos = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = Conexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT * FROM repuestos order by descripcion");
			if (rs!=null)
			{
				while (rs.next())
				{
					Repuesto rep = new Repuesto();
					rep.setCodigo(rs.getInt("cod_repuesto"));
					rep.setDescripcion(rs.getString("descripcion"));
					rep.setPrecio(rs.getFloat("precio"));
					rep.setStock(rs.getInt("stock"));
					misRepuestos.add(rep);
				}
			}
			
		} catch (SQLException e){
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
		return misRepuestos;
		
	}

}
