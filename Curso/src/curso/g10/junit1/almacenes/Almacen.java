package almacenes;

import java.util.Vector;

public abstract class Almacen {
	

	

	
	public abstract void ingresar(String concepto, double x) throws Exception ;

	public abstract void retirar(String concepto, double x) throws Exception ;

	public abstract double getSaldo() ;

	public abstract void addMovimiento(Movimiento m);
		
	public abstract void verMovimientos();

	public abstract int getInventory(String S); 
}