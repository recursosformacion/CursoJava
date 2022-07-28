package curso.g90.herenciaAgroalimentaria;

import java.util.Calendar;

public class PCongelados extends Productos {
	
	private int temperatura;
	
	
	public int getTemperatura() {
		return temperatura;
	}


	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}


	public PCongelados() {
		super();
	}


	public PCongelados(Calendar fechaCaducidad, int numeroLote, int temperatura) {
		super(fechaCaducidad, numeroLote);
		setTemperatura(temperatura);
	}


	public String toString(){
		return super.toString() + 
				" Temperatura:" + getTemperatura();
	}
	
}
