package curso.g11.colecciones;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PruebaSet2 {
	static Set<String> lista = new HashSet<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lista.add("Miguel"));
		System.out.println(lista.add("Jose"));
		System.out.println(lista.add("Antonio"));
		System.out.println(lista.add("Miguel"));
		
		
		
		for (String dato : lista){
			System.out.println(dato);
		}
	}

}
