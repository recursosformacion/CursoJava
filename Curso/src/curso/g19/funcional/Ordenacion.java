package curso.g19.funcional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Ordenacion {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("B", "A", "C", "D", "F");
	    Set<String> set = new TreeSet<>(list);

	    Object[] listOutput = list.stream().parallel().toArray();
	    Object[] setOutput = set.stream().parallel().toArray();
	    
	    System.out.println(Arrays.toString(listOutput));
	    System.out.println(Arrays.toString(setOutput));
	    
	    Set<Integer> seti = new TreeSet<>(
	    		  Arrays.asList(-9, -5, -4, -2, 1, 2, 4, 5, 7, 9, 12, 13, 16, 29, 23, 34, 57, 102, 230));
	    setOutput = seti.stream().parallel().limit(5).toArray();
	    System.out.println(Arrays.toString(setOutput));
	    setOutput = seti.stream().unordered().limit(5).toArray();
	    System.out.println(Arrays.toString(setOutput));
	    setOutput = seti.stream().unordered().parallel().limit(5).toArray();
	    System.out.println(Arrays.toString(setOutput));
	    
	    List<String> sortedList = list.stream()
	    		.sorted().collect(Collectors.toList());
	    sortedList.forEach(System.out::println);
	    
	    List<String> sortedListR = list.stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
	    sortedListR.forEach(System.out::println);
	}
}
