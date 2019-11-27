package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Auto;
import entidades.Cliente;

public class VehiculosFiltrar {
	
	public ArrayList<Auto> traerVehiculosFiltrados(String nombuscar){
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM autos a INNER JOIN clientes c ON a.dni = c.dni WHERE c.nombre_y_apellido LIKE ? AND activo = 'si' ORDER BY c.dni";
		ArrayList<Auto> misAutos = new ArrayList<>();
		if (nombuscar != null) {
			try {
				pstmt = Conexion.getInstancia().getConn().prepareStatement(query);
				pstmt.setString(1, "%" + nombuscar + "%");
				rs = pstmt.executeQuery();
				while (rs.next())
				{
					Auto auto = new Auto();
					Cliente cli = new Cliente();
					cli.setDni(rs.getString("dni"));
					cli.setNombre_y_apellido(rs.getString("nombre_y_apellido"));
					auto.setPatente(rs.getString("patente"));
					auto.setMarca(rs.getString("marca"));
					auto.setModelo(rs.getString("modelo"));
					auto.setAnio(rs.getInt("anio_fabricacion"));
					auto.setCli(cli);
					misAutos.add(auto);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					pstmt.close();
					Conexion.getInstancia().releaseConn();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return misAutos;
		
	}
}
