package curso.g15.runnables.sincroWaitOpt;

import java.util.Random;

public class GeneraNumero implements Runnable {

	Buffer buf;

	public void setBuf(Buffer buf) {
		this.buf = buf;
	}

	@Override
	public void run() {
		Random rn = new Random();
		while (true) {
			buf.setNumero(rn.nextInt());
			
		}
	}

}
