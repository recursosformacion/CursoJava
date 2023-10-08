package curso.g12.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LecturaBytes {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
//Los stream
		try {
			int aByte = System.in.read();
			System.out.println(aByte);
			
//los bufers		
			
			System.out.println("-----------------------------");
			// Lectura de hasta 10 bytes
			byte [] buffer = new byte[10];
			System.in.read(buffer);
			
			System.out.println(buffer);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
//leyendo caracteres
		InputStreamReader isr = new InputStreamReader(System.in);
		try {
			int numero = isr.read();
			System.out.println("--------------------"+numero);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//leyendo lineas
		InputStreamReader lin = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (lin);
		System.out.println("por lineas-------------------------");
		try {
			String cadena = br.readLine();
			System.out.println("leido:"+cadena);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
