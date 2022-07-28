package curso.g10.junit0;

import java.util.Vector;

public class Cuenta {
	protected String mNumero;
	protected String mTitular;
	protected Vector<Movimiento> mMovimientos;

	public Cuenta(String numero, String titular) {
		this.mNumero = numero;
		mTitular = titular;
		mMovimientos = new Vector<Movimiento>();
	}

	public void retirar(double x) throws Exception {
		retirar("Retirada de efectivo", x);
	}

	public void ingresar(double x) throws Exception {
		ingresar("Ingreso en efectivo", x);
	}

	public void ingresar(String concepto, double x) throws Exception {
		if (x <= 0)
			throw new Exception("No se puede ingresar una cantidad negativa");
		addMovimiento(concepto, x);
	}

	public void retirar(String concepto, double x) throws Exception {
		if (x <= 0) {
			throw new Exception("No se puede retirar una cantidad negativa");
		}
		if (getSaldo() < x) {
			throw new Exception("Saldo insuficiente");
		}

		addMovimiento(concepto, -x);
	}

	public double getSaldo() {
		double r = 0.0;
//		for (int i = 0; i < this.mMovimientos.size(); i++) {
//			Movimiento m = mMovimientos.elementAt(i);
//			r += m.getImporte();
//		}
		
		for (Movimiento m : mMovimientos) {
			r += m.getImporte();
		}
		
		return r;
	}

	public void addMovimiento(String concepto, double importe) {
		Movimiento m = new Movimiento();
		m.setConcepto(concepto);
		m.setImporte(importe);
		addMovimiento(m);
	}
	public void addMovimiento(Movimiento m) {
		mMovimientos.addElement(m);
	}

	public void verMovimientos() {
		ListarMovimientos.print("*********************Listado movimientos cuenta******************", mMovimientos);

	}
}