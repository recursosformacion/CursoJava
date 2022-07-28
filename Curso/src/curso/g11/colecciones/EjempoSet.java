package curso.g11.colecciones;

import java.util.HashSet;
import java.util.Set;

public class EjempoSet {

	public static void main(String[] args) {
		Set<String> nombreUsuarios = new HashSet<String>();

		System.out.println("Resultado de la carga : ");
		System.out.println(nombreUsuarios.add("Antonio"));
		System.out.println(nombreUsuarios.add("Juan"));
		System.out.println(nombreUsuarios.add("Pedro")); 
		System.out.println(nombreUsuarios.add("Pedro"));
		System.out.println(nombreUsuarios.add("Luis"));
		
		System.out.println("----------------------------------------------");
		System.out.println("Lista cargada : ");

		for(Object month : nombreUsuarios) 
			System.out.println(month + ", ");

	}

}
