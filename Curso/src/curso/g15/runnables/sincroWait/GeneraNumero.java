package curso.g15.runnables.sincroWait;

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
			synchronized (buf) {
				while (buf.isDisponible()) {
					System.out.println("Esperando espacio....");
					try {
						buf.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				buf.setNumero(rn.nextInt());
				buf.setDisponible(true);
				System.out.println("Numero disponible");
				buf.notifyAll();
			}

		}
	}

}
