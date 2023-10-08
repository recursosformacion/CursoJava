package curso.g12.nio.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LeerNioConBuffered {

	public static void main(String[] args) throws IOException {
		// ubicacion del fichero
		// Path path = Paths.get("D:/","prueba.txt");
		Path path = Paths.get("D:\\prueba.txt");

		boolean existe = Files.exists(path, 
				         new LinkOption[] { LinkOption.NOFOLLOW_LINKS });
		if (existe) {
			// Abrir fichero
			BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
			String s = null;
			while ((s = reader.readLine()) != null) {
				System.out.println(s);
			}
		} else {
			System.out.println("Fichero " 
					+ path.getFileName().toString() 
					+ " no existe");
		}

	}

}
