package curso.g05b.condicionalesybucles.Adivina;

import curso.utilidades.Consola;
/*
 * Realizar un juego para adivinar un número. Para ello pedir un número N 
 * u obtenerlo aleatoriamente, y luego ir pidiendo
 * números indicando “mayor” o “menor” según sea mayor o menor con respecto a N. 
 * El proceso termina cuando el usuario acierta.
 */
public class Adivina {

	public static void main(String[] args) {
		int n, num;
		// num guarda los números introducidos
		//-----------------------------------------
		//				System.out.print("Introduce N: ");
		//				n = Consola.entero();
		//-----------------------------------------
		n=(int)(Math.random()*100)+1;
		// en lugar de pedir n... podemos hacer que se n tome un valor
		// aleatorio entre 1 y 100.
		// Así el juego es algo más entretenido.
		//--------------------------------------------------------
		System.out.print("Introduce número: ");
		num = Consola.entero();
		while (num != n) // mientras no coincidan ambos números
		{
			if (num > n)
				System.out.println("menor");
			else
				System.out.println("mayor");
			System.out.print("Introduce número: ");
			num = Consola.entero();
		}
		// al salir del mientras tenemos la certeza que num es igual a n
		System.out.println("acertaste...");
	}

}
