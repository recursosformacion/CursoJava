package curso.g10.junit2;

public class division {

	public int calcula() throws ErrorMio{
		int a = 0;
		int b = 300;
		int c=0;
		try {
			c=  (b/a);
			
		} catch(ArithmeticException e){
		//	System.out.println("Se ha producido un error");
			throw new ErrorMio("Se ha producido un error");
			//e.printStackTrace();
		} finally{
			System.out.println("Programa finalizado");
		}
		
		return c;
	}
}
