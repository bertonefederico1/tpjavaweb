package datos;

import java.sql.*;
import java.util.ArrayList;

import entidades.*;

public class DatosCliente {
	
	public ArrayList<Cliente> traerClientes(String nombuscar) throws Exception {

		ArrayList<Cliente> misClientes = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM clientes WHERE nombre_y_apellido LIKE ? AND activo = 'si' ORDER BY nombre_y_apellido";
		if (nombuscar != null) {
			pstmt = Conexion.getInstancia().getConn().prepareStatement(query);
			pstmt.setString(1, "%" + nombuscar + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setNombre_y_apellido(rs.getString("nombre_y_apellido"));
				c.setDireccion(rs.getString("direccion"));
				c.setDni(rs.getString("dni"));
				c.setTelefono(rs.getString("telefono"));
				c.setMail(rs.getString("mail"));
				misClientes.add(c);
			}
			rs.close();
			pstmt.close();
			Conexion.getInstancia().releaseConn();
		}
		return misClientes;
	}

	public ArrayList<Cliente> traerClientes() throws Exception {

		ArrayList<Cliente> misClientes = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		stmt = Conexion.getInstancia().getConn().createStatement();
		rs = stmt.executeQuery("SELECT * FROM clientes WHERE activo = 'si' ORDER BY nombre_y_apellido");
		if (rs != null) {
			while (rs.next()) {
				Cliente cli = new Cliente();
				cli.setDni(rs.getString("dni"));
				cli.setNombre_y_apellido(rs.getString("nombre_y_apellido"));
				cli.setDireccion(rs.getString("direccion"));
				cli.setMail(rs.getString("mail"));
				cli.setTelefono(rs.getString("telefono"));
				misClientes.add(cli);
			}
		}
		rs.close();
		stmt.close();
		Conexion.getInstancia().releaseConn();
		return misClientes;
	}

	public void agregarCliente(Cliente cli) throws Exception {
		PreparedStatement pstmt = null;
		String insertar = ("insert into clientes(dni,nombre_y_apellido,direccion,mail,telefono,activo) values(?,?,?,?,?,?)");
		pstmt = Conexion.getInstancia().getConn().prepareStatement(insertar);
		pstmt.setInt(1, Integer.parseInt(cli.getDni()));
		pstmt.setString(2, cli.getNombre_y_apellido());
		pstmt.setString(3, cli.getDireccion());
		pstmt.setString(4, cli.getMail());
		pstmt.setString(5, cli.getTelefono());
		pstmt.setString(6, "si");
		pstmt.executeUpdate();
		pstmt.close();
		Conexion.getInstancia().releaseConn();
	}

	public void modificarCliente(Cliente cli) throws Exception {
		PreparedStatement pstmt = null;
		String sql = ("UPDATE clientes SET nombre_y_apellido=?,dni=?,direccion=?,telefono=?,mail=? WHERE dni=?");
		pstmt = Conexion.getInstancia().getConn().prepareStatement(sql);
		pstmt.setString(1, cli.getNombre_y_apellido());
		pstmt.setInt(2, Integer.parseInt(cli.getDni()));
		pstmt.setString(3, cli.getDireccion());
		pstmt.setString(4, cli.getTelefono());
		pstmt.setString(5, cli.getMail());
		pstmt.setInt(6, Integer.parseInt(cli.getDni()));
		pstmt.executeUpdate();
		pstmt.close();
		Conexion.getInstancia().releaseConn();
	}

	public void eliminarCliente(int dni) throws Exception {
		PreparedStatement pstmt = null;
		String sql = ("UPDATE clientes c SET activo = 'no' WHERE c.dni = ?");
		pstmt = Conexion.getInstancia().getConn().prepareStatement(sql);
		pstmt.setInt(1, dni);
		pstmt.executeUpdate();
		pstmt.close();
		Conexion.getInstancia().releaseConn();
		
		sql = ("UPDATE clientes c " 
				+ "INNER JOIN autos a "
					+ "ON c.dni = a.dni " 
				+ "SET a.activo = 'no' "
				+ "WHERE c.dni = ?");
		pstmt = Conexion.getInstancia().getConn().prepareStatement(sql);
		pstmt.setInt(1, dni);
		pstmt.executeUpdate();
		pstmt.close();
		Conexion.getInstancia().releaseConn();
		DatosTurno dt = new DatosTurno();
		dt.eliminarTurno(dni);
	}

	public ArrayList<Cliente> clientesConReparacionesFinalizadasParaEnviarEmail()
			throws Exception {
		String query = ("SELECT * FROM clientes cli "
						+ "INNER JOIN autos a "
							+ "ON cli.dni = a.dni "
						+ "INNER JOIN reparaciones repa "
							+ "ON a.patente = repa.patente "
						+ "WHERE repa.activa = 'si' AND repa.estado = 'Finalizada' AND a.activo = 'si' AND cli.activo = 'si' AND cli.mail is not null");
		ArrayList<Cliente> destinatarios = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		stmt = Conexion.getInstancia().getConn().createStatement();
		rs = stmt.executeQuery(query);
		if (rs != null) {
			while (rs.next()) {
				Cliente cli = new Cliente();
				cli.setMail(rs.getString("mail"));
				destinatarios.add(cli);
			}
		}
		rs.close();
		stmt.close();
		Conexion.getInstancia().releaseConn();
		return destinatarios;
	}
	
}
