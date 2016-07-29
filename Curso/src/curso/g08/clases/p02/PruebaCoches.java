package curso.g08.clases.p02;

public class PruebaCoches {

	public static void main(String[] args) {
		
		Coche c1 = new Coche("Negro","Ford",6);
		Coche c2 = new Coche("Blanco","Arosa", 5); 
		Coche c3 = new Coche("Verde","Peugeot",4);
		Coche c4 = c1;
		c4.setColor("Amarillo");
		System.out.println("Coche 1 es:"+c1.toString());
		System.out.println("Coche 2 es:"+c2.toString());
		System.out.println("Coche 3 es:"+c3.toString());
		System.out.println("Coche 4 es:"+c4.toString());
		
	}

}
