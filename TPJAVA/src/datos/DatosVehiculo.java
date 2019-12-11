package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.*;

public class DatosVehiculo {

	public ArrayList<Auto> traerVehiculosFiltrados(String nombuscar) throws Exception {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String query = "SELECT * "
				+ "FROM autos a "
				+ "INNER JOIN clientes c "
					+ "ON a.dni = c.dni "
				+ "WHERE a.activo = 'si' AND (c.nombre_y_apellido LIKE ? OR a.patente LIKE ?) "
				+ "ORDER BY c.dni";
		ArrayList<Auto> misAutos = new ArrayList<>();
		if (nombuscar != null) {
			pstmt = Conexion.getInstancia().getConn().prepareStatement(query);
			pstmt.setString(1, "%" + nombuscar + "%");
			pstmt.setString(2, "%" + nombuscar + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
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
			rs.close();
			pstmt.close();
			Conexion.getInstancia().releaseConn();
		}
		return misAutos;

	}

	public void modificarVehiculo(Auto auto, String patente_original) throws Exception {
		PreparedStatement pstmt = null;
		String sql = ("UPDATE autos SET patente = ?, marca = ?, modelo = ?, anio_fabricacion = ?, cantidad_km = ? WHERE patente = ?");
		pstmt = Conexion.getInstancia().getConn().prepareStatement(sql);
		pstmt.setString(1, auto.getPatente());
		pstmt.setString(2, auto.getMarca());
		pstmt.setString(3, auto.getModelo());
		pstmt.setInt(4, auto.getAnio());
		pstmt.setInt(5, auto.getCantKM());
		pstmt.setString(6, patente_original);
		pstmt.executeUpdate();

		pstmt.close();
		Conexion.getInstancia().releaseConn();
	}

	public void eliminarVehiculo(String patente) throws Exception {
		PreparedStatement pstmt = null;
		String sql = ("UPDATE autos a SET activo= ? WHERE a.patente = ?");
		pstmt = Conexion.getInstancia().getConn().prepareStatement(sql);
		pstmt.setString(1, "no");
		pstmt.setString(2, patente);
		pstmt.executeUpdate();

		pstmt.close();
		Conexion.getInstancia().releaseConn();
	}

	public ArrayList<Auto> vehiculosYClientes() throws Exception {
		ArrayList<Auto> misAutos = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		stmt = Conexion.getInstancia().getConn().createStatement();
		rs = stmt.executeQuery("SELECT * FROM autos a INNER JOIN clientes c ON a.dni = c.dni AND a.activo = 'si' ORDER BY c.dni");
		if (rs != null) {
			while (rs.next()) {
				Auto auto = new Auto();
				Cliente cli = new Cliente();
				cli.setDni(rs.getString("dni"));
				cli.setNombre_y_apellido(rs.getString("nombre_y_apellido"));
				auto.setPatente(rs.getString("patente"));
				auto.setMarca(rs.getString("marca"));
				auto.setModelo(rs.getString("modelo"));
				auto.setAnio(rs.getInt("anio_fabricacion"));
				auto.setCantKM(rs.getInt("cantidad_km"));
				auto.setCli(cli);
				misAutos.add(auto);
			}
		}
		rs.close();
		stmt.close();
		Conexion.getInstancia().releaseConn();
		return misAutos;
	}

	public ArrayList<Auto> vehiculosDelCliente(String dni) throws Exception {
		ArrayList<Auto> misVehiculos = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT patente, marca, modelo, anio_fabricacion FROM autos WHERE dni = ? AND activo = 'si'";
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
		rs.close();
		pstmt.close();
		Conexion.getInstancia().releaseConn();
		return misVehiculos;
	}

	public void agregarVehiculo(Auto auto) throws Exception {
		PreparedStatement pstmt = null;
		String insertarAuto = ("insert into autos(patente, marca, modelo, anio_fabricacion, cantidad_km, dni, activo) values(?,?,?,?,?,?,?)");
		pstmt = Conexion.getInstancia().getConn().prepareStatement(insertarAuto);
		pstmt.setString(1, auto.getPatente());
		pstmt.setString(2, auto.getMarca());
		pstmt.setString(3, auto.getModelo());
		pstmt.setInt(4, auto.getAnio());
		pstmt.setInt(5, auto.getCantKM());
		pstmt.setString(6, auto.getCli().getDni());
		pstmt.setString(7, "si");
		pstmt.executeUpdate();

		pstmt.close();
		Conexion.getInstancia().releaseConn();
	}

	public ArrayList<Auto> traerAutos() throws Exception {
		ArrayList<Auto> misAutos = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		stmt = Conexion.getInstancia().getConn().createStatement();
		rs = stmt.executeQuery("SELECT * FROM autos");
		if (rs != null) {
			while (rs.next()) {
				Auto auto = new Auto();
				auto.setPatente(rs.getString("patente"));
				auto.setMarca(rs.getString("marca"));
				auto.setModelo(rs.getString("modelo"));
				auto.setAnio(rs.getInt("anio_fabricacion"));
				auto.setCantKM(rs.getInt("cantidad_km"));
				misAutos.add(auto);
			}
		}
		rs.close();
		stmt.close();
		Conexion.getInstancia().releaseConn();
		return misAutos;
	}

}
