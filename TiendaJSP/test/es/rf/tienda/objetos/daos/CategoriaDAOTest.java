package es.rf.tienda.objetos.daos;

import static org.junit.Assert.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;

import es.rf.tienda.util.HibernateUtil;

public class CategoriaDAOTest {
	Categoria cat;
	CategoriaDAOH cDAO;
	private static Session sesion;
	private static Transaction tx;

	
	public final String NOMBRE = "Inciensos asociados";
	public final String DESCRIPCION = "Estos inciensos son los mas olorosos del mundo";
	public final String NOMBRE_1 = "Inciensos asociados Modificado";
	public final String DESCRIPCION_1 = "Estos inciensos son los mas olorosos del mundo Modificado";
	
	
	@BeforeClass
	public static void inicioC(){
		sesion = HibernateUtil.getSession();
		tx = sesion.beginTransaction();
	}
	
	@AfterClass
	public static void finC(){
		tx.commit();
		sesion.close();
	
	}
	public void borrarTodo(){
		String stringQuery = "DELETE FROM Categoria";
		Query query = sesion.createQuery(stringQuery);
		query.executeUpdate();
	}
	
	@Before
	public void inicio(){
		borrarTodo();
		cat =   new Categoria();
		cDAO=new CategoriaDAOH();
		
	}

	@Test
	public void testInsertar() throws DAOException {
		insertaCat();
		
		Categoria l = new Categoria();
		l.setId_categoria(cat.getId_categoria());
		assertEquals(cat,cDAO.leerRegistro(l));	
		
	}
	
	@Test
	public void testActualizar() throws DAOException {
		insertaCat();
		cat.setCat_nombre(NOMBRE_1);
		cat.setCat_descripcion(DESCRIPCION_1);
		
		
		

	}

	@Test
	public void testBorrar() {
		fail("Not yet implemented");
	}

	@Test
	public void testLeerTodos() {
		fail("Not yet implemented");
	}

	@Test
	public void testLeerVarios() {
		fail("Not yet implemented");
	}

	public void insertaCat() throws DAOException{
		cat.setCat_nombre(NOMBRE);
		cat.setCat_descripcion(DESCRIPCION);
		cDAO.insertarRegistro(cat);
		
	}

}
