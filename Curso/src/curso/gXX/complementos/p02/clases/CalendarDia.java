package curso.g09.complementos.p02.clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarDia {

	/*
	 * metodo Hoy
	 * 
	 * Devolver la fecha actual en formato largo jueves, 14 de julio de 2016
	 * 
	 * 
	 */
	public String hoy() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy");
		return sdf.format(cal.getTime());
	}

	/*
	 * metodo aplazar parametros: numero de dias aplazados
	 * 
	 * devolver la fecha que sera dentro de el numero de dias indicado en
	 * parametros en formato corto.
	 * 
	 * 
	 */

	public String aplazado(int dias) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, dias);
		return sdf.format(cal.getTime());
	}

	/*
	 * metodo Distancia parametros: fecha1, fecha2 retorna el numero de dias
	 * entre las fechas
	 * 
	 */
	public int distancia(Calendar dia1, Calendar dia2) {

		if (dia1.get(Calendar.YEAR) == dia2.get(Calendar.YEAR)) {
			return Math.abs(dia1.get(Calendar.DAY_OF_YEAR) - dia2.get(Calendar.DAY_OF_YEAR));
		} else {
			return 365 - dia1.get(Calendar.DAY_OF_YEAR) + dia2.get(Calendar.DAY_OF_YEAR);
		}
	}
	
	/**
	 * 
	 * Recibe una String con fecha en formato dd/mm/yyyy y comprueba
	 * que la fecha es correcta y es inferior a la techa que indican como maxima
	 * 
	 * @param fechaMax
	 * @param fechaEntrada
	 * @return
	 */
	public boolean filtrarFechaMax(Calendar fechaMax, String fechaEntrada) {

		return true;
	}
	
	/**
	 * metodo: filtrarFechaMin
	 * Descripcion: Recibe una String con fecha en formato dd/mm/yyyy y comprueba
	 * que la fecha es correcta y es superior a la techa que indican como minima
	 * 
	 * @param fechaMin
	 * @param fechaEntrada
	 * @return
	 */
	public boolean filtrarFechaMin(Calendar fechaMin, String fechaEntrada) {

		return true;
	}

	/**
	 * string2Calendar
	 * 
	 * Recibe una string en formato dd/mm/yyyy y devuelve un calendar
	 * 
	 * @param entrada
	 * @return
	 */
	public Calendar string2Calendar(String entrada){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sdf.parse(entrada));
		} catch (ParseException e) {
			return null;
		}
		return calendar;
	}
	
	
	/**
	 * calendar2String
	 * Recibe un objeto calendar y devuelve una String con formato DD/MM/YYYY
	 * @param cal
	 * @return
	 */
	public String calendar2String(Calendar cal){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
		return sdf.format(cal.getTime())	;
	}
	
	
	
	
	public int distanciaOK(Calendar f1, Calendar f2) {
		Calendar dia1 = (Calendar) f1.clone();
		Calendar dia2 = (Calendar) f2.clone();

		if (dia1.get(Calendar.YEAR) == dia2.get(Calendar.YEAR)) {
			return Math.abs(dia1.get(Calendar.DAY_OF_YEAR) - dia2.get(Calendar.DAY_OF_YEAR));
		} else {
			if (dia2.get(Calendar.YEAR) > dia1.get(Calendar.YEAR)) {
				// swap them
				Calendar temp = dia1;
				dia1 = dia2;
				dia2 = temp;
			}
			int extraDays = 0;

			int dia1OriginalYearDays = dia1.get(Calendar.DAY_OF_YEAR);

			while (dia1.get(Calendar.YEAR) > dia2.get(Calendar.YEAR)) {
				dia1.add(Calendar.YEAR, -1);
				// getActualMaximum() !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				extraDays += dia1.getActualMaximum(Calendar.DAY_OF_YEAR);
			}

			return extraDays - dia2.get(Calendar.DAY_OF_YEAR) + dia1OriginalYearDays;
		}
	}
}
