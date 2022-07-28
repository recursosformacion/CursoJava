package curso.g15.runnables.sincro;

public class Sincro implements Runnable {
	static Integer n = 1;
	private String mensaje;

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			synchronized (n) {
				System.out.println(mensaje + " " + n);
				n++;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

//		boolean condicion = false;
//		while (!condicion) {
//			try {
//				wait();
//			} catch (InterruptedException e) {
//			} catch (IllegalMonitorStateException e) {
//				
//			}
//			
//		}
//		this.notifyAll();

	}

}
