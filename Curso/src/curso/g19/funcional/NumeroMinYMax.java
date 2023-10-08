package curso.g19.funcional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumeroMinYMax {

	public static void main(String[] arg) {
		
		List<Integer> mia = new ArrayList<Integer>();

		for (int a = 0; a < 10; a++) {
			mia.add((int) Math.round(Math.random() * 10000));
		}
		System.out.println(mia);
		
		//***********************Generando con iterate	
		Integer maxi = Stream.iterate(0, t-> (int) Math.round(Math.random() * 10000))
			.limit(10)
			.max(Integer::compare)
			.orElseThrow(NoSuchElementException::new);
		System.out.println("Un maximo-" + maxi);

		List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10);
		Integer max = listOfIntegers.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);

		Person jose = new Person("Jose", 23);
		Person laura = new Person("Laura", 40);
		Person pablo = new Person("Pablo", 32);
		List<Person> people = Arrays.asList(jose, laura, pablo);

		Person minByAge = people.stream().min(Comparator.comparing(Person::getAge))
				.orElseThrow(NoSuchElementException::new);

		System.out.println("m�ximo:" + max);
		System.out.println("minimo:" + minByAge.getName() + "/" + minByAge.getAge());

		List<Person> sortedPerson = people.stream().sorted(Comparator.comparingInt(Person::getAge).reversed())
				.collect(Collectors.toList());
		sortedPerson.forEach(p -> System.out.println(p.getName() + "/" + p.getAge()));

		String salida = people.stream().map(Person::getName).collect(Collectors.joining(", ", "(", ")"));
		System.out.println(salida);
		
		Optional<Integer> total = listOfIntegers.stream().reduce(Integer::sum);
			
		listOfIntegers.stream().reduce(Integer::sum).ifPresent(System.out::println);
	}
}

class Person {
	String name;
	Integer age;

	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	// standard constructors, getters and setters
}
