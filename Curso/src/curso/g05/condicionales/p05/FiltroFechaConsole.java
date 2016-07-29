package curso.g05.condicionales.p05;

import curso.utilidades.Consola;
/*
 * Pedir el día, mes y año de una fecha e indicar si la fecha es correcta. Con meses de 28, 30 y 31 días.
Sin años bisiestos.
 */
public class FiltroFechaConsole {

	public static void main(String[] args) {
		int dia, mes, año;
		// para que una fecha sea correcta se tiene que cumplir
		// día en el rango 1..30
		// mes en el rango 1..12
		// año cualquiera distinto del 0
		System.out.print("Introduzca día: ");
		dia = Consola.entero();
		System.out.print("Introduzca mes: ");
		mes = Consola.entero();
		System.out.print("Introduzca año: ");
		año = Consola.entero();
		if (dia >= 1 && dia <= 30)
			if (mes >= 1 && mes <= 12)
				if (año != 0)
					System.out.println("Fecha correcta");
				else
					System.out.println("Año incorrecto");
			else
				System.out.println("Mes incorrecto");
		else
			System.out.println("Día incorrecto");
	}

}
