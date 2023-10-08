package curso.g60.scaner;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LeerFichero {
	public static void main(String[] args) throws IOException {
		String carpeta = "C:\\";
		String archivo = "lista";
		// Path path =
		// FileSystems.getDefault().getPath(carpeta, archivo);
		// Scanner leerfichero = new Scanner(path);
		File fichero = new File("D:\\RF_GIT\\git\\CursoJava\\Curso\\src\\curso\\g60\\scaners\\PruebasPaths.java");
		try (Scanner leerfichero = new Scanner(fichero)) {
			// en vez de utilizar nextLine, puedo...
			leerfichero.useDelimiter("\n");
			while (leerfichero.hasNext()) {
				String cadena = leerfichero.next();
				System.out.print(cadena + " ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
