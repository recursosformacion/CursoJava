package curso.g10.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest {

	Calculadora calc;
	
	@Before
	public void inicio(){
		calc = new Calculadora();
	}
	
	@Test
	public void testSuma() {
		assertEquals("Suma de 7 + 3", 10, calc.suma(7, 3), 0);
	}
	@Test
	public void testSuma2() {
		assertNotEquals("Suma de 7 + 3", 12, calc.suma(7, 3), 0);
	}
	
}
