package curso.g05.condicionales.p06;

public class NumerosALetras {
	public static void main(String[] args) {
		int num = 72;
		int unidades, decenas;
		
		unidades = num % 10;
		decenas = num / 10;
		switch (decenas) {
		case 0:
			System.out.print("");
			break;
		case 1:
			System.out.print("diez");
			break;
		case 2:
			System.out.print("veinte");
			break;
		case 3:
			System.out.print("treinta");
			break;
		case 4:
			System.out.print("cuarenta");
			break;
		case 5:
			System.out.print("cincuenta");
			break;
		case 6:
			System.out.print("sesenta");
			break;
		case 7:
			System.out.print("setenta");
			break;
		case 8:
			System.out.print("ochenta");
			break;
		case 9:
			System.out.print("noventa");
			break;
		}
		System.out.print(" y ");
		switch (unidades) {
		case 0:
			System.out.println("");
			break;
		case 1:
			System.out.println("uno");
			break;
		case 2:
			System.out.println("dos");
			break;
		case 3:
			System.out.println("tres");
			break;
		case 4:
			System.out.println("cuatro");
			break;
		case 5:
			System.out.println("cinco");
			break;
		case 6:
			System.out.println("seis");
			break;
		case 7:
			System.out.println("siete");
			break;
		case 8:
			System.out.println("ocho");
			break;
		case 9:
			System.out.println("nueve");
			break;
		}
	}

}
