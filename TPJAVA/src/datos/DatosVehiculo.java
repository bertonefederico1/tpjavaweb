package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Auto;

public class DatosVehiculo {
	
	public ArrayList<Auto> traerAutos() {
		
		ArrayList<Auto> misAutos = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = Conexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT * FROM autos");
			if (rs!=null)
			{
				while (rs.next())
				{
					Auto auto = new Auto();
					auto.setPatente(rs.getString("patente"));
					auto.setMarca(rs.getString("marca"));
					auto.setModelo(rs.getString("modelo"));
					auto.setAnio(rs.getInt("anio_fabricacion"));
					auto.setCantKM(rs.getFloat("cant_km"));
					misAutos.add(auto);
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
		return misAutos;
		
	}

}

