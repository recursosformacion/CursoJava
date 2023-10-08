package curso.gXX.complementos.p02.clases;

public class Main {

	public static void main(String[] args) {
		CalendarDia cd = new CalendarDia();
		Regresiva rg= new Regresiva();
		System.out.println(cd.hoy());
		System.out.println(cd.aplazado(30));
		
		rg.contador();
		

	}

}
