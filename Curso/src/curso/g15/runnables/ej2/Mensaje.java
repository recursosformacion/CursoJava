package curso.g15.runnables.ej2;

public class Mensaje implements Runnable {

	private String mensaje;

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	@Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + "-"+mensaje);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (Thread.interrupted())
            	// Nos han pedido que acabemos...
            	break; // o return;   
        }
    }
}
