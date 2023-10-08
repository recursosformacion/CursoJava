package curso.g16.concurrent;

public class Mensaje extends Thread {

	private String mensaje;

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	Mensaje(String m){
		mensaje = m;
	}
	
	@Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "-"+mensaje);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
