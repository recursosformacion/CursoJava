package curso.g02.sintaxis.p01;

/* Esta clase define variables para comprobar las normas de definicion de variables
 * en Java, y luego imprime un par de mensajes
 * 
 * Author: Miguel
 */

public class Nombres3 {

	public static void main(String[] args) {
		
		int $nombre;
		int pasado;		//Modificado el nombre de la variable
		int alcance;    //Añadido el ; al final de linea
		
		int _contador;
		_contador=25;
		
		$nombre=_contador;
		pasado=_contador;

		System.out.println($nombre + " / " + _contador);
		
		System.out.println("En \"Java\" puede\n que tengamos que utilizar\n caracteres especiales");
		
	}

}
