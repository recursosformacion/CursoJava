package curso.g07.funciones.p03;

public class Saludos {
	
	private String usuario;
	
	public void hola(String nombre) {
		usuario = nombre;
		System.out.println("Hola " + usuario);
	}
	public int adios(int valor) {
		System.out.println("Adios, " + usuario);
		return valor * 3;
	}
}
