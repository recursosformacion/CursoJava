package curso.g05.condicionales.p06;

public class NumerosALetras1 {
	public static void main(String[] args) {
		for (int a = 0; a < 100; a++)
			conversion(a);

	}

	public static void conversion(int num) {

		int unidades, decenas;
		String[] parte1 = { "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez", "once",
				"doce", "trece", "catorce", "quince" };
		String[] parte2 = { "diez", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta",
				"noventa" };

		unidades = num % 10;
		decenas = num / 10;
		String mensaje = "";
		if (num > 0) {
			if (num < 16) {
				mensaje = parte1[num - 1];
			} else {
				mensaje = parte2[decenas - 1];
				if (unidades > 0) {
					mensaje += " y ";
					if (decenas == 2) {
						mensaje = "venti";
					}
					if (decenas == 1) {
						mensaje = "dieci";
					}
					mensaje += parte1[unidades - 1];
				}
			}
			System.out.println(mensaje);
		}

	}

}
