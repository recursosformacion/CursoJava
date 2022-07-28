package curso.g99.herenciaYpolimorfismo;

public abstract class Figura {
	private int coordenada_x, coordenada_y, ancho, alto;
	protected double perimetro, area;
	protected String nombre;
	
	Figura(int ancho, int alto){
		setAncho(ancho);
		this.alto=alto;
	}
	
	public abstract double area();	
	
	
	public int getCoordenada_x() {
		return coordenada_x;
	}
	public void setCoordenada_x(int coordenada_x) {
		this.coordenada_x = coordenada_x;
	}
	public int getCoordenada_y() {
		return coordenada_y;
	}
	public void setCoordenada_y(int coordenada_y) {
		this.coordenada_y = coordenada_y;
	}
	public int getAncho() {
		return ancho/10;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho*10;
	}
	public int getAlto() {
		return alto;
	}
	public void setAlto(int alto) {
		this.alto = alto;
	}

	public void dibujar(){
		System.out.println("Dibujando "+ nombre);
	}
}
