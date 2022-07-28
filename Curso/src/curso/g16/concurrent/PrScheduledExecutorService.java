package curso.g16.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class PrScheduledExecutorService {
	public static void main(String args[]) throws InterruptedException {
		execute();
	}

	public static void execute() throws InterruptedException {
		Mensaje m1 = new Mensaje("Mensaje1");
		Mensaje m2 = new Mensaje("Mensaje2");
		Mensaje m3 = new Mensaje("Mensaje3");

//		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

		Future<?> future = 
				executorService.schedule(m1, 5, TimeUnit.SECONDS);
		ScheduledFuture<?> scheduledFuture = 
				executorService.scheduleAtFixedRate(m2, 2, 10, TimeUnit.SECONDS);
		Future<?> future3 = 
				executorService.schedule(m3, 1, TimeUnit.SECONDS);
		
		

		Thread.sleep(20000);
		executorService.shutdown();
	}
}
