package curso.g10.junit1.almacenes;

import java.util.Vector;

public class AlmacenImpl extends Almacen{
	protected int cantidad;
	protected String nombreArticulo;
	protected Vector mMovimientos;

	public AlmacenImpl() {
		
		mMovimientos = new Vector();
	}

	
	public void ingresar(String concepto, double x) throws Exception {
		if (x <= 0)
			throw new Exception("No se puede ingresar una cantidad negativa");
		Movimiento m = new Movimiento();
		m.setConcepto(concepto);
		m.setImporte(x);
		this.mMovimientos.addElement(m);
	}

	public void retirar(String concepto, double x) throws Exception {
		if (x <= 0)
			throw new Exception("No se puede retirar una cantidad negativa");
		if (getSaldo() < x)
			throw new Exception("Saldo insuficiente");
		Movimiento m = new Movimiento();
		m.setConcepto(concepto);
		m.setImporte(-x);
		this.mMovimientos.addElement(m);
	}

	public double getSaldo() {
		double r = 0.0;
		for (int i = 0; i < this.mMovimientos.size(); i++) {
			Movimiento m = (Movimiento) mMovimientos.elementAt(i);
			r += m.getImporte();
		}
		return r;
	}

	public void addMovimiento(Movimiento m)
		{
		mMovimientos.addElement(m);
		}
	public void verMovimientos() {
		
		for (int i = 0; i < this.mMovimientos.size(); i++) {
			Movimiento m = (Movimiento) mMovimientos.elementAt(i);
			System.out.println(m.mConcepto+ "\t\t"+m.mImporte);
		}
		
	}
	
	public int getInventory(String articulo){
		return 0;
		
	
	}
}