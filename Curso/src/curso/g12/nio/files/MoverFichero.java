package curso.g12.nio.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MoverFichero {

	public static void main(String[] args) throws IOException {
		Path origen = Paths.get("d:\\Principal","fichero2.txt");
		Path destino = Paths.get("D:\\Principal\\pr1\\movido.txt");
		Files.move(origen, destino, StandardCopyOption.REPLACE_EXISTING);
	}

}
