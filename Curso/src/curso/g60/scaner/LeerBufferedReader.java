package curso.g60.scaner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeerBufferedReader {

	public static void main(String[] args) {
		// Con un InputStream (System.in) que siempre esta abierto!!!!
		// nos creamos el Reader
		InputStreamReader entrada = new InputStreamReader(System.in);
		// Con el Reader, podemos creanos nustro Buffered
		try (BufferedReader reader = new BufferedReader(entrada);) {
			String linea = "";
			StringBuffer todo = new StringBuffer();
			linea = reader.readLine();	// y ahora leemos las lineas
			while (!linea.equals("")) {
				todo.append(linea);
				linea = reader.readLine();
			}
			System.out.println("************************************");
			System.out.println(todo);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
