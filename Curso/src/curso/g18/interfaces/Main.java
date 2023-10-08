package curso.g18.interfaces;

import java.io.Serializable;

public class Main {

	public static void main(String[] args) {
		Interface1 objeto = (a,b) -> a + b;			//implementacion metodo abtracto
		//Pri objeto = new Pri();
		
		System.out.println(objeto.cuenta(3, 5));
		System.out.println(objeto.resuelto(20));
		System.out.println(objeto.saluda());
		
		//Serializable aa = new Grabando();
	}

}
