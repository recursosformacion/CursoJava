package es.rf.tienda.util;

import static org.junit.Assert.*;

import org.junit.Test;
	
	

public class ValidatorTest {
	
	final String NOT_ALFANUMERIC="jkhkhjk657675/&%/&%/?=)?)?cvx vcxcvxvc";
	final String ALFANUMERIC = "poiuytre wqasdf . hhhhh ссс , ; -";
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
	final String NUMERO_DNI_ERROR_LETRA = "12.345.678-A";
	final String NUMERO_DNI_ERROR_FORM_CORTO = "12.2.678-A";
	final String NUMERO_DNI_ERROR_FORM_CORTO2 = "122.678-A";
	final String NUMERO_DNI_ERROR_FORM_LARGO = "123.456.678-A";
	final String NUMERO_DNI_ERROR_FORM_ERR = "12345678A";
	final String NUMERO_DNI_ERROR_FORM_ERR2 = "12.345.678.A";
	

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

	@Test
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
		assertFalse(Validator.cumpleDNI(NUMERO_DNI_ERROR_LETRA ));
		assertFalse(Validator.cumpleDNI(NUMERO_DNI_ERROR_FORM_CORTO ));
		assertFalse(Validator.cumpleDNI(NUMERO_DNI_ERROR_FORM_CORTO2 ));
		assertFalse(Validator.cumpleDNI(NUMERO_DNI_ERROR_FORM_LARGO));
		assertFalse(Validator.cumpleDNI(NUMERO_DNI_ERROR_FORM_ERR));
		assertFalse(Validator.cumpleDNI(NUMERO_DNI_ERROR_FORM_ERR2 ));
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
		fail("Not yet implemented");
	}

	@Test
	public void testValDateIgual() {
		fail("Not yet implemented");
	}

	@Test
	public void testEsFechaValida() {
		fail("Not yet implemented");
	}

	@Test
	public void testEsPasswordValida() {
		fail("Not yet implemented");
	}

}
