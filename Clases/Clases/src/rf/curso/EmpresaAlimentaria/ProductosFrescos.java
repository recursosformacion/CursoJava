package rf.curso.EmpresaAlimentaria;

import java.util.Calendar;

import es.rf.tienda.util.Rutinas;

public class ProductosFrescos extends Productos {

	private Calendar fechaEnvasado;
	private String PaisOrigen;
	
	public ProductosFrescos(){}
	
	
	
	
	public ProductosFrescos(Calendar fechaEnvasado, String paisOrigen) {
		super();
		this.fechaEnvasado = fechaEnvasado;
		PaisOrigen = paisOrigen;
	}




	public Calendar getFechaEnvasado() {
		return fechaEnvasado;
	}
	public void setFechaEnvasado(Calendar fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}
	public String getPaisOrigen() {
		return PaisOrigen;
	}
	public void setPaisOrigen(String paisOrigen) {
		PaisOrigen = paisOrigen;
	}
	@Override
	public String toString() {
		return "\n\nProductosFrescos-----------------\n "+
					super.toString() + "\n" + 
				"FechaEnvasado\t=" + 	Rutinas.convierteAString(getFechaEnvasado()) + 
				", PaisOrigen\t=" + getPaisOrigen();
	}
	
	
	
}
