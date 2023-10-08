package es.rf.tienda.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/********************************************************************************************
 * NOMBRE: Validator.java
 * 
 * DESCRIPCION: Clase auxiliar para validar los datos que sean introducidos en
 * la aplicaci�n.
 * 
 * @version 30/01/2016
 * @author Miguel Garcia
 * 
 ******************************************************************************************/
public class Validator {

	private static final String ALFANUMERIC_PATTERN = "^[0-9a-zA-Z ]+$";

	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	/**
	 * Patr�n para validar el email, evitando puntos finales antes de la @ y que
	 * solo contenga car�cteres alfanum�ricos
	 */
	private final static String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	/**
	 * Permite verificar que un DNI cumple con el patr�n XX.XXX.XXX-L
	 */
	private final static String DNI_PATTERN = "\\d{2}\\.\\d{3}\\.\\d{3}-[a-zA-Z]";

	/**
	 * Permite validar un tel�fono, el cual debe contener de 10 a 20 d�gitos y
	 * donde los espacios est�n permitidos
	 */
	private final static String PHONE_PATTERN = "[\\d ]{10,20}";

	/**
	 * Orden de las letras con las cuales se comprobar� la validez del DNI
	 */
	private final static String LETRA_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";

	/**
	 * Longitud que debe tener todo DNI pasado a la aplicaci�n.
	 */
	private final static int LONGITUD_DNI = 12;

	private final static String COD_PRODUCTO = "[A-Z]{2}[\\d]{3}";

	public static boolean isCodigoProducto(String texto) {
		if (texto == null || texto.length() == 0)
			return false;
		Pattern pattern = Pattern.compile(COD_PRODUCTO);
		Matcher matcher = pattern.matcher(texto);
		return matcher.matches();
		// return texto.matches(COD_PRODUCTO);
	}

	public static boolean isNumeric(String valor) {
		try {
			double x = Double.parseDouble(valor);
		} catch (ArithmeticException e) {
			return false;
		}
		return true;
	}

	/*
	 * *************************************************************************
	 * ************** NOMBRE: isAlfanumeric *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * Permite verificar que el texto pasado solo contiene caracters
		 * alfanum�ricos
		 * 
		 * @param texto
		 *            String a verificar que solo tenga car�cteres alfanum�ricos
		 * 
		 * @return true, si cumple solo contiene caracters alfanum�ricos. <br>
		 *         false en caso contrario FECHA: Enero 2016
		 * 
		 *         AUTOR: Miguel Garcia - Barcelona
		 * 
		 **************************************************************************************/
	public static boolean isAlfanumeric(String texto) {
		Pattern pattern = Pattern.compile(ALFANUMERIC_PATTERN);
		Matcher matcher = pattern.matcher(texto);
		return matcher.matches();
	}

	public static boolean isVacio(final String prueba) {
		return (prueba == null || prueba.equals(""));
	}

	/*
	 * *************************************************************************
	 * ************** NOMBRE: cumplePhoneNumber *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * El phone number debe tener un total de entre 10 y 20, contando
		 * d�gitos y espacios. M�nimo aceptable son 10 d�gitos.
		 * 
		 * @param phoneNumber
		 *            String con el n�mero de telefono de entre 10 y 20 d�gitos.
		 *            Puede tener espacios, pero siempre con 10 d�gitos como
		 *            m�nimo.
		 * 
		 * @return true, si cumple todas las condiciones
		 *
		 *         FECHA: Enero 2016 AUTOR: Miguel Garcia
		 * 
		 **************************************************************************************/
	public static boolean cumplePhoneNumber(String phoneNumber) {
		return phoneNumber.matches(PHONE_PATTERN) && phoneNumber.replace(" ", "").matches("\\d{10,}");
	}

	/*
	 * *************************************************************************
	 * ************** NOMBRE: isEmailValido *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * Comprueba si el email tiene un formato que pueda ser v�lido.
		 * 
		 * @param email
		 *            String a comprobar
		 * 
		 * @return true, en caso que el formato sea v�lido FECHA: Enero 2016
		 * 
		 *         AUTOR: Miguel Garcia
		 * 
		 **************************************************************************************/
	public static boolean isEmailValido(String email) {
		if (email == null) {
			return false;
		}

		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.find();
	}

	/*
	 * *************************************************************************
	 * ************** NOMBRE: cumpleDNI *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * Esta funci�n verifica que el DNI cumple el siguiente formato:
		 * xx.xxx.xxx-L <br>
		 * El DNI ha de tener longitud 12
		 * 
		 * @param dni
		 *            String con DNI a ser validado
		 * 
		 * @return true, si el DNI cumple el estandar nacional. FECHA: Enero
		 *         2016 AUTOR: Miguel Garcia
		 * 
		 **************************************************************************************/
	public static boolean cumpleDNI(String dni) {
		if (dni == null) {
			return false;
		}

		// si es un NIE se hacen las operaciones necesarias para poder calcular
		// luego la letra correcta
		if (dni.startsWith("X")) {
			dni = dni.replaceFirst("X", "0");
		} else if (dni.startsWith("Y")) {
			dni = dni.replaceFirst("Y", "1");
		} else if (dni.startsWith("Z")) {
			dni = dni.replaceFirst("Z", "2");
		}

		if (dni.length() != LONGITUD_DNI) {
			return false;
		}

		if (!dni.matches(DNI_PATTERN)) { // se comprueba que el formato del DNI
											// se ajusta al patr�n definido
			return false;
		}

		String dniNumerico = dni.substring(0, dni.length() - 2).replace(".", "");
		int valorNumerico = Integer.parseInt(dniNumerico);

		Character letraDNI = Character.toUpperCase(dni.charAt(dni.length() - 1));

		if (LETRA_DNI.charAt(valorNumerico % 23) == letraDNI) {
			return true;
		} else {
			return false;
		}
	}

