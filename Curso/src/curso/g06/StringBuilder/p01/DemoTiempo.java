package curso.g06.StringBuilder.p01;

import java.lang.StringBuilder;

public class DemoTiempo {
    public static void main(String[] args) {
    

	long t1 = System.currentTimeMillis();

	// Version 1: add to string.
	String value = "";
	for (int i = 0; i < 10000; i++) {
	    value += Integer.toString(i) + ' ';
	}

	long t2 = System.currentTimeMillis();

	// Version 2: append to StringBuilder.
	StringBuilder builder = new StringBuilder();
	for (int i = 0; i < 10000; i++) {
	    builder.append(i).append(' ');
	}

	long t3 = System.currentTimeMillis();

	// ... Lengths are equal.
	System.out.println("Longitud de la string\t\t" + value.length());
	System.out.println("longitud de StringBuilder\t" + builder.length());

	// ... Times.
	System.out.println("Tiempo con String \t\t"+ (t2 - t1));
	System.out.println("Tiempo con StringBuilder\t" + (t3 - t2));
    }
}