package curso.g05.condicionalesybucles.p06;

import java.util.stream.Stream;

public class ImprimeNumeros {

	public static void main(String[] args) {

		for (int i = 100; i >= 0; i -= 23)
			System.out.println(i);

		Stream.iterate(100, t -> t - 23).filter(t -> t < 0).limit(10).forEach(System.out::println);

	}
}
