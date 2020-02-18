package datos;

import java.sql.*;

public class Conexion {

	private static Conexion instancia;

	private String driver = "com.mysql.jdbc.Driver";
	//private String host = "node41809-tpjava2019.jelastic.saveincloud.net";
	private String host = "node43529-tpjava2019.jelastic.saveincloud.net";
	private String port = "3306";
	private String user = "tpjava";
	//private String password = "123456";
	private String password = "juanbjusto1750";
	private String db = "tpjava";
	private int conectados = 0;
	private Connection conn = null;

	private Conexion() throws Exception {
		Class.forName(driver);
	}

	public static Conexion getInstancia() throws Exception {
		if (instancia == null) {
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getConn() throws Exception {
		if (conn == null || conn.isClosed()) {
			conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db, user, password);
			conectados = 0;
		}
		conectados++;
		return conn;
	}

	public void releaseConn() throws Exception {
		conectados--;
		if (conectados <= 0) {
			conn.close();
		}

	}

}
