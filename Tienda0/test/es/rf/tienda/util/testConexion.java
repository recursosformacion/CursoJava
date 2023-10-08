package es.rf.tienda.util;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.rf.tienda.exception.DAOException;

public class testConexion {
	private static Connection conn;
	static Statement stm;
	static final String IDENTIFICADOR1 = "MGG-jsksjsksjsksjsk";
	static final String REGISTRO1 = " -  categoria Uno";
	static final String REGISTRO2 = " -  categoria Dos";
	
	static final String SQL_LIMPIA = "Delete from categoria where cat_nombre LIKE '" + IDENTIFICADOR1 + "%'";
	
	static final String INSERTA1 = "INSERT into categoria VALUES (1,'" + 
									IDENTIFICADOR1
									+ REGISTRO1  
									+ "','Descripcion de la primera categoria')";
	
	static final String INSERTA2 = "INSERT into categoria VALUES (?, ?  "
			+ ",'Descripcion de la  categoria')";
	
	final String SQL_LEER = "SELECT COUNT(*) as contador FROM categoria WHERE cat_nombre LIKE '" + 
												IDENTIFICADOR1 + 
												 "%'";
	
	@BeforeClass
	public static void inicializar() throws DAOException, SQLException {
		conn = Conexion.getConnection();
		stm = conn.createStatement();
		borraTodo();
	}

	@AfterClass
	public static void finalizar() throws SQLException {
		borraTodo();
		conn.close();
	}

	
	@Test
	public void insertar() throws SQLException{
		System.out.println(stm.executeUpdate(INSERTA1));
		conn.commit();
		System.out.println(SQL_LEER);
		ResultSet rs = stm.executeQuery(SQL_LEER);
		rs.next();
		int conta = rs.getInt("contador");
		if (conta != 1) {
			fail ("Fallo insert. Contador = " + conta );
		}
		
	}
	
	@Test
	public void insertar2() throws SQLException{
		System.out.println(stm.executeUpdate(INSERTA1));
		PreparedStatement pst = conn.prepareStatement(INSERTA2);
		pst.setInt(1,2);
		pst.setString(2, IDENTIFICADOR1 + "Categoria 2");
		pst.executeUpdate();
		conn.commit();
		System.out.println(SQL_LEER);
		ResultSet rs = stm.executeQuery(SQL_LEER);
		rs.next();
		int conta = rs.getInt("contador");
		if (conta != 2) {
			fail ("Fallo insert. Contador = " + conta );
		}
		
	}
	
	@Test
	public void inicio() throws DAOException {
		
/*		
		try {
			
			//System.out.println(stm.executeUpdate(inserta1));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
	}

	/*
	 * @Before public void inicio() throws DAOException{ conn =
	 * Conexion.getConnection(); }
	 * 
	 * @Test public void testCommit() throws DAOException, SQLException {
	 * Statement stm = conn.createStatement(); stm.executeUpdate(
	 * "Update EMP set JOB = JOB"); RFDataConnection.commit(); }
	 * 
	 * @Test public void testRollback() throws SQLException, DAOException {
	 * Statement stm = conn.createStatement(); stm.executeUpdate(
	 * "Update EMP set sal = sal + 10000 "); RFDataConnection.rollback(); }
	 * 
	 * @Test public void testCloseStatement() throws SQLException, DAOException
	 * { Statement stm = conn.createStatement();
	 * RFDataConnection.closeStatement(stm); assertTrue("Cerrar statment"
	 * ,stm.isClosed()); }
	 * 
	 * @Test public void testCloseResulSet() throws SQLException, DAOException {
	 * Statement stm = conn.createStatement(); ResultSet rs = stm.executeQuery(
	 * "SELECT * FROM EMP"); RFDataConnection.closeResulSet(rs);
	 * 
	 * }
	 * 
	 */
	@Before
	public void borra(){
		borraTodo();
	}
	public static void borraTodo() {
		try {
			conn = Conexion.getConnection();
			Statement stm = conn.createStatement();
			stm.executeUpdate(SQL_LIMPIA);
		} catch (DAOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
