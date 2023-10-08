package curso.g12.nio.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class LeerFichero {

	public static void main(String[] args) throws IOException {
		String sCarpAct = System.getProperty("user.dir");
		String direc=sCarpAct + "/src/curso/g12/nio/files";
		
		File carpeta = new File(direc);
		String[] listado = carpeta.list();
		if (listado == null || listado.length == 0) {
		    System.out.println("No hay elementos dentro de la carpeta actual");
		    return;
		}
		else {
		    Arrays.stream(listado).forEach(System.out::println);
		}
		Files.lines(Paths.get(direc + "\\PruebaStores.java")).forEach(System.out::println);


	}

}
