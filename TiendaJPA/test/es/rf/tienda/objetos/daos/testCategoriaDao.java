package es.rf.tienda.objetos.daos;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.RFDataConnection;

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
	public void testLeerTodos() throws DAOException, DomainException {
		List<Categoria> lista= cDAO.listarTodos();
		assertTrue("Lista todo", lista.size()>0);
		
	}

	@Test
	public void testLeerRegistros() {
		fail("Not yet implemented");
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
		
		
		cDAO.guardar(reg1);
		RFDataConnection.commit();
		cDAO.guardar(reg2);
		RFDataConnection.commit();
		
	}

	@Test
	public void testBorrarRegistro() {
		fail("Not yet implemented");
	}

}
