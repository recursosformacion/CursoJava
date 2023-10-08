package es.rf.tienda.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import es.rf.tienda.exception.DAOException;


public class Conexion {

	/**
	 * Variable para obtener la conexi�n
	 */
	private static Connection  conn;
	/**
	 * Driver JDBC
	 */
	private final static String JDBC_DRIVER= "oracle.jdbc.driver.OracleDriver";
	
	/**
	 * Direcci�n de la BD
	 */
	private final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	/**
	 * Nombre de la DB
	 */
	private final static String DATABASE = "";
	
	/**
	 * Usuario para acceder a BD
	 */
	private final static String USUARIO="alumno";
	
	/**
	 * Password para acceder a la BD
	 */
	private final static String PASSWORD="curso";
	
	/**
	 * Comando para la creaci�n de una BD
	 * @throws DAOException 
	 */
	//private final static String SQL_CREATE = "CREATE DATABASE ";



	public static void conectar() throws DAOException{
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Error al conectar a la BD");
		}
	}
	
	public static Connection getConnection() throws DAOException {

		try {
			if (conn == null || 
					conn.isClosed()) {
				try {
					Class.forName(JDBC_DRIVER);
					System.out.println("Se ha registrado el Driver correctamente");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

				try {
					conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
					
					//System.out.println("Se ha conectado correctamente a la BD");
				} catch (SQLException e){
					e.printStackTrace();
				}


				if (conn !=null){
					//System.out.println("Conexi�n al servidor lista para ser usada");				
				} else {
					System.out.println("Conexi�n errorena");
					throw new DAOException("No se ha podido conectar con la BD");
				}

			}
		} catch (SQLException e) {
			System.out.println("Conexi�n erronea");
			throw new DAOException("No se ha podido conectar con la BD");
		}
		
		return conn;
	}

	public static void closeConnection() throws DAOException {
		try {
			if (conn!=null && 
					!conn.isClosed()){
				conn.close();				
			}
		} catch (Exception e){
			System.out.println("No se ha podido cerrar la conexi�n a la BD");
			throw new DAOException("Error al cerrar conexi�n a BD");			
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


	public static void rollback(Connection conn0) throws DAOException 
	{
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
			if (rs!=null){
				rs.close();
			}
		} catch (SQLException e) {		
			e.printStackTrace();
			throw new DAOException("No ha sido posible realizar operaci�n close sobre elemento ResultSet");
		}
	}
}
