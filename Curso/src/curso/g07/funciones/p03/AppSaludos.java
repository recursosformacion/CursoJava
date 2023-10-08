package curso.g07.funciones.p03;

public class AppSaludos {

	public static void main(String[] args) {
		Saludos sMiguel = new Saludos();
		Saludos sAntonio = new Saludos();
		
		sMiguel.hola("Miguel ");
		sAntonio.hola("Antonio ");
		
		int numA = sAntonio.adios(2);
		int numM = sMiguel.adios(5);
		
		System.out.println("La respuesta fue " + numM + " y " + numA);
	}

}
