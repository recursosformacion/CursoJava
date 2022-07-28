package curso.g16.concurrent;

import java.util.concurrent.Executor;

public class Lanzador implements Executor {

	@Override
	public void execute(Runnable r) {
		(new Thread(r)).start();

	}

}
