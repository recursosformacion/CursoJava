package curso.g05b.condicionalesybucles.Adivina;

import curso.utilidades.Consola;
/*
 * Realizar un juego para adivinar un numero. Para ello 
 * obtener aleatoriamente un numero, y luego ir pidiendo
 * numeros indicando 'mayor' o 'menor' segun sea mayor o menor con respecto a N. 
 * El proceso termina cuando el usuario acierta.
 */
public class Adivina {

	public static void main(String[] args) {
		int n, num;
		// num guarda los numeros introducidos
		//-----------------------------------------
		//				System.out.print("Introduce N: ");
		//				n = Consola.entero();
		//-----------------------------------------
		n=(int)(Math.random()*100)+1;
		// en lugar de pedir n... podemos hacer que se n tome un valor
		// aleatorio entre 1 y 100.
		// As� el juego es algo m�s entretenido.
		//--------------------------------------------------------
		System.out.print("Introduce numero: ");
		num = Consola.entero();
		while (num != n) // mientras no coincidan ambos numeros
		{
			if (num > n)
				System.out.println("menor");
			else
				System.out.println("mayor");
			System.out.print("Introduce numero: ");
			num = Consola.entero();
		}
		// al salir del mientras tenemos la certeza que num es igual a n
		System.out.println("acertaste...");
	}

}
