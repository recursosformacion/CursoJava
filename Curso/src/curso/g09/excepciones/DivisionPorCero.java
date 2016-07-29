package curso.g09.excepciones;


public class DivisionPorCero {

	public static void main(String[] args) {
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
