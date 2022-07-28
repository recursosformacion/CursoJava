package curso.g19.funcional;

import java.util.List;
import java.util.stream.Collector;
import java.util.ArrayList;
import java.util.Arrays;

public class NumerosMayores {
	public static void main(String[] args) {
		List<Integer> numeros = new ArrayList<Integer>(Arrays.asList(11, 8, 9, 15, 39, 1, 4, 83));
		
		int contador = 0;

		for (int numero: numeros) {
			if(numero > 10){
				contador ++;
			}
		}

		System.out.println(contador);
		
		
		Long resultado = numeros.stream().filter(num -> num > 10).count();
			System.out.println("Hay " + resultado + " numeros, y son:");
			
			numeros.stream().filter(num -> num > 10).forEach(System.out::println);
			
			List<Integer> salida = numeros.stream().filter(num -> num > 10).collect(Collector.toList());
			
	}
	

}
