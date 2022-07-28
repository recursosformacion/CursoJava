package curso.g10.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest {
	
	Calculadora calc;
	@Before
	public void inicio(){
		calc=new Calculadora();
	}
	@Test
	public void testSuma() {
		int resp=calc.suma(10, 12);
		assertEquals("Prueba suma 10 + 12", 22,resp,0);
		
		assertEquals("Suma 7+ -3",4,calc.suma(7, -3),0);
	}

	@Test
	public void testResta() {
		assertEquals("Prueba resta 10 - 12", -2,calc.resta(10, 12),0);
		assertEquals("Prueba resta 10 - -6", 16,calc.resta(10, -6),0);
	}

	@Test
	public void testMultiplica() {
		assertEquals("Prueba mult 10 * 12", 120,calc.multiplica(10, 12),0);
	}

	@Test
	public void testDivide() {
		assertEquals("Prueba div 10 /5", 2,calc.divide(10, 5),0);
		
	}
	@Test (expected=ArithmeticException.class)
	public void testDivideCero() {
		assertEquals("Prueba div 10 /0", 0,calc.divide(10, 0),0);
		
	}

}
