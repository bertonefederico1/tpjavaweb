package datos;

import java.sql.*;
import java.util.ArrayList;

import entidades.Mecanico;

public class MecanicoFiltrar {

	public ArrayList<Mecanico> traerMecanicos(String buscamecanico) {

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String query = "SELECT matricula, nombre_y_apellido, direccion, telefono, mail FROM mecanicos WHERE matricula = ? or nombre_y_apellido like ? order by nombre_y_apellido";
		ArrayList<Mecanico> misMecanicos = new ArrayList<>();
		if (buscamecanico != null) {
			try {
				pstmt = Conexion.getInstancia().getConn()
						.prepareStatement(query);
				pstmt.setString(1, buscamecanico);
				pstmt.setString(2, "%" + buscamecanico + "%");
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Mecanico m = new Mecanico();
					m.setNombre_y_apellido(rs.getString("nombre_y_apellido"));
					m.setDireccion(rs.getString("direccion"));
					m.setMatricula(rs.getInt("matricula"));
					m.setTelefono(rs.getString("telefono"));
					m.setMail(rs.getString("mail"));
					misMecanicos.add(m);
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
		return misMecanicos;
	}

}
