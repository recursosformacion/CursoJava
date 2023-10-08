package curso.g15.runnables.sincroWaitOpt;

public class PresentaNumero implements Runnable {

	Buffer buf;

	public void setBuf(Buffer buf) {
		this.buf = buf;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println(buf.getNumero());
		}
	}

}
