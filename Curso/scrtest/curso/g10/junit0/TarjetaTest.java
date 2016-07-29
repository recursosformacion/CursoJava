package dominio;

import static org.junit.Assert.*;

import org.junit.Test;

public abstract class TarjetaTest {

	Tarjeta tarjeta;
	Cuenta cuenta;

	public void setUp() throws Exception
	{
	cuenta=new Cuenta("0001.0002.12.1234567890", "Fulano de Tal");
	cuenta.ingresar(1000.0);
	}
	@Test
	public abstract Tarjeta preparaTarjeta(Cuenta c);
	@Test
	public abstract Tarjeta tarjetaInicial();
	@Test
	public void testRetirar300() {
		try {
			Tarjeta tarjeta = tarjetaInicial();
			tarjeta.retirar(300.0);
			Cuenta c = new Cuenta("1234.5678.12.1234567891", "Paco Pil");
			Tarjeta esperada = this.preparaTarjeta(c);
			assertTrue(tarjeta.getSaldo() == esperada.getSaldo());
		} catch (Exception e) {
		}
	}
}

}
