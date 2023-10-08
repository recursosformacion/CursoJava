package curso.g05.condicionalesybucles.p07;

public class SumaCinco {

	public static void main(String[] args) {
		int contador=10;
		long total=0;
		int indice=0;
		while (contador>0){
			if (++indice%5 ==0){
				--contador;
				total+=indice;
				System.out.println(indice);
			}
		}
		System.out.println("El total es:"+total);
	}

}
