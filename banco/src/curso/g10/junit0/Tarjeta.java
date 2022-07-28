package curso.g10.junit0;

import java.util.Calendar;

public abstract class Tarjeta {
	protected String mNumero, mTitular;
	protected Calendar mFechaDeCaducidad;
	protected Cuenta mCuentaAsociada;

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
}
