package curso.g09.complementos.p02.clases;

public class Regresiva {

	public void contador() {
		for (int a = 9; a >= 0; a--) {
			for (int b = 9; b >= 0; b--) {
				if (a == 3)
					System.out.print("E");
				else
					System.out.print(a);
				if (b == 3)
					System.out.print("E");
				else
					System.out.print(b);
				System.out.println();
			}
		}
	}
}
