package curso.g18.interfaces;

import java.io.Serializable;

public class Grabando implements acceso, Serializable {

	
	public String acceder(int a) {
		System.out.println(a);
		return null;
	}

	@Override
	public boolean grabar(String s) {
		System.out.println(s);
		return false;
	}

}
