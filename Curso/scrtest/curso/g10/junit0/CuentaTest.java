package dominio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CuentaTest {
	Cuenta cuenta;

	
	@Before
	public void inicio() throws Exception
	{
	cuenta = new Cuenta("0001.0002.12.1234567890", "Fulano de Tal");
	}

	
	@Test
	public void testIngresar1000() {
		try {
			cuenta.ingresar(1000);
			assertTrue(cuenta.getSaldo() == 1000.0);
		} catch (Exception e) {
			fail("No debería haber fallado");
		}
	}
	@Test
	public void testRetirar1000() {
		try {
			cuenta.retirar(1000);
		} catch (Exception e) {
		}
		assertTrue(cuenta.getSaldo() == 0.0);
	}
	@Test
	public void testIngresoYRetirada() {
		try {
			cuenta.ingresar(1000.0);
			cuenta.retirar(300.0);
		} catch (Exception e) {
		}
		assertTrue(cuenta.getSaldo() == 700.0);
	}

	
}
