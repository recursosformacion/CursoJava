package curso.g05.condicionalesybucles.p05;

import curso.utilidades.Consola;

/*
 * Leer un número y mostrar su cuadrado, repetir el proceso hasta que se introduzca un número
negativo.
 */
public class CalculaCuadradoConsole {

	public static void main(String[] args) {
		int num, cuadrado;
		// num guardará el número que leamos
		// y cuadrado guardará el cuadrado de num
		System.out.print("Introduzca número: ");
		num = Consola.entero();
		while (num >= 0) { // repetimos el proceso mientras el número leído no
							// sea negativo
			cuadrado = num * num;
			System.out.println(num + "² es igual a " + cuadrado);
			System.out.print("Introduzca otro número: ");
			num = Consola.entero(); // volvemos a leer num
		}

	}

}