	/***************************
	 * alternativo ************************** public static boolean
	 * verDNI(String dni) {
	 * 
	 * Validador val = new Validador(); int ret = val.checkNif(dni); if (ret >
	 * 0) { return true; } else { return false; } }
	 */

	/**
	 * ***************************************************************************************
	 * NOMBRE: cumpleRango *
	 * 
	 * DESCRIPCI�N:
	 */
	/**
	 * Comprueba que un N�mero se necuentra entre 2 valores
	 * 
	 * @param valor
	 *            (int)/(double) N�mero a comprobar
	 * @param valorMinimo
	 *            (int) N�mero valor aceptable
	 * @param valorMaximo
	 *            (int) M�N�mero valor aceptable
	 * 
	 * @return true si valorMinimo > valor > valorMaximo FECHA: Enero 2016
	 *         AUTOR: Miguel Garcia
	 * 
	 **************************************************************************************/
	public static boolean cumpleRango(int valor, int valorMinimo, int valorMaximo) {
		return valor >= valorMinimo && valor <= valorMaximo;
	}

	public static boolean cumpleRango(double valor, int valorMinimo, int valorMaximo) {
		return valor >= valorMinimo && valor <= valorMaximo;
	}

	/*
	 * *************************************************************************
	 * ************** NOMBRE: cumpleLongitudMin *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * Comprobar que el texto pasado tiene una longitud de al menos x
		 * caracteres, siendo x el entero pasado como par�metro
		 * 
		 * @param texto
		 *            String texto a comprobar
		 * @param longitudMinima
		 *            int que indique longitud m�nima.
		 * 
		 * @return cierto, si la longitud del texto es mayor o igual que
		 *         longitudMinima FECHA: Enero 2016 AUTOR: Miguel Garcia
		 * 
		 **************************************************************************************/
	public static boolean cumpleLongitudMin(String texto, int longitudMinima) {
		return texto != null && texto.length() >= longitudMinima;
	}

	/*
	 * *************************************************************************
	 * ************** NOMBRE: cumpleLongitudMax *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * Comprobar que el texto pasado tiene una longitud de, como mucho, x
		 * caracteres, siendo x el entero pasado como par�metro
		 * 
		 * @param texto
		 *            String con el texto a comprobar
		 * @param longitudMaxima
		 *            int con la longitud m�xima del texto
		 * 
		 * @return true, si el texto es menor o igual que la longitud m�xima.
		 *         FECHA: Enero 2016 AUTOR: Miguel Garcia
		 * 
		 **************************************************************************************/
	public static boolean cumpleLongitudMax(String texto, int longitudMaxima) {
		return texto != null && texto.length() <= longitudMaxima;
	}

	/****************************************************************************************
	 * NOMBRE: cumpleLongitud *
	 * 
	 * DESCRIPCI�N:
	 */
	/**
	 * Comprobar que la longitud de un texto se encuentra entre unos valores
	 * m�ximos y m�nimos
	 * 
	 * @param texto
	 *            String con el texto que a validar
	 * @param longitudMinima
	 *            (int) M�nima longitud del texto
	 * @param longitudMaxima
	 *            (int) M�xima longitud v�lida para el texo
	 * 
	 * @return true, si la longitud del texto cumple: longitudMinima <=
	 *         longitudTexto <=longitudMaxima FECHA: Enero 2016 AUTOR: Miguel
	 *         Garcia - Barcelona
	 * 
	 **************************************************************************************/
	public static boolean cumpleLongitud(String texto, int longitudMinima, int longitudMaxima) {

		return texto != null && cumpleLongitudMin(texto, longitudMinima) && cumpleLongitudMax(texto, longitudMaxima);

	}

	/**
	 * Valida una fecha calendar con m�nimo min
	 * 
	 * @param fecha
	 * @param min
	 * @return
	 */

	public static boolean valDateMin(Calendar fecha, Calendar min) {
		Calendar aux = min;
		aux.add(Calendar.DAY_OF_YEAR, -1);
		fecha.setLenient(false);
		if (fecha.after(aux))
			return true;
		else
			return false;
	}

	/**
	 * Valida una fecha calendar con m�ximo max
	 * 
	 * @param fecha
	 * @param max
	 * @return
	 */
	public static boolean valDateMax(Calendar fecha, Calendar max) {
		Calendar aux = max;
		fecha.setLenient(false);
		if (fecha.before(aux))
			return true;
		else
			return false;
	}

	/**
	 * esFechaValida Recibe una string con formato fecha dd/mm/aaaa y comprueba
	 * el formato
	 * 
	 * @param fecha
	 * @return
	 */
	public static boolean esFechaValida(String fecha) {
		if (fecha != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Calendar calendar = Calendar.getInstance();
			try {
				calendar.setTime(sdf.parse(fecha));
			} catch (ParseException e) {
				return false;
			}

			return (fecha.compareTo(sdf.format(calendar.getTime())) == 0);
		}
		return false;

	}

	/**
	 * Nombre esPasswordValida Descripcion Comprueba que la cadena recibida
	 * cumpla con lasnormas de contrase�a
	 * 
	 * @param password
	 *            string con la contrase�a introducida
	 * @return true si cumple con las especificaciones
	 */
	public static boolean esPasswordValida(String password) {
		Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();

	}
}
