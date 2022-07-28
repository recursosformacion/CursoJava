package curso.g12.stream0;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Sobreescribir {

	public static void main(String[] args) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		/*
		try {

			fichero = new FileWriter("d:/prueba.txt");
			pw = new PrintWriter(fichero);

			for (int i = 0; i < 10; i++)
				pw.println("Linea " + i);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				// en finally nos asegurarmos que
				// se cierra el fichero.
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}*/

		try {

			fichero = new FileWriter("d:/prueba.txt", true);
			pw = new PrintWriter(fichero);

			for (int i = 0; i < 10; i++)
				pw.println("Linea " + i);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				// en finally nos asegurarmos que
				// se cierra el fichero.
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
}
