package curso.g10.junit0;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Rutinas {
	
	/**
	 * Crea un dato etiquetado
	 * @param etiqueta
	 * @param valor
	 * @return
	 */
	public static String etiquetar(String etiqueta,String valor){
		String salida = "<" + etiqueta + ">";
		salida += valor;
		salida += "</" + etiqueta + ">";
		return salida;
	}

	/**
	 * Recibe una fecha en formato dd/mm/yyyy y devuelve un objeto Calendar con
	 * dicho valor
	 * 
	 * @param fecha
	 * @return
	 */
	public static Calendar convierteACalendar(String fecha) {
		if (fecha != null && fecha.length() > 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Calendar calendar = Calendar.getInstance();
			try {
				calendar.setTime(sdf.parse(fecha));
			} catch (ParseException e) {
				return null;
			}
			return calendar;
		} else
			return null;
	}

	public static String convierteAString(Calendar fecha) {
		if (fecha != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			return sdf.format(fecha.getTime());
		} else
			return "";
	}

	public static boolean esFechaLogica(String fecha) {
		Calendar test = convierteACalendar(fecha);
		if (test != null) {
			String testS = convierteAString(test);
			return fecha.equals(testS);
		}
		return false;
	}

	public static String addCampo(String salida, String nombreCampo, Calendar valor, String separador) {
		if (valor != null)
			return addSalidaSencilla(salida, nombreCampo, "'" + Rutinas.convierteAString(valor) + "'", separador);
		else
			return addSalidaSencilla(salida, nombreCampo, null, separador);

	}

	public static String addCampo(String salida, String nombreCampo, double valor, String separador) {
		salida = Rutinas.addSalidaSencilla(salida, nombreCampo, "" + valor, separador);
		return salida;
	}

	public static String addCampo(String salida, String nombreCampo, long valor, String separador) {
		salida = Rutinas.addSalidaSencilla(salida, nombreCampo, "" + valor, separador);
		return salida;
	}

	public static String addCampo(String salida, String nombreCampo, String valor, String separador) {
		if (valor != null)
			return addSalidaSencilla(salida, nombreCampo, "'" + valor + "'", separador);
		else
			return addSalidaSencilla(salida, nombreCampo, null, separador);
	}
	/*
	 * String salida=""; salida=addSalida(salida,"importe",134.20,",");
	 * ---------------->salida = importe=134.20
	 * salida=addSalida(salida,"nombre","Miguel",","; ---------------->salida =
	 * importe=134.20,nombre="Miguel" salida=addSalida(salida,"tipo",22,",")
	 * ---------------->salida = importe=134.20,nombre="Miguel",tipo=22
	 */

	/**
	 * Completa SQL A�adiendo el nombre del campo y su valor (sis e pasa)
	 * Pensado para INSERT y UPDATES
	 * 
	 * @param salida
	 * @param nombreCampo
	 * @param valor
	 * @param separador
	 * @return Devuelve una string con los valores a�adidos
	 */

	/**
	 * Recibe una String parcialmente construida y que tiene que completar, El
	 * nombre del campo se a�ade solo si no es nulo A continuacion del nombre
	 * del campo, se a�ade un signo "=" solo si se ha a�adido nombre del campo a
	 * continuacion se a�ade el valor recibido
	 * 
	 * @param salida
	 *            : Parte de la string ya construida
	 * @param nombreCampo
	 *            : Nombre del campo que se va a a�adir
	 * @param valor
	 *            : Valor del campo
	 * @param separador
	 *            : Separador que se tiene que a�adir entre campos
	 * @return : String que recibimos parcialmente construida a la que le hemos
	 *         añadido el nuevo campo
	 */
	public static String addSalidaSencilla(String salida, String nombreCampo, String valor, String separador) {
		if (salida != null && salida.length() > 0)
			salida += " " + separador + " ";
		if (nombreCampo != null && nombreCampo.length() != 0)
			salida += nombreCampo + " = ";
		salida += valor;
		return salida;
	}

}
