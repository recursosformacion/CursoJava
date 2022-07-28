package curso.g05a.buclesanidados.p11.fibonacci;

public class FibonacciRecursivo {

	public static int FibonacciRecursivo(int n){
        if(n < 2)
           return 1;
        else
           return FibonacciRecursivo(n-1) + FibonacciRecursivo(n-2);
     }
		 public static void main(String args[]){
			 int n = 20;
			 System.out.println("Recursivo es:");      
	         System.out.println("F(" + n + ")=" + FibonacciRecursivo(n-1));
		 }
}
