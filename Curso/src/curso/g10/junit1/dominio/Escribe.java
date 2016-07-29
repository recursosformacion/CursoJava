package dominio;

import java.io.FileWriter;
import java.io.IOException;

public class Escribe {
	public void writeASentence(FileWriter writer) throws IOException {
		  writer.write("una cadena");
		  writer.flush();
		}
}
