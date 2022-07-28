package curso.g11.colecciones;

import java.util.*;
import java.util.Map.Entry;

public class pruebaMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> lista = new TreeMap<String, String>();
		
		lista.put("prime","Miguel");
		lista.put("segun","Antonio");

		System.out.println("Numero de elementos:" + lista.size());
		for (Entry dato : lista.entrySet()){
			System.out.println(dato);
		}

	}

}
