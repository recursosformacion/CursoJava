package curso.g12.nio.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Calendar;
import java.util.Set;

public class CrearFichero {

	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get("D:", "Principal", "fichero2.txt");

		// Crear fichero
		Files.createFile(path);

		// Create temp file in default location
		File.createTempFile("temporal", 
				               String.valueOf(Calendar.getInstance().getTime().getTime()));
	}

}
