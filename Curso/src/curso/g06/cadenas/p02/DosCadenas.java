package curso.g06.cadenas.p02;

public class DosCadenas {

	public static void main(String[] args) {
		
		String a = "Esto es una string";
		String b = "Y esto tambien";
		
		if (a.compareTo(b)==0) {
			System.out.println("Son iguales");
		}
		else {
			System.out.println("No son iguales");
		}
		String c = a + b;
		String d = a + b;
		System.out.println("Comparando por punteros " + (c==d));
		System.out.println("comparando por strings " + (c.compareTo(d)==0));
		System.out.println("La string a tiene " + a.length() + "caracteres");
		System.out.println("La string b tiene " + b.length() + "caracteres");
		System.out.println("La string c tiene " + c.length() + "caracteres");
		System.out.println("La string d tiene " + d.length() + "caracteres");
		
		b=a;
		a=a.replace("e","k");
		System.out.println("a="+a);
		System.out.println("b="+b);
	}

}
