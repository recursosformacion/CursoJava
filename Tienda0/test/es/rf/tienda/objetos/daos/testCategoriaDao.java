package es.rf.tienda.objetos.daos;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.Conexion;
import es.rf.tienda.util.RFDataConnection;

public class testCategoriaDao {
	
	static Statement stm;
	static final String IDENTIFICADOR = "MGG-jsksjsksjsksjsk";
	
	static final String SQL_LIMPIA = "Delete from categoria where cat_nombre LIKE '" + IDENTIFICADOR + "%'";
	static final String CAT_NOMBRE_1 = 	IDENTIFICADOR + " -  categoria Uno";
	static final String CAT_DESCRIPCION_1 ="Descripcion de la primera categoria";
	static final String CAT_NOMBRE_2 = 	IDENTIFICADOR + " -  categoria Dos";
	static final String CAT_DESCRIPCION_2 ="Descripcion de la segunda categoria";
	
	
	static CategoriaDAO cDAO;
	static Categoria reg1;
	static Categoria reg2;
	
	@BeforeClass
	public static void inicializar() throws DomainException{
		borraTodo();
		
		cDAO = new CategoriaDAO();
		reg1 = new Categoria();
		reg1.setCat_nombre(CAT_NOMBRE_1);
		reg1.setCat_descripcion(CAT_DESCRIPCION_1);
		
		reg2 = new Categoria();
		reg2.setCat_nombre(CAT_NOMBRE_2);
		reg2.setCat_descripcion(CAT_DESCRIPCION_2);
	}
	
	@Test
	public void testLeerTodos() throws DAOException, DomainException {
		insertarPrueba();
		List<Categoria> lista= cDAO.leerTodos();
		borrarPrueba();
		assertTrue("Lista todo", lista.size()>0);
	}

	@Test 
	public void testLeerRegistros() throws DAOException, DomainException {
		insertarPrueba();
		Categoria reg3 = new Categoria();
		reg3.setCat_nombre(reg1.getCat_nombre());
		
		List<Categoria> lcat= cDAO.leerRegistros(reg3);
		if (lcat.size()>0){
			for (Categoria cate : lcat){
				if (!cate.getCat_nombre().equals(reg1.getCat_nombre())){
					fail("Error Leer Registro, recibido" + cate.getCat_nombre() +
							" Esperado " + reg1.getCat_nombre() );
				}
			}
			borrarPrueba();
		} else
			fail("No se encontro ningun registro");
	}

	@Test
	public void testLeerRegistro() throws DAOException, DomainException {
		insertarPrueba();
		Categoria reg3 = new Categoria();
		reg3.setId_categoria(reg1.getId_categoria());
		reg3 = cDAO.leerRegistro(reg3);
		borrarPrueba();
		assertEquals(reg3, reg1);
	}

	@Test
	public void testActualizarRegistro() throws DAOException, DomainException {
		insertarPrueba();
		System.out.println("a-->"+ reg1.getId_categoria());
		Categoria reg3 = new Categoria();
		reg3.setId_categoria(reg1.getId_categoria());
		reg3 = cDAO.leerRegistro(reg3);
		reg3.setCat_nombre(CAT_NOMBRE_2);
		cDAO.actualizarRegistro(reg3);
		RFDataConnection.commit();
		Categoria reg4 = new Categoria();
		reg4.setId_categoria(reg1.getId_categoria());
		reg4 =cDAO.leerRegistro(reg4);
		assertEquals(reg4, reg3);
		borrarPrueba();
		
	}

	@Test
	public void testInsertarRegistro() throws DAOException, DomainException {
		cDAO.insertarRegistro(reg1);
		RFDataConnection.commit();
		Categoria reg3 = cDAO.leerRegistro(reg1);
		assertTrue(reg1.equals(reg3));
		
	}

	@Test (expected= DAOException.class)
	public void testBorrarRegistro() throws DAOException, DomainException {
		cDAO.insertarRegistro(reg1);
		cDAO.borrarRegistro(reg1);
		cDAO.leerRegistro(reg1);
	}
	
	
	
	public static void borraTodo() {
		Connection conn;
		Statement stm;
		try {
			conn = Conexion.getConnection();
			stm = conn.createStatement();
			stm.executeUpdate(SQL_LIMPIA);
		} catch (DAOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void insertarPrueba() throws DAOException{
		cDAO.insertarRegistro(reg1);
		cDAO.insertarRegistro(reg2);
		RFDataConnection.commit();
		
	}
	
	private void borrarPrueba() throws DAOException{
		cDAO.borrarRegistro(reg1);
		cDAO.borrarRegistro(reg2);
		RFDataConnection.commit();
		
	}
}
