package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.*;

public class DatosVehiculo {
	
	public void modificarVehiculo(Auto auto, String patente_original){
		PreparedStatement pstmt = null;
		String sql= ("UPDATE autos SET patente = ?, marca = ?, modelo = ?, anio_fabricacion = ?, cantidad_km = ? WHERE patente = ?");
		try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(sql);
			pstmt.setString(1, auto.getPatente());
			pstmt.setString(2, auto.getMarca());
			pstmt.setString(3, auto.getModelo());
			pstmt.setInt(4, auto.getAnio());
			pstmt.setFloat(5, auto.getCantKM());
			pstmt.setString(6, patente_original);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				pstmt.close();
				Conexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void eliminarVehiculo(String patente){
		PreparedStatement pstmt = null;
		String sql= ("UPDATE autos a SET activo= ? WHERE a.patente = ?");
		try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(sql);
			pstmt.setString(1, "no");
			pstmt.setString(2, patente);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				pstmt.close();
				Conexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Auto> vehiculosYClientes(){
		ArrayList<Auto> misAutos = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = Conexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT * FROM autos a INNER JOIN clientes c ON a.dni = c.dni AND a.activo = 'si' ORDER BY c.dni");
			if (rs!=null)
			{
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
					auto.setCantKM(rs.getFloat("cantidad_km"));
					auto.setCli(cli);
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
	
	public ArrayList<Auto> vehiculosDelCliente(String dni) {
		ArrayList<Auto> misVehiculos = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="SELECT patente, marca, modelo, anio_fabricacion FROM autos WHERE dni = ? AND activo = 'si'";
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
	
	public void agregarVehiculo(Auto auto){
		PreparedStatement pstmt = null;
		String insertarAuto = ("insert into autos(patente, marca, modelo, anio_fabricacion, cantidad_km, dni, activo) values(?,?,?,?,?,?,?)");
		try {
			pstmt = Conexion.getInstancia().getConn().prepareStatement(insertarAuto);
			pstmt.setString(1, auto.getPatente());
			pstmt.setString(2, auto.getMarca());
			pstmt.setString(3, auto.getModelo());
			pstmt.setInt(4, auto.getAnio());
			pstmt.setFloat(5, auto.getCantKM());
			pstmt.setString(6, auto.getCli().getDni());
			pstmt.setString(7, "si");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				Conexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
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
					auto.setCantKM(rs.getFloat("cantidad_km"));
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

