package es.rf.tienda.util;

import static org.junit.Assert.*;

import org.junit.Test;

import jdk.nashorn.internal.ir.annotations.Ignore;
	
	

public class ValidatorTest {
	
	final String NOT_ALFANUMERIC="jkhkhjk657675/&%/&%/?=)?)?cvx vcxcvxvc";
	final String ALFANUMERIC = "poiuytre wqasdf . hhhhh ñññ , ; -";
	final String CODIGO_PRODUCTO_OK = "AB123";
	final String CODIGO_PRODUCTO_NO1 = "A123B";
	final String CODIGO_PRODUCTO_NO2 = "Ab123";
	final String CODIGO_PRODUCTO_NO3 = "A0123";
	final String CODIGO_PRODUCTO_FORMATO_ERR_NUM= "12345";
	final String CODIGO_PRODUCTO_FORMATO_ERR_ALF= "ABCDE";
	final String CODIGO_PRODUCTO_FORMATO_ERR_LON= "AB345678";
	 String STRING_NULA;
	final String STRING_VACIA="";
	final String CORREO_ELECTRONICO_CORRECTO = "migarcia@recursosformacion.com";
	final String CORREO_ELECTRONICO_ERRONEO_1 = "migarcia.recursosformacion.com";
	final String CORREO_ELECTRONICO_ERRONEO_2 = "migarcia@recursosformacion";
	
	final String NUMERO_DNI_OK = "12.345.678-Z";
	final String NUMERO_DNI_OK1 = "47.887.847-F";
	final String NUMERO_DNI_ERROR_LETRA = "12.345.678-A";
	final String NUMERO_DNI_ERROR_FORM_CORTO = "12.2.678-A";
	final String NUMERO_DNI_ERROR_FORM_CORTO2 = "122.678-A";
	final String NUMERO_DNI_ERROR_FORM_LARGO = "123.456.678-A";
	final String NUMERO_DNI_ERROR_FORM_ERR = "12345678A";
	final String NUMERO_DNI_ERROR_FORM_ERR2 = "12.345.678.A";
	
	final String PASSWORD_VALIDA = "1g@aaaaAaa";
	final String PASSWORD_VALIDA1 = "aaaAaaa1g$aaaaAaa";
	final String PASSWORD_ERROR1 = "1gaaaaaa";
	final String PASSWORD_ERROR2 = "--aaaaaa";
	final String PASSWORD_ERROR3 = "--123456";
	final String PASSWORD_ERROR4 = "-1-aa";
	final String PASSWORD_ERROR5 = "--aaaaaa";
	
	final String FECHA_VALIDA = "10/03/2016";
	final String FECHA_VALIDA1 = "29/02/2000";
	final String FECHA_ERROR1 = "40/03/2016";
	final String FECHA_ERROR2 = "10/13/2016";
	final String FECHA_ERROR3 = "10/13/año";
	final String FECHA_ERROR4 = "10/13";
	final String FECHA_ERROR5 = "";
	
	final int RANGO_MAX = 100;
	final int RANGO_MIN = 10;
	final int RANGO_OK1 = 10;
	final int RANGO_OK2 = 50;
	final int RANGO_OK3 = 100;
	final int RANGO_ER1 = 9;
	final int RANGO_ER2 = 101;
	final int RANGO_ER3 = 5000;
	final int RANGO_ER4 = 0;
			

	@Test
	public void testIsAlfanumericIS() {
		assertTrue(Validator.isAlfanumeric(ALFANUMERIC));
	}
	
	
	
	@Test
	public void testIsAlfanumericNOT() {
		assertFalse(Validator.isAlfanumeric(NOT_ALFANUMERIC));
	}

	@Test
	public void testIsCodigoProductoIS() {
		assertTrue(Validator.isCodigoProducto(CODIGO_PRODUCTO_OK));
	}
	
	@Test
	public void testIsCodigoProductoNO1() {
		assertFalse(Validator.isCodigoProducto(CODIGO_PRODUCTO_NO1));
	}
	
	@Test
	public void testIsCodigoProductoNO2() {
		assertFalse(Validator.isCodigoProducto(CODIGO_PRODUCTO_NO2));
	}
	@Test
	public void testIsCodigoProductoNO3() {
		assertFalse(Validator.isCodigoProducto(CODIGO_PRODUCTO_NO3));
	}
	@Test
	public void testIsCodigoProductoNOT_NUM() {
		assertFalse(Validator.isCodigoProducto(CODIGO_PRODUCTO_FORMATO_ERR_NUM));
	}
	
	@Test
	public void testIsCodigoProductoNOT_LONG() {
		assertFalse(Validator.isCodigoProducto(CODIGO_PRODUCTO_FORMATO_ERR_LON));
	}
	
	@Test
	public void testIsCodigoProductoNOT_ALF() {
		assertFalse(Validator.isCodigoProducto(CODIGO_PRODUCTO_FORMATO_ERR_ALF));
	}
	@Test
	public void testIsVacio() {
		assertTrue(Validator.isVacio(STRING_NULA));
		assertTrue(Validator.isVacio(STRING_VACIA));
		assertFalse(Validator.isVacio(ALFANUMERIC));
	}

