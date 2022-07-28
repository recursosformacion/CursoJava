package curso.g05a.buclesanidados.p11.fibonacci;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciStream {

	public static void main(String[] args) {
		System.out.println("UNO************************************");
		Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
		.limit(10)
		.forEach(x -> System.out.println("{" + x[0] + "," + x[1] + "}"));
		
		System.out.println("DOS*********************************************");
		Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
		.limit(10)
		.map(t -> t[0])
		.forEach(x -> System.out.println(x));
		
		System.out.println("TRES******************************************");
		String collect = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .map(String::valueOf) // convert to string
                .collect(Collectors.joining(", "));

        System.out.println("Result : " + collect);
        
        System.out.println("CUATRO******************************************");
		Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .map(String::valueOf) // convert to string
                .forEach(System.out::print);
	}

}
