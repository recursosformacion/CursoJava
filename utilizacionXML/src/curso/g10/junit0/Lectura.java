package curso.g10.junit0;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lectura {

	public static String leerFichero(String fichero)  {
		StringBuffer stringBuffer = new StringBuffer();
		FileReader fileReader = null;
		File file = new File(fichero);
		try {

			fileReader = new FileReader(file);

			int numCharsRead;
			char[] charArray = new char[1024];
			while ((numCharsRead = fileReader.read(charArray)) > 0) {
				stringBuffer.append(charArray, 0, numCharsRead);
			}
			

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			return stringBuffer.toString();

		}
	}
}
