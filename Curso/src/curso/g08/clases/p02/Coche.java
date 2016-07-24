package curso.g08.clases.p02;

public class Coche {
	private String color;
	private String modelo;
	private int marchas;
	private double velocidad = 0;
	private String matricula;
	
	static int contador;

	static {
		contador=1500;
	}
	
	Coche(){
		setMatricula("B-"+ ++contador);
	}
	
	Coche(String color,String modelo, int marchas){
		this();
		setColor(color);
		setModelo(modelo);
		setMarchas(marchas);
		
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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Coche \nColor=\t" + getColor() + 
				"\nModelo=\t" + getModelo() +
				"\nMarchas=\t" + getMarchas() +
				"\nVelocidad=\t" + getVelocidad() + 
				"\nMatricula=\t" + getMatricula() ;
	}
	
	
}
