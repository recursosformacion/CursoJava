package es.rf.tienda.dominio;

import es.rf.tienda.util.Validator;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Validator.cumpleDNI("38.474.364-X"));
		System.out.println(Validator.isAlfanumeric("Hola que tal"));
		Categoria c1 = new Categoria();
		System.out.println(c1.isValid());
		
	}

}
