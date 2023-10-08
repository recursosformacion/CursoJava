package curso.g04.operadores;

public class Contadores {

	public static void main(String[] args) {
		int valor=0;
		valor=23;
		valor+=10;
		System.out.println("Resultado a=" + --valor);
		System.out.println("Resultado b=" + ++valor);
		System.out.println("Resultado c=" + valor++);
		System.out.println("Resultado d=" + valor--);
		System.out.println("Resultado e=" + valor);
	}

}
