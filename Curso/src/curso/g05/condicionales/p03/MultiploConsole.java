package curso.g05.condicionales.p03;

import curso.utilidades.Consola;

/*
 * Pedir dos números y decir cual es el mayor o si son iguales
 * y si uno es multiplo de otro
 */

public class MultiploConsole {

	public static void main(String[] args) {

		int n1, n2;
		System.out.print("Introduce un número: ");
		n1 = Consola.entero();
		System.out.print("Introduce otro número: ");
		n2 = Consola.entero();
		// si ambos números son iguales diría que n2 es mayor que n1
		if (n1 == n2)
			System.out.println("Son iguales");
		else {
			if (n1 > n2)
				System.out.println(n1 + " es mayor que " + n2);
			else
				System.out.println(n2 + " es mayor que " + n1);
		}
		if (n1 % n2 == 0)
			System.out.println("Son múltiplos");
		else
			System.out.println("No son múltiplos");
	}

}
