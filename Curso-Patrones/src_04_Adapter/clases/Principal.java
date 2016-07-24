

package clases;


/**
 * Clase principal donde se establecen las instancias y llamados a metodos
 * del aplicativo
 * @author chenao
 *
 */
public class Principal {


    public static void main(String[] args) {
    	
    	Principal miPrincipal = new Principal();
    	System.out.println("\n******************Motor Comun*********************");
    	miPrincipal.usarMotorComun();
    	System.out.println("**************************************************\n");
    	System.out.println("*****************Motor Economico******************");
    	miPrincipal.usarMotorEconomico();
    	System.out.println("**************************************************\n");
    	System.out.println("*****************Motor Electrico******************");
    	miPrincipal.usarMotorElectrico();
    	System.out.println("**************************************************\n");
    }

	private void usarMotorComun() {
	    Motor motor = new MotorEconomico();
        motor = new MotorComun();
        motor.encender();
        motor.acelerar();
        motor.apagar();
	}

	private void usarMotorElectrico() {
		Motor motor = new MotorElectricoAdapter() ;
        motor.encender();
        motor.acelerar();
        motor.apagar();		
	}

	private void usarMotorEconomico() {
        Motor motor = new MotorEconomico();
        motor.encender();
        motor.acelerar();
        motor.apagar();		
	}
	public void prueba(){
		int entero;
		boolean boleano;
	//	if (null==entero) System.out.println("hola");
	//	if (entero==null) System.out.println("hola");
	}
}
