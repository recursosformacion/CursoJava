package curso.g05a.buclesanidados.p10;

import curso.utilidades.Consola;
/*
 * Dibuja un cuadrado de n elementos de lado utilizando *.
 */
public class DibujaCuadradoConsola {

	public static void main(String[] args) {
		int n; // tamaño del lado
		int fila, col;
		System.out.print ("Lado del cuadrado: ");
		n = Consola.entero();
		for (fila=1; fila<=n; fila++)
		{
		for (col=1; col<=n; col++)
		System.out.print ("* ");
		System.out.println ("");
		}

	}

}
