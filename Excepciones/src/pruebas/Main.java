package pruebas;


import java.util.Optional;
import java.util.concurrent.TransferQueue;


public class Main {

	
	private static int errorCode(boolean error) {
        return (error) ? 1 : 0;
    }

    private static Optional<Integer> optional(boolean error) {
        return (error) ? Optional.empty() : Optional.of(0);
    }

    private static Integer exception(boolean error) throws Exception {
        if (error) {
            throw new Exception();
        } else {
            return 0;
        }
    }




    public static void main(String[] args) {
        int errorCode = errorCode(true);
        if (errorCode != 0) {
            System.out.printf("Error code: %d%n", errorCode);
        }

        Optional<Integer> value = optional(true);
        if (!value.isPresent()) {
            System.out.println("Optional empty");
        }

        try {
            exception(true);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
