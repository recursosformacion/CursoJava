package curso.g15.runnables.sincroWait;

public class PresentaNumero implements Runnable {

	Buffer buf;

	public void setBuf(Buffer buf) {
		this.buf = buf;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (buf) {
				while (!buf.isDisponible()) {
					System.out.println("Esperando numero");
					try {
						buf.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(buf.getNumero());
				buf.setDisponible(false);
				buf.notifyAll();
			}
		}
	}

}
