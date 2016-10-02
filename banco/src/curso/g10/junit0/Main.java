package curso.g10.junit0;

import java.util.Calendar;

public class Main {

	static Cuenta c;
	static Debito tDebito;
	static Credito tCredito;
	public static void main(String[] args) throws Exception {
		c=new Cuenta("123456","Miguel Garcia");
		c.ingresar(1000);
		c.ingresar("Para pruebas", 2000);
		c.retirar(200);
		c.retirar("Para mas pruebas",500);
		
		
		long tiempo=Long.parseLong("12096000000");
		Calendar fecha=Calendar.getInstance(); 
		fecha.add(Calendar.YEAR, 4);//	Caduca en 4 años
		tDebito=new Debito("1234567890123456", "Miguel Garcia", fecha);
		tDebito.setCuenta(c);
		tDebito.ingresar(80);
		tDebito.retirar(50);
		
		
		tCredito=new Credito("1234567890123456", "Miguel Garcia", fecha,50000);
		tCredito.setCuenta(c);
		tCredito.ingresar(80);
		tCredito.retirar(50);
		System.out.println(tCredito.getSaldo());
		
		System.out.println("--------------------------Movimientos-------------------");
		c.verMovimientos();

	}

}
