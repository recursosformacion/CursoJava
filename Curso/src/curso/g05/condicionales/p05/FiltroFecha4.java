package curso.g05.condicionales.p05;


public class FiltroFecha4 {

	public static void main(String[] args) {
		int dia=20;
		int mes=8;
		int a�o=2015;
		int[] diaMes={31,28,31,30,31,30,31,31,30,31,30,31};
		
		boolean diaok=false;
		if (mes >= 1 && mes <= 12)
			if (a�o != 0){
				if (a�o%4==0) diaMes[1]=29;
				if (dia<=diaMes[mes-1])
					System.out.println("Fecha correcta");
				else
					System.out.println("D�a incorrecto");
			}
			else
				System.out.println("A�o incorrecto");
		else
			System.out.println("Mes incorrecto");
		
		
		
	}

}
