package curso.g06.cadenas.p01;

public class Aprendiendo {
	static String cadena;
	public static void main(String[] args) {
		
		cadena="Siempre se puede aprender java";
		
		System.out.println("A-El numero de letras es "+cadena.length());

		
		System.out.println("B-El numero de palabras es "+(contar(' ')+1));
		System.out.println("C-El numero de a's es "+contar('a'));	
		
		String[] palabras = cadena.split(" ");
		for (int a=palabras.length-1;a>0;a--){
			System.out.print(palabras[a]+" ");
		}
		System.out.println();
		
		for (int a=cadena.length()-1;a>=0;a--)
			System.out.print(cadena.charAt(a));
		System.out.println();
	}
	private static int contar(char caracter){
		int a=0;
		for (int i = 0; i < cadena.length(); i++) {
			if (cadena.charAt(i)==caracter)
				a++;
		}
		return a;
	}

}
