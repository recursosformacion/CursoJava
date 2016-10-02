package curso.g10.junit0;

import java.util.Vector;
import java.util.Calendar;

public class Credito extends Tarjeta {
	protected double mCredito;
	protected Vector<Movimiento> mMovimientos;

	public Credito(String numero, String titular, Calendar fechaCaducidad, double credito) {
		super(numero, titular, fechaCaducidad);
		mCredito = credito;
		mMovimientos = new Vector<Movimiento>();
	}

	public void retirar(double x) throws Exception {
		Movimiento m = new Movimiento();
		m.setConcepto("Retirada en cajero automatico");
		x = (x * 0.05 < 3.0 ? 3 : x * 0.05); // Añadimos una comision de un 5%,
												// minimo de 3 euros.
		m.setImporte(x);
		mMovimientos.addElement(m);
		if (x > getCreditoDisponible())
			throw new Exception("Credito insuficiente");
	}

	public void ingresar(double x) throws Exception {
		Movimiento m = new Movimiento();
		m.setConcepto("Ingreso en cuenta asociada (cajero automatico)");
		m.setImporte(x);
		mMovimientos.addElement(m);
		mCuentaAsociada.ingresar(x);
	}

	public void pagoEnEstablecimiento(String datos, double x) throws Exception {
		Movimiento m = new Movimiento();
		m.setConcepto("Compra a credito en: " + datos);
		m.setImporte(x);
		mMovimientos.addElement(m);
	}

	public double getSaldo() {
		double r = 0.0;
		for (int i = 0; i < this.mMovimientos.size(); i++) {
			Movimiento m = (Movimiento) mMovimientos.elementAt(i);
			r += m.getImporte();
		}
		return r;
	}

	public double getCreditoDisponible() {
		return mCredito - getSaldo();
	}

	public void liquidar(int mes, int anno) {
		Movimiento liq = new Movimiento();

		liq.setConcepto("Liquidacion de operaciones tarj. credito, " + (mes + 1) + " de " + (anno + 1900));
		double r = 0.0;
		for (int i = 0; i < this.mMovimientos.size(); i++) {
			Movimiento m = (Movimiento) mMovimientos.elementAt(i);
			if (m.getFecha().get(Calendar.MONTH) + 1 == mes && m.getFecha().get(Calendar.YEAR) == anno) {
				r += m.getImporte();
				mMovimientos.remove(i);
			}
		}
		liq.setImporte(r);
		if (r != 0)
			mCuentaAsociada.addMovimiento(liq);
	}
}
