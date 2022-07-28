package curso.g03.datos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LecturaTeclado {

	public static void main(String[] args) {
		
		InputStreamReader entrada = new InputStreamReader(System.in);
		
		BufferedReader reader = new BufferedReader(entrada);
		
		String linea;
		try {
			linea = reader.readLine();
			while (linea != null) {
				// procesar el texto de la línea
				linea = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
