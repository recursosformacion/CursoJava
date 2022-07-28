package curso.g09.excepciones;


public class DivisionPorCeroLanza {

	public static void main(String[] args) throws ArithmeticException {
		int a=0;
		int b=300;
		int c;
		try {
			c=b/a;
			System.out.println("El resultado es "+c);
		} finally {
			System.out.println("Programa finalizado");
		}
		
		
		

	}

}
