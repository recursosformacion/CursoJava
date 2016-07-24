package curso.g05.condicionales.p04;

import curso.utilidades.Consola;

public class NotasSwitchConsole {

	public static void main(String[] args) {
		int nota;
		System.out.print("Introduzca una nota: ");
		nota = Consola.entero();
		switch (nota) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
			System.out.println("INSUFICIENTE");
			break;
		case 5:
			System.out.println("SUFICIENTE");
			break;
		case 6:
			System.out.println("BIEN");
			break;
		case 7:
		case 8:
			System.out.println("NOTABLE");
			break;
		case 9:
		case 10:
			System.out.println("SOBRESALIENTE");
			break;
		default:
			System.out.println("ERROR");
			break;
		}

	}

}
