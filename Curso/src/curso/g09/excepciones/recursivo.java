package curso.g09.excepciones;
public class recursivo {
	
	//This is an example of a badly done recursive call that results in an error
	public static void main(String arg[]){
		infinity();
	}
	
	public static void infinity(){
		System.out.println("Ifinity!");
		try {
			infinity();
		}
		catch (Error e){
			System.out.println("Error java");
		}
	}
}
