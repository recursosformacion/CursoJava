package es.rf.tienda.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import es.rf.tienda.exception.DAOException;

public class RFDataConnectionTest {
	private static Connection conn;
	public final static String CLAVE_1 = "@2";
	public final static String TEXTO_1 = "Esto es el texto para el pais";
	public final static String REGION_1 = "1";
	public static String INSERT_1;
	public final static String SELECT_G = "SELECT * FROM COUNTRIES WHERE ";
	public final static String SELECT_1 = "SELECT * FROM COUNTRIES ";

	@BeforeClass
	public static void inicio() throws DAOException, SQLException {
		INSERT_1 = "INSERT INTO COUNTRIES VALUES('" + CLAVE_1 + "','" + TEXTO_1 + "'," + REGION_1 + ")";
		
		int filas = RFDataConnection.ejecutar("DELETE COUNTRIES WHERE COUNTRY_ID LIKE '@_' ");
	}

	@AfterClass
	public static void fin() throws DAOException {
		RFDataConnection.closeConnection();
	}

	@Test
	public void testInsertar() throws SQLException, DAOException {
		int filas = RFDataConnection.ejecutar(INSERT_1);
		System.out.println("Registros afectados:" + filas);
		

		ResultSet rs = RFDataConnection.ejecutarQuery(SELECT_G + "COUNTRY_ID = '" + CLAVE_1 + "'");
		rs.next();

	}

	@Test
	public void listado() throws SQLException, DAOException{
		ResultSet rs = RFDataConnection.ejecutarQuery(SELECT_1);
		while (rs.next()){
			System.out.print(rs.getString("COUNTRY_ID") + "\t");
			System.out.print((rs.getString("COUNTRY_NAME") + "          ").substring(0, 30) + "\t");
			System.out.println(rs.getInt("REGION_ID"));
			
			
		}
	}
	/*
	 * @Test public void testCommit() throws DAOException, SQLException {
	 * Statement stm = conn.createStatement();
	 * stm.executeUpdate("Update EMP set JOB = JOB"); RFDataConnection.commit();
	 * }
	 * 
	 * @Test public void testRollback() throws SQLException, DAOException {
	 * Statement stm = conn.createStatement();
	 * stm.executeUpdate("Update EMP set sal = sal + 10000 ");
	 * RFDataConnection.rollback(); }
	 * 
	 * @Test public void testCloseStatement() throws SQLException, DAOException
	 * { Statement stm = conn.createStatement();
	 * RFDataConnection.closeStatement(stm);
	 * assertTrue("Cerrar statment",stm.isClosed()); }
	 * 
	 * @Test public void testCloseResulSet() throws SQLException, DAOException {
	 * Statement stm = conn.createStatement(); ResultSet rs =
	 * stm.executeQuery("SELECT * FROM EMP");
	 * RFDataConnection.closeResulSet(rs);
	 * 
	 * }
	 */
}
