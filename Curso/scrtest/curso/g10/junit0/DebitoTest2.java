package dominio;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DebitoTest2 extends TarjetaTest {
	Tarjeta tarjeta;
	Cuenta cuenta;
	
	
	@Before
	public void setUp() throws Exception {
		cuenta = new Cuenta("0001.0002.12.1234567890", "Fulano de Tal");
		cuenta.ingresar(1000.0);
		Date hoy = new Date();
		long tiempo = Long.parseLong("12096000000");
		Date fecha = new Date(hoy.getTime() + tiempo); // Caduca en 4 años
		tarjeta = new Debito("1234567890123456", "Fulano de Tal", fecha);
		tarjeta.setCuenta(cuenta);
	}

	public void tearDown() throws Exception {
	}

	public Tarjeta tarjetaInicial() {
		return tarjeta;
	}
	@Test
	public void preparaTarjeta(Cuenta c) {
		Tarjeta t = new Debito("9876543210987654", "Paco Pil", null);
		t.setCuenta(cuenta);
		return t;
	}

}
