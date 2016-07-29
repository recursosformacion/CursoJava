package curso.g05a.buclesanidados.p11.fibonacci;

/**
 * Programa que imprima los N primeros números de la serie de Fibonacci. 
 * El primer número de la serie es 0, el segundo número es 1
 * y cada uno de los siguientes es la suma de los dos anteriores. 0, 1, 2, 3, 5,
 * 8, 13, ....... , N
 */
public class Fibonacci {

	public static void main(String[] args) {

		int numero = 20;
		int penultimo = 0;
		int ultimo = 0;
		int actual = 0;

		System.out.println("Los " + numero + " primeros términos de la serie de Fibonacci son:");

		for (int i = 1; i <= numero; i++) {
			System.out.print(actual + ", ");
			penultimo=ultimo;
			ultimo=actual;
			ultimo=ultimo==0?1:ultimo;
			actual=penultimo+ultimo;
		}
		System.out.println();
	}
}
