package curso.g05a.buclesanidados.p11.reloj;

public class Reloj {

	public static void main(String[] args) throws InterruptedException {
		for (int a = 0; a < 2; a++) {
			int dh = 0;
			int sh = 0;
			int mh = 0;
			for (dh = 0; dh < 24; dh++) {

				for (mh = 0; mh < 60; mh++) {

					for (sh = 0; sh < 60; sh++) {
					
						System.out.print("" + dh + ":" + mh + ":" + sh + "\n");
						Thread.sleep(1000);

					}
				}
			}
			System.out.print("\b\b\b\b\b\b\b\b\b\b");

		}
	}
}
