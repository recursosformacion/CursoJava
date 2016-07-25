package curso.g04.operadores.p02;

public class letras {

	public static void main(String arg[]) {
		char[] letras = { 'a', 'b', 'c', 'd' };

		char preg = 'c';
		int a;
		boolean encontrado=false;
		for (a = 0; a < letras.length && !encontrado; a++) {
			if (letras[a] == preg) {
				encontrado=true;
				break;
			} 
			//a=a*3-5;
		}
		System.out.println(a);

	}
}
