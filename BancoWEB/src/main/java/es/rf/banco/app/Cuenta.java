package es.rf.banco.app;

import java.io.Serializable;
import java.util.Vector;

import es.rf.banco.model.CuentaMo;

public class Cuenta extends CuentaMo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public final static String X_MOVIMIENTOS = "MOVIMIENTOS";
	public final static String X_CUENTA = "CUENTA";
	public final static String X_NUMERO = "NUMERO";
	public final static String X_TITULAR = "TITULAR";
	
	protected Vector<Movimiento> mMovimientos;
	
	public static final String INGRESO_EFECTIVO = "Ingreso en efectivo";
	public static final String RETIRADA_EFECTIVO = "Retirada de efectivo";

	public Cuenta(String numero, String titular) throws Exception {
		if ((numero!=null) && (numero.length()>0) ){
			if ((titular!=null) && (titular.length()>0) ){
				setmNumero(numero);
				setmTitular(titular);
				mMovimientos = new Vector<Movimiento>();
			} else
				throw new Exception("Titular no puede ser vacio");
		} else
			throw new Exception("Cuenta no puede ser vacio");		
	}

	

	public void ingresar(double x) throws ImporteNegativo  {		
		ingresar(INGRESO_EFECTIVO, x);
	}
	public void ingresar(String concepto, double x) throws ImporteNegativo {
		if (x <= 0)
			throw new ImporteNegativo("No se puede ingresar una cantidad negativa");
		Movimiento m = new Movimiento();
		m.setConcepto(concepto);
		m.setImporte(x);
		addMovimiento(m);
	}
	public void retirar(double x) throws Exception {
		retirar("Retirada de efectivo",x);
	}
	public void retirar(String concepto, double x) throws ImporteNegativo, SaldoInsuficiente  {
		if (x <= 0)
			throw new ImporteNegativo("No se puede retirar una cantidad negativa");
		if (getSaldo() < x)
			throw new SaldoInsuficiente("Saldo insuficiente");
		Movimiento m = new Movimiento();
		m.setConcepto(concepto);
		m.setImporte(-x);
		this.mMovimientos.addElement(m);
	}

	public double getSaldo() {
		double r = 0.0;
		for (int i = 0; i < this.mMovimientos.size(); i++) {
			Movimiento m =  mMovimientos.elementAt(i);
			r += m.getImporte();
		}
		return r;
	}

	public void addMovimiento(Movimiento m)
		{
		mMovimientos.addElement(m);
		}
	public void verMovimientos() {
		double r=0;
		for (int i = 0; i < this.mMovimientos.size(); i++) {
			Movimiento m = (Movimiento) mMovimientos.elementAt(i);
			r+=m.getImporte();
			System.out.println(m.getConcepto()+ "\t\t\t\t\t"+m.getImporte() + "\t" + r);
		}
		
	}




	
	public String toString(){
		String salida="Cuenta::";
		salida += " Numero:";
		salida += getmNumero();
		salida += " Titular:";
		salida += getmTitular();
		salida += " Movimientos:";
		for (int i = 0; i < this.mMovimientos.size(); i++) {
			salida += "("+i+")-"+ mMovimientos.elementAt(i).toString();
		}
		
		return salida;
	}
	
	public String toXML(String titulo){
		String salida2="";
		for (int i = 0; i < this.mMovimientos.size(); i++) {
			salida2 +=  mMovimientos.elementAt(i).toXML();
		}
		
		String salida="";
		salida +=  Rutinas.etiquetar(X_NUMERO, getmNumero());
		salida +=  Rutinas.etiquetar(X_TITULAR, getmTitular());
		salida +=  Rutinas.etiquetar(X_MOVIMIENTOS, salida2); 
		
		return Rutinas.etiquetar(titulo, salida);
	}
	
	public String toXML(){
		return toXML(X_CUENTA);
		
	}
	
}

