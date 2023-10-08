package es.rf.tienda.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Rutinas {
	
	public static String mensajes(String mensaje, String[] datos){
		String salida="";
		int contador=0;
		for (int a = 0; a < mensaje.length();a++){
			if (mensaje.charAt(a)=='?'){
				if (contador<=datos.length)
					salida +=datos[contador++];
				else
					salida +="?" + contador++ + "?";
			}
			else
				salida += mensaje.charAt(a);
		}
		
		return salida;
	}
	public static Calendar convierteACalendar(String fecha){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sdf.parse(fecha));
		} catch (ParseException e) {
			return null;
		}
		return calendar;
	}
	public static String Calendar2String( Calendar c){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(c.getTime());	
	}
	

	
	/**
	 * Completa SQL Añadiendo el nombre del campo (si se pasa) y su valor 
	 * Pensado para INSERT y UPDATES
	 * @param salida
	 * @param nombreCampo
	 * @param valor
	 * @param separador
	 * @return Devuelve una string con los valores añadidos
	 */
	public static String addSalida(String salida,String nombreCampo, int valor, String separador){
		if (valor>0 || (nombreCampo==null || nombreCampo.length()==0))
			return addSalidaSencilla( salida, nombreCampo,  ""+valor,  separador);
		else
			return salida;
	}
	public static String addSalida(String salida,String nombreCampo, double valor, String separador){
		return addSalidaSencilla( salida, nombreCampo,  ""+valor,  separador);
	}
	public static String addSalida(String salida,String nombreCampo, long valor, String separador){
		return addSalidaSencilla( salida, nombreCampo,  ""+valor,  separador);
	}
	public static String addSalida(String salida,String nombreCampo, String valor, String separador){
		return addSalidaSencilla( salida, nombreCampo, "'"+ valor + "'",  separador);
	}	
	/**
	 * Recibe una String parcialmente construida y que tiene que completar, 	
	 * El nombre del campo se añade solo si no es nulo
	 * A continuacion del nombre del campo, se añade un signo "=" solo si se ha añadido nombre del campo
	 * a continuacion se añade el valor recibido
	 * 
	 * @param salida		: Parte de la string ya construida
	 * @param nombreCampo   : Nombre del campo que se va a añadir
	 * @param valor         : Valor del campo
	 * @param separador		: Separador que se tiene que añadir entre campos
	 * @return				: String que recibimos parcialmente construida a la que le hemos añadido el nuevo campo
	 */
	public static String addSalidaSencilla(String salida,String nombreCampo, String valor, String separador){	
		if (salida.length()>0)
				salida += " " + separador + " ";
		if (nombreCampo!=null && nombreCampo.compareTo("")>0)
			salida +=nombreCampo + " = " ;
		salida += valor;
		return salida;
	}
	
	
	
	
	
}
