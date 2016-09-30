package es.rf.tienda.util;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class ValidatorTest {

	// *********Codigo de producto*********************//
	public final static String COD_PRODUCTO_CORTO = "ab1";
	public final static String COD_PRODUCTO_LARGO = "ABC123";
	public final static String COD_PRODUCTO_NUMERICO = "12345";
	public final static String COD_PRODUCTO_ALFA = "ABCDE";
	public final static String COD_PRODUCTO_NO_ALFA = "ABCDE";
	public final static String COD_PRODUCTO_OK = "AB123";

	// ************Cadenas alfanumericas **********************//
	public final static String TEXTO_ALFANUMERICO_ERRONEO = "lkjd salkas jlask daskla$&%";
	public final static String TEXTO_ALFANUMERICO_OK = "lkjd salkas jlask daskla";

	// ********** PHONE NUMBER*******************************//
	final static String PHONENUMBER_OK = "123 456 789 01";
	final static String PHONENUMBER_LARGO = "123 456 789 012 345 678 901 234";
	final static String PHONENUMBER_CORTO_NUMEROS = "123        ";
	final static String PHONENUMBER_CORTO = "123 ";
	final static String PHONENUMBER_FORMATO = "(123) 456 789 012 ";

	// ************ Mail *********************//
	public final static String MAIL_VALIDO = "migarcia@dopc.com";
	public final static String MAIL_VALIDO1 = "Miguel.Grcia@dopc.com";
	public final static String MAIL_VALIDO2 = "miguel_garcia@dopc.com";
	public final static String MAIL_VALIDO3 = "migarcia@mail.dopc.com";
	public final static String MAIL_SIN_DOMINIO = "migarcia";
	public final static String MAIL_SIN_TLD1 = "migarcia@dopc";
	public final static String MAIL_SIN_TLD2 = "migarcia@dopc.";
	public final static String MAIL_SIN_USER = "@dopc.com";
	public final static String MAIL_PUNTO = ".mi@dopc.com";
	public final static String MAIL_CORTO = "1@d.es";

	// ***************** DNI ***********************//
	public final static String DNI_VALIDO = "38.474.364-X";
	public final static String DNI_VALIDO1 = "38.474.364-x";
	public final static String DNI_ERROR_LETRA = "38.474.364-Y";
	public final static String DNI_ERROR_SIN_LETRA = "38.474.364-";
	public final static String DNI_ERROR_SIN_LETRA1 = "38.474.364";
	public final static String DNI_ERROR_FORMATO = "38474364X";
	public final static String DNI_ERROR_FORMATO_LETRAS = "38.A7A.364-X";
	
	//****************Fechas logicas**************************//
	public final static String FECHA_LOGICA_OK = "01/10/2016";
	public final static String FECHA_LOGICA_OK1 = "29/02/2016";
	public final static String FECHA_LOGICA_ERRDIA = "0/10/2016";
	public final static String FECHA_LOGICA_ERRDIA1 = "/10/2016";
	public final static String FECHA_LOGICA_ERRDIA2 = "00/10/2016";
	public final static String FECHA_LOGICA_ERRDIA3 = "31/04/2016";
	public final static String FECHA_LOGICA_ERRDIA4 = "30/02/2016";
	public final static String FECHA_LOGICA_ERRDIA5 = "29/02/2015";
	public final static String FECHA_LOGICA_ERRDIA6 = "aa/10/2016";
	public final static String FECHA_LOGICA_ERRMES = "01/00/2016";
	public final static String FECHA_LOGICA_ERRMES1 = "01/14/2016";
	public final static String FECHA_LOGICA_ERRMES2 = "01/1a/2016";
	public final static String FECHA_LOGICA_ERRANY = "01/10/0000";
	public final static String FECHA_LOGICA_ERRANY2 = "01/10/9999";
	
	// ***************Fechas **************************
	public static Calendar DIA_ANTERIOR;
	public static Calendar DIA_POSTERIOR;
	public static Calendar DIA_ACTUAL;
	static {
		Calendar aux = Calendar.getInstance();
		aux.add(Calendar.DAY_OF_YEAR, -1);
		DIA_ANTERIOR = aux;

		aux = Calendar.getInstance();
		aux.add(Calendar.DAY_OF_YEAR, +1);
		DIA_POSTERIOR = aux;

		DIA_ACTUAL = Calendar.getInstance();
	}

	@Test
	public void testIsCodigoProducto() {
		assertFalse(Validator.isCodigoProducto(COD_PRODUCTO_CORTO));
	}

	@Test
	public void testIsCodigoProducto0() {
		assertFalse(Validator.isCodigoProducto(null));
	}

	@Test
	public void testIsCodigoProducto00() {
		assertFalse(Validator.isCodigoProducto(""));
	}

	@Test
	public void testIsCodigoProducto1() {
		assertFalse(Validator.isCodigoProducto(COD_PRODUCTO_LARGO));
	}

	@Test
	public void testIsCodigoProducto2() {
		assertFalse(Validator.isCodigoProducto(COD_PRODUCTO_NUMERICO));
	}

	@Test
	public void testIsCodigoProducto3() {
		assertFalse(Validator.isCodigoProducto(COD_PRODUCTO_ALFA));
	}

	@Test
	public void testIsCodigoProducto4() {
		assertTrue(Validator.isCodigoProducto(COD_PRODUCTO_OK));
	}

	@Test
	public void testIsCodigoProducto5() {
		assertFalse(Validator.isCodigoProducto(COD_PRODUCTO_NO_ALFA));
	}

	@Test
	public void testIsAlfanumeric() {
		assertFalse(Validator.isAlfanumeric(TEXTO_ALFANUMERICO_ERRONEO));
	}

	@Test
	public void testIsAlfanumeric1() {
		assertTrue(Validator.isAlfanumeric(TEXTO_ALFANUMERICO_OK));
	}

	@Test
	public void testIsVacio() {
		assertTrue(Validator.isCodigoProducto(null));
	}

	@Test
	public void testIsVacio1() {
		assertTrue(Validator.isCodigoProducto(""));
	}

	@Test
	public void testIsVacio2() {
		assertFalse(Validator.isCodigoProducto(" "));
	}

	@Test
	public void testCumplePhoneNumber() {
		assertTrue(Validator.cumplePhoneNumber(PHONENUMBER_OK));
	}

	@Test
	public void testCumplePhoneNumber0() {
		assertFalse(Validator.cumplePhoneNumber(null));
	}

	@Test
	public void testCumplePhoneNumber00() {
		assertTrue(Validator.cumplePhoneNumber(""));
	}

	@Test
	public void testCumplePhoneNumber1() {
		assertFalse(Validator.cumplePhoneNumber(PHONENUMBER_CORTO));
	}

	@Test
	public void testCumplePhoneNumber2() {
		assertFalse(Validator.cumplePhoneNumber(PHONENUMBER_CORTO_NUMEROS));
	}

	@Test
	public void testCumplePhoneNumber3() {
		assertFalse(Validator.cumplePhoneNumber(PHONENUMBER_FORMATO));
	}

	@Test
	public void testCumplePhoneNumber4() {
		assertFalse(Validator.cumplePhoneNumber(PHONENUMBER_LARGO));
	}

	@Test
	public void testIsEmailValido() {
		assertTrue(Validator.isEmailValido(MAIL_VALIDO));
	}

	@Test
	public void testIsEmailValido0() {
		assertFalse(Validator.isEmailValido(null));
	}

	@Test
	public void testIsEmailValido00() {
		assertFalse(Validator.isEmailValido(""));
	}

	@Test
	public void testIsEmailValido1() {
		assertTrue(Validator.isEmailValido(MAIL_CORTO));
	}

	@Test
	public void testIsEmailValido2() {
		assertFalse(Validator.isEmailValido(MAIL_PUNTO));
	}

	@Test
	public void testIsEmailValido3() {
		assertFalse(Validator.isEmailValido(MAIL_SIN_DOMINIO));
	}

	@Test
	public void testIsEmailValido4() {
		assertFalse(Validator.isEmailValido(MAIL_SIN_TLD1));
	}

	@Test
	public void testIsEmailValido5() {
		assertFalse(Validator.isEmailValido(MAIL_SIN_TLD2));
	}

	@Test
	public void testIsEmailValido6() {
		assertFalse(Validator.isEmailValido(MAIL_SIN_USER));
	}

	@Test
	public void testIsEmailValido7() {
		assertTrue(Validator.isEmailValido(MAIL_VALIDO1));
	}

	@Test
	public void testIsEmailValido8() {
		assertTrue(Validator.isEmailValido(MAIL_VALIDO2));
	}

	@Test
	public void testIsEmailValido9() {
		assertTrue(Validator.isEmailValido(MAIL_VALIDO3));
	}

	@Test
	public void testCumpleDNI() {
		assertTrue(Validator.cumpleDNI(DNI_VALIDO));
	}

	@Test
	public void testCumpleDNI0() {
		assertFalse(Validator.cumpleDNI(null));
	}

	@Test
	public void testCumpleDNI00() {
		assertFalse(Validator.cumpleDNI(""));
	}

	@Test
	public void testCumpleDNI1() {
		assertTrue(Validator.cumpleDNI(DNI_VALIDO1));
	}

	@Test
	public void testCumpleDNI2() {
		assertFalse(Validator.cumpleDNI(DNI_ERROR_FORMATO));
	}

	@Test
	public void testCumpleDNI3() {
		assertFalse(Validator.cumpleDNI(DNI_ERROR_FORMATO_LETRAS));
	}

	@Test
	public void testCumpleDNI4() {
		assertFalse(Validator.cumpleDNI(DNI_ERROR_LETRA));
	}

	@Test
	public void testCumpleDNI5() {
		assertFalse(Validator.cumpleDNI(DNI_ERROR_SIN_LETRA));
	}

	@Test
	public void testCumpleDNI6() {
		assertFalse(Validator.cumpleDNI(DNI_ERROR_SIN_LETRA1));
	}

	@Test
	public void testCumpleRangoIntIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testCumpleRangoDoubleIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testCumpleLongitudMin() {
		fail("Not yet implemented");
	}

	@Test
	public void testCumpleLongitudMax() {
		fail("Not yet implemented");
	}

	@Test
	public void testCumpleLongitud() {
		fail("Not yet implemented");
	}

	@Test
	public void testValDateMin() {
		fail("Not yet implemented");
	}

	@Test
	public void testValDateMax() {
		assertTrue(Validator.valDateMax(DIA_ANTERIOR, DIA_ACTUAL));
	}
	@Test
	public void testValDateMax0() {
		assertTrue(Validator.valDateMax(null, null));
	}

	@Test
	public void testValDateMax1() {
		assertFalse(Validator.valDateMax(DIA_POSTERIOR, DIA_ACTUAL));
	}
	
	@Test
	public void testEsFechaValida() {
		assertTrue(Validator.esFechaValida(FECHA_LOGICA_OK));
	}
	@Test
	public void testEsFechaValida0() {
		assertFalse(Validator.esFechaValida(null));
	}
	@Test
	public void testEsFechaValida00() {
		assertFalse(Validator.esFechaValida(""));
	}

	@Test
	public void testEsFechaValida1() {
		assertFalse(Validator.esFechaValida(FECHA_LOGICA_ERRANY));
	}
	@Test
	public void testEsFechaValida2() {
		assertFalse(Validator.esFechaValida(FECHA_LOGICA_ERRANY2));
	}
	@Test
	public void testEsFechaValida3() {
		assertFalse(Validator.esFechaValida(FECHA_LOGICA_ERRDIA));
	}
	@Test
	public void testEsFechaValida4() {
		assertFalse(Validator.esFechaValida(FECHA_LOGICA_ERRDIA1));
	}
	@Test
	public void testEsFechaValida5() {
		assertFalse(Validator.esFechaValida(FECHA_LOGICA_ERRDIA2));
	}
	@Test
	public void testEsFechaValida6() {
		assertFalse(Validator.esFechaValida(FECHA_LOGICA_ERRDIA3));
	}
	@Test
	public void testEsFechaValida7() {
		assertFalse(Validator.esFechaValida(FECHA_LOGICA_ERRDIA4));
	}
	@Test
	public void testEsFechaValida8() {
		assertFalse(Validator.esFechaValida(FECHA_LOGICA_ERRDIA5));
	}
	@Test
	public void testEsFechaValida9() {
		assertFalse(Validator.esFechaValida(FECHA_LOGICA_ERRDIA6));
	}
	@Test
	public void testEsFechaValida10() {
		assertFalse(Validator.esFechaValida(FECHA_LOGICA_ERRMES));
	}
	@Test
	public void testEsFechaValida11() {
		assertFalse(Validator.esFechaValida(FECHA_LOGICA_ERRMES2));
	}
	
	@Test
	public void testEsPasswordValida() {
		fail("Not yet implemented");
	}

}
