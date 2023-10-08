package curso.g12.stream0;

import java.io.BufferedReader;
import java.io.FileReader;

public class LeerConBuffered {

	public static void main(String[] args) {

		String fichero = "d:/prueba.txt";
		try {
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);

			String linea;
			while ((linea = br.readLine()) != null)
				System.out.println(linea);

			fr.close();
		} catch (Exception e) {
			System.out.println("Error leyendo  " + fichero + ": " + e);
		}
	}

}
