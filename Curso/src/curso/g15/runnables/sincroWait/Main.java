package curso.g15.runnables.sincroWait;

public class Main {

	static Buffer buf;

	public static void main(String[] args) {

		buf = new Buffer();
		buf.setDisponible(false);
		
		GeneraNumero gn = new GeneraNumero();
		gn.setBuf(buf);
		PresentaNumero pn = new PresentaNumero();
		pn.setBuf(buf);
		
		Thread tgn = new Thread(gn);
		Thread tpn = new Thread(pn);
		
		tgn.start();
		tpn.start();

	}

}
