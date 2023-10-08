package curso.g12.nio.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ConsolaToDisk {

	public static void main(String[] args) {

		String nombreFichero = "";
		Path ficheroSalida = null;
		boolean existe = true;
		boolean fin = false;

		String sep = System.getProperty("line.separator");
		Scanner sc = new Scanner(System.in);

		/* Controlar nombre de fichero */
		do {
			System.out.println(System.getProperty("user.dir"));
			System.out.println("Indique ruta y nombre de fichero");
			nombreFichero = sc.nextLine();
			if (nombreFichero.length() == 0)
				fin = true;
			else {
				ficheroSalida = Paths.get(nombreFichero);
				existe = Files.exists(ficheroSalida, LinkOption.NOFOLLOW_LINKS);
			}
			if (existe) System.out.println("Este fichero existe");
		} while (existe && !fin);

		/************** iniciar captura/grabacion *************/
		if (!fin) {
			System.out.println("Puede iniciar la introduccion");

			try {
				Files.createFile(ficheroSalida);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			try (BufferedWriter writer = Files.newBufferedWriter(ficheroSalida, Charset.forName("UTF-8"));) {
				while (!fin && sc.hasNextLine()) {
					String linea = sc.nextLine();
					if (linea.length() == 0)
						fin = true;
					else
						writer.write(linea + sep);
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
		sc.close();
		System.out.println(
				"Grabado en " + ficheroSalida.getFileName() + " en " + ficheroSalida.toAbsolutePath().toString());

	}

}
