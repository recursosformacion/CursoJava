package curso.g12.nio.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Copias {

	public static void main(String[] args) {
		copiarDirectorios(new File("."),new File("D:\\pruebas"));

	}
	
	public static void copiarDirectorios(File d1, File d2){
		  if (d1.isDirectory()){
			  if (!d2.exists()){                              
				  d2.mkdir();
				  System.out.println("Creando directorio " + d2.toString());
				}
			  String[] ficheros = d1.list();
			  for (int x=0;x<ficheros.length;x++) {
			    copiarDirectorios(new File(d1,ficheros[x]),new File(d2,ficheros[x]));                           
			  }
		  } else {
		    copiarFicheros(d1,d2);
		  }
		}
	
	public static void copiarFicheros(File f1, File f2){
		 
		  try {
		    InputStream in = new FileInputStream(f1);
		    OutputStream out = new FileOutputStream(f2);
		 
		    byte[] buf = new byte[1024];
		    int len;
		 
		    while ((len = in.read(buf)) > 0) {
		      out.write(buf, 0, len);
		    }
		 
		    in.close();
		    out.close();
		 
		  } catch (IOException ioe){
		    ioe.printStackTrace();
		  }
		}

}
