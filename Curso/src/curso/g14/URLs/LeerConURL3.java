package curso.g14.URLs;

import java.net.HttpURLConnection;
import java.net.URL;

public class LeerConURL3 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://recursosformacion.com/");
			HttpURLConnection huc = (HttpURLConnection) url.openConnection();
			huc.addRequestProperty("User-Agent", 
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
			for (int i = 1; i <= 8; i++) {
				System.out.println(huc.getHeaderFieldKey(i) + " = " + huc.getHeaderField(i));
			}
			huc.disconnect();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
