package curso.g07.funciones.p01;


public class Ejecutando {
	public static void main(String[] args) {
		int num = 5;	
		mostrar(num);
		System.out.println("---------------------------");
	}

	static void mostrar(int num) {
		for (int i = 0; i < num; i++) {
			System.out.println("Módulo ejecutándose");
		}
	}
}
 