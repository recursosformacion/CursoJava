package curso.g04.operadores;

public class Operaciones {

	public static void main(String[] args) {
		int cantidad;
		int unidades;
		double precio;
		double importe;
		int total;
		
		
		cantidad=1000000000;
		unidades=12;
		precio=5.40; 
		
		importe=cantidad*unidades*precio;
		total=(int)(importe*1.21);
		
		System.out.println("cantidad\t=" + cantidad);
		System.out.println("unidades\t=" + unidades);
		System.out.println("precio\t\t=" + precio);
		
		System.out.println("Importe\t=" + importe);
		System.out.println("Iva\t="+ importe*0.21);
		System.out.println("Total\t="+ total+"  deberia ser:"+importe*1.21);

	}

}
