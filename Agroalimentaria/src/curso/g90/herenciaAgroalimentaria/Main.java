package curso.g90.herenciaAgroalimentaria;

import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		Calendar hoy = Calendar.getInstance();
		Productos p1 = new PRefrigerados(hoy,123,100);
		Productos p2 = new PCongelados(hoy,124,-34);
		Productos p3 = new PFrescos(hoy,125,hoy,"Espa�a");
		Productos p4 = new PCAire(hoy,126,-50,20.0,30.0,40.0,10.0);
		
		
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());
		System.out.println(p4.toString());

	}

}
