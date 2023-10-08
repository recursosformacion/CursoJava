package curso.g70.ficheros;

import java.io.PrintStream;

public class conPrintStream {

	public static void main(String[] args) {
		PrintStream ps = new PrintStream(System.out);
		ps.println("Imprimo usando PrintStream");

	}

}
