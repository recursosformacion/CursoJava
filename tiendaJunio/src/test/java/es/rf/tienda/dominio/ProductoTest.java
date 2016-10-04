package es.rf.tienda.dominio;

import es.rf.tienda.exception.DomainException;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ProductoTest {
	Producto producto;
	final String descri = "Texto para descripcion";

	@Before
	public void iniciar() {
		producto = new Producto();
	}

	// Probar menos de 5 posiciones
	@Test(expected = DomainException.class)
	public void testSetCodigo1() {
		producto.setCodigo("abc");
	}

	// Probar mas de 5 posiciones
	@Test(expected = DomainException.class)
	public void testSetCodigo2() {
		producto.setCodigo("abcdef");
	}

	// Probar 5 caracteres no alfanumericos
	@Test(expected = DomainException.class)
	public void testSetCodigo3() {
		producto.setCodigo("ab.de");
	}

	// Probar 5 caracteres alfanumericos
	@Test
	public void testSetCodigo4() {
		producto.setCodigo("abcdef");
		assertEquals("setCodigo", "abcdef", producto.getCodigo());
	}

	@Test
	public void testGetDescripcion() {
		final String descri = "Texto para descripcion";
		producto.setDescripcion(descri);
		assertEquals("Descripcion", descri, producto.getDescripcion());
	}
	// Comprobar entrada no numerica - no ha lugar

	// Comprobar entrada numerica con decimal/verificar igualdad
	@Test
	public void testSetPrecio1() {
		producto.setPrecio(123.34);
		assertEquals("Precio con decimales", 123.34, producto.getPrecio(), 0);
	}

	// Comprobar entrada numerica =0
	@Test(expected = DomainException.class)
	public void testSetPrecio2() {
		producto.setPrecio(0);
	}

	// Comprobar entrada numerica < 0
	@Test(expected = DomainException.class)
	public void testSetPrecio3() {
		producto.setPrecio(-100);
	}

	// Verificar un valor entre 1 y 4, inclusive
	@Test
	public void testSetDisponibilidad1() {
		for (int a = 1; a <= 4; a++) {
			producto.setDisponibilidad(a);
			assertEquals("Check valor " + a, a, producto.getDisponibilidad(), 0);
		}
	}

	// Verificar un valor inferior a 1
	@Test
	public void testSetDisponibilidad2() {
		for (int a = 1; a <= 4; a++) {
			producto.setDisponibilidad(a);
			assertEquals("Check valor " + a, a, producto.getDisponibilidad(), 0);
		}
	}
	// Verificar un error superior a 4

	@Test
	public void testSetDisponibilidad() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFecReposicion() throws DomainException {
		producto.setFecReposicion(new Date());
	}

	@Test
	public void testSetFecActivacion() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFecDesactivacion() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCantidadStock() {
		fail("Not yet implemented");
	}

}
