package es.rf.tienda.dominio;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.ValidatorTest;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class ProductoTest {
	Producto producto;
	final String TXT_DESCRIPCION="Texto para descripcion";
	
	 Calendar DIA_ANTERIOR;
	 Calendar DIA_POSTERIOR;
	 Calendar DIA_ACTUAL;
	
	
	@Before
	public void iniciar(){
		Calendar aux = Calendar.getInstance();
		aux.add(Calendar.DAY_OF_YEAR, -1);
		DIA_ANTERIOR=aux;
		
		aux = Calendar.getInstance();
		aux.add(Calendar.DAY_OF_YEAR, +1);
		DIA_POSTERIOR=aux;
		
		DIA_ACTUAL = Calendar.getInstance();
		
		producto=new Producto();
	}
	
	//Probar menos de 5 posiciones
	@Test(expected=DomainException.class)
	public void setId_producto1() throws DomainException{
			producto.setPro_descripcion(ValidatorTest.COD_PRODUCTO_CORTO);
	}
	
	//Probar mas de 5 posiciones
	@Test (expected=DomainException.class)
	public void setId_producto2() throws DomainException{
			producto.setId_producto(ValidatorTest.COD_PRODUCTO_LARGO);
	}
	
	//Probar 5 caracteres no alfanumericos
	@Test (expected=DomainException.class)
	public void setId_producto3() throws DomainException{
			producto.setId_producto(ValidatorTest.COD_PRODUCTO_NO_ALFA);
	}
	//Probar 5 caracteres alfanumericos
	@Test (expected=DomainException.class)
	public void setId_producto4() throws DomainException{
		producto.setId_producto(ValidatorTest.COD_PRODUCTO_ALFA);
		
	}
	@Test
	public void testsetPro_descripcion() throws DomainException {
	
		producto.setPro_descripcion(TXT_DESCRIPCION);
		assertEquals("Descripcion",TXT_DESCRIPCION, producto.getPro_descripcion());
	}
	//Comprobar entrada no numerica - no ha lugar
	
	//Comprobar entrada numerica con decimal/verificar igualdad
	@Test (expected=DomainException.class)
	public void testSetPrecio1() throws DomainException {
		producto.setPro_precio(123.34);
	
	}
	
	//Comprobar entrada numerica =0
	@Test 
	public void testSetPrecio2() throws DomainException{
		producto.setPro_precio(0d);
	}
	
	//Comprobar entrada numerica < 0
	@Test (expected=DomainException.class)
	public void testSetPrecio3() throws DomainException{
		producto.setPro_precio(-100);
	}


	@Test (expected=DomainException.class)
	public void testSetFecActivacion1() throws DomainException {
		producto.setPro_fecActi(DIA_ANTERIOR);
	}

	@Test
	public void testSetFecActivacion2() throws DomainException {
		producto.setPro_fecActi(DIA_POSTERIOR);
		assertEquals(DIA_POSTERIOR, producto.getPro_fecActi());
	}
	@Test  (expected=DomainException.class)
	public void testSetFecActivacion3() throws DomainException {
		producto.setPro_fecActi(DIA_ACTUAL);
	}
	
	@Test (expected=DomainException.class)
	public void testSetFecDesactivacion1() throws DomainException {
		producto.setPro_fecDesacti(DIA_ANTERIOR);
	}
	
	@Test
	public void testSetFecDesactivacion2() throws DomainException {
		producto.setPro_fecDesacti(DIA_POSTERIOR);
		assertEquals(DIA_POSTERIOR, producto.getPro_fecDesacti());
	}
	
	@Test  (expected=DomainException.class)
	public void testSetFecDesactivacion3() throws DomainException {
		producto.setPro_fecDesacti(DIA_ACTUAL);
	}



}
