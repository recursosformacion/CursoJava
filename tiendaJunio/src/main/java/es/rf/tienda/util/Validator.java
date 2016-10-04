package es.rf.tienda.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* ******************************************************************************************
 * NOMBRE: Validator.java
 * 
 * DESCRIPCION: *//**
					 * Clase auxiliar para validar los datos que sean
					 * introducidos en la aplicación.
					 * 
					 * @version 30/01/2016
					 * @author Miguel Garcia
					 * 
					 ******************************************************************************************/
public class Validator {

	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

	/**
	 * Patrón para validar el email, evitando puntos finales antes de la @ y que
	 * solo contenga carácteres alfanuméricos
	 */
	private final static String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	/**
	 * Permite verificar que un DNI cumple con el patrón XX.XXX.XXX-L
	 */
	private final static String DNI_PATTERN = "\\d{2}\\.\\d{3}\\.\\d{3}-[a-zA-Z]";

	/**
	 * Permite validar un teléfono, el cual debe contener de 10 a 20 dígitos y
	 * donde los espacios están permitidos
	 */
	private final static String PHONE_PATTERN = "[\\d ]{10,20}";

	/**
	 * Orden de las letras con las cuales se comprobará la validez del DNI
	 */
	private final static String LETRA_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";

	/**
	 * Longitud que debe tener todo DNI pasado a la aplicación.
	 */
	private final static int LONGITUD_DNI = 12;

	/*
	 * *************************************************************************
	 * ************** NOMBRE: isAlfanumeric *
	 * 
	 * DESCRIPCIÓN:
	 *//**
		 * Permite verificar que el texto pasado solo contiene caracters
		 * alfanuméricos
		 * 
		 * @param texto
		 *            String a verificar que solo tenga carácteres alfanuméricos
		 * 
		 * @return true, si cumple solo contiene caracters alfanuméricos. <br>
		 *         false en caso contrario FECHA: Enero 2016
		 * 
		 *         AUTOR: Miguel Garcia - Barcelona
		 * 
		 **************************************************************************************/
	public static boolean isAlfanumeric(String texto) {
		return texto.matches("[\\w áéíóúàèìòùäëïöüÁÉÍÓÚÀÈÌÒÙÄËÏÖÜ_-]*");
	}

	/*
	 * *************************************************************************
	 * ************** NOMBRE: cumplePhoneNumber *
	 * 
	 * DESCRIPCIÓN:
	 *//**
		 * El phone number debe tener un total de entre 10 y 20, contando
		 * dígitos y espacios. Mínimo aceptable son 10 dígitos.
		 * 
		 * @param phoneNumber
		 *            String con el número de telefono de entre 10 y 20 dígitos.
		 *            Puede tener espacios, pero siempre con 10 dígitos como
		 *            mínimo.
		 * 
		 * @return true, si cumple todas las condiciones
		 */
	/*
	 * FECHA: Enero 2016 AUTOR: Miguel Garcia
	 * 
	 **************************************************************************************/
	public static boolean cumplePhoneNumber(String phoneNumber) {
		return phoneNumber.matches(PHONE_PATTERN) && phoneNumber.replace(" ", "").matches("\\d{10,}");
	}

	/*
	 * *************************************************************************
	 * ************** NOMBRE: isEmailValido *
	 * 
	 * DESCRIPCIÓN:
	 *//**
		 * Comprueba si el email tiene un formato que pueda ser válido.
		 * 
		 * @param email
		 *            String a comprobar
		 * 
		 * @return true, en caso que el formato sea válido FECHA: Enero 2016
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
	 * DESCRIPCIÓN:
	 *//**
		 * Esta función verifica que el DNI cumple el siguiente formato:
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

		if (dni.length() != LONGITUD_DNI) {
			return false;
		}

		if (!dni.matches(DNI_PATTERN)) {
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

	// ************************** alternativo ***************************//
	public static boolean verDNI(String dni) {

/*		Validador val = new Validador();
		int ret = val.checkNif(dni);
		if (ret > 0) {
			return true;
		} else {
			return false;
		}*/
		return false;
	}

	/*
	 * *************************************************************************
	 * ************** NOMBRE: cumpleRango *
	 * 
	 * DESCRIPCIÓN:
	 *//**
		 * Comprueba que un número se necuentra entre 2 valores
		 * 
		 * @param valor
		 *            (int) Número a comprobar
		 * @param valorMinimo
		 *            (int) Mínimo valor aceptable
		 * @param valorMaximo
		 *            (int) Máximo valor aceptable
		 * 
		 * @return true si valorMinimo &le; valor &le; valorMaximo FECHA: Enero
		 *         2016 AUTOR: Miguel Garcia
		 * 
		 **************************************************************************************/
	public static boolean cumpleRango(int valor, int valorMinimo, int valorMaximo) {
		return valor >= valorMinimo && valor <= valorMaximo;
	}

	/*
	 * *************************************************************************
	 * ************** NOMBRE: cumpleLongitudMin *
	 * 
	 * DESCRIPCIÓN:
	 *//**
		 * Comprobar que el texto pasado tiene una longitud de al menos x
		 * caracteres, siendo x el entero pasado como parámetro
		 * 
		 * @param texto
		 *            String texto a comprobar
		 * @param longitudMinima
		 *            int que indique longitud mínima.
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
	 * DESCRIPCIÓN:
	 *//**
		 * Comprobar que el texto pasado tiene una longitud de, como mucho, x
		 * caracteres, siendo x el entero pasado como parámetro
		 * 
		 * @param texto
		 *            String con el texto a comprobar
		 * @param longitudMaxima
		 *            int con la longitud máxima del texto
		 * 
		 * @return true, si el texto es menor o igual que la longitud máxima.
		 *         FECHA: Enero 2016 AUTOR: Miguel Garcia
		 * 
		 **************************************************************************************/
	public static boolean cumpleLongitudMax(String texto, int longitudMaxima) {
		return texto != null && texto.length() <= longitudMaxima;
	}

	/*
	 * *************************************************************************
	 * ************** NOMBRE: cumpleLongitud *
	 * 
	 * DESCRIPCIÓN:
	 *//**
		 * Comprobar que la longitud de un texto se encuentra entre unos valores
		 * máximos y mínimos
		 * 
		 * @param texto
		 *            String con el texto que a validar
		 * @param longitudMinima
		 *            (int) Mínima longitud del texto
		 * @param longitudMaxima
		 *            (int) Máxima longitud válida para el texo
		 * 
		 * @return true, si la longitud del texto cumple: longitudMinima &le;
		 *         longitudTexto &le; longitudMaxima FECHA: Enero 2016 AUTOR:
		 *         Miguel Garcia - Barcelona
		 * 
		 **************************************************************************************/
	public static boolean cumpleLongitud(String texto, int longitudMinima, int longitudMaxima) {

		return texto != null && cumpleLongitudMin(texto, longitudMinima) && cumpleLongitudMax(texto, longitudMaxima);

	}

	public static void esFechaValida() {
	}

	public static boolean esPasswordValida(String password) {
		Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();

	}
}
