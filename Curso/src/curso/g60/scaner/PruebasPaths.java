package curso.g60.scaner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;


public class PruebasPaths {

	public static void main(String[] args) throws IOException {

		FileSystem sistemaFicheros = FileSystems.getDefault();
		Path rutaFichero = sistemaFicheros.getPath("\\xampp\\crash.txt");
		System.out.println(rutaFichero.getFileName());
		System.out.println(rutaFichero.getParent().getFileName());

		Path path = Paths.get("c:\\lista");
		System.out.println(path.toString());
		Path currentDir = Paths.get(".");
		System.out.println(".  -> " + currentDir.toAbsolutePath().normalize());
		Path pCurrentDir = Paths.get("..");
		System.out.println(".. -> " + pCurrentDir.toAbsolutePath().normalize());

		String work = pCurrentDir.toAbsolutePath().normalize().toString();
		Path wkPath = Paths.get(work, "dirPrueba");
		Path wkFile = Paths.get(wkPath.toString(), "fichePrueba");

		Files.deleteIfExists(wkFile); // para borrar
		if (Files.exists(wkPath))
			Files.delete(wkPath); // en sucesivas pasadas

		Path newPath = Files.createDirectory(wkPath);
		Path nuevo = Files.createFile(wkFile);
		
		List<String> lineasIni = Arrays.asList("Grabando 1", "Grabando 2", "Grabando 3");
		Files.write(nuevo,lineasIni,StandardCharsets.UTF_8,
						StandardOpenOption.CREATE,
		                StandardOpenOption.WRITE,
		                StandardOpenOption.APPEND);
		
		List<String> lines = Arrays.asList("line 1", "line 2", "line 3");
		Files.write(nuevo,lines,StandardCharsets.UTF_8,StandardOpenOption.APPEND);
		Files.write(nuevo, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
		//Files.write(nuevo, "\nGrabando y siguiendo pequeño contenido".getBytes(),
		//		StandardOpenOption.CREATE,
        //        StandardOpenOption.WRITE,
        //        StandardOpenOption.APPEND);
		
		try (BufferedWriter writer = Files.newBufferedWriter(nuevo, 
				StandardCharsets.UTF_8,StandardOpenOption.APPEND)) {
			writer.write("To be, or not to be. That is the question.");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		System.out.println("*********************************salida");
		try (BufferedReader reader= Files.newBufferedReader(nuevo,StandardCharsets.UTF_8)) {
			String linea;
			while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		System.out.println("*********************************fin salida");
		
		File acceso = new File(nuevo.toString());
		Path pathFromFile = acceso.toPath();
		File fileFromPath = nuevo.toFile();

		System.out.println("pathFromFile=" + pathFromFile.toString());
		System.out.println("fileFromPath=" + fileFromPath);

		Path absolutePath = pathFromFile.toAbsolutePath();
		Path canonicalPath = pathFromFile.toRealPath().normalize();
		Path relative = pathFromFile.relativize(wkPath.getParent());
		System.out.println("Relative path: " + relative.toString());
		System.out.println("absolutePath=" + absolutePath.toString());
		System.out.println("canonicalPath=" + canonicalPath.toString());
		System.out.println("pathUri =" + canonicalPath.toUri());

		System.out.println("Absolute path: " + relative.toAbsolutePath());
		System.out.println("Real path: " + relative.toRealPath());
		Path realPath = relative.toRealPath(LinkOption.NOFOLLOW_LINKS);
		System.out.println(realPath.toString());

		System.out.println("pathExists= " + Files.exists(path));
		System.out.println("pathIsFile= " + Files.isRegularFile(path));
		System.out.println("pathIsDir= " + Files.isDirectory(path));
		System.out.println("pathReadable= " + Files.isReadable(path));
		System.out.println("pathWritable= " + Files.isWritable(path));
		System.out.println("pathExecutable= " + Files.isExecutable(path));
		System.out.println("pathHidden= " + Files.isHidden(path));

		DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get(work));
		System.out.println("***** Contenido de " + work);
		paths.forEach(x -> System.out.println("(" + x.getNameCount() + ")" + x.getFileName() + "\n>" + x.getRoot()));

	}

}
