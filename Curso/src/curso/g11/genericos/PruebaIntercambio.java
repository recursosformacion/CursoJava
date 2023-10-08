package curso.g11.genericos;

public class PruebaIntercambio {

	public static void main(String[] args) {
		Intercambio<String> pruebasTexto = new Intercambio<String>("Miguel","Antonio");
		Intercambio<Integer> pruebasNumero = new Intercambio<Integer>(20,30);
		
		String texto1 = pruebasTexto.getUno();
		int numero1=pruebasNumero.getUno();
		
		System.out.println("Antes de intercambio");
		System.out.println("Texto 1="+texto1+" Numero 1="+numero1);
		pruebasTexto.invierte();
		pruebasNumero.invierte();
		texto1 = pruebasTexto.getUno();
		numero1=pruebasNumero.getUno();
		System.out.println("Despues de intercambio");
		System.out.println("Texto 1="+texto1+" Numero 1="+numero1);
	}

}
