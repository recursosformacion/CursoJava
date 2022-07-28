package pruebas;

public class Excepciones {

	public static void main(String[] args)  {
		int a=0;
		int b=300;
		try {
		 double c = b/a;
		}
		catch (ArithmeticException e){
			System.out.println("Se ha producido un error");
		}
		finally{
			System.out.println("Programa finalizado");
		}
				

	}

}
