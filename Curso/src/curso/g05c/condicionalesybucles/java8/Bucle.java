package curso.g05c.condicionalesybucles.java8;

import java.util.ArrayList;
import java.util.List;

public class Bucle {

	public static void main(String[] args) {
		List<String> items = new ArrayList<>();
		items.add("A");
		items.add("B");
		items.add("C");
		items.add("D");
		items.add("E");
		System.out.println("**************************************************uno");
		items.forEach((String item)->System.out.println(item));
		System.out.println("**************************************************dos");
		items.forEach(System.out::println);
		System.out.println("**************************************************tre");
		items.forEach((String item) ->{
			if("C".equals(item)){
				System.out.println(item);
			}
		});
	}

}
