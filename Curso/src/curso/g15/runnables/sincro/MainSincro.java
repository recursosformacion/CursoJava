package curso.g15.runnables.sincro;

public class MainSincro {

	public static void main(String[] args) {
		Sincro s1 = new Sincro();
		s1.setMensaje("Desde 1 ->");
		Thread thr1 = new Thread(s1);
		
		Sincro s2 = new Sincro();
		s2.setMensaje("Desde 2 ->");
		Thread thr2 = new Thread(s2);
		
		thr1.start();
		thr2.start();

	}

}
