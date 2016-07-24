package curso.g05.condicionales.p05;


public class FiltroFecha2 {

	public static void main(String[] args) {
		int dia=20;
		int mes=8;
		int año=2015;
		boolean diaok=false;
		if (mes >= 1 && mes <= 12)
			if (año != 0){
				switch (mes){
				case 1: case 3: case 5: case 7: case 8: case 10: case 12:
					if (dia<=31) diaok=true;
					break;
				case 4: case 6: case 9: case 11:
					if (dia<=30) diaok=true;
					break;
				default:
					if (dia<=28) diaok=true;
				}
				if (diaok)
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
