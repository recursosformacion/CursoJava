package es.rf.tienda.objetos.daos;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;

public class testCategoriaDao {
	static CategoriaDAO cDAO;
	static Categoria reg1;
	static Categoria reg2;
	
	@BeforeClass
	public static void inicializar(){
		cDAO = new CategoriaDAO();
		reg1 = new Categoria();
		reg1.setCat_nombre("Titulo 1");
		reg1.setCat_descripcion("Descripcion categoria 1");
		
		reg2 = new Categoria();
		reg2.setCat_nombre("Titulo 2");
		reg2.setCat_descripcion("Descripcion categoria 2");
	}
	
	@Test
	public void testLeerTodos() throws DAOException {
		insertarPrueba();
		List<Categoria> lista= cDAO.leerTodos();
		borrarPrueba();
		assertTrue("Lista todo", lista.size()>0);
		
	}

	@Test
	public void testLeerRegistros() {
		fail("Not yet implemented");
	}

	@Test
	public void testLeerRegistro() throws DAOException {
		System.out.println("Test leer registro--->");
		insertarPrueba();
		Categoria check = new Categoria();
		check.setId_categoria(reg1.getId_categoria());
		Categoria reglec = cDAO.leerRegistro(check);
		borrarPrueba();		
		assertEquals("Lectura",reg1.getCat_nombre(),reglec.getCat_nombre());
		
	}

	@Test
	public void testActualizarRegistro() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertarRegistro() throws DAOException {		
		cDAO.insertarRegistro(reg1);
		cDAO.insertarRegistro(reg2);
		Categoria r=new Categoria();
		r.setId_categoria(reg1.getId_categoria());
		cDAO.leerRegistro(r);
		borrarPrueba();
		
	}

	@Test
	public void testBorrarRegistro() {
		fail("Not yet implemented");
	}

	private void insertarPrueba() throws DAOException{
		cDAO.insertarRegistro(reg1);
		cDAO.insertarRegistro(reg2);
		
	}
	
	private void borrarPrueba() throws DAOException{
		cDAO.borrarRegistro(reg1);
		cDAO.borrarRegistro(reg2);
		
	}
}
