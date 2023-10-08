package curso.g14.URLs;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class LeerConURL2 {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://recursosformacion.com/");
			URLConnection urlcon = url.openConnection();
			urlcon.addRequestProperty("User-Agent", 
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
			InputStream stream = urlcon.getInputStream();
			int i;
			while ((i = stream.read()) != -1) {
				System.out.print((char) i);
			}
		} catch (Exception e) {
			e.printStackTrace();;
		}

	}

}
