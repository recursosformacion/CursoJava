package curso.g12.nio.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CrearEnlaces {

	public static void main(String[] args) throws IOException {
		Path existing = Paths.get("d:", "Principal","fichero2.txt");
		Path link = Paths.get("d:", "link");
		Path linkSym = Paths.get("d:", "linkSym");
		Files.createLink(link, existing);
		Files.createSymbolicLink(linkSym, existing);

	}

}
