package curso.g09.excepciones;


public class DivisionPorCeroBase {

	public static void main(String[] args) {
		int a=0;
		int b=300;
		int c;
		try {
			c=b/a;
			System.out.println("El resultado es "+c);
		} catch (ArithmeticException e){
			System.out.println("Se ha producido un error");
		} finally {
			System.out.println("Programa finalizado");
		}
		
		
		

	}

}
