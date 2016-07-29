package curso.g05.condicionales.p05;


public class FiltroFecha4 {

	public static void main(String[] args) {
		int dia=20;
		int mes=8;
		int año=2015;
		int[] diaMes={31,28,31,30,31,30,31,31,30,31,30,31};
		
		boolean diaok=false;
		if (mes >= 1 && mes <= 12)
			if (año != 0){
				if (año%4==0) diaMes[1]=29;
				if (dia<=diaMes[mes-1])
					System.out.println("Fecha correcta");
				else
					System.out.println("Día incorrecto");
			}
			else
				System.out.println("Año incorrecto");
		else
			System.out.println("Mes incorrecto");
		
		
		
	}

}
