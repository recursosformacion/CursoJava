package curso.g14.URLs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class LeeConURL {

	public static void main(String[] args) throws IOException {
		URL myURL = new URL("http://recursosformacion.com/");
		URL page1URL = new URL(myURL, "wordpress");
		URL page2URL = new URL(myURL, "utilidades/index");
		BufferedReader bffin = new BufferedReader(
				new InputStreamReader(myURL.openStream()));

		String inputLine;
		while ((inputLine = bffin.readLine()) != null)
			System.out.println(inputLine);
		bffin.close();

	}

}
