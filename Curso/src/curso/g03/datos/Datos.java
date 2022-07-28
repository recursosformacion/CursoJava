package curso.g03.datos;

import java.io.PrintStream;
import java.util.Locale;

public class Datos {
	
	

	public static void main(String[] args) {
		int dia=10;
		long nDni = 57443222;
		double precio;
		final boolean ACTIVO = true;
		
		precio=135.12;
		
		System.out.println("Dia "+dia);
		
		
		System.out.println("Dni\t"+nDni);
		System.out.println("Precio\t"+precio);
		System.out.println("Activo?\t"+ACTIVO);
		
		System.out.print("Esto aparece ");
		System.out.print("en una misma ");
		System.out.println("linea");
		
		System.out.println("Y esto en la siguiente");
		
		PrintStream ps = new PrintStream(System.out);
		ps.println("Imprimo usando PrintStream");
		
		ps.printf("Default floating-point format: %f\n", 1234567.123);
		System.out.printf("%d %(d %+d %05d\n", 3, -3, 3, 3);
		System.out.printf("Floating-point with commas: %,f\n", 1234567.123);
	    System.out.printf("Negative floating-point default: %,f\n", -1234567.123);
	    System.out.printf("Negative floating-point option: %,(f\n", -1234567.123);
	    System.out.printf("Line up positive and negative values:\n");
	    System.out.printf("% ,.2f\n% ,.2f\n", 1234567.123, -1234567.123);
		ps.close();

	}

}
