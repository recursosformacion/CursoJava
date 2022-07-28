package curso.g12.stream0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class LeerUtf8 {

	public static final String FICHERO_ENTRADA = "d:/prueba.txt";
	public static final String CODIGO_ENTRADA = "UTF-8";

	public static final String FICHERO_SALIDA = "d:/pruebaSalida.txt";
	public static final String CODIGO_SALIDA = "ASCII";

	public static void main(String[] args) {

		Writer out = null;
		String sep = System.getProperty("line.separator"); 
		try {
			FileInputStream fis = new FileInputStream(FICHERO_ENTRADA);
			InputStreamReader isr = new InputStreamReader(fis, CODIGO_ENTRADA);
			BufferedReader br = new BufferedReader(isr);

			FileOutputStream fos = new FileOutputStream(FICHERO_SALIDA);
			OutputStreamWriter osw = new OutputStreamWriter(fos, CODIGO_SALIDA);
			out = new BufferedWriter(osw);

			String linea;
			while ((linea = br.readLine()) != null) {
				try {
					out.write(linea + sep);
				} catch (IOException ex) {
					System.out.println("Error escritura: " + ex.getMessage());
				}
			}

			fis.close();

		} catch (UnsupportedEncodingException | FileNotFoundException ex2) {
			System.out.println("Mensaje error 2: " + ex2.getMessage());
		} catch (IOException ex1) {
			System.out.println("Error IOException: " + ex1.getMessage());
		} finally {
			try {
				out.close();
			} catch (IOException ex3) {
				System.out.println("Mensaje error cierre fichero: " + ex3.getMessage());
			}
		}

	}

}
