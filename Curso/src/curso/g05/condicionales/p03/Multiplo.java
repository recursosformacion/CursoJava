package curso.g05.condicionales.p03;


/*
 * Pedir dos números y decir cual es el mayor o si son iguales
 * y si uno es multiplo de otro
 */

public class Multiplo {

	public static void main(String[] args) {

		int n1 = 10;
		int n2=20;
		
		// si ambos números son iguales diría que n2 es mayor que n1
		if (n1 == n2)
			System.out.println("Son iguales");
		else {
			if (n1 > n2)
				System.out.println(n1 + " es mayor que " + n2);
			else
				System.out.println(n2 + " es mayor que " + n1);
		}
		if (n1 % n2 == 0 || n2 % n1 == 0)
			System.out.println("Son múltiplos");
		else
			System.out.println("No son múltiplos");
	}

}
