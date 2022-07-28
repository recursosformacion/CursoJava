package es.rf.banco.app;

public class ImporteNegativo extends Exception {

	ImporteNegativo(){}
	
	ImporteNegativo(String mensaje){
		super(mensaje);
	}
	
}
