package curso.g70.ficheros;

import java.util.Calendar;
import java.util.Locale;

public class Formateo {

	public static void main(String[] args) {
		long n = 461012;
		System.out.format("%d%n", n); 		// --->"461012"
		System.out.format("%08d %n", n); 	// --->"00461012"
		System.out.format("%+8d %n", n); 	// --->" +461012"
		System.out.format("%,8d %n", n); 	// --->" 461,012"
		System.out.format("%+,8d%n%n", n); 	// --->"+461,012"
		
		double pi = Math.PI;		
		System.out.format("%f %n", pi); 								// --->"3,141593"
		System.out.format("%.3f%n", pi); 							// --->"3,142"
		System.out.format("%10.3f %n", pi); 							// --->"     3,142"
		System.out.format("%+10.3f%n", -pi); 						// --->"    -3,142"
		System.out.format(new Locale("ES","es"),"%+10.4f%n", pi); // --->"   +3,1416"
		System.out.format("%f, %1$+020.10f %n%n", pi);				// --->"3,141593, +00000003,1415926536"
		
		Calendar c = Calendar.getInstance();
		System.out.format("%tB %te, %tY%n", c,c,c);									// --->"junio 19, 2022"
		System.out.format(new Locale("ES","es"), "%te de  %tB de %tY%n", c,c,c);	// --->"19 de  June de 2022"
		System.out.format("%tl:%tM, %tp%n", c,c,c);									// --->"10:07, am"	
	}

}
