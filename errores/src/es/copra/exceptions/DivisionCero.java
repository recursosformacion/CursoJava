package es.copra.exceptions;

public class DivisionCero extends RuntimeException {
	public DivisionCero(){
		super();
		
	}
	
	public DivisionCero(String mensaje){
		super(mensaje);
	}
}
