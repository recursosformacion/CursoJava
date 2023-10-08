package curso.g05b.condicionalesybucles.Adivina;

import curso.utilidades.Consola;

public class Jugando {

	static int n; // Mi numero
	static boolean finJuego; // final del juego
	static boolean finPartida; // final de partida
	static int ganoMaquina = 0;
	static int ganoUsuario = 0;

	static int topeSup = 100;
	static int topeInf = 0;
	static int miNum = 0;

	public static void main(String[] args) {

		while (!finJuego) {
			n = (int) (Math.random() * 100) + 1; // inicializo mi numero
			miNum = (int) (Math.random() * 100 + 1); // inicializo mi jugada
			while (!finPartida) {

				miTirada();
				if (!finJuego && !finPartida)
					tuTirada();
			}
			System.out.println("-------------------------------------------------");
			System.out.print("vamos " + ganoMaquina + " a " + ganoUsuario);
			if (ganoMaquina > ganoUsuario)
				System.out.println(" a mi favor");
			if (ganoMaquina < ganoUsuario)
				System.out.println(" a tu favor");
			if (ganoMaquina == ganoUsuario)
				System.out.println(" .....Increible, pero....EMPATADOS!!!!!!!!");

			System.out.println("Otra Partida? (S/N)");
			if ((Consola.cadena()).equalsIgnoreCase("N"))
				finJuego = true;
		}

	}

	static void miTirada() {
		String respuesta = "";
		System.out.println("Numero:" + miNum + "    (M)ayor, Me(n)or, (F)in");
		respuesta = Consola.cadena();
		if (respuesta.equalsIgnoreCase("M"))
			topeInf = miNum;
		else
			topeSup = miNum;
		miNum = (int) ((topeSup + topeInf) / 2);
		if (respuesta.equalsIgnoreCase("F")) {
			System.out.println("Te gane!!!!");
			ganoMaquina++;
			finPartida = true;
		}
	}

	static void tuTirada() {
		int num;
		System.out.print("Introduce número: ");
		num = Consola.entero();
		if (num > n)
			System.out.println("menor");
		else if (num < n)
			System.out.println("mayor");
		else {
			System.out.println("Me ganaste!!!!");
			ganoUsuario++;
			finPartida = true;
		}

	}
}
