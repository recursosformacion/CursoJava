package curso.g05.condicionales.p05;


public class FiltroFecha0 {

	public static void main(String[] args) {
		int dia=20;
		int mes=8;
		int a�o=2015;
		
		if (dia >= 1 && dia <= 30)
			if (mes >= 1 && mes <= 12)
				if (a�o != 0)
					System.out.println("Fecha correcta");
				else
					System.out.println("A�o incorrecto");
			else
				System.out.println("Mes incorrecto");
		else
			System.out.println("D�a incorrecto");
	}

}
