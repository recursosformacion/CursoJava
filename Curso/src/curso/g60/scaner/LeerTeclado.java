package curso.g60.scaner;

import java.util.Scanner;

public class LeerTeclado {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
				
		int n1,n2;
		System.out.print("Introduce un número: ");
		n1 = teclado.nextInt();
		teclado.nextLine();
		System.out.print("Introduce otro número: ");
		n2 = teclado.nextInt();
		teclado.nextLine();
		
		System.out.format("Primewr numero %d y segundo numero %d ", n1, n2);
	}
}
