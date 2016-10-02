package es.rf.tienda.objetos.daos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.util.RFDataConnection;

public class CategoriaDAO1Test {
	Categoria cat;
	CategoriaDAO1 cDAO;
	
	public final String NOMBRE = "Inciensos asociados";
	public final String DESCRIPCION = "Estos inciensos son los mas olorosos del mundo";
	
	@Before
	public void inicio(){
		cat =   new Categoria();
		cDAO=new CategoriaDAO1();
	}
	
	
	@Test
	public void testLeer() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertar() throws DAOException {
		cat.setCat_nombre(NOMBRE);
		cat.setCat_descripcion(DESCRIPCION);
		cDAO.insertar(cat);
		RFDataConnection.commit();
		Categoria l = new Categoria();
		l.setId_categoria(cat.getId_categoria());
		assertEquals(cat,cDAO.leer(l));
		
		
	}
	@Test
	public void testInsertar1() throws DAOException {
		cat.setCat_nombre(NOMBRE);
	
		cDAO.insertar(cat);
		RFDataConnection.commit();
		
		
	}

	@Test
	public void testActualizar() {
		fail("Not yet implemented");
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

	@Test
	public void testEntraString() {
		fail("Not yet implemented");
	}

}
