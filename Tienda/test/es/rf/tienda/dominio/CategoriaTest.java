package es.rf.tienda.dominio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CategoriaTest {

	Categoria prueba;
	final String NOMBRE = "Nombre de categoria";
	final String DESCRIPCION  = "Descripcion de categoria";
	
	@Before
	public void inicio(){
		prueba=new Categoria();
	}
	
	@Test
	public void testIsValid() {
		prueba.setCat_nombre(NOMBRE);
		prueba.setCat_descripcion(DESCRIPCION);
		prueba.setId_categoria(10);
		assertTrue(prueba.isValid());
	}
	@Test
	public void testIsValid1() {
		
		prueba.setCat_descripcion(DESCRIPCION);
		prueba.setId_categoria(10);
		assertFalse(prueba.isValid());
	}
	@Test
	public void testIsValid2() {
		prueba.setCat_nombre(NOMBRE);
		prueba.setCat_descripcion(DESCRIPCION);
		
		assertFalse(prueba.isValid());
	}
	


	@Test
	public void testSetCat_nombre() {
		prueba.setCat_nombre(NOMBRE);
		assertEquals("Nombre Categoria", NOMBRE, prueba.getCat_nombre());
	}

	@Test
	public void testSetCat_descripcion() {
		prueba.setCat_descripcion(DESCRIPCION);
		assertEquals("Descripcion categoria",DESCRIPCION, prueba.getCat_descripcion());
	}

}
