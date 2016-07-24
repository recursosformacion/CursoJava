package curso.g05.condicionalesybucles.p08;


public class Factorial {
	public static void main(String[] args) {
		
		double factorial;
		int num=8;
		
		factorial = 1; 
		for (int i = num; i > 0; i--) {
			factorial = factorial * i;
		}
		System.out.println("El factorial de " + num + " es: " + factorial);
	}

}
