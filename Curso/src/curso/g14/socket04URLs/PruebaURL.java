package curso.g14.socket04URLs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map.Entry;

public class PruebaURL {

	public static void main(String[] args) throws IOException {
		URL rfURL;
		BufferedReader in=null;
		try {
			rfURL = new URL ("https://recursosformacion.com");
			URLConnection connection =  rfURL.openConnection();
			
			connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			in = new BufferedReader(new 	InputStreamReader(connection.getInputStream()));

			
			System.out.println(in.readLine());
			//int status = connection.getResponseCode();
			
			for (Entry<String, List<String>> header : connection.getHeaderFields().entrySet()) {
			    System.out.println(header.getKey() + "=" + header.getValue());
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		finally {
			if (in!=null)
			in.close();
		}

			
			

	}

}
