package rf.curso.futbol;

public class Seleccion {
	private int id;
	private String nombre;
	private String apellidos;
	private int edad;
	
	
	public void concentrarse(){
		System.out.println("Concentrado estoy......");
		
	}
	public void viajar(){
		System.out.println("Y voy viajando.....!!!!!");
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
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "TipoBase [getId()=" + getId() + ", getNombre()=" + getNombre() + ", getApellidos()=" + getApellidos()
				+ ", getEdad()=" + getEdad() + "]";
	}
	
}
