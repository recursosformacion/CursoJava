package curso.g15.runnables.sincro;

public class NoSincro implements Runnable{
	static Integer n = 1;
	private String mensaje;
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(mensaje + " " + n);
			n++;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
