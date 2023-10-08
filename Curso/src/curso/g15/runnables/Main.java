package curso.g15.runnables;

public class Main {

	
		private static final Pato pato = new Pato();
	    private static final Cerdo cerdo = new Cerdo();
	 
	    public static void main(String[] args) {
	    	 Thread patoThread = new Thread(pato);
	         Thread cerdoThread = new Thread(cerdo);
	         patoThread.start();
	         cerdoThread.start();
	    }

	

}
