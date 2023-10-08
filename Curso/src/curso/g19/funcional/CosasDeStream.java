package curso.g19.funcional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CosasDeStream {

	public static void main(String[] arg) {
		Stream<String> nombres = Stream.of("Jose","Luisa","Isabel","Carla","Susana","Alejandro");
		
		Stream<String> pnombre =Stream.of("Pedro","Miguel","Enzo","Lola","Ignacio").parallel();
		List<String> result0 = pnombre.collect(Collectors.toList());
		
		
		String anombres[] = new String[]{"Pedro","Miguel","Enzo","Lola","Ignacio"};
		Arrays.stream(anombres).forEach(System.out::println);
		
		List<String> listNombres = Arrays.asList("Jose","Luisa","Isabel","Carla","Susana","Alejandro");
		List<String> result = listNombres.stream().collect(Collectors.toList());
		result.add("Julio");
		
		result.stream().reduce(String::concat).ifPresent(System.out::println);
	  
	
		
		
		
		
//		List<String> lnombres = nombres.collect(toList());
//		List<String> lnombresF = nombres.toList();
	}
}
