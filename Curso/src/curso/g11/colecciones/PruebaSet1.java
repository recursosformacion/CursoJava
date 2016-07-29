package curso.g11.colecciones;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class PruebaSet1 {
	static Set<String> lista = new TreeSet<String>();
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
