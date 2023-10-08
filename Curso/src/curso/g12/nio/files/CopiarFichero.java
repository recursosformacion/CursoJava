package curso.g12.nio.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopiarFichero {

	public static void main(String[] args) throws IOException {
		 //Ruta al fichero origen
	    Path pathSource = Paths.get("D:","prueba.txt");
		 
	    //Stream al fichero destino
	    File destFile = new File("c:/temp/newTest1.txt");
	    FileOutputStream fos = new FileOutputStream(destFile);
		
	    //copiamosorigen a destino y conseguimos los bytes copiados
	    long noOfBytes = Files.copy(pathSource, fos);
	    System.out.println(noOfBytes);
	    
	    //Utilizando InputStream y Path with Files.copy 
	    File sourceFile = new File("d:\\prueba.txt");
	    FileInputStream fis = new FileInputStream(sourceFile);
	    Path destPath1 = Paths.get("c:/temp","newTest2.txt");
	    
	    noOfBytes = Files.copy(fis,destPath1,StandardCopyOption.REPLACE_EXISTING);
	    System.out.println(noOfBytes);
	    
	    
	    
	    //Utilizando Path para origen y destino
	  //Ruta al fichero origen
	    Path pathSource1 = Paths.get("D:","prueba.txt");
	    Path destPath2 = Paths.get("d:\\principal","pruebaCopia.txt");
	    Path target = Files.copy(pathSource1,destPath2,StandardCopyOption.REPLACE_EXISTING);
	    System.out.println(target.getFileName());

	}

}
