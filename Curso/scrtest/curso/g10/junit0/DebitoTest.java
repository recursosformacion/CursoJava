package curso.g10.junit0;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DebitoTest {

	Debito debito;
	Cuenta cuenta;

	@Before
	public void inicio() throws Exception {
		cuenta = new Cuenta("0001.0002.12.1234567890", "Fulano de Tal");
		cuenta.ingresar(1000.0);
		Date hoy = new Date();
		long tiempo = Long.parseLong("12096000000");
		Date fecha = new Date(hoy.getTime() + tiempo); // Caduca en 4 años
		debito = new Debito("1234567890123456", "Fulano de	Tal", fecha);
		debito.setCuenta(cuenta);
	}

	

	@Test
	public void testRetirar1000() {
		try {
			debito.retirar(1000.0);
			assertTrue(debito.getSaldo() == cuenta.getSaldo());
			assertTrue(debito.getSaldo() == 0.0);
		} catch (Exception e) {
			fail("No deberia haber fallado");
		}
	}

}
