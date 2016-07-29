package curso.g05a.buclesanidados.p11.order;

import java.util.Arrays;

public class Ordenando {

	public static void main(String[] args) {
		// cargamos el array
		int[] lista = new int[10];

		System.out.print("Lista = ");
		for (int a = 0; a < lista.length; a++) {
			lista[a] = (int) (Math.random() * 100);
			System.out.print(lista[a] + ", ");
		}
		
		System.out.println("\n--------------------------------------------------");

		for (int i = 0; i < lista.length - 1; i++) {

			for (int j = 1; j < lista.length - i; j++) {

				// If current number is greater than swap those two
				if (lista[j - 1] > lista[j]) {
					int temp = lista[j];
					lista[j] = lista[j - 1];
					lista[j - 1] = temp;
				}
			}

		}
		
		System.out.println(Arrays.toString(lista));

	}
}
