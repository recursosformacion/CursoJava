package curso.g90.herenciaAgroalimentaria;

import java.util.Calendar;

public class PCAgua extends PCongelados {

	private double salinidad;

	public double getSalinidad() {
		return salinidad;
	}

	public void setSalinidad(double salinidad) {
		this.salinidad = salinidad;
	}

	public PCAgua() {
		super();

	}

	public PCAgua(Calendar fechaCaducidad, int numeroLote, int temperatura, int salinidad) {
		super(fechaCaducidad, numeroLote, temperatura);
		setSalinidad(salinidad);
	}

	public String toString() {
		return super.toString() + " Salinidad:" + getSalinidad();
	}

}
