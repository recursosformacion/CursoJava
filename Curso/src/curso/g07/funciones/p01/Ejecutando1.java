package curso.g07.funciones.p01;

public class Ejecutando1 {
	public static void main(String[] args) {
		int num = 5;
		for (int i = 0; i < num; i++) {
			mostrar(num);
		}
		System.out.println("---------------------------");
	}

	static void mostrar(int num) {
		System.out.println("Módulo ejecutándose");
	}
}
