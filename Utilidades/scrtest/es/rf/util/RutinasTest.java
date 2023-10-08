package es.rf.util;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

public class RutinasTest {
	
	public static final String FECHA_OK_10_02 = "10/02/2017";
	public static final String FECHA_ERR_FEBRERO = "30/02/2017";
	public static final String FECHA_ERR_MES_SUP = "10/14/2017";
	public static final String FECHA_ERR_MES_00 = "10/00/2017";
	public static final String FECHA_ERR_ANO_CERO = "10/02/0000";
	public static final String FECHA_OK_BISIESTO = "29/02/2004";
	public static final String FECHA_OK_BISIESTO_2000 = "29/02/2000";
	public static final String FECHA_OK_INICIO = "01/01/2017";
	public static final String FECHA_OK_FIN = "31/12/2017";
	public static final String FECHA_CORRECTA="20/10/2017";
	public static final String FECHA_INCORRECTA_1="40/12/2017";
	public static final String FECHA_INCORRECTA_2="0/12/2017";
	public static final String FECHA_INCORRECTA_3="10/14/2017";
	public static final String FECHA_INCORRECTA_4="10/0/2017";
	public static final String FECHA_INCORRECTA_5="-3/12/2017";
	public static final String FECHA_INCORRECTA_6="12345";
	
	final String NOMBRE_CAMPO_1="nombreUsuario";
	final String VALOR_CAMPO_1="miguel";
	final String NOMBRE_CAMPO_2="importe";
	final double VALOR_CAMPO_2=123.45;
	final String NOMBRE_CAMPO_3="tipo";
	final int VALOR_CAMPO_3=555;
	final String NOMBRE_CAMPO_4="fecha";
	final Calendar FECHA = Calendar.getInstance();
	
	@Test
	public void testConvierteACalendar() {
		Calendar fecha = Rutinas.convierteACalendar(FECHA_OK_10_02);
		String out = Rutinas.convierteAString(fecha);
		assertEquals(FECHA_OK_10_02, out);
	}

	@Test
	public void testConvierteACalendar1() {
		String ini=FECHA_ERR_FEBRERO;
		Calendar fecha = Rutinas.convierteACalendar(ini);
		String out = Rutinas.convierteAString(fecha);
		assertNotEquals(ini, out);
	}
	
	@Test
	public void testConvierteACalendar2() {
		String ini=FECHA_ERR_MES_SUP;
		Calendar fecha = Rutinas.convierteACalendar(ini);
		String out = Rutinas.convierteAString(fecha);
		assertNotEquals(ini, out);
	}
	
	@Test
	public void testConvierteACalendar3() {
		String ini=FECHA_ERR_MES_00;
		Calendar fecha = Rutinas.convierteACalendar(ini);
		String out = Rutinas.convierteAString(fecha);
		assertNotEquals(ini, out);
	}
	
	@Test
	public void testConvierteACalendar4() {
		String ini=FECHA_ERR_ANO_CERO;
		Calendar fecha = Rutinas.convierteACalendar(ini);
		String out = Rutinas.convierteAString(fecha);
		assertNotEquals(ini, out);
	}
	
	@Test
	public void testConvierteACalendar5() {
		String ini=FECHA_OK_BISIESTO;
		Calendar fecha = Rutinas.convierteACalendar(ini);
		String out = Rutinas.convierteAString(fecha);
		assertEquals(ini, out);
	}

	@Test
	public void testConvierteACalendar6() {
		String ini=FECHA_OK_BISIESTO_2000;
		Calendar fecha = Rutinas.convierteACalendar(ini);
		String out = Rutinas.convierteAString(fecha);
		assertEquals(ini, out);
	}
	
	@Test
	public void testConvierteACalendarNULL() {
		String ini=null;
		Calendar fecha = Rutinas.convierteACalendar(ini);
		
		assertEquals(null, fecha);
	}
	@Test
	public void testEsFechaLogicaINICIO() {
		assertTrue(Rutinas.esFechaLogica(FECHA_OK_INICIO ));
	}

	@Test
	public void testEsFechaLogicaFIN() {
		assertTrue(Rutinas.esFechaLogica(FECHA_OK_FIN));
	}
	
	@Test
	public void testEsFechaLogicaEnBisiesto() {
		assertTrue(Rutinas.esFechaLogica(FECHA_OK_BISIESTO_2000));
	}
	
	
	
	@Test
	public void testEsFechaLogicaErrorDia() {
		assertFalse(Rutinas.esFechaLogica(FECHA_ERR_FEBRERO ));
	}
	
	@Test
	public void testEsFechaLogicaErrorMes() {
		assertFalse(Rutinas.esFechaLogica(FECHA_ERR_MES_SUP));
	}
	
