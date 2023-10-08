package curso.utilidades;

import java.util.Scanner;

public class ConsoleScan {
	
	static Scanner sc ;
	ConsoleScan(){
		 sc = new Scanner(System.in);
	}
	
	
	
	public static  int entero() {
		
		return sc.nextInt();
	}

	public static  double real() {

		return sc.nextDouble();
	}

	public static  String cadena() {
		
		return sc.nextLine();
	}

	public static  char caracter() {
		
	//	return sc.next().charAt(0);
		return sc.findInLine(".").charAt(0);
	}
}
