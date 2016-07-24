package curso.g11.colecciones;

import java.util.*;

public class PruebaList {

	public static void main(String[] args) {
		List<String> lista = new ArrayList<String>();
		lista.add("Zoo");
		lista.add("Park");
		
		System.out.println("Numero de elementos:" + lista.size());
		for (String dato : lista){
			System.out.println(dato);
		}
		for (int i=0; i<lista.size(); i++) {
			  System.out.println(lista.get(i));
			}
	}

}
