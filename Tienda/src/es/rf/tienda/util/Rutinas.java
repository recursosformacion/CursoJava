package es.rf.tienda.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Rutinas {
	
	
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
	public static String convierteAString(Calendar fecha){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM"
				+ "/yyyy");		
		return sdf.format(fecha.getTime());
	}
	/**
	 * Completa SQL A�adiendo el nombre del campo y su valor (sis e pasa)
	 * Pensado para INSERT y UPDATES
	 * @param salida
	 * @param nombreCampo
	 * @param valor
	 * @param separador
	 * @return Devuelve una string con los valores a�adidos
	 */
	public static String addSalida(String salida,String nombreCampo, int valor, String separador){
		return addSalidaSencilla( salida, nombreCampo,  ""+valor,  separador);
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
		
	public static String addSalidaSencilla(String salida,String nombreCampo, String valor, String separador){	
		if (salida.length()>0)
				salida += " " + separador + " ";
		if (nombreCampo!=null && nombreCampo.compareTo("")>0)
			salida +=nombreCampo + " = " ;
		salida += valor;
		return salida;
	}
	
	
	
	
	
}
