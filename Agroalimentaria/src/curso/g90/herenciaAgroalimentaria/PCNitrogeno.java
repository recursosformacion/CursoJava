package curso.g90.herenciaAgroalimentaria;

import java.util.Calendar;

class PCNitrogeno extends PCongelados {
	private int segundos;
	private String metodo;
	public int getSegundos() {
		return segundos;
	}
	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}
	public String getMetodo() {
		return metodo;
	}
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	public PCNitrogeno() {
		super();
		
	}
	public PCNitrogeno(Calendar fechaCaducidad, int numeroLote, int temperatura, String metodo, int segundos) {
		super(fechaCaducidad, numeroLote, temperatura);
		setMetodo(metodo);
		setSegundos(segundos);
	}
	
	@Override
	public String toString(){
		return super.toString() +
				" Metodo:"+ getMetodo() + 
				" Tiempo de exposicion:" + getSegundos();
	}
	
}
