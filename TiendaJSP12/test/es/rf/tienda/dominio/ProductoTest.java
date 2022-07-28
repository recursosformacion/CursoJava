package es.rf.tienda.dominio;

import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.Rutinas;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProductoTest {
	Producto producto;
	final String DESCRI = "Texto para descripcion";
	String diaAnterior;
	String diaActual;
	String diaPosterior;

	@Before
	public void iniciar() {
		producto = new Producto();

		Calendar c = Calendar.getInstance();
		diaActual = Rutinas.Calendar2String(c);
		c.add(Calendar.DAY_OF_MONTH, -1);
		diaAnterior = Rutinas.Calendar2String(c);
		c.add(Calendar.DAY_OF_MONTH, 2);
		diaPosterior = Rutinas.Calendar2String(c);
	}

	// Probar menos de 5 posiciones
	@Test(expected = DomainException.class)
	public void setId_producto1() throws DomainException {
		producto.setPro_descripcion("abc");
	}

	// Probar mas de 5 posiciones
	@Test(expected = DomainException.class)
	public void setId_producto2() throws DomainException {
		producto.setId_producto("abcdef");
	}

	// Probar 5 caracteres no alfanumericos
	@Test(expected = DomainException.class)
	public void setId_producto3() throws DomainException {
		producto.setId_producto("ab%de");
	}

	// Probar 5 caracteres alfanumericos
	@Test
	public void setId_producto4() throws DomainException {
		producto.setId_producto("abcde");
		System.out.println("ID:" + producto.getId_producto());
		assertEquals("setId_producto", "abcde", producto.getId_producto());
	}

	/**
	 * prueba valido
	 * 
	 * @throws DomainException
	 */
	@Test
	public void testsetPro_descripcion() throws DomainException {
		final String DESCRI = "Texto para descripcion";
		producto.setPro_descripcion(DESCRI);
		assertEquals("Descripcion", DESCRI, producto.getPro_descripcion());
	}

	/**
	 * Descripcion corta
	 * 
	 * @throws DomainException
	 */
	@Test(expected = DomainException.class)
	public void testsetPro_descripcion1() throws DomainException {
		final String DESCRI = "Tex";
		producto.setPro_descripcion(DESCRI);
	}

	/**
	 * Descripcion larga
	 * 
	 * @throws DomainException
	 */
	@Test(expected = DomainException.class)
	public void testsetPro_descripcion2() throws DomainException {
		final String DESCRI = "aaaaaaaaaa bbbbbbbbbb cccccccccc dddddddddd eeeeeeeeee fffffffff ggggggggg hhhhhhhhh iiiiiiiiii jjjjjjjjjj";
		;
		producto.setPro_descripcion(DESCRI);
	}
	// Comprobar entrada no numerica - no ha lugar

	// Comprobar entrada numerica con decimal/verificar igualdad
	@Test
	public void testSetPrecio1() throws DomainException {
		double precio = 12.34;
		producto.setPro_precio(precio);
		System.out.println("Precio:" + producto.getPro_precio());
		assertEquals("Precio con decimales", precio, producto.getPro_precio(), 0);
	}

	// Comprobar entrada numerica =0
	@Test
	public void testSetPrecio2() throws DomainException {
		double precio = 0;
		producto.setPro_precio(precio);
		assertEquals("Precio con decimales", precio, producto.getPro_precio(), 0);

	}

	// Comprobar entrada numerica < 0
	@Test(expected = DomainException.class)
	public void testSetPrecio3() throws DomainException {
		double precio = -100;
		producto.setPro_precio(precio);

	}

	// *******************************Reposicion**********************
	// Comprobar fecha valida
	@Test
	public void testsetPro_fecRepos() throws DomainException {
		producto.setPro_fecRepos(diaPosterior);
		String resp = Rutinas.Calendar2String(producto.getPro_fecRepos());
		assertEquals("Fecha reposicion", diaPosterior, resp);
	}

	// Comprobar fecha anterior
	@Test(expected = DomainException.class)
	public void testsetPro_fecRepos1() throws DomainException {
		producto.setPro_fecRepos(diaAnterior);
		
	}

	// Comprobar formato eroneo
	@Test(expected = DomainException.class)
	public void testsetPro_fecRepos2() throws DomainException {
		String diaPrueba = "35/02/9999";
		producto.setPro_fecRepos(diaPrueba);
		
	}

	// **********************Fecha activacion***********************
	// Comprobar fecha valida
	@Test
	public void testsetPro_fecActi() throws DomainException {
		producto.setPro_fecActi(diaPosterior);
		String resp = Rutinas.Calendar2String(producto.getPro_fecActi());
		assertEquals("Fecha reposicion", diaPosterior, resp);
	}

	// Comprobar fecha anterior
	@Test(expected = DomainException.class)
	public void testsetPro_fecActi1() throws DomainException {
		producto.setPro_fecActi(diaAnterior);
		
	}

	// Comprobar formato eroneo
	@Test(expected = DomainException.class)
	public void testsetPro_fecActi2() throws DomainException {
		String diaPrueba = "35/02/9999";
		producto.setPro_fecActi(diaPrueba);
		
	}
}
