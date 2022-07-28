package curso.g16.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PruebaExecutorService {

	public static void main(String args[]){
		ExecutorService executorService = Executors.newFixedThreadPool(2);
	
		Mensaje m1 = new Mensaje("Mensaje1");
		executorService.execute(m1);
		
		Mensaje m2 = new Mensaje("Mensaje2");
		executorService.execute(m2);
		
		Mensaje m3 = new Mensaje("Mensaje3");
		executorService.execute(m3);
		
		
		executorService.shutdown();
	}
}
