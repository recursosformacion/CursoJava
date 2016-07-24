package curso.g12.stream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LecturaBuffer {

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(".\\src\\curso\\g12\\stream\\LecturaBytes.java"));

			String linea = reader.readLine();

			while (linea != null) {
				System.out.println(linea);
				linea = reader.readLine();
			}
			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
//https://www.fdi.ucm.es/profesor/jpavon/poo/2.13.EntradaySalida.pdf