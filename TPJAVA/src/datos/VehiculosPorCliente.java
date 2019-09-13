package datos;

import java.sql.*;
import java.util.ArrayList;

import entidades.*;

public class VehiculosPorCliente {

	public ArrayList<Auto> vehiculosDelCliente(String dni) {
		ArrayList<Auto> misVehiculos = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="SELECT patente, marca, modelo, anio_fabricacion FROM autos WHERE dni = ?";
		try {
			pstmt = Conexion.getInstancia().getConn().prepareStatement(sql);
			pstmt.setString(1, dni);
			rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Auto auto = new Auto();
					auto.setPatente(rs.getString("patente"));
					auto.setMarca(rs.getString("marca"));
					auto.setModelo(rs.getString("modelo"));
					auto.setAnio(rs.getInt("anio_fabricacion"));
					misVehiculos.add(auto);
				}
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return misVehiculos;
	}
}
