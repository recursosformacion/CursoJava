package curso.g07.funciones.p04;

import curso.utilidades.Consola;

/*
 * Escribir una función que calcule el máximo común divisor de dos números.
 *  el máximo común divisor de dos números es el número mças grande que
 *  es capaz de dividir a ambos números
 *  Para calcularlo podríamos utilizar algún algoritmo existente o hacerlo
 *  un poco por la "cuenta de la vieja".
 *  La idea es dividir por todos los n�meros desde 1 hasta mínimo(a, b)
 *  y quedarnos con el mayor.
 */

public class MaximoComunDivisor {

	

	public MaximoComunDivisor(int a, int b) {
		int mcd = 1;
		int min;
		min = minimo(a, b);
		mcd = 1; // existe un mcd seguro, el 1, que divide a y b.
		for (int i = 2; i <= min; i++)
			if (a % i == 0 && b % i == 0) // si i divide a "a" y "b"
				mcd = i; // i será el nuevo mcd.
		System.out.println("El mcd de " + a + " y " + b + " es: " + mcd);
	}

	public int minimo(int a, int b) {
		int min;
		if (a > b)
			min = b;
		else
			min = a;
		return (min);
	}

}
