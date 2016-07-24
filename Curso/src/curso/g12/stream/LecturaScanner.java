package curso.g12.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LecturaScanner {

	public static void main(String[] args) {
		File f = new File(".\\src\\curso\\g12\\stream\\LecturaBytes.java");
		System.out.println(f.getAbsolutePath());
		Scanner s;
		
		try {
			   s = new Scanner(f);
			   //----------------------------Lectura del fichero
			   while (s.hasNextLine()) {
				   String linea = s.nextLine();
				   System.out.println(linea);
				}
			   s.close();
			} catch (FileNotFoundException e) {
			   e.printStackTrace();
			}

	}

}
