package curso.g02.sintaxis.p01;

public class Nombres2 {

	public static void main(String[] args) {
		
		int $nombre;
		int pasado;		//Modificado el nombre de la variable
		int alcance;    //Añadido el ; al final de linea
		
		int _contador;
		_contador=25;
		
		$nombre=_contador;
		pasado=_contador;

		System.out.println($nombre + " / " + _contador);
	}

}
