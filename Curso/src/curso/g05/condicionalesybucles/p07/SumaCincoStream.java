package curso.g05.condicionalesybucles.p07;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumaCincoStream {

	public static void main(String[] args) {
		Stream.iterate(0, n->n+5)
		.limit(10)
		.forEach(System.out::println);
		
		List<Integer> lista = Stream.iterate(0, n->n+5).limit(10).collect(Collectors.toList());
		lista.stream().forEach(System.out::println);
		System.out.println("el total es " + lista.stream().reduce(0,Integer::sum));
	}

}