	@Ignore
	public void testCumplePhoneNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsEmailValido() {
		assertTrue(Validator.isEmailValido(CORREO_ELECTRONICO_CORRECTO));
		assertFalse(Validator.isEmailValido(CORREO_ELECTRONICO_ERRONEO_1));
		assertFalse(Validator.isEmailValido(CORREO_ELECTRONICO_ERRONEO_2));
	}

	@Test
	public void testCumpleDNI() {
		assertTrue(Validator.cumpleDNI(NUMERO_DNI_OK ));
		assertTrue(Validator.cumpleDNI(NUMERO_DNI_OK1 ));
		
		assertFalse(Validator.cumpleDNI(NUMERO_DNI_ERROR_LETRA ));
		assertFalse(Validator.cumpleDNI(NUMERO_DNI_ERROR_FORM_CORTO ));
		assertFalse(Validator.cumpleDNI(NUMERO_DNI_ERROR_FORM_CORTO2 ));
		assertFalse(Validator.cumpleDNI(NUMERO_DNI_ERROR_FORM_LARGO));
		assertFalse(Validator.cumpleDNI(NUMERO_DNI_ERROR_FORM_ERR));
		assertFalse(Validator.cumpleDNI(NUMERO_DNI_ERROR_FORM_ERR2 ));
	}

	@Test
	public void testCumpleRango1() {
		assertTrue(Validator.cumpleRango(RANGO_OK1, RANGO_MIN, RANGO_MAX));
	}
	@Test
	public void testCumpleRango2() {
		assertTrue(Validator.cumpleRango(RANGO_OK2, RANGO_MIN, RANGO_MAX));
	}
	@Test
	public void testCumpleRango3() {
		assertTrue(Validator.cumpleRango(RANGO_OK3, RANGO_MIN, RANGO_MAX));
	}
	@Test
	public void testCumpleRangoER1() {
		assertFalse(Validator.cumpleRango(RANGO_ER1, RANGO_MIN, RANGO_MAX));
	}
	@Test
	public void testCumpleRangoER2() {
		assertFalse(Validator.cumpleRango(RANGO_ER2, RANGO_MIN, RANGO_MAX));
	}
	@Test
	public void testCumpleRangoER3() {
		assertFalse(Validator.cumpleRango(RANGO_ER3, RANGO_MIN, RANGO_MAX));
	}
	@Test
	public void testCumpleRangoER4() {
		assertFalse(Validator.cumpleRango(RANGO_ER4, RANGO_MIN, RANGO_MAX));
	}
	@Ignore
	public void testCumpleLongitudMin() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testCumpleLongitudMax() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testCumpleLongitud() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testValDateMin() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testValDateMax() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testValDateIgual() {
		fail("Not yet implemented");
	}

	@Test
	public void testEsFechaValida() {
		assertTrue(Validator.esFechaValida(FECHA_VALIDA));
	}
	@Test
	public void testEsFechaValida1() {
		assertTrue(Validator.esFechaValida(FECHA_VALIDA1));
	}
	@Test
	public void testEsFechaError1() {
		assertFalse(Validator.esFechaValida(FECHA_ERROR1));
	}
	@Test
	public void testEsFechaError2() {
		assertFalse(Validator.esFechaValida(FECHA_ERROR2));
	}
	@Test
	public void testEsFechaError3() {
		assertFalse(Validator.esFechaValida(FECHA_ERROR3));
	}
	@Test
	public void testEsFechaError4() {
		assertFalse(Validator.esFechaValida(FECHA_ERROR4));
	}
	@Test
	public void testEsFechaError5() {
		assertFalse(Validator.esFechaValida(FECHA_ERROR5));
	}
	@Test
	public void testEsFechaError6() {
		assertFalse(Validator.esFechaValida(STRING_NULA));
	}
	@Test
	public void testEsFechaError7() {
		assertFalse(Validator.esFechaValida(STRING_VACIA));
	}
	
	@Test
	public void testEsPasswordValida() {
		assertTrue(Validator.esPasswordValida(PASSWORD_VALIDA));
	}
	@Test
	public void testEsPasswordValida1() {
		assertTrue(Validator.esPasswordValida(PASSWORD_VALIDA1));
		
	}
	@Test
	public void testEsPasswordError() {
		assertFalse(Validator.esPasswordValida(PASSWORD_ERROR1));
	}
	@Test
	public void testEsPasswordErro2r() {
		assertFalse(Validator.esPasswordValida(PASSWORD_ERROR2));
	}
	@Test
	public void testEsPasswordError3() {
		assertFalse(Validator.esPasswordValida(PASSWORD_ERROR3));
	}
	@Test
	public void testEsPasswordError4() {
		assertFalse(Validator.esPasswordValida(PASSWORD_ERROR4));
	}
	@Test
	public void testEsPasswordError5() {
		assertFalse(Validator.esPasswordValida(PASSWORD_ERROR5));
	}
	

}
