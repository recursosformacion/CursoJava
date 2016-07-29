package curso.g05a.buclesanidados.p11;

import curso.utilidades.Consola;

/*
 * Realizar un programa que nos pida un número n, y nos diga cuantos números hay entre 1 y n que son
primos.
 */
public class PrimosConsole {

	public static void main(String[] args) {
		boolean primo;
		int cont_pri = 0;
		System.out.print("Introduce numero: ");
		int num = Consola.entero();
		// vamos procesando todos los números entre 1..num
		for (int i = 1; i <= num; i++) {
			// para cada número i, calcularemos si es primo
			// veremos si el número i es divisible en el rango 2..i-1
			// El bucle while se puede hacer con menos vuelta... consultar
			// algoritmos para primos
			primo = true;
			int j = 2;
			while (j <= i - 1 && primo == true) {
				if (i % j == 0)
					primo = false;
				j++;
			}
			if (primo == true) {
				cont_pri++; // si es primo incrementamos el contador de primos
				System.out.println(i + (" es primo"));
			}
		}
		System.out.println("En el rango 1.." + num + ", hay " + cont_pri + " números primos");
	}
}
