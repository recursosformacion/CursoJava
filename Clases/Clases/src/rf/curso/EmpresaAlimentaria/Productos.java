package rf.curso.EmpresaAlimentaria;

import java.util.Calendar;

import es.rf.tienda.util.Rutinas;

public class Productos {
	private Calendar fechaCaducidad;
	private String numeroLote;
	public Calendar getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(Calendar fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public String getNumeroLote() {
		return numeroLote;
	}
	public void setNumeroLote(String numeroLote) {
		this.numeroLote = numeroLote;
	}
	@Override
	public String toString() {
		return "FechaCaducidad\t=" + Rutinas.convierteAString(getFechaCaducidad()) + ", NumeroLote\t=" + getNumeroLote();
	}
	
	
}
