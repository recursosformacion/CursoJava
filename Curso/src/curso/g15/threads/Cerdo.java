package curso.g15.threads;

import java.util.Random;

public class Cerdo extends Thread {

	@Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Cerdo " + i);
            try {
                Thread.sleep(numeroRandom(1000, 5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static int numeroRandom(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
