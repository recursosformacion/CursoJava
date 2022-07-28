package curso.g60.scaner;

import java.util.Scanner;

public class LeerString {
	public static void main(String[] args) {
		String string = new String("3 2 4 AF Pepe 8");
		Scanner scString = new Scanner(string);
		while (scString.hasNext()) {
			String cadena = scString.next();
			System.out.print(cadena + "-");
		}
	}
}