	@Test
	public void testEsFechaLogicaNull() {
		assertFalse(Rutinas.esFechaLogica(null));
	}
	
	@Test
	public void testEsFechaLogicaTRUE() {
		assertTrue(Rutinas.esFechaLogica(FECHA_CORRECTA));
	}
	@Test
	public void testEsFechaLogicaDiaErroneo() {
		assertFalse(Rutinas.esFechaLogica(FECHA_INCORRECTA_1));
	}
	@Test
	public void testEsFechaLogicaDia0() {
		assertFalse(Rutinas.esFechaLogica(FECHA_INCORRECTA_2));
	}
	@Test
	public void testEsFechaLogicaMesErroneo() {
		assertFalse(Rutinas.esFechaLogica(FECHA_INCORRECTA_3));
	}
	@Test
	public void testEsFechaLogicaMes0() {
		assertFalse(Rutinas.esFechaLogica(FECHA_INCORRECTA_4));
	}
	@Test
	public void testEsFechaLogicaDiaNegativo() {
		assertFalse(Rutinas.esFechaLogica(FECHA_INCORRECTA_5));
	}
	@Test
	public void testEsFechaLogicaFormatoErroneo() {
		assertFalse(Rutinas.esFechaLogica(FECHA_INCORRECTA_6));
	}
	@Test
	public void testConvierteACalendarOK() {
		Calendar test = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String testS = sdf.format(test.getTime());
		Calendar dato = Rutinas.convierteACalendar(testS);
		if (!sonIgualesCalendars(dato,test))
				fail("Error convierte a calendar");
	}

	@Test
	public void testConvierteAStringOK() {
		Calendar test = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String testS = sdf.format(test.getTime());
		assertEquals(testS,Rutinas.convierteAString(test));
	}

	

	@Test
	public void testAddCampoStringStringDoubleString() {
		String salida="";
		assertEquals(NOMBRE_CAMPO_2+" = "+VALOR_CAMPO_2, 
						Rutinas.addCampo(salida, NOMBRE_CAMPO_2, VALOR_CAMPO_2, ","));
	}
	@Test
	public void testAddCampoStringStringDoubleString2() {
		String salida="";
		salida=Rutinas.addCampo(salida, NOMBRE_CAMPO_1, VALOR_CAMPO_1, ",");
		salida=Rutinas.addCampo(salida, NOMBRE_CAMPO_2, VALOR_CAMPO_2, ",");
		String previsto=NOMBRE_CAMPO_1+" = '"+VALOR_CAMPO_1+"' , "+NOMBRE_CAMPO_2+" = "+VALOR_CAMPO_2;
		assertEquals(previsto,salida);
	}

	@Test
	public void testAddCampoStringStringStringString() {
		String salida="";
		assertEquals(NOMBRE_CAMPO_1+" = '"+VALOR_CAMPO_1+"'", 
				Rutinas.addCampo(salida, NOMBRE_CAMPO_1, VALOR_CAMPO_1, ","));
	}
	@Test
	public void testAddCampoStringStringStringStringNULL() {
		String dato = null;
		String salida="";
		assertEquals(NOMBRE_CAMPO_1+" = null", 
				Rutinas.addCampo(salida, NOMBRE_CAMPO_1, dato, ","));
	}

	@Test
	public void testAddCampoStringStringIntString() {
		String salida="";
		assertEquals(NOMBRE_CAMPO_3+" = "+VALOR_CAMPO_3, 
						Rutinas.addCampo(salida, NOMBRE_CAMPO_3, VALOR_CAMPO_3, ","));
	}
	@Test
	public void testAddCampoStringNuloIntString() {
		String salida="";
		assertEquals(""+VALOR_CAMPO_3, 
						Rutinas.addCampo(salida, "", VALOR_CAMPO_3, ","));
	}

	@Test
	public void testAddCampoStringStringCalendarString() {
		String salida="";
		
		assertEquals(NOMBRE_CAMPO_4+" = '"+Rutinas.convierteAString(FECHA)+"'", 
						Rutinas.addCampo(salida, NOMBRE_CAMPO_4, FECHA, ","));
	}
	@Test
	public void testAddCampoStringStringCalendarStringNULL() {
		String salida="";
		Calendar nulo=null;
		assertEquals(NOMBRE_CAMPO_4+" = null", 
						Rutinas.addCampo(salida, NOMBRE_CAMPO_4, nulo, ","));
	}
	

	public boolean sonIgualesCalendars(Calendar dato, Calendar test){
		if ((dato.get(Calendar.YEAR)!= test.get(Calendar.YEAR)) |
				(dato.get(Calendar.MONTH)!= test.get(Calendar.MONTH))|
				(dato.get(Calendar.DAY_OF_MONTH)!= test.get(Calendar.DAY_OF_MONTH)))
			return false;
		return true;
	}
}
