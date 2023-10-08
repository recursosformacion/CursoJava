package es.rf.banco.servicio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Vector;

import es.rf.banco.app.Credito;
import es.rf.banco.app.Cuenta;
import es.rf.banco.app.Debito;
import es.rf.banco.model.CuentaMo;

public class Cuentas {

	private static File salida;
	private static Vector<CuentaMo> listaCuentas;
	public static final String FICHERO_LISTA_CUENTAS = "d:/myCuentas.txt";
	
	public static CuentaMo leer(String numeroCuenta) throws IOException, ClassNotFoundException {
		try {
			listaCuentas = leer();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if (listaCuentas!=null){
			for (CuentaMo dato : listaCuentas){
				if (dato.getmNumero().equals(numeroCuenta)){
					return dato;
				}
			}
		}
		return null;
	}
	
	public static void borrar(String numeroCuenta) throws IOException, ClassNotFoundException {
		try {
			listaCuentas = leer();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if (listaCuentas!=null){
			for (Iterator<CuentaMo> iterator = listaCuentas.iterator(); iterator.hasNext();) {
				CuentaMo dato = iterator.next();
			    if (dato.getmNumero().equals(numeroCuenta)) {
			        // Remove the current element from the iterator and the list.
			        iterator.remove();
			    }
			}
		}
		try {
			grabar(listaCuentas);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}
	

	public static Vector<CuentaMo> leer() throws IOException, ClassNotFoundException {
		salida = new File(FICHERO_LISTA_CUENTAS);
		listaCuentas = new Vector<CuentaMo>();

		System.out.println(salida.getAbsolutePath());
		FileInputStream fi = new FileInputStream(salida);
		ObjectInputStream oi = new ObjectInputStream(fi);

		// Read objects
		Vector<CuentaMo> listaCuentas = (Vector<CuentaMo>) oi.readObject();

		oi.close();
		fi.close();

		return listaCuentas;
	}

	public static boolean grabar(Vector<CuentaMo> listaCuentas) throws IOException {
		File salida = new File(FICHERO_LISTA_CUENTAS);
		FileOutputStream f = new FileOutputStream(salida);
		ObjectOutputStream o = new ObjectOutputStream(f);

		// Write objects to file
		o.writeObject(listaCuentas);

		o.close();
		f.close();

		return true;
	}

	public static boolean add(CuentaMo cuenta) {
		try {
			listaCuentas = leer();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		listaCuentas.add(cuenta);
		try {
			grabar(listaCuentas);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
