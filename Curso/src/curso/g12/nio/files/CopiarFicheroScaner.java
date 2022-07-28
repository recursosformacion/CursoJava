package curso.g12.nio.files;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class CopiarFicheroScaner {

	public static void main(String[] args) throws IOException {
			    
	    //Utilizando InputStream y Path con Files.copy 
		InputStream  sc = new BufferedInputStream(System.in);

	    Path destPath1 = Paths.get("c:/temp","newTest2.txt");
	    
	    long noOfBytes = Files.copy(sc,destPath1,StandardCopyOption.REPLACE_EXISTING);
	    System.out.println(noOfBytes);	  

	}

}
