package curso.g10.junit;

class Exc1 {
	  static double subroutine() {
	    int d = 0;
	    return 10 / d;
	  }
	  public static void main(String args[]) {
	    System.out.println("Antes de Exc1.subroutine");
	    Exc1.subroutine();
	    System.out.println("Despues de Exc1.subroutine");
	  }
	}