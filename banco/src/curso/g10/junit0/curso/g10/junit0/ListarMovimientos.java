package curso.g10.junit0;

import java.text.SimpleDateFormat;
import java.util.List;

public class ListarMovimientos {

	public static  void print(String titulo, List<Movimiento> mMovimientos) {
		SimpleDateFormat fechaDma = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(titulo);
		double r = 0;
		for (Movimiento m : mMovimientos) {
			r += m.mImporte;
			
			System.out.println(fechaDma.format(m.mFecha.getTime()) + " "  + String.format("%-60s", m.mConcepto) + "\t\t\t\t\t" + m.mImporte + "\t" + r);
		}

	}
}
