package curso.g90.herenciaAgroalimentaria;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PFrescos extends Productos {

	
	private Calendar fechaEnvasado;
	private String paisOrigen;
	
	public Calendar getFechaEnvasado() {
		return fechaEnvasado;
	}
	public String  getFechaEnvasadoStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
		return sdf.format(fechaEnvasado.getTime());
	}
	
	public void setFechaEnvasado(Calendar fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}
	public String getPaisOrigen() {
		return paisOrigen;
	}
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	
	public String toString(){		
		return super.toString()+
				" Fecha Envasado:"+ getFechaEnvasadoStr()+
				" Pais Origen:" + getPaisOrigen();			
	}
	public PFrescos() {
		super();
		
	}
	public PFrescos(Calendar fechaCaducidad, int numeroLote,Calendar fechaEnvasado, String paisOrigen) {
		super(fechaCaducidad,numeroLote);
		this.fechaEnvasado = fechaEnvasado;
		this.paisOrigen = paisOrigen;
	}
	
	
}
