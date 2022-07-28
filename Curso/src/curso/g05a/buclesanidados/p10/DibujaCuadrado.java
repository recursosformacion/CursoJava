package curso.g05a.buclesanidados.p10;

public class DibujaCuadrado {

	public static void main(String[] args) {
		int n = 8; // tamaño del lado
		int fila, col;

		for (fila = 1; fila <= n; fila++) {
			for (col = 1; col <= n; col++)
				System.out.print("* ");
			System.out.println("");
		}

	}

}
