package curso.g90.herenciaAgroalimentaria;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import curso.utilidades.Rutinas;

public class Productos {
	private Calendar fechaCaducidad;
	private int	numeroLote;
	
	private static int cuentaLote;
	
	
	public Calendar getFechaCaducidad() {
		return fechaCaducidad;
	}
	public String getFechaCaducidadStr(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(fechaCaducidad.getTime());
		
	}


	public void setFechaCaducidad(Calendar fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}



	public int getNumeroLote() {
		return numeroLote;
	}



	public void setNumeroLote(int numeroLote) {
		this.numeroLote = numeroLote;
	}



	public String toString(){
		return "Fecha caducidad:"+Rutinas.convierteAString(getFechaCaducidad())+
				" Numero Lote:"+getNumeroLote();
	}
	public Productos() {
		super();
		setNumeroLote(++cuentaLote);
	}
	public Productos(Calendar fechaCaducidad, int numeroLote) {
		this();
		setFechaCaducidad(fechaCaducidad);
		//setNumeroLote(numeroLote);
	}
}
