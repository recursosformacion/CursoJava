package curso.g06.cadenas.p01;

public class zzz {
	
	public static void main(String args[]){
		String entrada="Esto es un mensaje";
		int importe = 32;
		
		imprimir(entrada,importe);
		System.out.println("entrada="+entrada);
		System.out.println("importe="+importe);	
	}
				
	static void imprimir(String impresion, int valor){
		impresion = impresion + "\n y el valor es ";
		
		System.out.println(impresion + " = " + valor);
		valor=123;
	}
}
