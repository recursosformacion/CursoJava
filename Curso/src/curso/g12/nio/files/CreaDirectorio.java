package curso.g12.nio.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class CreaDirectorio {

	public static void main(String[] args) throws IOException {
		Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rwxrwx--x");
		FileAttribute<Set<PosixFilePermission>> fileAttributes = PosixFilePermissions.asFileAttribute(perms);
		// Files.createDirectories(path,fileAttributes); //esta linea solo
		// funciona en entornos Linux

		Path path = Paths.get("D:", "Principal", "pr1");

		// crear directorio D:\Principal\pr1
		Files.createDirectories(path);

		Path path1 = Paths.get("D:", "Principal", "pr2");

		// crea Directorio pr2 bajo d:/Principal
		Files.createDirectory(path1);

		// crea un directorio temporal en el directorio temp del sistema
		Files.createTempDirectory("ParaTemp"); // le añade un identificador para
												// garantizar unicidad

		// crea un directorio temporal en el directorio indicado
		Files.createTempDirectory(path, "ParaTemp");

	}

}
