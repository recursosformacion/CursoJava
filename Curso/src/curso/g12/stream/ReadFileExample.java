package curso.g12.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/**
 * Leyendo en formato ASCII
 * @author migarcia
 *
 */
public class ReadFileExample {
	
		public static void main(String[] args) {

			File file = new File("C:/robots.txt");
			FileInputStream fis = null;

			try {
				fis = new FileInputStream(file);

				System.out.println("Total file size to read (in bytes) : "
						+ fis.available());

				int content;
				while ((content = fis.read()) != -1) {
					// convert to char and display it
					System.out.print((char) content);
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (fis != null)
						fis.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
}
