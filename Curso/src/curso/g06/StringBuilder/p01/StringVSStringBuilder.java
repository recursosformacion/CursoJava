package curso.g06.StringBuilder.p01;

public class StringVSStringBuilder {

	public static void main(String[] args) {
		String s1 = "una string" ;
		StringBuilder sb1 = new StringBuilder("una StringBuilder");
		
		concatString(s1);
		
		concatStringBuilder(sb1);
		System.out.println(s1);
		System.out.println(sb1);

	}
	public static void concatString(String s1) {
		s1=s1 + " y mas";
	}
	
	public static void concatStringBuilder(StringBuilder s1) {
		s1.append(" y mas ");
	}

}
