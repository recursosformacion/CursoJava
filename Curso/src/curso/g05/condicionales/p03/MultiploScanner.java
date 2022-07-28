package curso.g05.condicionales.p03;

import java.util.Scanner;

public class MultiploScanner {

	public static void main(String[] args) {
		String nombre;
		
		Scanner sc = new Scanner(System.in);
        
		int n1, n2;
		System.out.print("Introduce un n�mero: ");
		n1 = sc.nextInt();
		sc.nextLine();
		System.out.print("Introduce otro n�mero: ");
		n2 = sc.nextInt();
		sc.nextLine();
		
		// si ambos números son iguales diráa que n2 es mayor que n1
		if (n1 == n2)
			System.out.println("Son iguales");
		else {
			if (n1 > n2)
				System.out.println(n1 + " es mayor que " + n2);
			else
				System.out.println(n2 + " es mayor que " + n1);
		}
		if (n1 % n2 == 0 || n2 % n1 == 0)
			System.out.println("Son m�ltiplos");
		else
			System.out.println("No son m�ltiplos");
	}
	
}
