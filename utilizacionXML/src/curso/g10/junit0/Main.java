package curso.g10.junit0;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Calendar;

public class Main {

	static Cuenta c;
	static Debito tDebito;
	static Credito tCredito;

	public static void main(String[] args) throws Exception {
		c = new Cuenta("123456", "Miguel Garcia");
		c.ingresar(1000);
		c.ingresar("Para pruebas", 2000);
		c.retirar(200);
		c.retirar("Para mas pruebas", 500);

		long tiempo = Long.parseLong("12096000000");
		Calendar fecha = Calendar.getInstance();
		fecha.add(Calendar.YEAR, 4);// Caduca en 4 a�os
		tDebito = new Debito("1234567890123456", "Miguel Garcia", fecha);
		tDebito.setCuenta(c);
		tDebito.ingresar(80);
		tDebito.retirar(50);

		System.out.println(c.toString());

		tCredito = new Credito("1234567890123456", "Miguel Garcia", fecha, 50000);
		tCredito.setCuenta(c);
		tCredito.ingresar(80);
		tCredito.retirar(50);
		System.out.println(tCredito.getSaldo());

		System.out.println("--------------------------Movimientos-----------m--------");
		c.verMovimientos();

		try {
			File salida = new File("d:/myObjects.txt");
			System.out.println(salida.getAbsolutePath());
			FileOutputStream f = new FileOutputStream(salida);
			ObjectOutputStream o = new ObjectOutputStream(f);

			// Write objects to file
			o.writeObject(c);
			o.writeObject(tDebito);
			o.writeObject(tCredito);

			o.close();
			f.close();

			salida = new File("d:/myObjects.txt");
			System.out.println(salida.getAbsolutePath());
			FileInputStream fi = new FileInputStream(salida);
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			c = (Cuenta) oi.readObject();
			tDebito = (Debito) oi.readObject();
			tCredito = (Credito) oi.readObject();

			oi.close();
			fi.close();

			System.out.println("--------------------------Movimientos leidos-------------------");
			c.verMovimientos();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		try {
			File salida = new File("d:/myXML.txt");
			PrintWriter o = new PrintWriter(salida);
			

			// Write objects to file
			o.println(c.toXML());
//			o.writeChars(tDebito.toXML());
//			o.writeChars(tCredito.toXML());

			o.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
		System.out.println(Lectura.leerFichero("d:/myXML.txt"));
	}

}
