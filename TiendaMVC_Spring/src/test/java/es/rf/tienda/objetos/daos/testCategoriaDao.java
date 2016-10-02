package es.rf.tienda.objetos.daos;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.util.RFDataConnection;

public class testCategoriaDao {
	static CategoriaDAO cDAO;
	static Categoria reg1;
	static Categoria reg2;

	@BeforeClass
	public static void inicializar() {
		cDAO = new CategoriaDAO();
		reg1 = new Categoria();
		reg1.setTituloCategoria("Titulo 1");
		reg1.setDescripcionCategoria("Descripcion categoria 1");

		reg2 = new Categoria();
		reg2.setTituloCategoria("Titulo 2");
		reg2.setDescripcionCategoria("Descripcion categoria 2");
	}

	@Test
	public void testLeerTodos() throws DAOException {
		List<Categoria> lista = cDAO.leerTodos();
		assertTrue("Lista todo", lista.size() > 0);
	}

	@Test
	public void testLeerRegistros() throws DAOException {
		Categoria nueva = new Categoria();
		nueva.setIdCategoria(1);
		Categoria salida = cDAO.leerRegistro(nueva);
		assertEquals("Leyendo 1",1,salida.getIdCategoria());
	}

	@Test
	public void testLeerRegistro() {
		fail("Not yet implemented");
	}

	@Test
	public void testActualizarRegistro() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertarRegistro() throws DAOException {

		cDAO.insertarRegistro(reg1);
		RFDataConnection.commit();
		cDAO.insertarRegistro(reg2);
		RFDataConnection.commit();

	}

	@Test
	public void testBorrarRegistro() {
		fail("Not yet implemented");
	}

}
