package curso.g9900.BBDD0;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class OracleJDBCTest {
	private static Connection conn;

	private static OracleJDBC ojdbc;

	public final static String CLAVE_1 = "@2";
	public final static String TEXTO_1 = "Esto es el texto para el pais";
	public final static String REGION_1 = "1";
	public static String INSERT_1;
	public final static String SELECT_G = "SELECT * FROM COUNTRIES WHERE ";
	public final static String SELECT_COUNT = "SELECT count(*) as contador FROM COUNTRIES WHERE ";
	public final static String SELECT_1 = "SELECT * FROM COUNTRIES ";

	@BeforeAll
	public static void inicio() throws Exception, SQLException {
		ojdbc = OracleJDBC.getInstance();

		INSERT_1 = "INSERT INTO COUNTRIES VALUES('" + CLAVE_1 + "','" + TEXTO_1 + "'," + REGION_1 + ")";

		int filas = ojdbc.ejecutar("DELETE COUNTRIES WHERE COUNTRY_ID LIKE '@_' ");
	}

	@AfterAll
	public static void fin() throws Exception {
		// int filas = ojdbc.ejecutar("DELETE COUNTRIES WHERE COUNTRY_ID LIKE '@_' ");
		ojdbc.closeConnection();
	}

	@Test
	public void testInsertar() throws SQLException, Exception {

		int filas = ojdbc.ejecutar(INSERT_1);
		System.out.println("Registros afectados:" + filas);
		assertEquals(1, filas);

		ResultSet rs = ojdbc.ejecutarQuery(SELECT_COUNT + "COUNTRY_ID = '" + CLAVE_1 + "'");
		rs.next();
		int conta = rs.getInt("contador");
		assertEquals(1, conta);

		rs = ojdbc.ejecutarQuery(SELECT_G + "COUNTRY_ID = '" + CLAVE_1 + "'");
		rs.next();

	}

	@Test
	public void listado() throws SQLException, Exception {
		ResultSet rs = ojdbc.ejecutarQuery(SELECT_1);
		int count=0;
		while (rs.next()) {
			count++;
			System.out.print(rs.getString("COUNTRY_ID") + "\t");
			System.out
					.print((rs.getString("COUNTRY_NAME") + "                                        ").substring(0, 30)
							+ "\t");
			System.out.println(rs.getInt("REGION_ID"));

		}
		assertTrue(count>0);
	}
	/*
	 * @Test public void testCommit() throws Exception, SQLException { Statement stm
	 * = conn.createStatement(); stm.executeUpdate("Update EMP set JOB = JOB");
	 * OracleJDBC.commit(); }
	 * 
	 * @Test public void testRollback() throws SQLException, Exception { Statement
	 * stm = conn.createStatement();
	 * stm.executeUpdate("Update EMP set sal = sal + 10000 ");
	 * OracleJDBC.rollback(); }
	 * 
	 * @Test public void testCloseStatement() throws SQLException, Exception {
	 * Statement stm = conn.createStatement(); OracleJDBC.closeStatement(stm);
	 * assertTrue("Cerrar statment",stm.isClosed()); }
	 * 
	 * @Test public void testCloseResulSet() throws SQLException, Exception {
	 * Statement stm = conn.createStatement(); ResultSet rs =
	 * stm.executeQuery("SELECT * FROM EMP"); OracleJDBC.closeResulSet(rs);
	 * 
	 * }
	 */
}
