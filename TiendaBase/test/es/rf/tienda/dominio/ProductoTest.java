package es.rf.tienda.dominio;
import es.rf.tienda.exception.DomainException;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProductoTest {
	Producto producto;
	final String descri="Texto para descripcion";
	
	
	@Before
	public void iniciar(){
		producto=new Producto();
	}
	
	//Probar menos de 5 posiciones
	@Test(expected=DomainException.class)
	public void setId_producto1() throws DomainException{
			producto.setPro_descripcion("abc");
	}
	
	//Probar mas de 5 posiciones
	@Test (expected=DomainException.class)
	public void setId_producto2() throws DomainException{
			producto.setId_producto("abcdef");
	}
	
	//Probar 5 caracteres no alfanumericos
	@Test (expected=DomainException.class)
	public void setId_producto3() throws DomainException{
			producto.setId_producto("ab.de");
	}
	//Probar 5 caracteres alfanumericos
	@Test 
	public void setId_producto4() throws DomainException{
		producto.setId_producto("abcdef");
		assertEquals("setId_producto", "abcdef",producto.getId_producto());
	}
	@Test
	public void testsetPro_descripcion() throws DomainException {
		final String descri="Texto para descripcion";
		producto.setPro_descripcion(descri);
		assertEquals("Descripcion",descri, producto.getPro_descripcion());
	}
	//Comprobar entrada no numerica - no ha lugar
	
	//Comprobar entrada numerica con decimal/verificar igualdad
	@Test
	public void testSetPrecio1() throws DomainException {
		producto.setPro_precio(123.34);
		assertEquals("Precio con decimales",123.34,producto.getPro_precio(),0);
	}
	
	//Comprobar entrada numerica =0
	@Test (expected=DomainException.class)
	public void testSetPrecio2() throws DomainException{
		producto.setPro_precio(0d);
	}
	
	//Comprobar entrada numerica < 0
	@Test (expected=DomainException.class)
	public void testSetPrecio3() throws DomainException{
		producto.setPro_precio(-100);
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
