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
	public static void inicializar(){
		cDAO = new CategoriaDAO();
	
		
		reg1 = new Categoria();
		reg1.setId_categoria(90);
		reg1.setCat_nombre("Titulo n-1");
		reg1.setCat_descripcion("Descripcion categoria n-1");
		
		reg2 = new Categoria();
		reg2.setCat_nombre("Titulo n");
		reg2.setCat_descripcion("Descripcion categoria n");
	}
	
	
	@Test
	public void testLeerTodos() throws DAOException {
		List<Categoria> lista= cDAO.leerTodos();
		for (Categoria reg1 : lista){
			System.out.println("Id:"+reg1.getId_categoria() + " Titulo:" + reg1.getCat_nombre());;
			
		}
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
		cDAO.insertarRegistro(reg1);
		RFDataConnection.commit();
		reg2 = new Categoria();
		reg2.setId_categoria(reg1.getId_categoria());
		Categoria resp=cDAO.leerRegistro(reg2);
		
		assertTrue(resp.equals(reg1));		
	}

	@Test (expected= DAOException.class)
	public void testBorrarRegistro() throws DAOException {
		cDAO.insertarRegistro(reg1);
		RFDataConnection.commit();
		reg2 = new Categoria();
		reg2.setId_categoria(reg1.getId_categoria());
		int num = cDAO.borrarRegistro(reg2);
		RFDataConnection.commit();
		Categoria resp=cDAO.leerRegistro(reg2);
		
		assertTrue(resp.equals(reg1));			
	}

}
