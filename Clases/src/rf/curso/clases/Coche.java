package rf.curso.clases;

public class Coche {

	String color;
	String modelo;
	int marchas;
	double velocidad;
	
	int idNumCoche;
	
	static int numeroCoche;
	
	static {
		numeroCoche =1500; 
	}
	
	Coche(){
		idNumCoche=++numeroCoche;
	}
	
	Coche(String color, String modelo, int marchas){
		this();
		this.color = color;
		this.modelo = modelo;
		this.marchas = marchas;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getMarchas() {
		return marchas;
	}
	public void setMarchas(int marchas) {
		this.marchas = marchas;
	}
	public double getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}
	
	
}
