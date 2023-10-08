package es.rf.banco.app;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Movimiento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public final static String X_MOVIMIENTO = "MOVIMIENTO";
	public final static String X_CONCEPTO = "CONCEPTO";
	public final static String X_FECHA = "FECHA";
	public final static String X_IMPORTE = "IMPORTE";
	
	private String mConcepto;
	private Calendar mFecha;
	private double mImporte;

	 Movimiento() {
		mFecha = Calendar.getInstance();
	}

	public double getImporte() {
		return mImporte;
	}

	public String getConcepto() {
		return mConcepto;
	}

	public void setConcepto(String newMConcepto) {
		mConcepto = newMConcepto;
	}

	public Calendar getFecha() {
		return mFecha;
	}

	public void setFecha(Calendar newMFecha) {
		mFecha = newMFecha;
	}

	public void setImporte(double newMImporte) {
		mImporte = newMImporte;
	}
	
	public String toString(){
		
		String salida="Movimiento::";
		salida +=" Concepto:";
		salida +=getConcepto();
		salida +=" Fecha:";
		salida += Rutinas.convierteAString(getFecha());
		salida +=" Importe:";
		salida +=getImporte();
		
		return salida;
				
	}
public String toXML(){
		
		String salida="";
		salida +=Rutinas.etiquetar(X_CONCEPTO, getConcepto());
		salida +=Rutinas.etiquetar(X_FECHA, Rutinas.convierteAString(getFecha()));
		salida +=Rutinas.etiquetar(X_IMPORTE, getImporte()+"");

		return Rutinas.etiquetar(X_MOVIMIENTO, salida);
				
	}

}
