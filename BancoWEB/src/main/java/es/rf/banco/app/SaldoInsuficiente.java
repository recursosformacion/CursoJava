package es.rf.banco.app;

public class SaldoInsuficiente extends Exception {

	SaldoInsuficiente(){}
	
	SaldoInsuficiente(String mensaje){
		super(mensaje);
	}
	
}
