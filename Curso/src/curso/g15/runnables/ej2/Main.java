package curso.g15.runnables.ej2;

public class Main {

	public static void main(String[] args) {
		Mensaje m1= new Mensaje();
		Mensaje m2= new Mensaje();
		
		m1.setMensaje("Este mensaje es desde 1");
		m2.setMensaje("Este mensaje es desde 2");
		
		Thread tm1 = new Thread(m1);
		Thread tm2 = new Thread(m2);
		
		tm1.start();
		tm2.start();
		tm1.interrupt();
	}
}
