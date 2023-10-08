package es.sopra.prueba;

import es.copra.exceptions.DivisionCero;

public class Errores {

	public static void main(String[] args) {
		try {
			operacion();
		} catch (DivisionCero e) {
			e.printStackTrace();
		}
	}

	public static void operacion() {
		try {
			int a = 0;
			int b = 300;
			int c = b / a;
		} catch (ArithmeticException e) {
			throw new DivisionCero("Fallo la division");
		} finally {
			System.out.println("Programa finalizado");
		}
	}

}
