package curso.g10.junit0;

public class SaldoInsuficiente extends Exception {

	SaldoInsuficiente(){}
	
	SaldoInsuficiente(String mensaje){
		super(mensaje);
	}
	
}
