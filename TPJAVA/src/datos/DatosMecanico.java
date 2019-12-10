package datos;

import java.sql.*;

import entidades.*;

import java.util.ArrayList;

public class DatosMecanico {
	
	public ArrayList<Mecanico> traerMecanicos(String buscamecanico) {

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String query = "SELECT matricula, nombre_y_apellido, direccion, telefono, mail FROM mecanicos WHERE (matricula = ? "
				       + "OR nombre_y_apellido LIKE ?) AND activo = 'si' ORDER BY nombre_y_apellido";
		ArrayList<Mecanico> misMecanicos = new ArrayList<>();
		if (buscamecanico != null) {
			try {
				pstmt = Conexion.getInstancia().getConn().prepareStatement(query);
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
	
	public ArrayList<Mecanico> traerMecanicos() {
		
		ArrayList<Mecanico> misMecanicos = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = Conexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT matricula, nombre_y_apellido, direccion, telefono, mail "
									+ "FROM mecanicos WHERE activo = 'si' ORDER BY nombre_y_apellido");
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
	
	public void modificarMecanico(Mecanico mec){
	PreparedStatement pstmt = null;
	String sql = ("UPDATE mecanicos SET nombre_y_apellido=?,matricula=?,direccion=?,telefono=?,mail=? WHERE matricula=?");
	try {
		pstmt = Conexion.getInstancia().getConn().prepareStatement(sql);
		pstmt.setString(1, mec.getNombre_y_apellido());
		pstmt.setInt(2, mec.getMatricula());
		pstmt.setString(3, mec.getDireccion());
		pstmt.setString(4, mec.getTelefono());
		pstmt.setString(5, mec.getMail());
		pstmt.setInt(6, mec.getMatricula());
		pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			pstmt.close();
			Conexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	}
	
	
	public void agregarMecanico (Mecanico mec){
		PreparedStatement pstmt = null;
		String insertarMecanico = ("insert into mecanicos(nombre_y_apellido, direccion, telefono, mail) values(?,?,?,?)");
		try {
			pstmt = Conexion.getInstancia().getConn().prepareStatement(insertarMecanico);
			pstmt.setString(1, mec.getNombre_y_apellido());
			pstmt.setString(2, mec.getDireccion());
			pstmt.setString(3, mec.getTelefono());
			pstmt.setString(4, mec.getMail());
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
	
	public void eliminarMecanico(int matricula){
		PreparedStatement pstmt = null;
		String sql= ("UPDATE mecanicos SET activo= 'no' WHERE matricula = ?");
		try {
			pstmt= Conexion.getInstancia().getConn().prepareStatement(sql);
			pstmt.setInt(1, matricula);
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
}
