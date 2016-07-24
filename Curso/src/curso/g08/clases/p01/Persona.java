package curso.g08.clases.p01;

public abstract class Persona {
	private int id;
	private String nombre;
	
	
	abstract String aString();
	
	//Persona(){}
	public Persona(String nombre){
		setNombre(nombre);
	}
	
	public void imprimirQuien(){
		System.out.println(nombre);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
