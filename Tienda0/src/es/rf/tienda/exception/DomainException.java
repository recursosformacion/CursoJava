package es.rf.tienda.exception;

@SuppressWarnings("serial")
public class DomainException extends Exception {
	
	public DomainException(){
		super();
	}
	
	public DomainException(String mensaje) {
		super(mensaje);
		
	}
	
	

}
