package es.rf.tienda.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import es.rf.tienda.exception.DAOException;

public class ConexionBASE {

	private static Connection conn;

	private final static String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";

	private final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";

	private final static String USUARIO = "alumno";

	private final static String PASSWORD = "Curso201605";

	public static Connection getConnection() throws DAOException {
		if (conn == null || conn.isClosed()) {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
			if (conn != null) {
				System.out.println("Conexion al servidor lista para ser usada");
			} else {
				System.out.println("Conexion errorena");
				throw new DAOException("No se ha podido conectar con la BD");
			}
		}
		return conn;
	}

	public static void closeConnection() throws DAOException {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (Exception e) {
			System.out.println("No se ha podido cerrar la conexion a la BD");
			throw new DAOException("Error al cerrar conexion a BD");
		} finally {
			conn = null;
		}
	}

	public static void commit(Connection conn0) throws DAOException {
		try {
			if (conn != null) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Error al realizar commit");
		}
	}

	public static void rollback(Connection conn0) throws DAOException {
		try {
			if (conn != null) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Error al realizar rollback");
		}

	}

	public static void closeStatement(PreparedStatement ps) throws DAOException {
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("No ha sido posible realizar operaci�n close sobre elemento Statement");
		}
	}

	public static void closeResulSet(ResultSet rs) throws DAOException {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("No ha sido posible realizar operaci�n close sobre elemento ResultSet");
		}
	}
}
