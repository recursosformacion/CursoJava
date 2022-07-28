package curso.g05.condicionales.p04;


public class NotasIf {

	public static void main(String[] args) {
		int nota;
		
		nota = 6;
		
		if (nota >= 0 && nota < 5)
			System.out.println("INSUFICIENTE");
		else if (nota == 5)
			System.out.println("SUFICIENTE");
		else if (nota == 6)
			System.out.println("BIEN");
		else if (nota == 7 || nota == 8)
			System.out.println("NOTABLE");
		else if (nota == 9 || nota == 10)
			System.out.println("SOBRESALIENTE");
	}
}

