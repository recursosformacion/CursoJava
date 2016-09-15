package rf.curso.clasesBase;

public abstract class Vehiculo {

	private String color;
	private String modelo;
	private int marchas;
	private double velocidad;
	private String fabricante;
	private String matricula;
	private int numRuedas;
	
	private int idNumVehiculo;
	
	 static int numeroVehiculo;
	
	static {
		numeroVehiculo =1500; 
	}
	
	public Vehiculo(){
		idNumVehiculo=++numeroVehiculo;
		System.out.println("Creando vehiculo ID-" + idNumVehiculo);
	}
	
	public Vehiculo(String color, String modelo, int marchas){
		this();
		this.color = color;
		this.modelo = modelo;
		this.marchas = marchas;
	}
	Vehiculo(String color, String modelo, int marchas, double velocidad, String fabricante, String matricula){
		this(color,modelo,marchas);
		this.velocidad=velocidad;
		this.fabricante= fabricante;
		this.matricula=matricula;
		
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

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getIdNumVehiculo() {
		return idNumVehiculo;
	}

	public int getNumRuedas() {
		return numRuedas;
	}

	public void setNumRuedas(int numRuedas) {
		this.numRuedas = numRuedas;
	}

	public abstract double consumo();

	@Override
	public String toString() {
		return "Vehiculo [getColor()=" + getColor() + ", getModelo()=" + getModelo() + ", getMarchas()=" + getMarchas()
				+ ", getVelocidad()=" + getVelocidad() + ", getFabricante()=" + getFabricante() + ", getMatricula()="
				+ getMatricula() + ", getIdNumVehiculo()=" + getIdNumVehiculo() + ", getNumRuedas()=" + getNumRuedas()
				+ ", consumo()=" + consumo() + "]";
	}
	
	
	
	
}
