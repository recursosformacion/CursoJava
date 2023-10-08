package curso.g10.junit0;

import java.io.Serializable;
import java.util.Calendar;

public abstract class Tarjeta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String X_NUMERO = "NUMERO";
	public static final String X_FECHA_CADUCIDAD = "FECHACADUCIDAD";
	public static final String X_CUENTA_ASOCIADA = "CUENTAASOCIADA";
	
	private String mNumero, mTitular;
	private Calendar mFechaDeCaducidad;
	private Cuenta mCuentaAsociada;

	public Tarjeta(String numero, String titular, Calendar fechaCaducidad) {
		mNumero = numero;
		mTitular = titular;
		mFechaDeCaducidad = fechaCaducidad;
	}

	public void setCuenta(Cuenta c) {
		mCuentaAsociada = c;
	}

	public abstract void retirar(double x) throws Exception;

	public abstract void ingresar(double x) throws Exception;

	public abstract void pagoEnEstablecimiento(String datos, double x) throws Exception;

	public abstract double getSaldo();

	public String getmNumero() {
		return mNumero;
	}

	public void setmNumero(String mNumero) {
		this.mNumero = mNumero;
	}

	public String getmTitular() {
		return mTitular;
	}

	public void setmTitular(String mTitular) {
		this.mTitular = mTitular;
	}

	public Calendar getmFechaDeCaducidad() {
		return mFechaDeCaducidad;
	}

	public void setmFechaDeCaducidad(Calendar mFechaDeCaducidad) {
		this.mFechaDeCaducidad = mFechaDeCaducidad;
	}

	public Cuenta getmCuentaAsociada() {
		return mCuentaAsociada;
	}

	public void setmCuentaAsociada(Cuenta mCuentaAsociada) {
		this.mCuentaAsociada = mCuentaAsociada;
	}
	
	public String toXML(){
		String salida="";
		salida +=Rutinas.etiquetar(X_NUMERO, getmNumero());
		salida +=Rutinas.etiquetar(X_FECHA_CADUCIDAD, Rutinas.convierteAString(getmFechaDeCaducidad()));
		salida +=getmCuentaAsociada().toXML(X_CUENTA_ASOCIADA);
		
		
		
		
		
		return salida;
	}
}
