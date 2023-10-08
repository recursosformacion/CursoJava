package curso.g10.junit0;

import java.util.Vector;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Optional;

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
		x = (x * 0.05 < 3.0 ? 3 : x * 0.05) + x; // Añadimos una comision de un 5%,
												// minimo de 3 euros.
		m.setImporte(-x);
		
		if (x > getCreditoDisponible())
			throw new Exception("Credito insuficiente");
		else
			mMovimientos.add(m);
	}

	public void ingresar(double x) throws Exception {
		Movimiento m = new Movimiento();
		m.setConcepto("Ingreso en cuenta asociada (cajero automatico)");
		m.setImporte(x);
		mMovimientos.addElement(m);
		//mCuentaAsociada.ingresar(x);
	}

	public void pagoEnEstablecimiento(String datos, double x) throws Exception {
		Movimiento m = new Movimiento();
		m.setConcepto("Compra a credito en: " + datos);
		m.setImporte(-x);
		mMovimientos.add(m);
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
		return mCredito + getSaldo();
	}

	public void liquidar(int mes, int anno) {
		verMovimientos();
		Movimiento m;
		Movimiento liq = new Movimiento();
		liq.setConcepto("Liquidacion de operaciones tarj. credito, " + (mes + 1) + " de " + anno);
		double r = 0.0;
		
		Iterator<Movimiento> mov = mMovimientos.iterator();
		while (mov.hasNext()) {
			m= mov.next();
			if (m.getFecha().get(Calendar.MONTH) == mes && m.getFecha().get(Calendar.YEAR) == anno) {
				r += m.getImporte();
				mov.remove();
			}
		}

// con stream ----------------------------------------------------------
//		Optional<Double> total = mMovimientos.stream()
//				.filter(x-> x.getFecha().get(Calendar.MONTH) == mes && x.getFecha().get(Calendar.YEAR) == anno)
//				.map(x -> x.getImporte())
//				.reduce(Double::sum);
//		mMovimientos.removeIf(x-> x.getFecha().get(Calendar.MONTH) == mes && x.getFecha().get(Calendar.YEAR) == anno);		
				
				
				
				
				//		for (int i = 0; i < this.mMovimientos.size(); i++) {
//			m = (Movimiento) mMovimientos.elementAt(i);
//			if (m.getFecha().get(Calendar.MONTH) == mes && m.getFecha().get(Calendar.YEAR) == anno) {
//				r += m.getImporte();
//				mMovimientos.remove(i);
//			}
//		}
		liq.setImporte(r);
		if (r != 0)
			mCuentaAsociada.addMovimiento(liq);
	}
	
	public void verMovimientos() {
		ListarMovimientos.print("*********************Listado movimientos tarjeta******************", mMovimientos);

	}
}
