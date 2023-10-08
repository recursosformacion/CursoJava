package curso.g12.nio.files;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;

public class PruebaStores {

	public static void main(String[] args) throws IOException {
		DecimalFormat df = new DecimalFormat("###,###,###,###");
		for (FileStore store : FileSystems.getDefault().getFileStores()) {
			long total = store.getTotalSpace() / 1024;
			long used = (store.getTotalSpace() - store.getUnallocatedSpace()) / 1024;
			long avail = store.getUsableSpace() / 1024;
			System.out.format("%-20s %12s %12s %12s%n", store, df.format(total),  df.format(used), df.format(avail));
			
		}
		System.out.println("-------------------------------------------------------");
		
		Path currentDir = Paths.get(".");
		System.out.println(currentDir.toAbsolutePath());
		Path currentDirNorm = currentDir.normalize();
		System.out.println(currentDirNorm.toAbsolutePath());
		
		System.out.println("----------------------------");
		Path path = Paths.get("D:\\AreaTrabajo\\WorkspaceCurso\\Curso"); // Crear un path absoluto
		System.out.println(path.toString());
		//path = path.getFileName(); // returns Path examples
		System.out.println("path.getFileName()="+path.getFileName().toString());
		//path = path.getName(0); // returns AreaTrabajo
		System.out.println("path.getName(0)="+path.getName(0).toString());
		int count = path.getNameCount(); // returns 3 (AreaTrabajo, WorkspaceCurso, y Curso)
		//path = path.subpath(0, 2); // returns AreaTrabajo\\WorkspaceCurso
		System.out.println("path.subpath(0, 2)="+path.subpath(0, 2).toString());
		//path = path.getParent(); // returns D:\AreaTrabajo\WorkspaceCurso
		System.out.println("path.getParent()="+path.getParent().toString());
		//path = path.getRoot(); // devuelve el nombre del disco, por ejempl "D:\". En linux sera "/"
		System.out.println("path.getRoot()="+path.getRoot().toString());
	}

}
