package curso.g05a.buclesanidados.p11;

public class Primos {

	public static void main(String[] args) {
		boolean primo;
		int cont_pri = 0;

		int num = 10000000;
		long startTime = System.currentTimeMillis();
		for (int i = 1; i <= num; i++) {
			// para cada número i, calcularemos si es primo
			primo = true;
			int j = 2;
			while (j <= (i/2) - 1 && primo == true) {
				if (i % j == 0)
					primo = false;
				j++;
			}
			if (primo == true) {
				cont_pri++; // si es primo incrementamos el contador de primos
				//System.out.println(i + (" es primo"));
			}
		}
		System.out.println("En el rango 1.." + num + ", hay " + cont_pri + " números primos");
		
		long stopTime = System.currentTimeMillis();
	      long elapsedTime = stopTime - startTime;
	      System.out.println(elapsedTime);
	}
}
