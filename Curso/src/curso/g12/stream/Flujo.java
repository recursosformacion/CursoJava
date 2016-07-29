package curso.g12.stream;

import java.io.IOException;

public class Flujo {

	public static void main(String args[]) throws IOException {
		int c;
		int contador = 0;
		// se lee hasta encontrar el fin de línea
		while ((c = System.in.read()) != '\n') {
			contador++;
			System.out.print((char) c);
		}
		System.out.println(); // Se escribe el fin de línea
		System.err.println("Contados " + contador + " bytes en total.");
	}

}
